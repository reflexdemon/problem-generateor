package io.vpv.math.problemgenerateor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vpv.math.problemgenerateor.interceptor.SecurityProtection;
import io.vpv.math.problemgenerateor.model.User;
import io.vpv.math.problemgenerateor.service.EncryptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public LoginController(EncryptionService encryptionService, ObjectMapper objectMapper) {
        this.encryptionService = encryptionService;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String redirect(HttpServletRequest request,
                           @RequestParam(required = false) String key,
                           @RequestParam String encryptedToken) {
        try {
            String plainJSON = encryptionService.decrypt(encryptedToken);
            User user = objectMapper.readValue(plainJSON, User.class);
            request.getSession(true).setAttribute(SecurityProtection.SESSION_USER, user);
            logger.info("The key returned is {}", key);
            if (null != key && key.equalsIgnoreCase("local")) {
                return "redirect:http://localhost:8080/";
            }
        } catch (Exception e) {
            throw new RuntimeException("Problem", e);
        }
        return "redirect:/";

    }

    @RequestMapping("/logout")
    public ResponseEntity<String> signOutUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (null != session) {
            session.removeAttribute(SecurityProtection.SESSION_USER);
        }
        logger.info("Signing Out");
        return new ResponseEntity<>("Signed out", HttpStatus.OK);
    }

    @RequestMapping("/signin")
    public String signin() {
        logger.info("Signing In");
        return "redirect:/";
    }
}
