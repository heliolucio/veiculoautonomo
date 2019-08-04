package br.com.fiap.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.entity.Porta;

public class PortaDto {

	private Long idPorta;
	private String statusPorta;

	public PortaDto(Porta porta) {
		this.idPorta = porta.getIdPorta();
		this.statusPorta = porta.getStatusPorta();
	}

	public Long getIdPorta() {
		return idPorta;
	}

	public void setIdPorta(Long idPorta) {
		this.idPorta = idPorta;
	}

	public String getStatusPorta() {
		return statusPorta;
	}

	public void setStatusPorta(String statusPorta) {
		this.statusPorta = statusPorta;
	}

	public static List<PortaDto> convert(List<Porta> porta) {
		return porta.stream().map(PortaDto::new).collect(Collectors.toList());
	}

}
