package cn.bdqn.warehousemanager.config;


import cn.bdqn.warehousemanager.communal.entity.Menu;
import cn.bdqn.warehousemanager.communal.entity.Role;
import cn.bdqn.warehousemanager.communal.mapper.menu.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

//security动态权限配置-读取权限
@Component
public class CustomFileterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    AntPathMatcher antPathMatcher = new AntPathMatcher();//用于实现ant风格的URL匹配
    @Autowired
    MenuMapper menuMapper;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();//提前当前请求的URL
        List<Menu> allMenus = menuMapper.getAllMenus();
        for (Menu menu : allMenus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] roleArr = new String[roles.size()];
                for (int i = 0; i < roleArr.length; i++) {
                    roleArr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleArr);
            }
        }
        return SecurityConfig.createList("ROLE_");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterSecurityInterceptor.class.isAssignableFrom(aClass);
    }
}
