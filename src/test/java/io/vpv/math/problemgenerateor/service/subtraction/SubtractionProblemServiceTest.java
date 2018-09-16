package io.vpv.math.problemgenerateor.service.subtraction;

import io.vpv.math.problemgenerateor.service.addition.BaseProblemServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SubtractionProblemServiceTest extends BaseProblemServiceTest {

    @Autowired
    private SubtractionProblemService subtractionProblemService;

    @Test
    public void generateProblemStatement() {
        int lowerBound = 10;
        int upperBound = 30;
        assertOperations(subtractionProblemService, lowerBound, upperBound);
    }
}