/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cherry.calculator.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdw18
 */
public class History implements DataSource {

    private List<CalculationData> history = new ArrayList<>();

    public History() {
        history.add(new CalculationData(1,1,1,1,"*"));
        history.add(new CalculationData(2,1,1,4,"*"));
        history.add(new CalculationData(3,1,1,123,"*"));
        history.add(new CalculationData(4,1,1,99,"*"));
    }
    
    @Override
    public List<CalculationData> getAllCalculation() {
        return history;
    }

    @Override
    public void persistObject(Object object) {
    if(object instanceof CalculationData data) history.add(data);
    }


    @Override
    public boolean delete(int id) {
    return history.removeIf(i -> i.getId() == id);
    }

}
