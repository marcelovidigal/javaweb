package javaweb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
	
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
}