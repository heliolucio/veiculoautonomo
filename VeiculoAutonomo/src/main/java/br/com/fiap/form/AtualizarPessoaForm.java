package br.com.fiap.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.entity.Pessoa;
import br.com.fiap.repository.PessoaRepository;

public class AtualizarPessoaForm {

	@NotNull
	@NotEmpty
	private String telefonePessoa;
	@NotNull
	@NotEmpty
	@Length(max = 255)
	private String emailPessoa;

	public String getTelefonePessoa() {
		return telefonePessoa;
	}

	public void setTelefonePessoa(String telefonePessoa) {
		this.telefonePessoa = telefonePessoa;
	}

	public String getEmailPessoa() {
		return emailPessoa;
	}

	public void setEmailPessoa(String emailPessoa) {
		this.emailPessoa = emailPessoa;
	}

	public Pessoa atualizar(Long id, PessoaRepository pessoaRepository) {

		Pessoa pessoa = pessoaRepository.getOne(id);

		pessoa.setTelefonePessoa(this.getTelefonePessoa());
		pessoa.setEmailPessoa(this.getEmailPessoa());

		return pessoa;
	}

}
