package cherry.calculator.model;

/**
 * Represents a single calculation data record.
 * Stores information about a calculation, including its unique ID, input numbers, 
 * operator, and result. This class serves as a data container for calculations.
 * 
 * @author Mateusz Wiśniewski
 */
public class CalculationData {

    /**
     * The unique identifier for the calculation record.
     */
    private int id;

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
     * The mathematical operator used for the calculation.
     * Examples of supported operators include "+", "-", "*", and "/".
     */
    private String operator;

    /**
     * Parameterized constructor to create a {@code CalculationData} object with 
     * specified values for all fields.
     * 
     * @param id the unique identifier for the calculation
     * @param firstNumber the first input number
     * @param secondNumber the second input number
     * @param resultNumber the result of the calculation
     * @param operator the mathematical operator used in the calculation
     */
    public CalculationData(int id, double firstNumber, double secondNumber, double resultNumber, String operator) {
        this.id = id;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.resultNumber = resultNumber;
        this.operator = operator;
    }

    /**
     * Default constructor that initializes the fields with default values.
     * {@code id} is set to 0, {@code firstNumber} and {@code secondNumber} are set to 0,
     * {@code resultNumber} is set to 0, and {@code operator} is set to "+".
     */
    public CalculationData() {
        this.id = 0;
        this.firstNumber = 0;
        this.secondNumber = 0;
        this.resultNumber = 0;
        this.operator = "+";
    }

    /**
     * Retrieves the unique identifier for the calculation record.
     * 
     * @return the ID of the calculation
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the calculation record.
     * 
     * @param id the unique identifier to be assigned
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the first input number for the calculation.
     * 
     * @return the value of {@code firstNumber}
     */
    public double getFirstNumber() {
        return firstNumber;
    }

    /**
     * Sets the first input number for the calculation.
     * 
     * @param firstNumber the value to be assigned to {@code firstNumber}
     */
    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * Retrieves the second input number for the calculation.
     * 
     * @return the value of {@code secondNumber}
     */
    public double getSecondNumber() {
        return secondNumber;
    }

    /**
     * Sets the second input number for the calculation.
     * 
     * @param secondNumber the value to be assigned to {@code secondNumber}
     */
    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * Retrieves the result of the calculation.
     * 
     * @return the value of {@code resultNumber}
     */
    public double getResultNumber() {
        return resultNumber;
    }

    /**
     * Sets the result of the calculation manually.
     * 
     * @param resultNumber the value to be assigned to {@code resultNumber}
     */
    public void setResultNumber(double resultNumber) {
        this.resultNumber = resultNumber;
    }

    /**
     * Retrieves the mathematical operator used in the calculation.
     * 
     * @return the operator as a string
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the mathematical operator used in the calculation.
     * 
     * @param operator the operator to be assigned (e.g., "+", "-", "*", "/")
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }
}
