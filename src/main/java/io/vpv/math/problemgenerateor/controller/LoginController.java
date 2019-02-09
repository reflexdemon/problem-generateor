package io.vpv.math.problemgenerateor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vpv.math.problemgenerateor.interceptor.SecurityProtection;
import io.vpv.math.problemgenerateor.model.User;
import io.vpv.math.problemgenerateor.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    private EncryptionService encryptionService;
    private ObjectMapper objectMapper;

    @Autowired
    public LoginController(EncryptionService encryptionService, ObjectMapper objectMapper) {
        this.encryptionService = encryptionService;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String redirect(HttpServletRequest request,
                           HttpServletResponse response,
                           @RequestParam(required = false) String key,
                           @RequestParam String encryptedToken) {
        try {
            String plainJSON = encryptionService.decrypt(encryptedToken);
            User user = objectMapper.readValue(plainJSON, User.class);
            request.getSession().setAttribute(SecurityProtection.SESSION_USER, user);
        } catch (Exception e) {
            try {
                response.sendError(400, "User cannot login");
            } catch (IOException e1) {
                throw new RuntimeException("Problem", e1);
            }
        }
        return "redirect:/";

    }
}
