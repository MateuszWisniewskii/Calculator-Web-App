/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cherry.calculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author mdw18
 */
@Entity
public class CalculationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double firstNumber;

    private String operator;

    private double secondNumber;

    private double resultNumber;


    /**
     * Get the value of resultNumber
     *
     * @return the value of resultNumber
     */
    public double getResultNumber() {
        return resultNumber;
    }

    /**
     * Set the value of resultNumber
     *
     * @param resultNumber new value of resultNumber
     */
    public void setResultNumber(double resultNumber) {
        this.resultNumber = resultNumber;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalculationEntity)) {
            return false;
        }
        CalculationEntity other = (CalculationEntity) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cherry.calculator.entity.CalculationEntity[ id=" + id + " ]";
    }

}
