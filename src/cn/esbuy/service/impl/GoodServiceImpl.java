package cn.esbuy.service.impl;

import java.util.List;

import cn.esbuy.dao.GoodDao;
import cn.esbuy.dao.impl.GoodDaoImpl;
import cn.esbuy.entity.Good;
import cn.esbuy.entity.GoodVo;
import cn.esbuy.service.GoodService;

public class GoodServiceImpl implements GoodService {

    GoodDao goodDao = new GoodDaoImpl();

    @Override
    public List<GoodVo> getList() {
        return goodDao.selectList(null);
    }
    
    @Override
    public List<GoodVo> getList(Integer top) {
        return goodDao.selectList(top);
    }


    @Override
	public List<GoodVo> getList(int tid, String gdname) {
    		return goodDao.selectList(tid, gdname);
	}
    
    @Override
    public Good getGood(int gdid) {
        return goodDao.selectGood(gdid);
    }
    
    @Override
    public boolean addGood(Good good) {
        if (goodDao.insertGood(good) >= 1) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean editGood(Good good) {
        if (goodDao.updateGood(good) >= 1) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean removeGood(int gdid) {
        if (goodDao.deleteGood(gdid) >= 1) {
            return true;
        }
        return false;
    }

}
