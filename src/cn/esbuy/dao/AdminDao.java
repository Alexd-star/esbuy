package cn.esbuy.dao;

import cn.esbuy.entity.Admin;

public interface AdminDao {

    /**
     * Description: 根据用户名获取管理员<br/>
     * @author liYan
     * @param aname
     */
	Admin getAdminbyAname(String aname);

}
