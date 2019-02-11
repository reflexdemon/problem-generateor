package io.vpv.math.problemgenerateor.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SecurityProtection extends HandlerInterceptorAdapter {

    public static final String SESSION_USER = "SESSION_USER";
    public static final String ASK_SESSION = "https://truelogin.vpv.io/whoisthis?callback=";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${app.callback}")
    private String callback;

    public SecurityProtection() {
    }

    @PostConstruct
    public void init() {
        logger.info("callback value is set to {}", callback);
    }

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
