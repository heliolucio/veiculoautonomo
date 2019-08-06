package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_porta")
public class Porta implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idPorta;
	private String statusPorta;

	public Porta() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_porta")
	public Long getIdPorta() {
		return idPorta;
	}

	public void setIdPorta(Long idPorta) {
		this.idPorta = idPorta;
	}

	@Column(name = "status_porta", nullable = false)
	public String getStatusPorta() {
		return statusPorta;
	}

	public void setStatusPorta(String statusPorta) {
		this.statusPorta = statusPorta;
	}

}
