package cn.esbuy.dao;

import java.sql.SQLException;
import java.util.List;

import cn.esbuy.entity.Scar;
import cn.esbuy.entity.ScarVo;

public interface ScarDao {

    /**
     * Description: 查询uid查询当前用户的购物车<br/>
     * @author liY
     * @param uid
     * @return
     * @throws SQLException
     */
    List<ScarVo> selectList(int uid);

    /**
     * Description: 根据scid删除购物车记录<br/>
     * @author liYan
     * @param scid
     * @return
     * @throws SQLException
     */
    int deleteScar(int scid) ;
    
    /**
     * Description:插入购物车 <br/>
     * @author liYan
     * @param scar
     * @return
     * @throws SQLException
     */
    int insertScar(Scar scar);
    
    /**
     * Description:根据uid和gdid查询购物车ID <br/>
     * @author liYan
     * @param scar
     * @return
     * @throws SQLException
     */
    int selectScID(int uid, int gdid);
    
    /**
     * Description:根据scid更新购物车 <br/>
     * @author liYan
     * @param scar
     * @return
     * @throws SQLException
     */
    int updateScar(int scid);
}
