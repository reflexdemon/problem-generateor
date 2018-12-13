package io.vpv.math.problemgenerateor.util;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class RandomNumberUtil {

    public int getRandomInt(int lowerBound, int upperBound) {
        Random random = new Random();
        return (random.nextInt(upperBound - lowerBound) + lowerBound);
    }

    public int getRandomInt(int upperBound) {
        return getRandomInt(0, upperBound);
    }

    public String createRandomGUID() {
        // Creating a random UUID (Universally unique identifier).
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
