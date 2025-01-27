/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cherry.calculator.model;

/**
 *
 * @author mdw18
 */
public class CalculatorModel {

    private double firstNumber;
    private double secondNumber;
    private double resultNumber;
    private String operator;

    public double doCalculation() {
        switch (operator) {
            case "+":
                resultNumber = firstNumber + secondNumber;
                break;
            case "-":
                resultNumber = firstNumber - secondNumber;
                break;
            case "*":
                resultNumber = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    resultNumber = firstNumber / secondNumber;
                } else {
                    throw new ArithmeticException("Nie można dzielić przez zero.");
                }
                break;
            default:
                throw new IllegalArgumentException("Nieznany operator: " + operator);
        }
        return resultNumber;
    }

    public CalculatorModel() {
        this.firstNumber = 0;
        this.secondNumber = 0;
        this.resultNumber = 0;
        this.operator = "+";
    }

    public CalculatorModel(double firstNumber, double secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.resultNumber = this.doCalculation();
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getResultNumber() {
        return resultNumber;
    }

    public void setResultNumber(double resultNumber) {
        this.resultNumber = resultNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
