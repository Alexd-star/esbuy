package cn.esbuy.service;

import cn.esbuy.entity.EmailSet;

public interface EmailSetService {

    /**
     * Description: 获取邮件发送设置<br/>
     * @author liYan
     * @return
     */
    EmailSet getEmailSet() ;
    
    /**
     * Description: 修改邮件发送设置<br/>
     * @author liYan
     * @param emailset
     * @return
     */
    boolean editEmailSet(EmailSet emailset);
    
    /**
     * Description: 根据uid给指定用户发送邮件<br/>
     * @author liYan
     * @param uid
     * @return
     */
    boolean sendEmail(int uid);

}
