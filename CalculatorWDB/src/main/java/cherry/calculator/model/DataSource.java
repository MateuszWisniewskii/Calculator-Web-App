package cherry.calculator.model;

import java.util.List;

/**
 * Represents a generic data source for storing and managing calculation data.
 * This interface defines methods for retrieving, persisting, and deleting calculation records.
 * It can be implemented by any class that aims to provide data persistence or storage functionality.
 * 
 * @author Mateusz Wiśniewski
 */
public interface DataSource {

    /**
     * Retrieves all calculation records stored in the data source.
     * Each record is represented by an instance of {@link CalculationData}.
     * 
     * @return a list of {@link CalculationData} objects representing the stored calculations.
     */
    public List<CalculationEntity> getAllCalculation();

    /**
     * Adds a new object to the data source.
     * The object can represent a calculation or any relevant data 
     * that the implementation is designed to handle.
     * 
     * @param object the object to be persisted in the data source.
     */
    public void persistObject(Object object);

    /**
     * Deletes a calculation record from the data source based on its unique identifier.
     * 
     * @param id the unique identifier of the calculation to delete.
     * @return true if a record with the specified ID was deleted, false otherwise.
     */
    public boolean delete(int id);

    public int getMaxId();

    public Iterable<CalculationEntity> getEvenCalculation();

}
