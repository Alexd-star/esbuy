package cn.esbuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.esbuy.dao.GoodTypeDao;
import cn.esbuy.entity.GoodType;
import cn.esbuy.utils.JdbcUtils;

public class GoodTypeDaoImpl implements GoodTypeDao {

	@Override
	public List<GoodType> selectList() {
		Statement st = null;
		ResultSet rs = null;
		// 创建List集合
		List<GoodType> list = new ArrayList<GoodType>();
		// 获取连接
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from goodtype order by tid desc";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int tid = rs.getInt("tid");
				String tName = rs.getString("tName");
				GoodType goodtype = new GoodType(tid, tName);
				list.add(goodtype);
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
	public GoodType selectGoodType(int tid) {
		PreparedStatement st = null;
		ResultSet rs = null;
		// 获取连接
		GoodType goodtype = null;
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from goodtype where tid = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, tid);
			rs = st.executeQuery();
			if (rs.next()) {
				goodtype = new GoodType();
				goodtype.setTid(tid);
				goodtype.setTname(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
		return goodtype;
	}

	@Override
	public int insertGoodType(String tname) {
		PreparedStatement st = null;
		Connection conn = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into goodtype (tName) values (?)";
			st = conn.prepareStatement(sql);
			st.setString(1, tname);
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
	public int updateGoodType(GoodType goodtype) {
		PreparedStatement st = null;
		Connection conn = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update goodtype set tname=? where tid=?";
			st = conn.prepareStatement(sql);
			st.setString(1, goodtype.getTname());
			st.setInt(2, goodtype.getTid());
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
	public int deleteGoodType(int tid) {
		PreparedStatement st = null;
		Connection conn = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from goodtype where tid = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, tid);
			re = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(null, st, conn);
		}
		return re;
	}

}
