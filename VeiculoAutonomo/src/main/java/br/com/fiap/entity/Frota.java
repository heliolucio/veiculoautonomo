package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_frota")
public class Frota implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idFrota;
	private String marcaVeiculo;
	private String modeloVeiculo;
	private String corVeiculo;
	private String placaVeiculo;
	private String anoVeiculo;
	private List<Viagem> viagens = new ArrayList<>();

	public Frota() {
		super();
	}
	
	public Frota(String marcaVeiculo, String modeloVeiculo, String corVeiculo, String placaVeiculo, String anoVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
		this.modeloVeiculo = modeloVeiculo;
		this.corVeiculo = corVeiculo;
		this.placaVeiculo = placaVeiculo;
		this.anoVeiculo = anoVeiculo;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veiculo")
	public Long getIdFrota() {
		return idFrota;
	}

	public void setIdFrota(Long idFrota) {
		this.idFrota = idFrota;
	}

	@Column(name = "marca_veiculo", nullable = false, length = 255)
	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}

	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}

	@Column(name = "modelo_veiculo", nullable = false, length = 255)
	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	@Column(name = "cor_veiculo", nullable = false, length = 255)
	public String getCorVeiculo() {
		return corVeiculo;
	}

	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}

	@Column(name = "placa_veiculo", nullable = false, length = 255)
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	@Column(name = "ano_veiculo", nullable = false)
	public String getAnoVeiculo() {
		return anoVeiculo;
	}

	public void setAnoVeiculo(String anoVeiculo) {
		this.anoVeiculo = anoVeiculo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "frota")
	public List<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}

}
