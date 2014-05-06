package javaweb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@ManagedBean
public class AutomovelBean {
	
	private Automovel automovel = new Automovel();
	
	private List<Automovel> automoveis;
	
	@SuppressWarnings("unchecked")
	public List<Automovel> getAutomoveis() {
		if (this.automoveis == null) {
			EntityManager entityManager = JPAUtil.getEntityManager();
			Query query = entityManager.createQuery("select a from Automovel a", Automovel.class);
			this.automoveis = query.getResultList();
			entityManager.close();
		}
		
		return automoveis;
	}
	
	/*
	private String marca;
	private String modelo;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private String observacao;
	*/
	public Automovel getAutomovel() {
		return this.automovel;
	}
	
	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
	/*
	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Integer getAnoFabricacao() {
		return this.anoFabricacao;
	}
	
	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public Integer getAnoModelo() {
		return this.anoModelo;
	}
	
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	public String getObservacao() {
		return this.observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	*/
	public void salvar(Automovel automovel) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(automovel);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void excluir(Automovel automovel){
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		automovel = entityManager.merge(automovel);
		entityManager.remove(automovel);
		transaction.commit();
		entityManager.close();
	}
	
}