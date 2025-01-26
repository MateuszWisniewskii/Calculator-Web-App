/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cherry.calculator.model;

import java.util.List;

/**
 *
 * @author mdw18
 */
public interface DataSource {

    public List<CalculationData> getAllCalculation();

    public void persistObject(Object object);

    public boolean delete(int id);

}
