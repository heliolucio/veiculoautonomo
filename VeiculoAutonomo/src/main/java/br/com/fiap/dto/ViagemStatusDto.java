package br.com.fiap.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.entity.ViagemStatus;

public class ViagemStatusDto {

	private Long idStatusViagem;
	private String statusViagem;

	public ViagemStatusDto(ViagemStatus viagemStatus) {
		this.idStatusViagem = viagemStatus.getIdViagemStatus();
		this.statusViagem = viagemStatus.getStatusViagem();
	}

	public Long getIdStatusViagem() {
		return idStatusViagem;
	}

	public void setIdStatusViagem(Long idStatusViagem) {
		this.idStatusViagem = idStatusViagem;
	}

	public String getStatusViagem() {
		return statusViagem;
	}

	public void setStatusViagem(String statusViagem) {
		this.statusViagem = statusViagem;
	}

	public static List<ViagemStatusDto> convert(List<ViagemStatus> viagemStatus) {
		return viagemStatus.stream().map(ViagemStatusDto::new)
				.collect(Collectors.toList());
	}

}
