package cn.esbuy.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * Description:数据库中的表Good的实体类 <br/>
 * date: 2020年2月14日 下午4:14:43 <br/>
 *
 * @author liYan
 * @version
 */
public class Good {
    private int gdid;
    private int tid;
    private String gdcode;
    private String gdname;
    private BigDecimal gdprice;
    private int gdquantity;
    private int gdsaleqty;
    private String gdcity;
    private String gdimage;
    private String gdinfo;
    private Date gdaddtime;
    private int gdhot;

    public String getGdcode() {
        return gdcode;
    }

    public void setGdcode(String gdcode) {
        this.gdcode = gdcode;
    }

    public String getGdname() {
        return gdname;
    }

    public void setGdname(String gdname) {
        this.gdname = gdname;
    }

    public String getGdcity() {
        return gdcity;
    }

    public void setGdcity(String gdcity) {
        this.gdcity = gdcity;
    }

    public String getGdimage() {
        return gdimage;
    }

    public void setGdimage(String gdimage) {
        this.gdimage = gdimage;
    }

    public String getGdinfo() {
        return gdinfo;
    }

    public void setGdinfo(String gdinfo) {
        this.gdinfo = gdinfo;
    }

    public Date getGdaddtime() {
        return gdaddtime;
    }

    public void setGdaddtime(Date gdaddtime) {
        this.gdaddtime = gdaddtime;
    }

	public int getGdid() {
		return gdid;
	}

	public void setGdid(int gdid) {
		this.gdid = gdid;
	}

	public BigDecimal getGdprice() {
		return gdprice;
	}

	public void setGdprice(BigDecimal gdprice) {
		this.gdprice = gdprice;
	}

	public int getGdquantity() {
		return gdquantity;
	}

	public void setGdquantity(int gdquantity) {
		this.gdquantity = gdquantity;
	}

	public int getGdsaleqty() {
		return gdsaleqty;
	}

	public void setGdsaleqty(int gdsaleqty) {
		this.gdsaleqty = gdsaleqty;
	}

	public int getGdhot() {
		return gdhot;
	}

	public void setGdhot(int gdhot) {
		this.gdhot = gdhot;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Good() {}

	public Good(int gdid, int tid, String gdcode, String gdname, BigDecimal gdprice, int gdquantity, int gdsaleqty,
			String gdcity, String gdimage, String gdinfo, Date gdaddtime, int gdhot) {
		this.gdid = gdid;
		this.tid = tid;
		this.gdcode = gdcode;
		this.gdname = gdname;
		this.gdprice = gdprice;
		this.gdquantity = gdquantity;
		this.gdsaleqty = gdsaleqty;
		this.gdcity = gdcity;
		this.gdimage = gdimage;
		this.gdinfo = gdinfo;
		this.gdaddtime = gdaddtime;
		this.gdhot = gdhot;
	}
    
}