package br.com.onsys.constants;

public enum TipoUsuarioEnum {

	ADMIN(1 ,"Administrador"),
	COMUM(2 , "Comum");
	
	private Integer valor;
	private String tipoUsuario;
	
	TipoUsuarioEnum (Integer valor, String tipoUsuario){
		this.valor = valor;
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getValor() {
		return valor;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}
}
