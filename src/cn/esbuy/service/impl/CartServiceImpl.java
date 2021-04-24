package cn.esbuy.service.impl;

import java.util.List;

import cn.esbuy.dao.ScarDao;
import cn.esbuy.dao.impl.ScarDaoImpl;
import cn.esbuy.entity.Scar;
import cn.esbuy.entity.ScarVo;
import cn.esbuy.service.CartService;

/**
 * Description: <br/>
 * Date: 2020年2月17日 下午6:53:32 <br/>
 * 
 * @author liYan
 * @version
 * @see
 */
public class CartServiceImpl implements CartService {
    private ScarDao scarDao = new ScarDaoImpl();

    @Override
    public List<ScarVo> getList(int uid) {
        return scarDao.selectList(uid);
    }
    
    @Override
	public boolean addCart(Scar scar) {
    		int scid = 0;
    		if ((scid=scarDao.selectScID(scar.getUid(), scar.getGdid())) > 0) {
    			 if (scarDao.updateScar(scid) >=1) {
    				 return true;
    			 }
    		} else {
    			if (scarDao.insertScar(scar) >= 1) {
    				return true;
    	        }
    		}
        return false;
	}

	@Override
    public boolean deleteCart(int scid) {
        if (scarDao.deleteScar(scid) >= 1) {
            return true;
        }
        return false;
    }

}
