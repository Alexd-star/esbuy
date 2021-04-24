package cn.esbuy.service;

import cn.esbuy.entity.Admin;

public interface AdminService {

    /**
     * Description: 后台登录是否成功<br/>
     * @param aname
     * @param apwd
     * @return
     */
    boolean isLogin(String aname, String apwd);

    /**
     * Description: 根据aname获取管理员<br/>
     * @param uname
     * @return
     */
    Admin getAdmin(String aname);

}
