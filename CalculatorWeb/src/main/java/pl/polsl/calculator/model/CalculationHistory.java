/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.calculator.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdw18
 */
public class CalculationHistory implements DataSource {

    private List<CalculationData> history = new ArrayList<>();

    public CalculationHistory() {
       // history = new ArrayList<>();
        history.add(new CalculationData(0, 1, "+", 2, 3));
        history.add(new CalculationData(1, 11, "-", 2, 9));
        history.add(new CalculationData(2, 1, "*", 2, 2));
        history.add(new CalculationData(3, 100, "/", 5, 20));
    }

    @Override
    public List<CalculationData> getAllCalculation() {
        return history;
    }

    @Override
    public void saveData(Object object) {
        if (object instanceof CalculationData data) {
            history.add(data);
        }
    }

    @Override
    public boolean deleteData(int id) {
        return history.removeIf(i -> i.getId() == id);
    }
}
