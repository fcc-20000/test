package cn.bdqn.warehousemanager.controller;

import cn.bdqn.warehousemanager.communal.entity.vo.UpdateWarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingProductsVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.warhouse.*;
import cn.bdqn.warehousemanager.communal.util.Page;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/warehouse")
public class WarehousingController {

//    @Autowired
//    WarehousingService warehousingService;

//    @GetMapping("/inhouse")
//    public ModelAndView getWarhousing(WarehousingVo warehousingVo) {
//        String result = warehousingService.getWarhousing(warehousingVo);
//        ModelAndView modelAndView = JSON.parseObject(result, ModelAndView.class);
//        modelAndView.addObject("warehousingVo", warehousingVo);
//        modelAndView.setViewName("warehousing");
//        return modelAndView;
//    }

   /* @GetMapping("/detailed")
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
    }*/

}
