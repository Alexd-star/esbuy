package cn.esbuy.dao;

import java.util.List;
import cn.esbuy.entity.Good;
import cn.esbuy.entity.GoodVo;

public interface GoodDao {
    
	/**
	 * Description: 查询所有商品信息 包含商品的类别名称 按添加时间倒序排序，返回前top条记录<br/>
	 * @param top
	 * @return
	 */
    List<GoodVo> selectList(Integer top);
    
	/**
	 * Description: 根据tID和商品名称查询商品<br/>
	 * @param tid
	 * @param gdname
	 * @return
	 */
    List<GoodVo> selectList(int tid, String gdname);

	/**
	 * Description: 根据gdid查询商品<br/>
	 * @param gdid
	 * @return
	 */
    Good selectGood(int gdid);
    
    /**
	 * Description: 插入商品，不包括上传的商品图片路径 插入成功返回大于等于1，否则返回0<br/>
	 * @author liYan
	 * @param good
	 */
    int insertNotImgOfGood(Good good);
    
	/**
	 * Description: 插入商品，包括上传的商品图片路径 成功返回大于等于1，否则返回0<br/>
	 * @author liYan
	 * @param good 
	 * @return
	 */
    int insertGood(Good good);
    
	/**
	 * Description: 修改商品，不包括上传的商品图片路径，返回大于等于1，否则返回0<br/>
	 * @author liYan
	 * @param good
	 * @return
	 */
    public int updateNotImgOfGood(Good good);
    
	/**
	 * Description: 修改商品，包括上传的商品图片路径，返回大于等于1，否则返回0<br/>
	 * @author liYan
	 * @param good
	 * @return
	 */
    int updateGood(Good good);
    
    /**
     * Description: 根据gdid删除商品信息 <br/>
     * @author liYan
     * @param gdid
     * @return
     */
    int deleteGood(int gdid);
}
