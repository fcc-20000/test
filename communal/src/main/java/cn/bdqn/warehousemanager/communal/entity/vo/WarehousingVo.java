package cn.bdqn.warehousemanager.communal.entity.vo;

import cn.bdqn.warehousemanager.communal.entity.warhouse.WarehousingProducts;

import java.io.Serializable;
import java.util.List;

/**
 * 仓库库管理虚拟表
 */
public class WarehousingVo  implements Serializable {
    private Integer id;
    private Integer wid;
    private Integer aid;
    private Integer sid;
    private String founder;
    private String reviewer;
    private String reviewTime;
    private String creationTime;
    private String remarks;
    private String aName;//审核状态
    private String sName;//供应商
    private String wName;//入库类型
    private Integer pageNo;
    private Integer pageSize;
    private String contactPerson;//供应商联系人
    private String phone;//供应商联系电话

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

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

    @Override
    public String toString() {
        return "WarehousingVo{" +
                "id=" + id +
                ", wid=" + wid +
                ", aid=" + aid +
                ", sid=" + sid +
                ", founder='" + founder + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", reviewTime='" + reviewTime + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", remarks='" + remarks + '\'' +
                ", aName='" + aName + '\'' +
                ", sName='" + sName + '\'' +
                ", wName='" + wName + '\'' +
                '}';
    }
}
