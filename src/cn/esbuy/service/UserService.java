package cn.esbuy.service;

import java.util.List;

import cn.esbuy.entity.User;

public interface UserService {

    /**
     * Description: 查询所有用户信息<br/>
     * @author liYan
     * @return
     */
    List<User> getList();
    
    /**
     * Description: 根据用户名或者手机包含的keywords查询用户 admin使用<br/>
     * @author liYan
     * @return
     */
    List<User> getList(String keywords);
    
	/**
     * Description:根据uid查询用户 <br/>
     * @author liYan
     * @param uid
     * @return
     */
    User getUser(int uid);
    
	/**
     * Description:根据uname查询用户 <br/>
     * @author liYan
     * @param uname
     * @return
     */
    User getUser(String uname);
    
    /**
     * Description: 根据uid删除用户 true/ false <br/>
     * @author liYan
     * @param uid
     * @return
     */
    boolean removeUser(int uid);
    
    /**
     * Description: 会员注册<br/>
     * @author liYan
     * @param user
     * @return
     */
    boolean addUser(User user);
    
    /**
     * Description: 判断会员信息是否修改成功<br/>
     * @author liYan
     * @param user
     * @return
     */
    boolean editUser(User user);
    
    /**
     * Description: 检查用户名是否存在<br/>
     * @author liYan
     * @param uname
     * @return
     */
    boolean checkName(String uname);
    
    /**
     * Description:判断登录是否成功，成功则返回true，否则返回false <br/>
     * @author liYan
     * @param uname
     * @param upwd
     * @return
     */
    boolean isLogin(String uname, String upwd);

    /**
     * Description: 根据用户ID查询用户邮箱<br/>
     * @author liYan
     * @param uid
     * @return
     */
    String getUemail(int uid);

}
