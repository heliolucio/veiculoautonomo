package br.com.fiap.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.fiap.entity.ViagemStatus;
import br.com.fiap.repository.ViagemStatusRepository;

public class AtualizarViagemStatusForm {

	@NotNull
	@NotEmpty
	private String statusViagem;

	public String getStatusViagem() {
		return statusViagem;
	}

	public void setStatusViagem(String statusViagem) {
		this.statusViagem = statusViagem;
	}

	public ViagemStatus atualizar(Long id, ViagemStatusRepository viagemStatusRepository) {
		ViagemStatus viagemStatus = viagemStatusRepository.getOne(id);

		viagemStatus.setStatusViagem(this.getStatusViagem());

		return viagemStatus;
	}

}
