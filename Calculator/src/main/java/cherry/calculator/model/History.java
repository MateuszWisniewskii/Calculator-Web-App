package cherry.calculator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the history of calculations performed by the calculator.
 * Stores a list of {@link CalculationData} objects that contain information 
 * about previous calculations. Implements the {@link DataSource} interface.
 * 
 * @author Mateusz wiśniewski
 */
public class History implements DataSource {

    /**
     * A list to hold all the calculation history.
     * Each entry in the list represents a single calculation.
     */
    private List<CalculationData> history = new ArrayList<>();

    /**
     * Default constructor that initializes the history list.
     * Currently, it does not add any initial data, but can be extended 
     * to include predefined calculation entries.
     */
    public History() {
//        history.add(new CalculationData(1,1,1,1,"*"));
//        history.add(new CalculationData(2,1,1,4,"*"));
//        history.add(new CalculationData(3,1,1,123,"*"));
//        history.add(new CalculationData(4,1,1,99,"*"));
    }
    
    /**
     * Retrieves all stored calculation data from the history.
     * 
     * @return a list of all calculation data objects stored in the history.
     */
    @Override
    public List<CalculationData> getAllCalculation() {
        return history;
    }

    /**
     * Adds a new calculation data object to the history.
     * The object is only added if it is an instance of {@link CalculationData}.
     * 
     * @param object the object to be added to the history.
     * @throws ClassCastException if the object is not an instance of CalculationData.
     */
    @Override
    public void persistObject(Object object) {
        if(object instanceof CalculationData data) {
            history.add(data);
        }
    }

    /**
     * Deletes a calculation entry from the history by its unique ID.
     * If a calculation with the specified ID exists, it will be removed.
     * 
     * @param id the unique identifier of the calculation to delete.
     * @return true if a calculation was removed, false if no such calculation was found.
     */
    @Override
    public boolean delete(int id) {
        return history.removeIf(i -> i.getId() == id);
    }
}
