package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_viagemstatus")
public class ViagemStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idViagemStatus;
	private String statusViagem;

	public ViagemStatus() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_viagemstatus")
	public Long getIdViagemStatus() {
		return idViagemStatus;
	}

	public void setIdViagemStatus(Long idViagemStatus) {
		this.idViagemStatus = idViagemStatus;
	}

	@Column(name = "status_viagem", nullable = false, length = 45)
	public String getStatusViagem() {
		return statusViagem;
	}

	public void setStatusViagem(String statusViagem) {
		this.statusViagem = statusViagem;
	}

}
