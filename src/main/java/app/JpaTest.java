package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import data.LegoSetting;
import data.LegoStatistics;

public class JpaTest {
    private static final String PERSISTENCE_UNIT_NAME = "lego"; // Change to your persistence unit name

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

//        try {
//            // Begin a transaction
//            em.getTransaction().begin();
//
//            // Create a new entity object and persist it to the database
//            LegoSetting legosetting = new LegoSetting();
//            legosetting.setColorvalue(0.1);
//            em.persist(legosetting);
//
//            // Commit the transaction
//            em.getTransaction().commit();
//
//            System.out.println("Legosetting added successfully with ID: " + legosetting.getId());
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//        } finally {
//            // Close the EntityManager
//            em.close();
//            emf.close();
//        }
        
        try {
            // Begin a transaction
            em.getTransaction().begin();

            // Create a new entity object and persist it to the database
            LegoStatistics ls = new LegoStatistics();
            ls.setOn_line_time(15);
            ls.setBattery_voltage(12);
            em.persist(ls);

            // Commit the transaction
            em.getTransaction().commit();

            System.out.println("Legosetting added successfully with ID: " + ls.getId());
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            // Close the EntityManager
            em.close();
            emf.close();
        }
    }
    
}