package br.com.fiap.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.entity.Frota;
import br.com.fiap.repository.FrotaRepository;

public class AtualizarFrotaForm {

	@NotNull
	@NotEmpty
	@Length(max = 45)
	private String marcaVeiculo;
	@NotNull
	@NotEmpty
	@Length(max = 45)
	private String modeloVeiculo;
	@NotNull
	@NotEmpty
	@Length(max = 45)
	private String corVeiculo;
	@NotNull
	@NotEmpty
	@Length(max = 45)
	private String placaVeiculo;
	@NotNull
	@NotEmpty
	@Length(max = 11)
	private String anoVeiculo;

	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}

	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getCorVeiculo() {
		return corVeiculo;
	}

	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public String getAnoVeiculo() {
		return anoVeiculo;
	}

	public void setAnoVeiculo(String anoVeiculo) {
		this.anoVeiculo = anoVeiculo;
	}

	public Frota atualizar(Long id, FrotaRepository frotaRepository) {
		Frota frota = frotaRepository.getOne(id);
		
		frota.setMarcaVeiculo(this.getMarcaVeiculo());
		frota.setModeloVeiculo(this.getModeloVeiculo());
		frota.setCorVeiculo(this.getCorVeiculo());
		frota.setPlacaVeiculo(this.getPlacaVeiculo());
		frota.setAnoVeiculo(this.getAnoVeiculo());
		
		return frota;
	}
	
}
