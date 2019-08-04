package br.com.fiap.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.entity.Pessoa;

public class PessoaForm {

	@NotNull
	@NotEmpty
	@Length(max = 255)
	private String nomePessoa;
	@NotNull
	@NotEmpty
	@Length(max = 20)
	private String telefonePessoa;
	@NotNull
	@NotEmpty
	@Length(max = 255)
	private String emailPessoa;
	@NotNull
	@NotEmpty
	@Length(max = 45)
	private String senhaPessoa;

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

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

	public String getSenhaPessoa() {
		return senhaPessoa;
	}

	public void setSenhaPessoa(String senhaPessoa) {
		this.senhaPessoa = senhaPessoa;
	}

	public Pessoa convert() {
		return new Pessoa(nomePessoa, telefonePessoa, emailPessoa, senhaPessoa);
	}

}
