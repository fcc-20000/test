package cn.bdqn.warehousemanager.communal.entity;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class Role implements Serializable {
    private Integer id;
    @NotEmpty(message = "角色名不能为空！")
    private String name;
    private String creationTime;

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

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
