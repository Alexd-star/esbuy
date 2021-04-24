package cn.esbuy.entity;

import java.util.Date;

/**
 * 
 * Description: <br/>
 * date: 2020年2月19日 下午5:36:04 <br/>
 *
 * @author liYan
 * @version
 */
public class User {

    /** 主键 */
    private Integer uid;

    /** 用户名 */
    private String uname;

    /** 密码 */
    private String upwd;

    /** 性别 */
    private String usex;

    /** 出生年月日 */
    private Date ubirth;

    /** 手机号 */
    private String uphone;

    /** 电子邮箱 */
    private String uemail;

    /** QQ号码 */
    private String uqq;

    /** 用户头像 */
    private String uimage;

    /** 积分 */
    private Integer ucredit;

    /** 注册时间 */
    private Date uregtime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUqq() {
        return uqq;
    }

    public void setUqq(String uqq) {
        this.uqq = uqq;
    }

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
    }

    public Integer getUcredit() {
        return ucredit;
    }

    public void setUcredit(Integer ucredit) {
        this.ucredit = ucredit;
    }

	public Date getUbirth() {
		return ubirth;
	}

	public void setUbirth(Date ubirth) {
		this.ubirth = ubirth;
	}

	public Date getUregtime() {
		return uregtime;
	}

	public void setUregtime(Date uregtime) {
		this.uregtime = uregtime;
	}
    
}