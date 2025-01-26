/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.calculator.model;

import java.util.List;

/**
 *
 * @author mdw18
 */
public interface DataSource {
    
    public List<CalculationData> getAllCalculation();
    public void saveData(Object object);
    public boolean deleteData(int id);
}
