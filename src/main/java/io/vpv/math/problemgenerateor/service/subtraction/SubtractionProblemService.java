package io.vpv.math.problemgenerateor.service.subtraction;

import io.vpv.math.problemgenerateor.model.ProblemStatement;
import io.vpv.math.problemgenerateor.service.ProblemService;
import io.vpv.math.problemgenerateor.util.RandomNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubtractionProblemService implements ProblemService {

    private final RandomNumberUtil randomNumberUtil;

    @Autowired
    public SubtractionProblemService(RandomNumberUtil randomNumberUtil) {
        this.randomNumberUtil = randomNumberUtil;
    }

    @Override
    public ProblemStatement generateProblemStatement(int lowerBound, int upperBound) {
        //TODO: Write Tests
        ProblemStatement statement = new ProblemStatement();
        int first = randomNumberUtil.getRandomInt(lowerBound, upperBound);
        int second = randomNumberUtil.getRandomInt(lowerBound, upperBound);

        if (first < second) {
            //swap
            int temp = first;
            first = second;
            second = temp;
        }

        statement.setFirstNumber(first);
        statement.setSecondNumber(second);
        statement.setAnswer(statement.getFirstNumber() - statement.getSecondNumber());
        return statement;
    }
}
