package br.com.fiap.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.entity.Pagamento;

public class PagamentoForm {

	@NotNull
	@NotEmpty
	@Length(max = 255)
	private String descPagamento;

	public String getDescPagamento() {
		return descPagamento;
	}

	public void setDescPagamento(String descPagamento) {
		this.descPagamento = descPagamento;
	}

	public Pagamento convert() {
		return new Pagamento(descPagamento);
	}
}
