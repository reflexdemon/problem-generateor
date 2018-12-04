package io.vpv.math.problemgenerateor.controller.api;

import io.vpv.math.problemgenerateor.model.ProblemStatement;
import io.vpv.math.problemgenerateor.service.ProblemGenerator;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ProblemGeneratorAPI extends BaseAPI {
    private final Logger logger = getLogger(this.getClass());

    private ProblemGenerator problemGenerator;

    @Autowired
    public ProblemGeneratorAPI(final ProblemGenerator problemGenerator) {
        this.problemGenerator = problemGenerator;
    }

    @RequestMapping(path = "/add", method = GET)
    public ResponseEntity<List<ProblemStatement>> getAddProblems(@RequestParam(required = false, defaultValue = "10") final String size,
                                                                 @RequestParam(required = false, defaultValue = "10") final String min,
                                                                 @RequestParam(required = false, defaultValue = "100") final String max
    ) {
        List<ProblemStatement> problems = problemGenerator.getAddProblems(parseInt(size), parseInt(min), parseInt(max));
        logger.debug("Problems:" + problems);
        return new ResponseEntity<>(problems, HttpStatus.OK);
    }

    @RequestMapping(path = "/sub", method = GET)
    public ResponseEntity<List<ProblemStatement>> getSubProblems(@RequestParam(required = false, defaultValue = "10") final String size,
                                                                 @RequestParam(required = false, defaultValue = "10") final String min,
                                                                 @RequestParam(required = false, defaultValue = "100") final String max
    ) {
        List<ProblemStatement> problems = problemGenerator.getSubProblems(parseInt(size), parseInt(min), parseInt(max));
        logger.debug("Problems:" + problems);
        return new ResponseEntity<>(problems, HttpStatus.OK);
    }
}
