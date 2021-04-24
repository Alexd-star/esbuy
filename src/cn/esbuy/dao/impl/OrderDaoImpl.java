package cn.esbuy.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.esbuy.dao.OrderDao;
import cn.esbuy.entity.Order;
import cn.esbuy.entity.OrderDetail;
import cn.esbuy.entity.OrderVo;
import cn.esbuy.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {

	@Override
	public List<OrderVo> selectList() {
		List<OrderVo> list = new ArrayList<OrderVo>();
		Statement st = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select oID, oCode, oTotal, oTime, oStatus, uID, uName from `order` join user"
					+ " using(uID) order by oTime desc";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				OrderVo orderVo = new OrderVo();
				orderVo.setOid(rs.getInt("oID"));
				orderVo.setOcode(rs.getString("oCode"));
				orderVo.setUid(rs.getInt("uID"));
				orderVo.setOtime(rs.getTimestamp("oTime"));
				orderVo.setOstatus(rs.getInt("oStatus"));
				orderVo.setUname(rs.getString("uName"));
				orderVo.setOtotal(rs.getBigDecimal("oTotal"));
				list.add(orderVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
		return list;
	}

	@Override
	public List<Order> selectList(int uid) {
		List<Order> list = new ArrayList<Order>();
		PreparedStatement st = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select oID, oCode, oTotal, oTime, oStatus from `order` where uid = ? order by oTime desc";
			st = conn.prepareStatement(sql);
			st.setInt(1, uid);
			rs = st.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOid(rs.getInt("oID"));
				order.setUid(uid);
				order.setOcode(rs.getString("oCode"));
				order.setOtime(rs.getTimestamp("oTime"));
				order.setOtotal(rs.getBigDecimal("oTotal"));
				order.setOstatus(rs.getInt("oStatus"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
		return list;
	}

	@Override
	public boolean insertOrder(Order order, List<OrderDetail> list) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "";
		boolean flag = false;
		try {
			conn = JdbcUtils.getConnection();
			int oid = 0;
			// 开启事务
			conn.setAutoCommit(false);
			// 调用存储过程up_insertorder,插入订单并返回订单ID
			CallableStatement proc = conn.prepareCall("{ call up_insertorder(?,?,?) }");
			proc.setInt(1, order.getUid());
			proc.setString(2, generateOcode(order.getUid()));
			proc.setBigDecimal(3, order.getOtotal());
			rs = proc.executeQuery();
			if (rs.next()) {
				oid = rs.getInt("oid");
			}
			rs.close();
			proc.close();
			// 插入订单详情
			sql = "insert orderdetail (oID, gdID, odNum) values (?, ?, ?)";
			st = conn.prepareStatement(sql);
			for (OrderDetail od : list) {
				st.setInt(1, oid);
				st.setInt(2, od.getGdid());
				st.setInt(3, od.getOdnum());
				st.addBatch();
			}
			st.executeUpdate();
			st.close();
			// 删除购物车
			sql = "delete from scar where uID = ? ";
			st = conn.prepareStatement(sql);
			st.setInt(1, order.getUid());
			st.executeUpdate();
			// 提交事务
			conn.commit();
			// 关闭事务
			conn.setAutoCommit(true);
			flag = true;
		} catch (SQLException e) {
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
		return flag;
	}

	@Override
	public int updateOstatus(int oid, int ostatus) {
		Connection conn = null;
		PreparedStatement st = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update `order` set oStatus = ? where oID = ?";
			st = conn.prepareStatement(sql);
			st.setInt(2, oid);
			st.setInt(1, ostatus);
			re = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, st, conn);
		}
		return re;
	}

	@Override
	public boolean deleteOrder(int oid) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "";
		boolean flag = false;
		try {
			conn = JdbcUtils.getConnection();
			// 开启事务
			conn.setAutoCommit(false);
			// 删除订单详情
			sql = "delete from `orderdetail` where oid = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, oid);
			st.executeUpdate();
			st.close();
			// 删除订单
			sql = "delete from `order` where oid = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, oid);
			st.executeUpdate();
			// 提交事务
			conn.commit();
			// 关闭事务
			conn.setAutoCommit(true);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, st, conn);
		}
		return flag;
	}

	private String generateOcode(int uid) {
		String code = (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date());
		code = code + String.format("%06d", uid) + ((int) (Math.random() * 9000) + 1000);
		return code;
	}
}
