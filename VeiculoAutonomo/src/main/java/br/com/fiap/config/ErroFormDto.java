package br.com.fiap.config;

public class ErroFormDto {

	private String campo;
	private String msgErro;

	public ErroFormDto(String campo, String msgErro) {
		this.campo = campo;
		this.msgErro = msgErro;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMsgErro() {
		return msgErro;
	}

	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}

}
