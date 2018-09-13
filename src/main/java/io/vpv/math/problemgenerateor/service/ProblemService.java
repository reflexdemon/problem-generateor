package io.vpv.math.problemgenerateor.service;

import io.vpv.math.problemgenerateor.model.ProblemStatement;

public interface ProblemService {

    public ProblemStatement generateProblemStatement(int lowerBound, int upperBound);

}
