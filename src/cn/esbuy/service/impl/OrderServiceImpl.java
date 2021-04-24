package cn.esbuy.service.impl;

import java.util.List;
import cn.esbuy.dao.OrderDao;
import cn.esbuy.dao.impl.OrderDaoImpl;
import cn.esbuy.entity.Order;
import cn.esbuy.entity.OrderDetail;
import cn.esbuy.entity.OrderVo;
import cn.esbuy.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    
    @Override
    public boolean deliverOrder(int oid) {
    		// 2 表示已发货
        if (orderDao.updateOstatus(oid, 2) >= 1)
            return true;
        return false;
    }
    
    @Override
    public boolean receiptOrder(int oid) {
    		// 3 表示已收货
        if (orderDao.updateOstatus(oid, 3) >= 1)
            return true;
        return false;
    }

    @Override
    public boolean addOrder(Order order, List<OrderDetail> list) {
        return orderDao.insertOrder(order, list) ;
    }

	@Override
	public List<OrderVo> getList() {
		return orderDao.selectList();
	}

	@Override
	public List<Order> getList(int uid) {
		return orderDao.selectList(uid);
	}
	
	@Override
    public boolean removeOrder(int oid) {
		return orderDao.deleteOrder(oid);
    }
}
