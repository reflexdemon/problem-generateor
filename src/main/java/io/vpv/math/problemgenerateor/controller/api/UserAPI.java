package io.vpv.math.problemgenerateor.controller.api;

import io.vpv.math.problemgenerateor.interceptor.SecurityProtection;
import io.vpv.math.problemgenerateor.model.User;
import io.vpv.math.problemgenerateor.service.ProblemGenerator;
import io.vpv.math.problemgenerateor.util.RandomNumberUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class UserAPI extends BaseAPI {
    private final Logger logger = getLogger(this.getClass());

    @Autowired
    public UserAPI(RandomNumberUtil randomNumberUtil, ProblemGenerator problemGenerator) {
        super(randomNumberUtil, problemGenerator);
    }

    @RequestMapping("/user")
    public ResponseEntity<User> getUserFromSession(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(SecurityProtection.SESSION_USER);
        logger.info("Returning User : {}", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
