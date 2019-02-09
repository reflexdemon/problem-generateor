package io.vpv.math.problemgenerateor.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityProtection extends HandlerInterceptorAdapter {

    public static final String SESSION_USER = "SESSION_USER";
    public static final String ASK_SESSION = "https://truelogin.vpv.io/whoisthis?callback=";

    @Value("${app.callback}")
    private String callback = "LOCAL_TESTING";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ((request.getRequestURL().indexOf("/login") < 0) && null == request.getSession().getAttribute(SESSION_USER)) {
            String redirectURL = ASK_SESSION + callback;
            response.sendRedirect(redirectURL);
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
