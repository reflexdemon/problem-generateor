package io.vpv.math.problemgenerateor.controller.api;

import io.vpv.math.problemgenerateor.model.ErrorResponse;
import io.vpv.math.problemgenerateor.service.ProblemGenerator;
import io.vpv.math.problemgenerateor.util.RandomNumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseAPI {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final RandomNumberUtil randomNumberUtil;
    protected ProblemGenerator problemGenerator;

    @Autowired
    public BaseAPI(final RandomNumberUtil randomNumberUtil, final ProblemGenerator problemGenerator) {
        this.randomNumberUtil = randomNumberUtil;
        this.problemGenerator = problemGenerator;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> error(Exception ex) {
        String errorId = randomNumberUtil.createRandomGUID();
        logger.error("Exception raised: " + errorId, ex);
        ErrorResponse response = new ErrorResponse(errorId, ex.getClass().getCanonicalName() + ": " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
