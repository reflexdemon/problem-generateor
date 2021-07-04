package io.vpv.math.problemgenerateor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vpv.math.problemgenerateor.interceptor.SecurityProtection;
import io.vpv.math.problemgenerateor.model.User;
import io.vpv.math.problemgenerateor.service.EncryptionService;
import io.vpv.math.problemgenerateor.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private EncryptionService encryptionService;
    private ObjectMapper objectMapper;
    private AppUtil appUtil;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${app.localEndpoint}")
    private String localEndpoint;

    @Autowired
    public LoginController(EncryptionService encryptionService, ObjectMapper objectMapper, AppUtil appUtil) {
        this.encryptionService = encryptionService;
        this.objectMapper = objectMapper;
        this.appUtil = appUtil;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String redirect(HttpServletRequest request,
                           @RequestParam(required = false) String key,
                           @RequestParam String encryptedToken) {
        try {
            String plainJSON = encryptionService.decrypt(encryptedToken);
            logger.info("The plainJSON returned is {}", plainJSON);
            User user = objectMapper.readValue(plainJSON, User.class);
            request.getSession(true).setAttribute(SecurityProtection.SESSION_USER, user);
            logger.info("The key returned is {}", key);
        } catch (Exception e) {
            throw new RuntimeException("Problem", e);
        }
        return getCorrectRedirectionEndpoint(key);

    }

    @RequestMapping("/logout")
    public String signOutUser(HttpServletRequest request, @RequestParam(required = false) String key) {
        HttpSession session = request.getSession(false);
        logger.info("Signing Out");
        if (null != session) {
            session.removeAttribute(SecurityProtection.SESSION_USER);
        }
        return getCorrectRedirectionEndpoint(key);
    }

    private String getCorrectRedirectionEndpoint(final String key) {
        if (appUtil.isLocal(key)) {
            return "redirect:" + localEndpoint;
        }
        return "redirect:/";
    }

    @RequestMapping("/signin")
    public String signin(@RequestParam(required = false) String key) {
        logger.info("Signing In");
        return getCorrectRedirectionEndpoint(key);
    }
}
