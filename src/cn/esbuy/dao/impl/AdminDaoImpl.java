package cn.esbuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import cn.esbuy.dao.AdminDao;
import cn.esbuy.entity.Admin;
import cn.esbuy.utils.JdbcUtils;

public class AdminDaoImpl implements AdminDao {
	
    @Override
    public Admin getAdminbyAname(String aname) {
    		ResultSet rs = null;
    		PreparedStatement st =null;
        // 获取连接
        Connection conn = null;
        Admin admin = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from admin where aName=?";
	        st = conn.prepareStatement(sql);
	        st.setString(1, aname);
	        rs = st.executeQuery();
	        if (rs.next()) {
	        		admin = new Admin();
	        		admin.setAid(rs.getInt(1));
	        		admin.setAname(rs.getString(2));
	        		admin.setApwd(rs.getString(3));
	        		admin.setAlastlogin(rs.getDate(4));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, st, conn);
		}
        return admin;
    }

}
