package cn.bdqn.warehousemanager.communal.entity.warhouse;

import java.io.Serializable;

/**
 * 单据类型
 */
public class WarehousingType  implements Serializable {
    private Integer id;
    private String wname;
    private Integer classification;

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

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }
}
