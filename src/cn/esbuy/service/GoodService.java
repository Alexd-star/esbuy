package cn.esbuy.service;

import java.util.List;

import cn.esbuy.entity.Good;
import cn.esbuy.entity.GoodVo;

public interface GoodService {

    /**
     * Description: 调用GoodDao中的方法 返回所有商品信息<br/>
     * @author liYan
     * @return
     */
    List<GoodVo> getList();
    
    /**
     * Description: 调用GoodDao中的方法 查询前top条商品信息<br/>
     * @author liYan
     * @return
     */
    List<GoodVo> getList(Integer top);
    
    /**
     * Description: 调用GoodDao中的方法 根据tid和gdname返回商品信息<br/>
     * @author liYan
     * @return
     */
    List<GoodVo> getList(int tid, String gdname);

    /**
     * Description: 根据gdid查询商品<br/>
     * @author liYan
     * @param gdid
     * @return
     */
    Good getGood(int gdid);
    
    /**
     * Description: 添加商品数据，成功返回true，否则返回false <br/>
     * @author liYan
     * @param good
     * @return
     */
    boolean addGood(Good good);
    
    /**
     * Description: 判断修改商品信息是否成功<br/>
     * @author liYan
     * @param good
     * @return
     */
    boolean editGood(Good good);
    
    /**
     * Description: 判断删除商品信息是否成功<br/>
     * @author liYan
     * @param gdid
     * @return
     */
    boolean removeGood(int gdid);

}
