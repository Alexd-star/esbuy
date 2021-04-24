package cn.esbuy.dao;

import java.util.List;
import cn.esbuy.entity.Order;
import cn.esbuy.entity.OrderVo;
import cn.esbuy.entity.OrderDetail;

public interface OrderDao {

    /**
     * Description:插入订单 <br/>
     * @author liYan
     * @param order
     * @param list
     * @return
     */
    boolean insertOrder(Order order, List<OrderDetail> list);
    
    /**
     * Description: 根据uid查询订单<br/>
     * @author liYan
     * @param uid
     * @return
     */
    List<Order> selectList(int uid);
    
    /**
     * Description: 查询所有订单<br/>
     * @author liYan
     */
    List<OrderVo> selectList();
    
    /**
     * Description: 根据oid更新订单状态<br/>
     * @author liYan
     */
    int updateOstatus(int oid, int ostatus);
    
    /**
     * Description:根据oid删除订单和订单详情 <br/>
     * @author liYan
     * @param oid
     * @return
     */
    boolean deleteOrder(int oid);

}
