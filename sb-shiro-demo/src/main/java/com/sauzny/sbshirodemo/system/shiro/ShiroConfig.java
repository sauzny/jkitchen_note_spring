package com.sauzny.sbshirodemo.system.shiro;

import com.sauzny.sbshirodemo.SbwConstant;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/***************************************************************************
 *
 * @时间: 2018/12/28 - 9:50
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Configuration
public class ShiroConfig {


    /**
     * 自定义realm
     *
     * @return
     */
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    /**
     * 安全管理器
     * 注：使用shiro-spring-boot-starter 1.4时，返回类型是SecurityManager会报错，直接引用shiro-spring则不报错
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }


    /**
     * 设置过滤规则
     *
     * @param securityManager
     * @return
     */
    @Bean
    @Order(SbwConstant.FilterOrder.SHIROFILTER)
    public ShiroFilterFactoryBean shiroFilter(org.apache.shiro.mgt.SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 增加自定义的 MyShiroFilter
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("myshiro", new MyShiroFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        // 设置url
        //shiroFilterFactoryBean.setLoginUrl("/login");
        //shiroFilterFactoryBean.setSuccessUrl("/");

        // restful下只设置这一个就可以
        shiroFilterFactoryBean.setUnauthorizedUrl(SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING+"/unauth");

        // 注意此处使用的是LinkedHashMap，是有顺序的，shiro会按从上到下的顺序匹配验证，匹配了就不再继续验证
        // 所以上面的url要苛刻，宽松的url要放在下面，尤其是"/**"要放到最下面，如果放前面的话其后的验证规则就没作用了。
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 不验证权限，直接通过，anon
        filterChainDefinitionMap.put(SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING+"/login", "anon");
        filterChainDefinitionMap.put(SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING+"/unauth", "anon");
        filterChainDefinitionMap.put(SbwConstant.Controller.USER_CONTROLLER_MAPPING+"/help", "anon");
        //filterChainDefinitionMap.put("/users/help", "anon");
        //filterChainDefinitionMap.put("/sbshiro/users/help", "anon");
        //filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        // 其他所有的都需要权限认证
        filterChainDefinitionMap.put("/**", "myshiro");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    /**
     * shiro集成进来后，调用API直接404异常。
     * 在shiro的配置中加入defaultAdvisorAutoProxyCreator.setUsePrefix(true);
     * @return
     */
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        return defaultAdvisorAutoProxyCreator;
    }

}
