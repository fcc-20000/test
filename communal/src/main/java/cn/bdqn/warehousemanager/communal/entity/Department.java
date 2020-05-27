package cn.bdqn.warehousemanager.communal.entity;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class Department  implements Serializable {
    private Integer id;
    @NotEmpty(message = "部门名不能为空")
    private String departmentName;
    private String creationTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
