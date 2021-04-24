package cn.esbuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.esbuy.dao.GoodDao;
import cn.esbuy.entity.Good;
import cn.esbuy.entity.GoodVo;
import cn.esbuy.utils.JdbcUtils;

public class GoodDaoImpl implements GoodDao {

	@Override
	public List<GoodVo> selectList(Integer top) {
		PreparedStatement st = null;
		ResultSet rs = null;
		// 创建List集合
		List<GoodVo> list = new ArrayList<GoodVo>();
		// 获取连接
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from good join goodtype on good.tid = goodtype.tid order by gdAddTime desc";
			//如果top为null，返回所有记录；否则，返回前top条记录
			Map<String, Object> params = new HashMap<String, Object>();
			if (top != null) {
				sql = sql + " limit ?";
				params.put("top", top);
			}
			st = conn.prepareStatement(sql);
			if (params.containsKey("top")) st.setInt(1, (int)params.get("top"));
			rs = st.executeQuery();
			while (rs.next()) {
				GoodVo goodVo = new GoodVo();
				goodVo.setGdid(rs.getInt("gdID"));
				goodVo.setTid(rs.getInt("tID"));
				goodVo.setGdcode(rs.getString("gdCode"));
				goodVo.setGdname(rs.getString("gdName"));
				goodVo.setGdprice(rs.getBigDecimal("gdPrice"));
				goodVo.setGdquantity(rs.getInt("gdQuantity"));
				goodVo.setGdsaleqty(rs.getInt("gdSaleQty"));
				goodVo.setGdcity(rs.getString("gdCity"));
				goodVo.setGdimage(rs.getString("gdImage"));
				goodVo.setGdinfo(rs.getString("gdInfo"));
				goodVo.setGdaddtime(rs.getDate("gdAddTime"));
				goodVo.setGdhot(rs.getInt("gdHot"));
				goodVo.setTname(rs.getString("tName"));
				list.add(goodVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
		return list;
	}

	@Override
	public List<GoodVo> selectList(int tid, String gdname)  {
		PreparedStatement st = null;
		ResultSet rs = null;
		// 创建List集合
		List<GoodVo> list = new ArrayList<GoodVo>();
		// 获取连接
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			//动态组合SQL
			Map<String, Object> params = new HashMap<String, Object>();
			String sql = "select * from good join goodtype on good.tID = goodtype.tID where 1 = 1";
			if (tid>0) {
				sql = sql + " and good.tID=?";
				params.put("tID", tid);
			} else if (!gdname.equals("")) {
				sql = sql + " and gdName like ?";
				params.put("gdName", "%" + gdname + "%");
			}
			sql = sql + " order by gdAddTime desc";
			//创建PreparedStatement，动态设置参数
			st = conn.prepareStatement(sql);
			for (int i=0; i<params.size(); i++) {
				if (params.containsKey("tID")) st.setInt((i+1), (int)params.get("tID"));
				else if (params.containsKey("gdName")) st.setString((i+1), params.get("gdName").toString());
			}
			rs = st.executeQuery();
			while (rs.next()) {
				GoodVo goodVo = new GoodVo();
				goodVo.setGdid(rs.getInt("gdID"));
				goodVo.setTid(rs.getInt("tID"));
				goodVo.setGdcode(rs.getString("gdCode"));
				goodVo.setGdname(rs.getString("gdName"));
				goodVo.setGdprice(rs.getBigDecimal("gdPrice"));
				goodVo.setGdquantity(rs.getInt("gdQuantity"));
				goodVo.setGdsaleqty(rs.getInt("gdSaleQty"));
				goodVo.setGdcity(rs.getString("gdCity"));
				goodVo.setGdimage(rs.getString("gdImage"));
				goodVo.setGdinfo(rs.getString("gdInfo"));
				goodVo.setGdaddtime(rs.getDate("gdAddTime"));
				goodVo.setGdhot(rs.getInt("gdHot"));
				goodVo.setTname(rs.getString("tName"));
				list.add(goodVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
		return list;
	}

	@Override
	public Good selectGood(int gdid) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection conn = null;
		Good good = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from good where  gdid = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, gdid);
			good = new Good();
			rs = st.executeQuery();
			if (rs.next()) {
				good.setGdid(rs.getInt("gdID"));
				good.setTid(rs.getInt("tID"));
				good.setGdcode(rs.getString("gdCode"));
				good.setGdname(rs.getString("gdName"));
				good.setGdprice(rs.getBigDecimal("gdPrice"));
				good.setGdquantity(rs.getInt("gdQuantity"));
				good.setGdsaleqty(rs.getInt("gdSaleQty"));
				good.setGdcity(rs.getString("gdCity"));
				good.setGdimage(rs.getString("gdImage"));
				good.setGdinfo(rs.getString("gdInfo"));
				good.setGdaddtime(rs.getDate("gdAddTime"));
				good.setGdhot(rs.getInt("gdHot"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
		return good;
	}

	
	@Override
	public int insertNotImgOfGood(Good good) {
		PreparedStatement st = null;
		Connection conn = null;
		int re = 0;
		// 获取连接
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into good (tID, gdCode, gdName, gdPrice, gdQuantity, gdCity, gdInfo)"
					+ " values (?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, good.getTid());
			st.setString(2, good.getGdcode());
			st.setString(3, good.getGdname());
			st.setBigDecimal(4, good.getGdprice());
			st.setInt(5, good.getGdquantity());
			st.setString(6, good.getGdcity());
			st.setString(7, good.getGdinfo());
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
	public int insertGood(Good good) {
		PreparedStatement st = null;
		Connection conn = null;
		int re = 0;
		// 获取连接
		try {
			conn = JdbcUtils.getConnection();
			if (good.getGdimage() == null) {
				re = insertNotImgOfGood(good);
				return re;
			} 
			String sql = "insert into good (tID, gdCode, gdName, gdPrice, gdQuantity, gdCity, "
					+ "gdImage, gdInfo) values (?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, good.getTid());
			st.setString(2, good.getGdcode());
			st.setString(3, good.getGdname());
			st.setBigDecimal(4, good.getGdprice());
			st.setInt(5, good.getGdquantity());
			st.setString(6, good.getGdcity());
			st.setString(7, good.getGdimage());
			st.setString(8, good.getGdinfo());
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
	public int updateNotImgOfGood(Good good) {
		PreparedStatement st = null;
		Connection conn = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update good set tID=?, gdCode=?, gdName=?, gdPrice=?, gdQuantity=?, "
					+ "gdCity=?, gdInfo=? where gdid=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, good.getTid());
			st.setString(2, good.getGdcode());
			st.setString(3, good.getGdname());
			st.setBigDecimal(4, good.getGdprice());
			st.setInt(5, good.getGdquantity());
			st.setString(6, good.getGdcity());
			st.setString(7, good.getGdinfo());
			st.setInt(8, good.getGdid());
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
	public int updateGood(Good good) {
		PreparedStatement st = null;
		Connection conn = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			if (good.getGdimage() == null) {
				re = updateNotImgOfGood(good);
				return re;
			} 
			String sql = "update good set tID=?, gdCode=?, gdName=?, gdPrice=?, gdQuantity=?, "
					+ "gdCity=?, gdImage=?, gdInfo=? where gdid=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, good.getTid());
			st.setString(2, good.getGdcode());
			st.setString(3, good.getGdname());
			st.setBigDecimal(4, good.getGdprice());
			st.setInt(5, good.getGdquantity());
			st.setString(6, good.getGdcity());
			st.setString(7, good.getGdimage());
			st.setString(8, good.getGdinfo());
			st.setInt(9, good.getGdid());
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
    public int deleteGood(int gdid) {
		PreparedStatement st = null;
		Connection conn = null;
		int re = 0;
        try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from good where gdid = ?";
	        st = conn.prepareStatement(sql);
	        st.setInt(1, gdid);
	        re = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(null, st, conn);
		}
        return re;
    }
}
