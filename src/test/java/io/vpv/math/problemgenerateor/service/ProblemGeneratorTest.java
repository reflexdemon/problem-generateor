package io.vpv.math.problemgenerateor.service;

import io.vpv.math.problemgenerateor.ProblemGenerateorApplicationTests;
import io.vpv.math.problemgenerateor.model.ProblemStatement;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProblemGeneratorTest extends ProblemGenerateorApplicationTests {

    @Autowired
    private ProblemGenerator problemGenerator;

    @Test
    public void shouldGenerateAdditionProblems() {
        int length = 10;
        int lowerBound = 10;
        int upperBound = 100;
        List<ProblemStatement> addProblems = problemGenerator.getAddProblems(length, lowerBound, upperBound);
        System.out.println("addProblems:" + addProblems);
        Assert.assertNotNull("The result is not empty, ", addProblems);
        assertEquals("The length is matching", addProblems.size(), length);
    }

    @Test
    public void shouldGenerateSubtractionProblems() {
        int length = 10;
        int lowerBound = 10;
        int upperBound = 100;
        List<ProblemStatement> subProblems = problemGenerator.getSubProblems(length, lowerBound, upperBound);
        System.out.println("addsubProblems:" + subProblems);
        Assert.assertNotNull("The result is not empty, ", subProblems);
        assertEquals("The length is matching", subProblems.size(), length);
    }
}