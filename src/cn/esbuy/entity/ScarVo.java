package cn.esbuy.entity;

import java.math.BigDecimal;

public class ScarVo extends Scar {
	private String gdname;
	private BigDecimal gdprice;
	private String gdimage;

	public String getGdname() {
		return gdname;
	}

	public void setGdname(String gdname) {
		this.gdname = gdname;
	}

	public BigDecimal getGdprice() {
		return gdprice;
	}

	public void setGdprice(BigDecimal gdprice) {
		this.gdprice = gdprice;
	}

	public String getGdimage() {
		return gdimage;
	}

	public void setGdimage(String gdimage) {
		this.gdimage = gdimage;
	}
	
	
	
}
