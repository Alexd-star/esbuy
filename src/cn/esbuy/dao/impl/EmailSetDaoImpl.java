package cn.esbuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.esbuy.dao.EmailSetDao;
import cn.esbuy.entity.EmailSet;
import cn.esbuy.utils.JdbcUtils;

public class EmailSetDaoImpl implements EmailSetDao {

	@Override
	public int updateEmail(EmailSet emailset) {
		Connection conn = null;
		PreparedStatement st = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update  emailset set emServer=?, emAddress = ?, emPassCode = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, emailset.getEmserver());
			st.setString(2, emailset.getEmaddress());
			st.setString(3, emailset.getEmpasscode());
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
	public EmailSet selectEmail() {
		ResultSet rs = null;
		PreparedStatement st = null;
		Connection conn = null;
		EmailSet emailset = new EmailSet();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from emailset";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if (rs.next()) {
				emailset.setEmserver(rs.getString("emServer"));
				emailset.setEmaddress(rs.getString("emAddress"));
				emailset.setEmpasscode(rs.getString("emPassCode"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
		return emailset;
	}
}
