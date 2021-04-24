package cn.esbuy.service.impl;

import java.util.List;

import cn.esbuy.dao.GoodTypeDao;
import cn.esbuy.dao.impl.GoodTypeDaoImpl;
import cn.esbuy.entity.GoodType;
import cn.esbuy.service.GoodTypeService;

public class GoodTypeServiceImpl implements GoodTypeService {
    GoodTypeDao goodtypeDao = new GoodTypeDaoImpl();

    @Override
    public List<GoodType> getList() {
        return goodtypeDao.selectList();
    }

    @Override
    public GoodType getGoodType(int tid) {
        return goodtypeDao.selectGoodType(tid);
    }
    
    @Override
    public boolean addGoodType(String tname) {
        if (goodtypeDao.insertGoodType(tname) >= 1) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean updateGoodType(GoodType goodtype) {
        if (goodtypeDao.updateGoodType(goodtype) >= 1)
            return true;
        return false;

    }
    
    @Override
    public boolean deleteGoodType(int tid) {
        if (goodtypeDao.deleteGoodType(tid) >= 1)
            return true;
        return false;
    }

}
