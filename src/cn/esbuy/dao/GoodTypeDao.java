package cn.esbuy.dao;

import java.util.List;
import cn.esbuy.entity.GoodType;

public interface GoodTypeDao {

    /**
     * Description:获取所有商品类别 <br/>
     * @author liYan
     * @return
     */
    List<GoodType> selectList();

    /**
     * Description:根据tid查询商品类别 <br/>
     * @author liYan
     * @param tid
     * @return
     */
    GoodType selectGoodType(int tid);

    /**
     * Description:根据类别名称插入商品类别 <br/>
     * @author liYan
     * @param tname
     * @return
     */
	int insertGoodType(String tname);
	
    /**
     * Description: 修改商品类别<br/>
     * @author liYan
     * @param goodtype
     * @return
     */
	int updateGoodType(GoodType goodtype);
	
    /**
     * Description: 根据tid删除商品类别<br/>
     * @author liYan
     * @param tid
     */
	int deleteGoodType(int tid);

}
