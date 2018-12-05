package io.vpv.math.problemgenerateor.service;

import io.vpv.math.problemgenerateor.model.ProblemStatement;
import io.vpv.math.problemgenerateor.service.addition.AdditionProblemService;
import io.vpv.math.problemgenerateor.service.multiply.MultiplyProblemService;
import io.vpv.math.problemgenerateor.service.subtraction.SubtractionProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Service
public class ProblemGenerator {

    private AdditionProblemService additionProblemService;

    private SubtractionProblemService subtractionProblemService;

    private MultiplyProblemService multiplyProblemService;

    @Autowired
    public ProblemGenerator(AdditionProblemService additionProblemService, SubtractionProblemService subtractionProblemService, MultiplyProblemService multiplyProblemService) {
        this.additionProblemService = additionProblemService;
        this.subtractionProblemService = subtractionProblemService;
        this.multiplyProblemService = multiplyProblemService;
    }


    public List<ProblemStatement> getAddProblems(final int length, int lowerBound, int upperBound) {
        return IntStream.range(0, length)
                .mapToObj(i -> additionProblemService.generateProblemStatement(lowerBound, upperBound))
                .collect(toList());
    }

    public List<ProblemStatement> getSubProblems(final int length, int lowerBound, int upperBound) {
        return IntStream.range(0, length)
                .mapToObj(i -> subtractionProblemService.generateProblemStatement(lowerBound, upperBound))
                .collect(toList());
    }

    public List<ProblemStatement> getMulProblems(final int length, int lowerBound, int upperBound) {
        return IntStream.range(0, length)
                .mapToObj(i -> multiplyProblemService.generateProblemStatement(lowerBound, upperBound))
                .collect(toList());
    }

}
