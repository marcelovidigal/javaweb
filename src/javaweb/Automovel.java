package javaweb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Automovel {
	
	@Id @GeneratedValue
	private Long id;
	private String marca;
	private String modelo;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private String observacao;
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public Integer getAnoModelo() {
		return anoModelo;
	}
	
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}