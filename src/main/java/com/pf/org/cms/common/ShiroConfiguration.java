package com.pf.org.cms.common;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @Auther: pf
 * @Date: 2017/12/12 19:34
 * @Description: shiro配置组件
 */
@Configuration
public class ShiroConfiguration {
    private static final Logger log = LoggerFactory.getLogger(ShiroConfiguration.class);

    /**
     * 注册Realm
     * @return SecurityManager
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        MyRealm myRealm = new MyRealm();
        manager.setRealm(myRealm);
        log.info("SecurityManager注册完成");
        return manager;
    }

    /**
     * 注册Filter
     * @param securityManager
     * @return ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        // 配置登录的url和登录成功的url
        filterFactoryBean.setLoginUrl("/auth/login");
        filterFactoryBean.setSuccessUrl("/home");
        // 配置未授权跳转页面
        filterFactoryBean.setUnauthorizedUrl("/static/403.ftl");
        // 配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        filterChainDefinitionMap.put("/css/**", "anon"); // 表示可以匿名访问
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/imgs/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/auth/**", "anon");
        filterChainDefinitionMap.put("/demo/**","anon");
        filterChainDefinitionMap.put("/*", "authc");// 表示需要认证才可以访问
        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/*.*", "authc");
        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        log.info("ShiroFilterFactoryBean注册完成");
        return filterFactoryBean;
    }

}
