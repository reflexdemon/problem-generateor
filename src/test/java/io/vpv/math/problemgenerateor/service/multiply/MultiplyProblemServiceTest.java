package io.vpv.math.problemgenerateor.service.multiply;

import io.vpv.math.problemgenerateor.service.addition.BaseProblemServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MultiplyProblemServiceTest extends BaseProblemServiceTest {

    @Autowired
    private MultiplyProblemService multiplyProblemService;

    @Test
    public void shouldGenerateValidProblems() {
        int lowerBound = 10;
        int upperBound = 30;
        assertOperations(multiplyProblemService, lowerBound, upperBound);
    }
}