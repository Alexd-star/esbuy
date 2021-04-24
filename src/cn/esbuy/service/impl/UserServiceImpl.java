package cn.esbuy.service.impl;

import java.util.List;

import cn.esbuy.dao.UserDao;
import cn.esbuy.dao.impl.UserDaoImpl;
import cn.esbuy.entity.User;
import cn.esbuy.service.UserService;
import cn.esbuy.utils.JdbcUtils;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getList() {
        return userDao.selectList();
    }
    
    @Override
	public List<User> getList(String keywords) {
    		return userDao.selectList(keywords);
	}

    @Override
    public User getUser(int uid) {
        return userDao.getUser(uid);
    }
    
    @Override
    public User getUser(String uname) {
        return userDao.selectList(uname).get(0);
    }

    @Override
    public boolean removeUser(int uid) {
        if (userDao.deleteUser(uid) >= 1) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean addUser(User user) {
        // 获取传递过来的密码
        String pwd = user.getUpwd();
        // 通过MD5加密
        String upwd = JdbcUtils.MD5Tools(pwd);
        // 把修改好的密码放入user中
        user.setUpwd(upwd);
        if (userDao.insertUser(user) >= 1) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean editUser(User user) {
        if (userDao.updateUser(user) >= 1) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean checkName(String uname) {
        if (userDao.isUname(uname) >= 1) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isLogin(String uname, String upwd) {
        // 获取数据库中的密码
        String pwd = userDao.selectUpwd(uname);
        // 当用户名不存在时
        if (pwd == null)
            return false;
        // 比较密码是否一致 JdbcUtils.MD5Tools(upwd)--> 把传递过来的密码进行MD5加密
        // ——>在和数据库中的密码比较
        if (pwd.equals(JdbcUtils.MD5Tools(upwd))) {// 密码正确
            return true;
        }
        return false;
    }
    
    @Override
    public String getUemail(int uid) {
    		return userDao.getUser(uid).getUemail();
    }

}
