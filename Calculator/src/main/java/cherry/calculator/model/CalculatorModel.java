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

    public CalculatorModel() {
        this.firstNumber = 0;
        this.secondNumber = 0;
        this.resultNumber = 0;
        this.operator = "+";
    }

    public CalculatorModel(double firstNumber, double secondNumber, double resultNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.resultNumber = resultNumber;
        this.operator = operator;
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
