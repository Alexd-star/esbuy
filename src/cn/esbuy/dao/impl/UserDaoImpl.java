package cn.esbuy.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.esbuy.dao.UserDao;
import cn.esbuy.entity.User;
import cn.esbuy.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> selectList() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user order by uRegtime desc";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setUid(rs.getInt("uID"));
				user.setUname(rs.getString("uName"));
				user.setUpwd(rs.getString("uPwd"));
				user.setUsex(rs.getString("uSex"));
				user.setUbirth(rs.getDate("uBirth"));
				user.setUphone(rs.getString("uPhone"));
				user.setUemail(rs.getString("uEmail"));
				user.setUqq(rs.getString("uQQ"));
				user.setUimage(rs.getString("uImage"));
				user.setUcredit(rs.getInt("uCredit"));
				user.setUregtime(rs.getDate("uRegtime"));
				list.add(user);
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
	public List<User> selectList(String keywords) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user where  uName like ? or uPhone like ? ";
			st = conn.prepareStatement(sql);
			st.setString(1, "%" + keywords + "%");
			st.setString(2, "%" + keywords + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUid(rs.getInt("uID"));
				user.setUname(rs.getString("uName"));
				user.setUpwd(rs.getString("uPwd"));
				user.setUsex(rs.getString("uSex"));
				user.setUbirth(rs.getDate("uBirth"));
				user.setUphone(rs.getString("uPhone"));
				user.setUemail(rs.getString("uEmail"));
				user.setUqq(rs.getString("uQQ"));
				user.setUimage(rs.getString("uImage"));
				user.setUcredit(rs.getInt("uCredit"));
				user.setUregtime(rs.getDate("uregtime"));
				list.add(user);
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
	public User getUser(int uid) {
		User user = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user where  uid = ? ";
			st = conn.prepareStatement(sql);
			st.setInt(1, uid);
			rs = st.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUid(rs.getInt("uID"));
				user.setUname(rs.getString("uName"));
				user.setUpwd(rs.getString("uPwd"));
				user.setUsex(rs.getString("uSex"));
				user.setUbirth(rs.getDate("uBirth"));
				user.setUphone(rs.getString("uPhone"));
				user.setUemail(rs.getString("uEmail"));
				user.setUqq(rs.getString("uQQ"));
				user.setUimage(rs.getString("uImage"));
				user.setUcredit(rs.getInt("uCredit"));
				user.setUregtime(rs.getDate("uregtime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
		return user;
	}

	@Override
	public int updateUser(User user) {
		Connection conn = null;
		PreparedStatement st = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update user set uName=?, uSex=?, uPhone=?, uEmail=?, uBirth=? where uID=?";
			st = conn.prepareStatement(sql);
			st.setString(1, user.getUname());
			st.setString(2, user.getUsex());
			st.setString(3, user.getUphone());
			st.setString(4, user.getUemail());
			st.setDate(5, new Date(user.getUbirth().getTime()));
			st.setInt(6, user.getUid());
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
	public int deleteUser(int uid) {
		Connection conn = null;
		PreparedStatement st = null;
		int re = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from user where uID = ?";
			st = conn.prepareStatement(sql);
	        st.setInt(1, uid);
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
    public int insertUser(User user) {
    		Connection conn = null;
		PreparedStatement st = null;
		int re = 0;
        // 获取连接
        try {
			conn = JdbcUtils.getConnection();
			// sql语句
	        String sql = "insert into user (uName, uPwd, uSex, uBirth, uPhone, uEmail, uQQ) " 
	        		+ "values(?, ?, ?, ?, ?, ?, ?)";
	        st = conn.prepareStatement(sql);
	        st.setString(1, user.getUname());
	        st.setString(2, user.getUpwd());
	        st.setString(3, user.getUsex());
	        st.setDate(4, new Date(user.getUbirth().getTime()));
	        st.setString(5, user.getUphone());
	        st.setString(6, user.getUemail());
	        st.setString(7, user.getUqq());
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
    public int isUname(String uname) {
    		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
        int num = 0;
        try {
			conn = JdbcUtils.getConnection();
			String sql = "select COUNT(*) as num from user where uName = ?";
	        	st = conn.prepareStatement(sql);
	        	st.setString(1, uname);
	        rs = st.executeQuery();
	        if (rs.next()) {
	            num = rs.getInt("num");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
        return num;
    }
    
    @Override
    public String selectUpwd(String uname) {
    		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
    		String upwd = null;
    		try {
				conn = JdbcUtils.getConnection();
				String sql = "select uPwd from user where uName=?";
		        st = conn.prepareStatement(sql);
		        st.setString(1, uname);
		        rs = st.executeQuery();
		        if (rs.next()) {
		        		upwd = rs.getString("upwd");
		        }
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
        return upwd;
    }
}
