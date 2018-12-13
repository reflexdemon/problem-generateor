package io.vpv.math.problemgenerateor.service.addition;

import io.vpv.math.problemgenerateor.ProblemGenerateorApplicationTests;
import io.vpv.math.problemgenerateor.model.ProblemStatement;
import io.vpv.math.problemgenerateor.service.ProblemService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BaseProblemServiceTest extends ProblemGenerateorApplicationTests {
    protected void assertOperations(ProblemService problemService, int lowerBound, int upperBound) {
        ProblemStatement result = problemService.generateProblemStatement(lowerBound, upperBound);
        assertTrue("First Number is greater than or equal to lower bound", result.getFirstNumber() >= lowerBound);
        assertTrue("First Number  is less than or equal to upper bound", result.getFirstNumber() <= upperBound);
        assertTrue("Second Number is greater than or equal to lower bound", result.getSecondNumber() >= lowerBound);
        assertTrue("Second Number  is less than or equal to upper bound", result.getSecondNumber() <= upperBound);
        assertNotNull("Operator Exist", result.getOperator());
    }

}
