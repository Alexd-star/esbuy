package cn.esbuy.dao;

import java.sql.SQLException;
import java.util.List;

import cn.esbuy.entity.User;

public interface UserDao {

	/**
	 * Description: 查询所有用户信息<br/>
	 * @author liYan
	 * @return
	 */
    List<User> selectList();
    
	/**
	 * Description: 根据用户名或者手机包含的keywords查询用户<br/>
	 * @author liYan
	 * @param keywords
	 * @return
	 */
    List<User> selectList(String keywords);
    
	/**
	 * Description:根据uid查询用户信息 <br/>
	 * @author liY
	 * @param uid
	 * @return
	 */
    User getUser(int uid);
    
    /**
     * Description: 注册 通过实体类,成功返回大于1，失败返回0<br/>
     * @author liYan
     * @throws SQLException
     */
    int insertUser(User user);
    
	/**
	 * Description: 修改用户资料信息<br/>
	 * @author liYan
	 * @param user
	 * @return
	 */
    int updateUser(User user);
    
	/**
	 * Description: 根据uid删除用户 <br/>
	 * @author liYan
	 * @param uid
	 * @return
	 */
    int deleteUser(int uid);
    
    /**
     * Description: 判断用户名是否存在,成功返回大于0，失败返回0<br/>
     * @author liYan
	 * @param uname
	 * @return
     */
    int isUname(String uname);
    
    /**
     * Description: 根据用户名获取用户密码<br/>
     * @author liYan
     * @param uname
     * @return
     */
    String selectUpwd(String uname);

}
