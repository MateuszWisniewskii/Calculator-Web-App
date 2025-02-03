/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cherry.calculator.model;

/**
 *
 * @author mdw18
 */
public class DivisionByZeroException extends Exception {

    public DivisionByZeroException() {
        super("Division by zero is not allowed");
    }
    
}
