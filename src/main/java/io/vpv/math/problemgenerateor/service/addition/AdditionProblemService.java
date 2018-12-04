package io.vpv.math.problemgenerateor.service.addition;

import io.vpv.math.problemgenerateor.model.ProblemStatement;
import io.vpv.math.problemgenerateor.service.ProblemService;
import io.vpv.math.problemgenerateor.util.RandomNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdditionProblemService implements ProblemService {

    private final RandomNumberUtil randomNumberUtil;

    @Autowired
    public AdditionProblemService(RandomNumberUtil randomNumberUtil) {
        this.randomNumberUtil = randomNumberUtil;
    }

    @Override
    public ProblemStatement generateProblemStatement(int lowerBound, int upperBound) {
        ProblemStatement statement = new ProblemStatement();
        statement.setFirstNumber(randomNumberUtil.getRandomInt(lowerBound, upperBound));
        statement.setSecondNumber(randomNumberUtil.getRandomInt(lowerBound, upperBound));
        return statement;
    }
}
