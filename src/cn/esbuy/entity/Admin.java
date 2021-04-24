package cn.esbuy.entity;

import java.util.Date;

public class Admin {
	private int aid;
	private String aname;
	private String apwd;
	private Date alastlogin;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public Date getAlastlogin() {
		return alastlogin;
	}
	public void setAlastlogin(Date alastlogin) {
		this.alastlogin = alastlogin;
	}
	public Admin() {
	}
	
	
}
