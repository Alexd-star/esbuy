package cn.esbuy.service;

import java.sql.SQLException;
import java.util.List;

import cn.esbuy.entity.GoodType;

public interface GoodTypeService {

	/**
     * Description: 查询所有商品类型<br/>
     * @author liYan
     * @return
     */
    List<GoodType> getList();

    /**
     * Description: 根据tid查询指定类别<br/>
     * @author liYan
     * @param tid
     * @throws SQLException
     */
    GoodType getGoodType(int tid);
    
    /**
     * Description: 判断添加商品类别是否成功 <br/>
     * @author liYan
     * @param tname
     * @return
     */
    boolean addGoodType(String tname);
    
    /**
     * Description:判断修改商品类别是否成功 <br/>
     * @author liYan
     * @param goodtype
     * @return
     */
    boolean updateGoodType(GoodType goodtype);
    
    /**
     * Description: 判断商品类别是否删除成功<br/>
     * @author liYan
     * @param tid
     * @return
     */
    boolean deleteGoodType(int tid);

}
