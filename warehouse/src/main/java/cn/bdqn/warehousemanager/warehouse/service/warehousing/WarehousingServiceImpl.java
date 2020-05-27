package cn.bdqn.warehousemanager.warehouse.service.warehousing;

import cn.bdqn.warehousemanager.communal.entity.vo.UpdateWarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingProductsVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.warhouse.Warehousing;
import cn.bdqn.warehousemanager.communal.entity.warhouse.WarehousingProducts;
import cn.bdqn.warehousemanager.communal.mapper.warhouse.warehousing.WarehousingMapper;
import cn.bdqn.warehousemanager.warehouse.service.warehousingproducts.WarehousingproductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WarehousingServiceImpl implements WarehousingService {
    @Autowired
    WarehousingMapper warehousingMapper;
    @Autowired
    WarehousingproductsService warehousingproductsService;

    @Override
    public int getAllWarehousingCount(WarehousingVo warehousing) {
        return warehousingMapper.getAllWarehousingCount(warehousing);
    }

    @Override
    public WarehousingVo getWarehousingVoById(Integer id) {
        return warehousingMapper.getWarehousingVoById(id);
    }

    @Override
    public Integer addWarehousing(WarehousingProductsVo warehousingProductsVo) {
        Warehousing warehousing = new Warehousing();
        warehousing.setWid(warehousingProductsVo.getWid());//入库类型
        warehousing.setSid(warehousingProductsVo.getSid());//供应商id
        warehousing.setRemarks(warehousing.getReviewer());//备注
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        warehousing.setCreationTime(sdf.format(new Date()));
        warehousingMapper.addWarehousing(warehousing);
        WarehousingProducts warehousingProducts = new WarehousingProducts();
        warehousingProducts.setWid(warehousing.getId());
        for (int i = 0; i < warehousingProductsVo.getpId().length; i++) {
            warehousingProducts.setBatch(warehousingProductsVo.getBatch()[i]);
            warehousingProducts.setPid(warehousingProductsVo.getpId()[i]);
            warehousingProducts.setLid(warehousingProductsVo.getLid()[i]);
            warehousingProducts.setNumber(warehousingProductsVo.getNumber()[i]);
            warehousingProducts.setTotalPrice(warehousingProductsVo.getTotalPrice()[i]);
            warehousingproductsService.addWarehousingProducts(warehousingProducts);
        }
        return warehousing.getId();
    }

    @Override
    public Integer deleteWarehousingById(Integer id) {


        warehousingproductsService.deleteWarehousingProductsByWid(id);

        return warehousingMapper.deleteWarehousingById(id);
    }

    @Override
    public Integer updateWarehousing(UpdateWarehousingVo updateWarehousingVo) {
        Warehousing warehousing = new Warehousing();
        warehousing.setId(updateWarehousingVo.getWarehousingId());
        warehousing.setWid(updateWarehousingVo.getWid());//入库类型
        warehousing.setSid(updateWarehousingVo.getSid());//供应商id
        warehousing.setRemarks(warehousing.getReviewer());//备注
        WarehousingProducts warehousingProducts = new WarehousingProducts();
        for (int i = 0; i < updateWarehousingVo.getId().length; i++) {//根据商品id来循环
            warehousingProducts.setBatch(updateWarehousingVo.getBatch()[i]);
            warehousingProducts.setId(updateWarehousingVo.getId()[i]);
            warehousingProducts.setPid(updateWarehousingVo.getpId()[i]);
            warehousingProducts.setLid(updateWarehousingVo.getLid()[i]);
            warehousingProducts.setNumber(updateWarehousingVo.getNumber()[i]);
            warehousingProducts.setTotalPrice(updateWarehousingVo.getTotalPrice()[i]);
            warehousingproductsService.updateWarehousingProducts(warehousingProducts);
        }
        return warehousingMapper.updateWarehousing(warehousing);
    }

    @Override
    public Integer updateReview(Integer id, String name, Integer aid) {
        Warehousing warehousing = new Warehousing();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        warehousing.setId(id);
        warehousing.setAid(aid);
        warehousing.setReviewer(name);
        warehousing.setReviewTime(sdf.format(new Date()));
        return warehousingMapper.updateReview(warehousing);
    }

    @Override
    public List<WarehousingVo> getAllWarehousing(WarehousingVo warehousing) {
        return warehousingMapper.getAllWarehousing(warehousing);
    }
}
