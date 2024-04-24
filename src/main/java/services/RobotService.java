package services;

import java.util.List;

//import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.LegoSetting;

@Path("/lego")
public class RobotService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("lego");
	
	
	
	@Path("/setvalues")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LegoSetting setValues(LegoSetting ls) {
		System.out.println("hello from server");
		System.out.println(ls);
	    EntityManager em=emf.createEntityManager();
	    try {
	    	em.getTransaction().begin();
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
}
	

