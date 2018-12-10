package io.vpv.math.problemgenerateor.service.divide;

import io.vpv.math.problemgenerateor.model.ProblemStatement;
import io.vpv.math.problemgenerateor.service.ProblemService;
import io.vpv.math.problemgenerateor.util.RandomNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionProblemService implements ProblemService {

    private final RandomNumberUtil randomNumberUtil;

    @Autowired
    public DivisionProblemService(RandomNumberUtil randomNumberUtil) {
        this.randomNumberUtil = randomNumberUtil;
    }

    @Override
    public ProblemStatement generateProblemStatement(int lowerBound, int upperBound) {
        //TODO: Write Tests
        ProblemStatement statement = new ProblemStatement();
        int second = randomNumberUtil.getRandomInt(lowerBound, upperBound);
        int answer = randomNumberUtil.getRandomInt(lowerBound, upperBound);
        int first = second * answer;

        statement.setFirstNumber(first);
        statement.setSecondNumber(second);
        statement.setAnswer(answer);
        return statement;
    }
}
