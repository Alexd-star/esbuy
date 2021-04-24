package cn.esbuy.entity;

public class Scar {
	private int scid;
	private int uid;
	private int gdid;
	private int scnum;
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGdid() {
		return gdid;
	}
	public void setGdid(int gdid) {
		this.gdid = gdid;
	}
	public int getScnum() {
		return scnum;
	}
	public void setScnum(int scnum) {
		this.scnum = scnum;
	}
	public Scar(int uid, int gdid, int scnum) {
		super();
		this.uid = uid;
		this.gdid = gdid;
		this.scnum = scnum;
	}
	public Scar() {
		super();
		// TODO Auto-generated constructor stub
	}
}
