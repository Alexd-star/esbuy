package cn.esbuy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class GoodVo extends Good {
	private String tname;

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public GoodVo(String tname) {
		super();
		this.tname = tname;
	}

	public GoodVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoodVo(int gdid, int tid, String gdcode, String gdname, BigDecimal gdprice, int gdquantity, int gdsaleqty,
			String gdcity, String gdimage, String gdinfo, Date gdaddtime, int gdhot) {
		super(gdid, tid, gdcode, gdname, gdprice, gdquantity, gdsaleqty, gdcity, gdimage, gdinfo, gdaddtime, gdhot);
		// TODO Auto-generated constructor stub
	}
	
	
}
