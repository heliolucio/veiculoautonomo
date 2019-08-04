package br.com.fiap.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.entity.Frota;

public class FrotaDto {

	private Long idFrota;
	private String marcaVeiculo;
	private String modeloVeiculo;
	private String placaVeiculo;

	public FrotaDto(Frota frota) {
		this.idFrota = frota.getIdFrota();
		this.marcaVeiculo = frota.getMarcaVeiculo();
		this.modeloVeiculo = frota.getModeloVeiculo();
		this.placaVeiculo = frota.getPlacaVeiculo();
	}

	public Long getIdFrota() {
		return idFrota;
	}

	public void setIdFrota(Long idFrota) {
		this.idFrota = idFrota;
	}

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

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public static List<FrotaDto> convert(List<Frota> frota) {
		return frota.stream().map(FrotaDto::new).collect(Collectors.toList());
	}

}
