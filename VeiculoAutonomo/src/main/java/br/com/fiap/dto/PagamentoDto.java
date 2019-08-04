package br.com.fiap.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.entity.Pagamento;

public class PagamentoDto {

	private Long idPagamento;
	private String descPagamento;

	public PagamentoDto(Pagamento pagamento) {
		this.idPagamento = pagamento.getIdPagamento();
		this.descPagamento = pagamento.getDescPagamento();
	}

	public Long getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Long idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getDescPagamento() {
		return descPagamento;
	}

	public void setDescPagamento(String descPagamento) {
		this.descPagamento = descPagamento;
	}

	public static List<PagamentoDto> convert(List<Pagamento> pagamentos) {
		return pagamentos.stream().map(PagamentoDto::new).collect(Collectors.toList());
	}

}
