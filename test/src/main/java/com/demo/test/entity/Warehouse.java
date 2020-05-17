package com.demo.test.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Warehouse)实体类
 *
 * @author makejava
 * @since 2020-05-16 17:17:38
 */
public class Warehouse implements Serializable {
    private static final long serialVersionUID = -87770072847143303L;
    /**
    * 仓库编号
    */
    private Integer id;
    /**
    * 仓库名称
    */
    private String wname;
    /**
    * 作用
    */
    private String effect;
    /**
    * 租赁时间
    */
    private Date leasetime;
    /**
    * 面积
    */
    private Object area;
    /**
    * 地址
    */
    private String address;
    /**
    * 部门id
    */
    private Integer did;
    /**
    * 仓库类型
    */
    private Integer wid;
    /**
    * 计量单位id
    */
    private Integer mid;
    /**
    * 联系人
    */
    private String contactperson;
    /**
    * 电话
    */
    private String phone;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Date getLeasetime() {
        return leasetime;
    }

    public void setLeasetime(Date leasetime) {
        this.leasetime = leasetime;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}