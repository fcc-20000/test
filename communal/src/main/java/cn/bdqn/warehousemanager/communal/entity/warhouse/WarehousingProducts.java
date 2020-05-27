package cn.bdqn.warehousemanager.communal.entity.warhouse;

import java.io.Serializable;

/**
 * 仓储产品
 */
public class WarehousingProducts implements Serializable {

    private Integer id;
    private Integer wid;
    private Integer pid;
    private Integer lid;
    private Integer number;
    private Double totalPrice;
    private String batch;
    private String lName;//库位名
    private Integer pId;
    private String pName;
    private String mName;
    private Double price;

    @Override
    public String toString() {
        return "WarehousingProducts{" +
                "id=" + id +
                ", wid=" + wid +
                ", pid=" + pid +
                ", lid=" + lid +
                ", number=" + number +
                ", totalPrice=" + totalPrice +
                ", batch='" + batch + '\'' +
                ", lName='" + lName + '\'' +
                ", pId=" + pId +
                ", pName='" + pName + '\'' +
                ", mName='" + mName + '\'' +
                ", price=" + price +
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
