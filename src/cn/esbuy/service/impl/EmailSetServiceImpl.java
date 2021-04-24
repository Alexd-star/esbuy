package cn.esbuy.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cn.esbuy.dao.EmailSetDao;
import cn.esbuy.dao.impl.EmailSetDaoImpl;
import cn.esbuy.entity.EmailSet;
import cn.esbuy.service.EmailSetService;
import cn.esbuy.service.UserService;

public class EmailSetServiceImpl implements EmailSetService {
    private EmailSetDao emailsetDao = new EmailSetDaoImpl();
    private UserService userService = new UserServiceImpl();

    @Override
    public EmailSet getEmailSet() {
        return emailsetDao.selectEmail();
    }
   
    @Override
    public boolean editEmailSet(EmailSet emailset) {
        if (emailsetDao.updateEmail(emailset) >= 1) {
            return true;
        }
        return false;

    }
    
    public boolean sendEmail(int uid) {
    		boolean flag = false;
    		EmailSet emailset =  getEmailSet();
    		Properties prop = new Properties();
    		prop.setProperty("mail.host", emailset.getEmserver());
    		prop.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求
    		prop.setProperty("mail.smtp.port", "25");
    		Session msession = Session.getInstance(prop);
    		try {
				Transport ts = msession.getTransport();
				ts.connect(emailset.getEmserver(), emailset.getEmaddress(), emailset.getEmpasscode());
				MimeMessage message = new MimeMessage(msession);
				message.setFrom(new InternetAddress(emailset.getEmaddress()));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(userService.getUemail(uid)));
				message.setSubject("订单发送提醒");
				message.setContent("订单已发货，请注意查收！", "text/html;charset=UTF-8");
				ts.sendMessage(message, message.getAllRecipients());
				ts.close();
				flag = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		return flag;
    		
    		
    }
}
