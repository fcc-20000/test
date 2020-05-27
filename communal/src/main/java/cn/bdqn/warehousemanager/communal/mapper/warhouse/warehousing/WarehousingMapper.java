package cn.bdqn.warehousemanager.communal.mapper.warhouse.warehousing;

import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.warhouse.Warehousing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehousingMapper {

    List<WarehousingVo> getAllWarehousing(WarehousingVo warehousing);

    Integer getAllWarehousingCount(WarehousingVo warehousing);

    WarehousingVo getWarehousingVoById(Integer id);

    Integer addWarehousing(Warehousing warehousing);

    Integer deleteWarehousingById(Integer id);

    Integer updateWarehousing(Warehousing warehousing);

    Integer updateReview(Warehousing warehousing);
}
