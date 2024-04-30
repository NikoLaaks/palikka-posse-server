package services;

import java.util.List;

//import javax.management.Query;
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

@Path("/lego")
public class RobotService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("lego");
	
	
	
	@Path("/setvalues")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LegoSetting setValues(LegoSetting ls) {
		
		
	    EntityManager em=emf.createEntityManager();
	    LegoSetting lastRow = null;
	    try {
	    	em.getTransaction().begin();
	    	
	    	// Fetch the last row from legosetting table
	        Query query = em.createQuery("SELECT l FROM LegoSetting l ORDER BY l.id DESC")
	                         .setMaxResults(1);
	        try {
	        	lastRow = (LegoSetting) query.getSingleResult();
	        }catch(NoResultException e){
	        	System.out.println("Table is empty");
	        }
	        
	        
	        // Copy values from last row to ls object if not provided
	        
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
	    }finally {
	        em.close(); // Close the EntityManager in the finally block to release resources
	    }
	    	
		return ls;
		
		
		
	}
	
	@Path("/getvalues")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public LegoSetting getValues() {
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
		Query q=(Query) em.createQuery("select s from LegoSetting s order by s.id desc").setMaxResults(1);
		List<LegoSetting> list=((javax.persistence.Query) q).getResultList();
		em.getTransaction().commit();		
		return list.get(0);
	}
	@Path("/sendstatistics")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LegoStatistics sendData(LegoStatistics statistics) {
		System.out.println(statistics);
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(statistics);
	    em.getTransaction().commit();		
		return statistics;
	}
	
	@Path("/getstatistics")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public LegoStatistics getStatistics() {
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
		Query q=(Query) em.createQuery("select s from LegoStatistics s order by s.id desc").setMaxResults(1);
		List<LegoStatistics> list=((javax.persistence.Query) q).getResultList();
		em.getTransaction().commit();		
		return list.get(0);
	}
}
	

