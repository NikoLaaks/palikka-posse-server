package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.LegoSetting;
import data.LegoStatistics;

/**
 * Service class providing REST endpoints for communication between the robot and the server.
 */
@Path("/lego")
public class RobotService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("lego");

    /**
     * Endpoint for sending values to the database that the robot uses when operating.
     * @param ls The LegoSetting object containing the values to be set.
     * @return The updated LegoSetting object.
     */
    @Path("/setvalues")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LegoSetting setValues(LegoSetting ls) {

        EntityManager em = emf.createEntityManager();
        LegoSetting lastRow = null;
        try {
            em.getTransaction().begin();

            // Fetch the last row from legosetting table
            Query query = em.createQuery("SELECT l FROM LegoSetting l ORDER BY l.id DESC").setMaxResults(1);
            try {
                lastRow = (LegoSetting) query.getSingleResult();
            } catch (NoResultException e) {
                System.out.println("Table is empty");
            }

            // Copy values from last row to ls object if not provided
            // so it doesn't change to 0 when only motor values are given
            if (lastRow != null) {
                if (ls.getColorvalue() == 0) {
                    ls.setColorvalue(lastRow.getColorvalue());
                }
                // Copy other fields as needed
            }

            em.persist(ls);
            em.getTransaction().commit();
            System.out.println("value added");
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Rollback the transaction if an exception occurs
            }
        } finally {
            em.close(); // Close the EntityManager in the finally block to release resources
        }

        return ls;
    }

    /**
     * Endpoint for getting values from the database that the robot uses for operating.
     * @return The latest LegoSetting object from the database.
     */
    @Path("/getvalues")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public LegoSetting getValues() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select s from LegoSetting s order by s.id desc").setMaxResults(1);
        List<LegoSetting> list = ((javax.persistence.Query) q).getResultList();
        em.getTransaction().commit();
        return list.get(0);
    }

    /**
     * Endpoint for sending statistics from the robot to the database.
     * @param statistics The LegoStatistics object containing the statistics to be stored.
     * @return The stored LegoStatistics object.
     */
    @Path("/sendstatistics")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LegoStatistics sendData(LegoStatistics statistics) {
        System.out.println(statistics);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(statistics);
        em.getTransaction().commit();
        return statistics;
    }

    /**
     * Endpoint for getting statistics from the database that are sent by the robot.
     * @return The latest LegoStatistics object from the database.
     */
    @Path("/getstatistics")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public LegoStatistics getStatistics() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select s from LegoStatistics s order by s.id desc").setMaxResults(1);
        List<LegoStatistics> list = ((javax.persistence.Query) q).getResultList();
        em.getTransaction().commit();
        return list.get(0);
    }
}
