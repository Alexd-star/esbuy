package cn.esbuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.esbuy.dao.ScarDao;
import cn.esbuy.entity.Scar;
import cn.esbuy.entity.ScarVo;
import cn.esbuy.utils.JdbcUtils;

public class ScarDaoImpl implements ScarDao {

	@Override
	public List<ScarVo> selectList(int uid) {
		// 创建List集合
		List<ScarVo> list = new ArrayList<ScarVo>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from `scar` join good using (gdID) where uid = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, uid);
			rs = st.executeQuery();
			while (rs.next()) {
				ScarVo scarVo = new ScarVo();
				scarVo.setGdid(rs.getInt("gdID"));
				scarVo.setGdname(rs.getString("gdName"));
				scarVo.setScid(rs.getInt("scID"));
				scarVo.setScnum(rs.getInt("scNum"));
				scarVo.setUid(rs.getInt("uID"));
				scarVo.setGdprice(rs.getBigDecimal("gdPrice"));
				scarVo.setGdimage(rs.getString("gdImage"));
				list.add(scarVo);
			}
		} catch (SQLException e) {
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
		return list;
	}

	@Override
	public int deleteScar(int scid) {
		Connection conn = null;
		PreparedStatement st = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from scar where scID = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, scid);
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
	public int insertScar(Scar scar) {
		Connection conn = null;
		PreparedStatement st = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into scar (uID, gdID, scNum) values(?, ?, ?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, scar.getUid());
			st.setInt(2, scar.getGdid());
			st.setInt(3, scar.getScnum());
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
	public int selectScID(int uid, int gdid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select scID from scar where uID=? and gdID=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, uid);
			st.setInt(2, gdid);
			rs = st.executeQuery();
			if (rs.next()) {
				re = rs.getInt("scID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
		return re;
	}

	@Override
	public int updateScar(int scid) {
		Connection conn = null;
		PreparedStatement st = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update scar set scNum=scNum+1 where scid=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, scid);
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
