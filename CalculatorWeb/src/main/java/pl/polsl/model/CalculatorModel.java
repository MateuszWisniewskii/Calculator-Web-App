/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

/**
 *
 * @author mdw18
 */
public class CalculatorModel {

//    @Getter
//    @Setter
    private double firstNumber, secondNumber;
//    @Getter
    private double result;
//    @Getter
//    @Setter
    private String operator;

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

    public double getResult() {
        return result;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void calculate() throws InvalidOperatorException, InvalidArgumentException {

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    throw new InvalidArgumentException("Cannot divide by zero!");
                }
                result = firstNumber / secondNumber;
                break;
            default:
                throw new InvalidOperatorException("Unknown operator: " + operator);

        }

    }
}
