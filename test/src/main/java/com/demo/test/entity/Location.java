package com.demo.test.entity;

import java.io.Serializable;

/**
 * (Location)实体类
 *
 * @author makejava
 * @since 2020-05-16 16:46:12
 */
public class Location implements Serializable {
    private static final long serialVersionUID = 504367543073129049L;
    
    private Integer id;
    /**
    * 库名
    */
    private String lname;
    /**
    * 所属仓库id
    */
    private Integer wid;
    /**
    * 库位状态id
    */
    private Integer lid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

}