package cn.esbuy.service;

import java.sql.SQLException;
import java.util.List;

import cn.esbuy.entity.Scar;
import cn.esbuy.entity.ScarVo;

public interface CartService {

    /**
     * Description:根据uid返回当前用户的购物车 <br/>
     * @author liYan
     * @param uid
     * @return
     * @throws SQLException
     */
    List<ScarVo> getList(int uid);
    
    /**
     * Description:加入购物车 如果该商品已经放入购物车，购买数量+1；如果没有放入购物车，则添加商品<br/>
     * @author liYan
     * @param scar
     * @return
     * @throws SQLException
     */
    boolean addCart(Scar scar);
    
    /**
     * Description:删除购物车记录 <br/>
     * @author liYan
     * @param scid
     * @return
     * @throws SQLException
     */
    boolean deleteCart(int scid);

}
