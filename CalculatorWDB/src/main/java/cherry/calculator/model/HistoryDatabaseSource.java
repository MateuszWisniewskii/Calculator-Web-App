/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cherry.calculator.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdw18
 */
public class HistoryDatabaseSource implements DataSource {

    private final EntityManagerFactory emf;

    public HistoryDatabaseSource() {
        emf = Persistence.createEntityManagerFactory("Calculator_PU");
    }

    @Override
    public List<CalculationEntity> getAllCalculation() {
        List<CalculationEntity> calulationList = null;
     EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT p FROM CalculationEntity p");
            calulationList = query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace(); // replace with proper message for the client
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return calulationList;
    }

    @Override
    public void persistObject(Object object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
            System.out.println("commited");
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            System.out.println("rolledback");
        } finally {
            em.close();
        }
    }
    public int getMaxId() {
        EntityManager em = emf.createEntityManager();
        int maxId = 0;
        try {
            Query query = em.createQuery("SELECT COALESCE(MAX(p.id), 0) FROM CalculationEntity p");
            maxId = (int) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return maxId;
    }
    
    @Override
    public boolean delete(int id) {
          EntityManager em = emf.createEntityManager();
        try{           
            em.getTransaction().begin();
            var result = em.createQuery("DELETE FROM CalculationEntity c WHERE c.id=:id").setParameter("id", id).executeUpdate() != 0;
            em.getTransaction().commit(); 
            return result;
        } catch(Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();            
        }    
        return true;
    }

}
