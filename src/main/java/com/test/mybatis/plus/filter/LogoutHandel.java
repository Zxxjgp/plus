package com.test.mybatis.plus.filter;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ProjectName: plus
 * @Package: com.test.mybatis.plus.filter
 * @ClassName: LogoutHandel
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/28 11:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/28 11:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LogoutHandel implements LogoutHandler {


    /**
     * 退出处理的，需要在登出的李敏进行配置
     * @param request
     * @param response
     * @param authentication
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        System.out.println("我开始处理logout完成了");
        if (ObjectUtils.anyNotNull(authentication)){
            if (SecurityContextHolder.getContext().getAuthentication().equals(authentication)){

                System.out.println("我开始处理logout完成了");
                Assert.notNull(request, "HttpServletRequest required");
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.invalidate();
                }

                SecurityContext context = SecurityContextHolder.getContext();
                context.setAuthentication(null);

                /**
                 * 执行退出操作
                 */
                SecurityContextHolder.clearContext();
                System.out.println("我已经处理logout完成了");
            }else {
                System.out.println("用户信息不一致的问题");
            }
        }else {
            System.out.println("用户已经退出无需处理");
        }

        System.out.println("我已经处理logout完成了");
    }


}
