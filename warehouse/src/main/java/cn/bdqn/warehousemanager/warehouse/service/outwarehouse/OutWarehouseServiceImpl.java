package cn.bdqn.warehousemanager.warehouse.service.outwarehouse;

import cn.bdqn.warehousemanager.communal.entity.vo.OutWarehouseVo;
import cn.bdqn.warehousemanager.communal.entity.vo.UpdateWarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingProductsVo;
import cn.bdqn.warehousemanager.communal.entity.warhouse.OutWarehouse;
import cn.bdqn.warehousemanager.communal.entity.warhouse.Warehousing;
import cn.bdqn.warehousemanager.communal.entity.warhouse.WarehousingProducts;
import cn.bdqn.warehousemanager.communal.mapper.warhouse.outwarehouse.OutWarehouseMapper;
import cn.bdqn.warehousemanager.communal.mapper.warhouse.warehousing.WarehousingMapper;
import cn.bdqn.warehousemanager.warehouse.service.warehousingproducts.WarehousingproductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class OutWarehouseServiceImpl implements OutWarehouseService {
    @Autowired
    OutWarehouseMapper outWarehouseMapper;
    @Autowired
    WarehousingproductsService warehousingproductsService;


    @Override
    public List<OutWarehouseVo> getAllWarehousing(OutWarehouseVo outWarehouseVo) {
        return outWarehouseMapper.getAllWarehousing(outWarehouseVo);
    }

    @Override
    public int getAllWarehousingCount(OutWarehouseVo outWarehouseVo) {
        return outWarehouseMapper.getAllWarehousingCount(outWarehouseVo);
    }

    @Override
    public OutWarehouseVo getWarehousingVoById(Integer id) {
        return outWarehouseMapper.getWarehousingVoById(id);
    }

    @Override
    public Integer addWarehousing(WarehousingProductsVo warehousingProductsVo) {
        OutWarehouse warehousing = new OutWarehouse();
        warehousing.setWid(warehousingProductsVo.getWid());//入库类型
        warehousing.setSid(warehousingProductsVo.getSid());//供应商id
        warehousing.setRemarks(warehousing.getReviewer());//备注
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        warehousing.setCreationTime(sdf.format(new Date()));
        outWarehouseMapper.addWarehousing(warehousing);
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

        return outWarehouseMapper.deleteWarehousingById(id);
    }

    @Override
    public Integer updateWarehousing(UpdateWarehousingVo updateWarehousingVo) {
        OutWarehouse warehousing = new OutWarehouse();
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
        return outWarehouseMapper.updateWarehousing(warehousing);
    }

    @Override
    public Integer updateReview(Integer id, String name, Integer aid) {
        OutWarehouse warehousing = new OutWarehouse();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        warehousing.setId(id);
        warehousing.setAid(aid);
        warehousing.setReviewer(name);
        warehousing.setReviewTime(sdf.format(new Date()));
        return outWarehouseMapper.updateReview(warehousing);
    }
}
