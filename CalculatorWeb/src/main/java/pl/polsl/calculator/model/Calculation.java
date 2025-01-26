/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.calculator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 *
 * @author mdw18
 */
@Entity
public class Calculation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "firstnumber")
    @NotBlank
    private double firstNumber;
    @Column(name = "secondnumber")
    @NotBlank
    private double secondNumber;
    @Column(name = "result")
    @NotBlank
    private double result;
    @Column(name = "operator")
    @NotBlank
    private String operator;

    public Calculation(int id, double firstNumber, String operator, double secondNumber, double result) {
        this.id = id;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
        this.operator = operator;
    }

    public Calculation(double firstNumber, String operator, double secondNumber, double result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
        this.operator = operator;
    }

    /**
     * Get the value of result
     *
     * @return the value of result
     */
    public double getResult() {
        return result;
    }

    /**
     * Set the value of result
     *
     * @param result new value of result
     */
    public void setResult(double result) {
        this.result = result;
    }

    /**
     * Get the value of operator
     *
     * @return the value of operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Set the value of operator
     *
     * @param operator new value of operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Get the value of secondNumber
     *
     * @return the value of secondNumber
     */
    public double getSecondNumber() {
        return secondNumber;
    }

    /**
     * Set the value of secondNumber
     *
     * @param secondNumber new value of secondNumber
     */
    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * Get the value of firstNumber
     *
     * @return the value of firstNumber
     */
    public double getFirstNumber() {
        return firstNumber;
    }

    /**
     * Set the value of firstNumber
     *
     * @param firstNumber new value of firstNumber
     */
    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
