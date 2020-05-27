package cn.bdqn.warehousemanager.communal.entity.vo;

import cn.bdqn.warehousemanager.communal.entity.warhouse.WarehousingProducts;

import java.io.Serializable;
import java.util.List;

/**
 * 订单表
 */
public class WarehousingProductsVo  implements Serializable {
    private Integer id;
    private Integer wid;
    private Integer aid;
    private Integer sid;
    private String founder;
    private String reviewer;
    private String reviewTime;
    private String creationTime;
    private String remarks;
    private Integer[] pId;//商品id
    private String[] batch;//商品批次
    private Integer[] number;//商品数量
    private Double[] totalPrice;//商品总价
    private Integer[] lid;//默认仓库id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer[] getpId() {
        return pId;
    }

    public void setpId(Integer[] pId) {
        this.pId = pId;
    }

    public String[] getBatch() {
        return batch;
    }

    public void setBatch(String[] batch) {
        this.batch = batch;
    }

    public Integer[] getNumber() {
        return number;
    }

    public void setNumber(Integer[] number) {
        this.number = number;
    }

    public Double[] getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double[] totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer[] getLid() {
        return lid;
    }

    public void setLid(Integer[] lid) {
        this.lid = lid;
    }
}
