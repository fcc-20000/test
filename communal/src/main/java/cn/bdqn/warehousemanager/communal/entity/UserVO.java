package cn.bdqn.warehousemanager.communal.entity;

import javax.validation.constraints.*;
import java.io.Serializable;

//用户展示类
public class UserVO  implements Serializable {
    private Integer id;
    @NotEmpty(message = "用户名不能为空！")
    private String username;
    @NotEmpty(message = "密码不能为空！")
    private String password;
    @NotEmpty(message = "手机号不能为空！")
    @Size(max = 12, min = 10, message = "手机号必须为11位")
    private String phone;
    @NotEmpty(message = "邮箱号不能为空！")
    @Email
    private String email;
    @NotNull(message = "所属部门不能为空！")
    private Integer did;
    @NotEmpty(message = "姓名不能为空！")
    private String reaName;
    @NotNull(message = "角色不能为空！")
    private Integer rid;
    private String creationTime;//创建时间
    private String founder;//创建人
    private String name;//用户角色
    private String departmentName;//所属部门
    private Integer pageNo;
    private Integer pageSize;

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", did=" + did +
                ", reaName='" + reaName + '\'' +
                ", rid=" + rid +
                ", creationTime='" + creationTime + '\'' +
                ", founder='" + founder + '\'' +
                ", name='" + name + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getReaName() {
        return reaName;
    }

    public void setReaName(String reaName) {
        this.reaName = reaName;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}
