/**
 * Project Name:ESBuy
 * File Name:GoodType.java
 * Package Name:cn.esbuy.entity
 * Date:2020年2月14日上午1:18:15
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.esbuy.entity;

import java.util.List;

/**
 * Description: 商品类别属性 <br/>
 * Date: 2020年2月14日 上午1:18:15 <br/>
 * 
 * @author liYan
 * @version
 * @see
 */
public class GoodType {
    private int tid;
    private String tname;
    private List<Good> goodlist;
    
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
    
    public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public List<Good> getGoodlist() {
		return goodlist;
	}

	public void setGoodlist(List<Good> goodlist) {
		this.goodlist = goodlist;
	}

	public GoodType() {

    }

	public GoodType(int tid, String tname) {
		this.tid = tid;
		this.tname = tname;
	}
	
	
}
