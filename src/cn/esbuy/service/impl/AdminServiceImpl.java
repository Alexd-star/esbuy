package cn.esbuy.service.impl;

import cn.esbuy.dao.AdminDao;
import cn.esbuy.dao.impl.AdminDaoImpl;
import cn.esbuy.entity.Admin;
import cn.esbuy.service.AdminService;
import cn.esbuy.utils.JdbcUtils;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public boolean isLogin(String aname, String apwd) {
        // 获取管理员信息
    		Admin admin = adminDao.getAdminbyAname(aname);
        // 当用户名不存在时
        if (admin == null)
            return false;
        // 比较密码是否一致 JdbcUtils.MD5Tools(upwd)--> 把传递过来的密码进行MD5加密
        // ——>在和数据库中的密码比较
        String pwd = admin.getApwd();
        if (pwd.equals(JdbcUtils.MD5Tools(apwd))) {// 密码正确
            return true;
        }
        return false;
    }

    @Override
    public Admin getAdmin(String aname) {
    		return adminDao.getAdminbyAname(aname);
    }

}
