package javaweb;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersistidorDeAutomovel {
	
	public static void main(String[] args) {
		
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
		//EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		Automovel automovel = new Automovel();
		automovel.setAnoFabricacao(2010);
		automovel.setModelo("Ferrari");
		automovel.setObservacao("Nunca foi batido");
		
		// insercao
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(automovel);
		entityTransaction.commit();
		
		// selecao
		Query query = entityManager.createQuery("select a from Automovel a", Automovel.class);
		
		@SuppressWarnings("unchecked")
		List<Automovel> autos = query.getResultList();
		
		for (Automovel auto : autos) {
			System.out.println(auto.getMarca());
		}
		
		// remocao
		Automovel auto = entityManager.getReference(Automovel.class, 1L);
		entityTransaction.begin();
		entityManager.remove(auto);
		entityTransaction.commit();
		
		entityManager.close();
		//entityManagerFactory.close();
	}
	
}