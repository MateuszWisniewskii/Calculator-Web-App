package pl.polsl.calculator.model;

public class CalculatorModel {

    private double firstNumber;
    private double secondNumber;
    private double result;
    private String operator;

    // Konstruktor domyślny
    public CalculatorModel() {
        this.firstNumber = 0;
        this.secondNumber = 0;
        this.operator = "+";
        this.result = 0;
    }

    // Konstruktor z parametrami
    public CalculatorModel(double firstNumber, double secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = calculateResult();
    }

    // Gettery i settery
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }

    // Metoda do obliczania wyniku na podstawie operatora
    public double calculateResult() {
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
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    throw new ArithmeticException("Nie można dzielić przez zero.");
                }
                break;
            default:
                throw new IllegalArgumentException("Nieznany operator: " + operator);
        }
        return result;
    }


}
