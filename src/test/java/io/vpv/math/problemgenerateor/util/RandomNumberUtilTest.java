package io.vpv.math.problemgenerateor.util;

import io.vpv.math.problemgenerateor.ProblemGenerateorApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

public class RandomNumberUtilTest extends ProblemGenerateorApplicationTests {

    @Autowired
    private RandomNumberUtil randomNumberUtil;


    @Test
    public void shouldReturnIntWithinRange() {
        int lowerBound = 10;
        int upperBound = 30;
        int result = randomNumberUtil.getRandomInt(lowerBound, upperBound);
        assertTrue("Result is greater than or equal to lower bound", result >= lowerBound);
        assertTrue("Result is less than or equal to upper bound", result <= upperBound);
    }


    @Test
    public void shouldReturnIntWithinRangeSingleParam() {
        int upperBound = 30;
        int result = randomNumberUtil.getRandomInt(upperBound);
        assertTrue("Result is greater than or equal to lower bound", result >= 0);
        assertTrue("Result is less than or equal to upper bound", result <= upperBound);
    }
}