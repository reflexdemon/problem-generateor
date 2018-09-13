package io.vpv.math.problemgenerateor.model;

public class ProblemStatement {

    private int firstNumber;
    private  int secondNumber;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProblemStatement{");
        sb.append("firstNumber=").append(firstNumber);
        sb.append(", secondNumber=").append(secondNumber);
        sb.append('}');
        return sb.toString();
    }
}
