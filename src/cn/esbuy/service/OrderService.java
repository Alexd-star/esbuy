package cn.esbuy.service;

import java.util.List;

import cn.esbuy.entity.Order;
import cn.esbuy.entity.OrderDetail;
import cn.esbuy.entity.OrderVo;

public interface OrderService {

	/**
	 * Description: 查询所有订单 包括用户名<br/>
	 * @author liYan
	 * @return
	 */
	List<OrderVo> getList();

	/**
	 * Description: 根据uid查询指定用户的订单<br/>
	 * @author liYan
	 * @param uid
	 * @return
	 */
	List<Order> getList(int uid);

	/**
	 * Description: 添加订单是否成功<br/>
	 * @author liYan
	 * @param order
	 * @param list
	 * @return
	 */
	boolean addOrder(Order order, List<OrderDetail> list);

	/**
	 * Description: 修改订单为已发货<br/>
	 * @author liYan
	 * @param oid
	 * @return
	 */
	boolean deliverOrder(int oid);

	/**
	 * Description: 修改订单为已收货<br/>
	 * @author liYan
	 * @param oid
	 * @return
	 */
	boolean receiptOrder(int oid);

	/**
	 * Description: 判断是否删除订单成功<br/>
	 * @author liYan
	 * @param oid
	 * @return
	 */
	boolean removeOrder(int oid);
}
