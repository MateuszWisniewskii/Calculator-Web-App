package cherry.calculator.model;

/**
 * Represents the model of a calculator that performs basic mathematical
 * operations such as addition, subtraction, multiplication, and division.
 * Stores input numbers, the operator, and the calculated result.
 *
 * @author Mateusz Wiśniewski
 * @version 1.0
 */
public class CalculatorModel {

    /**
     * The first input number for the calculation.
     */
    private double firstNumber;

    /**
     * The second input number for the calculation.
     */
    private double secondNumber;

    /**
     * The result of the calculation.
     */
    private double resultNumber;

    /**
     * The mathematical operator used for the calculation. Supported operators:
     * "+", "-", "*", "/".
     */
    private String operator;

    /**
     * Performs a calculation based on the values of {@code firstNumber},
     * {@code secondNumber}, and {@code operator}.
     *
     * @return the result of the calculation
     * @throws ArithmeticException if division by zero is attempted
     * @throws IllegalArgumentException if an unsupported operator is provided
     */
 public double doCalculation() throws DivisionByZeroException {
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
                    throw new DivisionByZeroException();
                }
                break;
            case "sqrt":
                if (firstNumber >= 0) {
                    resultNumber = Math.sqrt(firstNumber);
                } else {
                    throw new IllegalArgumentException("Cannot calculate square root of a negative number");
                }
                break;
            case "log":
                if (firstNumber > 0) {
                    resultNumber = Math.log(firstNumber);
                } else {
                    throw new IllegalArgumentException("Cannot calculate logarithm of a non-positive number");
                }
                break;
            case "sin":
                resultNumber = Math.sin(Math.toRadians(firstNumber));
                break;
            case "cos":
                resultNumber = Math.cos(Math.toRadians(firstNumber));
                break;
            case "tan":
                if (Math.cos(Math.toRadians(firstNumber)) != 0) {
                    resultNumber = Math.tan(Math.toRadians(firstNumber));
                } else {
                    throw new IllegalArgumentException("Undefined value for tangent at this angle");
                }
                break;
            case "cot":
                if (Math.sin(Math.toRadians(firstNumber)) != 0) {
                    resultNumber = 1.0 / Math.tan(Math.toRadians(firstNumber));
                } else {
                    throw new IllegalArgumentException("Undefined value for cotangent at this angle");
                }
                break;
            case "pow":
                resultNumber = Math.pow(firstNumber, secondNumber);
                break;
            case "mod":
                if (secondNumber != 0) {
                    resultNumber = firstNumber % secondNumber;
                } else {
                    throw new ArithmeticException("Cannot calculate modulus with divisor zero");
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
        return resultNumber;
    }

    /**
     * Default constructor that initializes all fields with default values.
     * {@code firstNumber} and {@code secondNumber} are set to 0,
     * {@code resultNumber} is set to 0, and {@code operator} is set to "+".
     */
    public CalculatorModel() {
        this.firstNumber = 0;
        this.secondNumber = 0;
        this.resultNumber = 0;
        this.operator = "+";
    }

    /**
     * Parameterized constructor that initializes the calculator model with
     * specific values for {@code firstNumber}, {@code secondNumber}, and
     * {@code operator}. Automatically performs the calculation and sets
     * {@code resultNumber}.
     *
     * @param firstNumber the first number for the calculation
     * @param secondNumber the second number for the calculation
     * @param operator the operator used for the calculation (+, -, *, /)
     */
    public CalculatorModel(double firstNumber, double secondNumber, String operator) throws DivisionByZeroException {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.resultNumber = this.doCalculation();
    }

    /**
     * Retrieves the first input number.
     *
     * @return the value of {@code firstNumber}
     */
    public double getFirstNumber() {
        return firstNumber;
    }

    /**
     * Sets the value of the first input number.
     *
     * @param firstNumber the value to be assigned to {@code firstNumber}
     */
    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * Retrieves the second input number.
     *
     * @return the value of {@code secondNumber}
     */
    public double getSecondNumber() {
        return secondNumber;
    }

    /**
     * Sets the value of the second input number.
     *
     * @param secondNumber the value to be assigned to {@code secondNumber}
     */
    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * Retrieves the calculated result.
     *
     * @return the value of {@code resultNumber}
     */
    public double getResultNumber() {
        return resultNumber;
    }

    /**
     * Sets the calculated result manually.
     *
     * @param resultNumber the value to be assigned to {@code resultNumber}
     */
    public void setResultNumber(double resultNumber) {
        this.resultNumber = resultNumber;
    }

    /**
     * Retrieves the operator used for the calculation.
     *
     * @return the value of {@code operator}
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the operator used for the calculation.
     *
     * @param operator the operator to be used for the calculation (+, -, *, /)
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }
}
