package io.vpv.math.problemgenerateor.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumberUtil {

    public int getRandomInt(int lowerBound, int upperBound) {
        Random random = new Random();
        return (random.nextInt(upperBound - lowerBound) + lowerBound);
    }

    public int getRandomInt(int upperBound) {
        return getRandomInt(0, upperBound);
    }
}
