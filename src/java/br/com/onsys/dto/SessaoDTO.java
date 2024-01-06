package br.com.onsys.dto;

import java.io.Serializable;

import br.com.onsys.entidades.basico.Usuario;

public class SessaoDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	private String fotoEmpresa;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getFotoEmpresa() {
		return fotoEmpresa;
	}
	public void setFotoEmpresa(String fotoEmpresa) {
		this.fotoEmpresa = fotoEmpresa;
	}
	

	
	
	
	
}
