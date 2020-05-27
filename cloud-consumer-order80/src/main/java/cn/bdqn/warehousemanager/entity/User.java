package cn.bdqn.warehousemanager.entity;

import cn.bdqn.warehousemanager.communal.entity.Menu;
import cn.bdqn.warehousemanager.communal.entity.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApiModel(value = "用户注册的实体")
public class User implements UserDetails {
    @ApiModelProperty(name = "id", notes = "用户编号", dataType = "Integer")
    private Integer id;
    @ApiModelProperty(name = "username", notes = "用户名", dataType = "String")
    @NotEmpty(message = "用户名不能为空！")
    private String username;
    @ApiModelProperty(name = "password", notes = "密码", dataType = "String")
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
    @NotEmpty(message = "工号不能为空！")
    private String creationTime;
    private String founder;
    private Boolean enabled;
    private Boolean locked;
    private List<Role> roles;

    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "User{" +
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
                ", enabled=" + enabled +
                ", locked=" + locked +
                ", roles=" + roles +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        for (Menu menu : menus) {
            authorities.add(new SimpleGrantedAuthority(menu.getMenuName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setUserName(String userName) {
        this.username = userName;
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

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }


    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
