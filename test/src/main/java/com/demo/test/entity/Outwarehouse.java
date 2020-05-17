package com.demo.test.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Outwarehouse)实体类
 *
 * @author makejava
 * @since 2020-05-16 17:03:37
 */
public class Outwarehouse implements Serializable {
    private static final long serialVersionUID = 921597443083928755L;
    /**
    * 出库单号
    */
    private Integer id;
    /**
    * 入库单类型
    */
    private Integer wid;
    /**
    * 审核状态
    */
    private Integer aid;
    /**
    * 供应商id
    */
    private Integer sid;
    /**
    * 制单人
    */
    private String founder;
    /**
    * 审核人
    */
    private String reviewer;
    /**
    * 审核时间
    */
    private Date reviewtime;
    /**
    * 创建时间
    */
    private Date creationtime;
    /**
    * 备注
    */
    private String remarks;


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

    public Date getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(Date reviewtime) {
        this.reviewtime = reviewtime;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}