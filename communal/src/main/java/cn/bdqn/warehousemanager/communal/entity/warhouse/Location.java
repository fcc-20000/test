package cn.bdqn.warehousemanager.communal.entity.warhouse;

import java.io.Serializable;

public class Location  implements Serializable {
    private Integer id;
    private String lName;
    private Integer wid;
    private Integer lid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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
