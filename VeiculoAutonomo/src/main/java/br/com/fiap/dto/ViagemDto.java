package br.com.fiap.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.entity.Viagem;

public class ViagemDto {

	private Long idViagem;
	private String origemViagem;
	private String destinoViagem;
	private String nomePessoa;
	private String marcaVeiculo;
	private String modeloVeiculo;
	private String formaPagamento;

	public ViagemDto(Viagem viagens) {
		this.idViagem = viagens.getIdViagem();
		this.origemViagem = viagens.getOrigemViagem();
		this.destinoViagem = viagens.getDestinoViagem();
		this.nomePessoa = viagens.getPessoa().getNomePessoa();
		this.marcaVeiculo = viagens.getFrota().getMarcaVeiculo();
		this.modeloVeiculo = viagens.getFrota().getModeloVeiculo();
		this.formaPagamento = viagens.getPagamento().getDescPagamento();
	}

	public Long getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(Long idViagem) {
		this.idViagem = idViagem;
	}

	public String getOrigemViagem() {
		return origemViagem;
	}

	public void setOrigemViagem(String origemViagem) {
		this.origemViagem = origemViagem;
	}

	public String getDestinoViagem() {
		return destinoViagem;
	}

	public void setDestinoViagem(String destinoViagem) {
		this.destinoViagem = destinoViagem;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
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

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public static List<ViagemDto> convert(List<Viagem> viagens) {
		return viagens.stream().map(ViagemDto::new).collect(Collectors.toList());
	}

}
