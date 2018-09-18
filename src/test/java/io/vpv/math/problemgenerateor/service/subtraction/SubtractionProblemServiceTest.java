package io.vpv.math.problemgenerateor.service.subtraction;

import io.vpv.math.problemgenerateor.model.ProblemStatement;
import io.vpv.math.problemgenerateor.service.addition.BaseProblemServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SubtractionProblemServiceTest extends BaseProblemServiceTest {

    @Autowired
    private SubtractionProblemService subtractionProblemService;

    @Test
    public void shouldGenerateValidProblems() {
        int lowerBound = 10;
        int upperBound = 30;
        assertOperations(subtractionProblemService, lowerBound, upperBound);
    }

    @Test
    public void shouldHaveFirstNumberAlwaysGreaterThanLast() {
        int lowerBound = 10;
        int upperBound = 300;
        ProblemStatement problemStatement = subtractionProblemService.generateProblemStatement(lowerBound, upperBound);
        Assert.assertTrue("Should have the first number greater than second", problemStatement.getFirstNumber() > problemStatement.getSecondNumber());
    }

}