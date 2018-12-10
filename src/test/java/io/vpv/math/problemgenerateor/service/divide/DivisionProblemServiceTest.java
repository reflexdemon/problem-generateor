package io.vpv.math.problemgenerateor.service.divide;

import io.vpv.math.problemgenerateor.model.ProblemStatement;
import io.vpv.math.problemgenerateor.service.ProblemService;
import io.vpv.math.problemgenerateor.service.addition.BaseProblemServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

public class DivisionProblemServiceTest extends BaseProblemServiceTest {

    @Autowired
    DivisionProblemService divisionProblemService;

    @Test
    public void shouldGenerateValidProblems() {
        int lowerBound = 2;
        int upperBound = 10;
        assertOperations(divisionProblemService, lowerBound, upperBound);
    }

    @Override
    protected void assertOperations(ProblemService problemService, int lowerBound, int upperBound) {
        ProblemStatement result = problemService.generateProblemStatement(lowerBound, upperBound);
        assertTrue("Answer is greater than or equal to lower bound", result.getAnswer() >= lowerBound);
        assertTrue("Second Number is greater than or equal to lower bound", result.getSecondNumber() >= lowerBound);
        assertTrue("Second Number  is less than or equal to upper bound", result.getSecondNumber() <= upperBound);
    }
}