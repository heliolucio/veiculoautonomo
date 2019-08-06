package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_viagem")
public class Viagem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idViagem;
	private String origemViagem;
	private String destinoViagem;
	private Pessoa pessoa;
	private Frota frota;
	private Pagamento pagamento;

	public Viagem() {
		super();
	}

	public Viagem(String origemViagem, String destinoViagem, Pessoa pessoa, Frota frota, Pagamento pagamento) {
		this.origemViagem = origemViagem;
		this.destinoViagem = destinoViagem;
		this.pessoa = pessoa;
		this.frota = frota;
		this.pagamento = pagamento;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_viagem")
	public Long getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(Long idViagem) {
		this.idViagem = idViagem;
	}

	@Column(name = "origem_viagem", nullable = false, length = 255)
	public String getOrigemViagem() {
		return origemViagem;
	}

	public void setOrigemViagem(String origemViagem) {
		this.origemViagem = origemViagem;
	}

	@Column(name = "destino_viagem", nullable = false, length = 255)
	public String getDestinoViagem() {
		return destinoViagem;
	}

	public void setDestinoViagem(String destinoViagem) {
		this.destinoViagem = destinoViagem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_pessoa")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_veiculo")
	public Frota getFrota() {
		return frota;
	}

	public void setFrota(Frota frota) {
		this.frota = frota;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_pagamento")
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

}
