package io.vpv.math.problemgenerateor.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Stream;

@Component
public class SecurityProtection extends HandlerInterceptorAdapter {

    public static final String SESSION_USER = "SESSION_USER";
    public static final String ASK_SESSION = "https://truelogin.vpv.io/whoisthis?callback=";

    /**
     * Enter URL that does not need logged in session.
     */
    private static final String[] SECURED_ENDPOINTS = {
            "/signin"
    };
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

        if (isSecured(request.getRequestURL().toString()) && null == request.getSession().getAttribute(SESSION_USER)) {
            String redirectURL = ASK_SESSION + callback;
            response.sendRedirect(redirectURL);
            return false;
        }
        return super.preHandle(request, response, handler);
    }

    private boolean isSecured(String url) {
        return Stream.of(SECURED_ENDPOINTS)
                .filter(a -> null != url)
                .anyMatch(allow -> url.contains(allow));
    }


}
