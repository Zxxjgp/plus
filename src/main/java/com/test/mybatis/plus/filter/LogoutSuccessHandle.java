package com.test.mybatis.plus.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @ProjectName: plus
 * @Package: com.test.mybatis.plus.filter
 * @ClassName: LogoutSuccessHandle
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/28 15:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/28 15:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LogoutSuccessHandle implements LogoutSuccessHandler {
    /**
     * 退出成功之后纯定向的页面
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String path = httpServletRequest.getContextPath();
        String basePath = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + path + "/";

        /**
         * 所述HttpServletRequest.logout（）方法可用于出登录当前用户。
         *
         * 通常这意味着SecurityContextHolder将被清除，HttpSession将被无效，任何“记住我”身份验证将被清除，等等。但是，配置的LogoutHandler实现将根据您的Spring Security配置而有所不同。重要的是要注意，在调用HttpServletRequest.logout（）之后，您仍然负责编写响应。通常，这将涉及重定向到欢迎页面
         */
        httpServletRequest.logout();
        httpServletResponse.sendRedirect(basePath + "logoutYemian");



    }
}
