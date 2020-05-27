package cn.bdqn.warehousemanager.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

//判断用户是否具有当前权限
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

    //判断是否具有当前权限
    @Override
    public void decide(Authentication auth, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        Collection<? extends GrantedAuthority> auths = auth.getAuthorities();
        for (ConfigAttribute configAttribute : collection) {
            if ("ROLE_".equals(configAttribute.getAttribute()) && auth instanceof UsernamePasswordAuthenticationToken) {
                return;//进入需要登录
            }
            for (GrantedAuthority authority : auths) {
                if (configAttribute.getAttribute().equals(authority.getAuthority())) {
                    return;//说明登录，解释方法进入正常流程
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
