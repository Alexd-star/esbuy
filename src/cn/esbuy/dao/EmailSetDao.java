package cn.esbuy.dao;

import cn.esbuy.entity.EmailSet;

public interface EmailSetDao {

    /**
     * Description: 修改邮件发送设置<br/>
     * @author liYan
     * @param emailset
     * @return
     */
    int updateEmail(EmailSet emailset);

    /**
     * Description: 查询邮件发送设置<br/>
     * @author liYan
     * @return
     */
    EmailSet selectEmail();
}
