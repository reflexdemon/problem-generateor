package io.vpv.math.problemgenerateor.service.addition;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdditionProblemServiceTest extends BaseProblemServiceTest {

    @Autowired
    private AdditionProblemService additionProblemService;

    @Test
    public void generateProblemStatement() {
        int lowerBound = 10;
        int upperBound = 30;
        assertOperations(additionProblemService, lowerBound, upperBound);
    }
}