package br.com.fiap.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.fiap.entity.Porta;
import br.com.fiap.repository.PortaRepository;

public class AtualizarPortaForm {

	@NotNull
	@NotEmpty
	private String statusPorta;

	public String getStatusPorta() {
		return statusPorta;
	}

	public void setStatusPorta(String statusPorta) {
		this.statusPorta = statusPorta;
	}

	public Porta atualizar(Long id, PortaRepository portaRepository) {
		Porta porta = portaRepository.getOne(id);

		porta.setStatusPorta(this.getStatusPorta());
		
		return porta;
	}

}
