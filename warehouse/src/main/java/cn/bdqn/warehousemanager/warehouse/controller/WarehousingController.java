package cn.bdqn.warehousemanager.warehouse.controller;

import cn.bdqn.warehousemanager.communal.entity.vo.UpdateWarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingProductsVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.warhouse.*;
import cn.bdqn.warehousemanager.communal.util.Page;
import cn.bdqn.warehousemanager.warehouse.service.audit.AuditService;
import cn.bdqn.warehousemanager.warehouse.service.location.LocationService;
import cn.bdqn.warehousemanager.warehouse.service.product.ProductService;
import cn.bdqn.warehousemanager.warehouse.service.supplier.SupplierService;
import cn.bdqn.warehousemanager.warehouse.service.warehousing.WarehousingService;
import cn.bdqn.warehousemanager.warehouse.service.warehousingproducts.WarehousingproductsService;
import cn.bdqn.warehousemanager.warehouse.service.warehousingtype.WarehousingTypeService;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Mod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WarehousingController {
    @Autowired
    ProductService productService;//商品

    @Autowired
    WarehousingService warehousingService;//入库表单
    @Autowired
    LocationService locationService;//库位
    @Autowired
    SupplierService supplierService;//供应商

    @Autowired
    WarehousingTypeService warehousingTypeService;//入库相信
    @Autowired
    AuditService auditService;//审核状态

    @Autowired
    WarehousingproductsService warehousingproductsService;//入库原因


    @PostMapping("/inhouse")
    public String getWarhousing(@RequestBody WarehousingVo warehousingVo) {
        ModelAndView modelAndView = new ModelAndView();
        if (warehousingVo.getPageNo() == null) {
            warehousingVo.setPageNo(1);
        }
        System.out.println("进入入库管理页面");
        int total = warehousingService.getAllWarehousingCount(warehousingVo);
        Page page = new Page(warehousingVo.getPageNo(), 4, total);
        List<Audit> auditList = auditService.getAuditAll();
        List<WarehousingType> warehousingTypeList = warehousingTypeService.getWarehousingTypeAll();
        warehousingVo.setPageNo(page.getBeginPos());
        warehousingVo.setPageSize(page.getPageSize());
        List<WarehousingVo> list = warehousingService.getAllWarehousing(warehousingVo);
        page.setRows(list);
        modelAndView.addObject("auditList", auditList);
        modelAndView.addObject("warehousingTypeList", warehousingTypeList);
        modelAndView.addObject("pages", page);
        return JSON.toJSONString(modelAndView);
    }

    @GetMapping("/detailed")
    public ModelAndView getDetailed(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("进入入库详情页面");
        List<WarehousingProducts> warehousingProductsList = warehousingproductsService.getWarehousingProductsById(id);
        WarehousingVo warehousingVo = warehousingService.getWarehousingVoById(id);
        modelAndView.setViewName("storageDetails");
        modelAndView.addObject("warehousingProductsList", warehousingProductsList);
        modelAndView.addObject("warehousingVo", warehousingVo);
        return modelAndView;
    }

    @GetMapping("/addWarehousing")
    public ModelAndView addWarehousingHtml() {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("添加入库详情页面");
        List<WarehousingType> warehousingTypeList = warehousingTypeService.getWarehousingTypeAll();
        List<Location> locationList = locationService.getLocationAll();
        List<Supplier> supplierList = supplierService.getSupplierAll();
        List<Product> productList = productService.getProductAll();
        modelAndView.addObject("productList", productList);//商品
        modelAndView.addObject("warehousingTypeList", warehousingTypeList);//入库单类型
        modelAndView.addObject("locationList", locationList);//库位
        modelAndView.addObject("supplierList", supplierList);//供应商
        modelAndView.setViewName("addWarehousing");
        return modelAndView;
    }

    @PostMapping("/addWarehousing")
    public String addWarehousing(WarehousingProductsVo warehousingProductsVo, HttpSession session) {
        System.out.println("添加入库详情");
        //获取用户创建人
//        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
//        String founder = ((UserDetails) securityContext.getAuthentication().getPrincipal()).getUsername();
//        warehousingProductsVo.setFounder(founder);
        int result = warehousingService.addWarehousing(warehousingProductsVo);
        if (result > 0) {
            return "redirect:/api/warehouse/inhouse";
        }
        return "redirect:/api/warehouse/addWarehousing";

    }


    @GetMapping("/updateWarehousingVo")
    public ModelAndView updateWarehousingHtml(Integer id) {
        System.out.println("更新入库信息页面");
        ModelAndView modelAndView = new ModelAndView();
        List<WarehousingProducts> warehousingProductsList = warehousingproductsService.getWarehousingProductsById(id);
        List<WarehousingType> warehousingTypeList = warehousingTypeService.getWarehousingTypeAll();
        WarehousingVo warehousingVo = warehousingService.getWarehousingVoById(id);
        List<Location> locationList = locationService.getLocationAll();
        List<Product> productList = productService.getProductAll();
        List<Supplier> supplierList = supplierService.getSupplierAll();
        modelAndView.addObject("warehousingTypeList", warehousingTypeList);//入库单类型
        modelAndView.addObject("supplierList", supplierList);//供应商
        modelAndView.addObject("locationList", locationList);//库位
        modelAndView.addObject("warehousingProductsList", warehousingProductsList);//入库产品信息
        modelAndView.addObject("warehousingVo", warehousingVo);
        modelAndView.setViewName("updateWarehousing");
        return modelAndView;
    }

    @PostMapping("/updateWarehousingVo")
    public String updateWarehousingVo(UpdateWarehousingVo updateWarehousingVo) {
        System.out.println("更新入库信息");
        int result = warehousingService.updateWarehousing(updateWarehousingVo);
        if (result > 0) {
            return "redirect:/api/warehouse/inhouse";
        }
        System.out.println("添加完成");
        return "updateWarehousingVo";
    }

    @GetMapping("/deleteWarehousingproducts")
    @ResponseBody
    public String deletarehousingproducts(Integer id) {
        System.out.println("删除入库产品信息");
        int result = warehousingproductsService.deleteWarehousingProductsByid(id);
        List<String> list = new ArrayList<>();
        String prompt;
        if (result > 0) {
            prompt = "删除成功";

        } else {
            prompt = "删除失败";
        }
        list.add(prompt);
        return JSON.toJSONString(list);
    }

    @GetMapping("/delete")
    @ResponseBody
    public String deleteWarehousing(Integer id) {
        System.out.println("删除入库信息");
        int result = warehousingService.deleteWarehousingById(id);
        List<String> list = new ArrayList<>();
        String prompt;
        if (result > 0) {
            prompt = "删除成功";

        } else {
            prompt = "删除失败";
        }
        list.add(prompt);
        return JSON.toJSONString(list);
    }

    @GetMapping("/updateReviewHtml")
    public ModelAndView updateReviewHtml(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("进入入库详情页面");
        List<WarehousingProducts> warehousingProductsList = warehousingproductsService.getWarehousingProductsById(id);
        WarehousingVo warehousingVo = warehousingService.getWarehousingVoById(id);
        modelAndView.setViewName("updateReview");
        modelAndView.addObject("warehousingProductsList", warehousingProductsList);
        modelAndView.addObject("warehousingVo", warehousingVo);
        return modelAndView;
    }

    @GetMapping("/updateReview")
    public String updateReview(Integer id, Integer aid) {
        ModelAndView modelAndView = new ModelAndView("/getWarehousing");
        Integer result = warehousingService.updateReview(id, "aaa", aid);
        if (result > 0) {
            return "redirect:/api/warehouse/inhouse";
        } else {
            return "redirect:/api/warehouse/updateReviewHtml?id=" + id;
        }
    }

}
