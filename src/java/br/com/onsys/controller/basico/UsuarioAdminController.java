package br.com.onsys.controller.basico;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.onsys.entidades.basico.Usuario;
import br.com.onsys.model.basico.UsuarioModel;

@Named
@ViewScoped
public class UsuarioAdminController  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	private List <Usuario> usuarios;
	
	@Inject
	private UsuarioModel usuarioModel;
	
	@PostConstruct
	public void onInit()  {
		try {	
			setUsuario(new Usuario());		
			setUsuarios(usuarioModel.getEntidades());
		} catch (Exception e) {
			e.printStackTrace();	
		}	
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
