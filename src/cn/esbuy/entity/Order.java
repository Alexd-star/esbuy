package cn.esbuy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	private int oid;
	private int uid;
	private Date otime;
	private BigDecimal ototal;
	private String ocode;
	private int ostatus;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getOtime() {
		return otime;
	}

	public void setOtime(Date otime) {
		this.otime = otime;
	}

	public BigDecimal getOtotal() {
		return ototal;
	}

	public void setOtotal(BigDecimal ototal) {
		this.ototal = ototal;
	}

	public String getOcode() {
		return ocode;
	}

	public void setOcode(String ocode) {
		this.ocode = ocode;
	}

	public int getOstatus() {
		return ostatus;
	}

	public void setOstatus(int ostatus) {
		this.ostatus = ostatus;
	}

}
