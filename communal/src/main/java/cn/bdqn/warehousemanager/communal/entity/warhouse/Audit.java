package cn.bdqn.warehousemanager.communal.entity.warhouse;

import java.io.Serializable;

/**
 * 入库单状态
 */
public class Audit  implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
