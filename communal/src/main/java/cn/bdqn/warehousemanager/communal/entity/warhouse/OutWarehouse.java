package cn.bdqn.warehousemanager.communal.entity.warhouse;

import java.io.Serializable;

/**
 * 出库管理
 */
public class OutWarehouse  implements Serializable {

    private Integer id;
    private Integer wid;
    private Integer aid;
    private Integer sid;
    private String founder;
    private String reviewer;
    private String reviewTime;
    private String creationTime;
    private String remarks;

    @Override
    public String toString() {
        return "OutWarehouse{" +
                "id=" + id +
                ", wid=" + wid +
                ", aid=" + aid +
                ", sid=" + sid +
                ", founder='" + founder + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", reviewTime='" + reviewTime + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
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
}
