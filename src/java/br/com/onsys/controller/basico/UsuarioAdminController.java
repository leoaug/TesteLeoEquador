package br.com.onsys.controller.basico;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.PrimeFaces;

import br.com.onsys.constants.TipoUsuarioEnum;
import br.com.onsys.dto.DTO;
import br.com.onsys.entidades.basico.Usuario;
import br.com.onsys.model.basico.UsuarioModel;

@Named
@ViewScoped
public class UsuarioAdminController  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	private List <Usuario> usuarios;
	
	private DTO <TipoUsuarioEnum> dto;
	
	@Inject
	private UsuarioModel usuarioModel;
	
	@PostConstruct
	public void onInit()  {
		try {	
			setUsuario(new Usuario());	
			setDto(new DTO<TipoUsuarioEnum>());
			setUsuarios(usuarioModel.getEntidades());
		} catch (Exception e) {
			e.printStackTrace();	
		}	
	}
	
	
	@Transactional
	public void alterar() throws Exception {
				
		usuarioModel.alterar(getUsuario());
			
		onInit();
			
		PrimeFaces.current().executeScript("PF('widgetVarDialogAdminUsuario').hide()");
		
		FacesContext.getCurrentInstance().
				addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário alterado.", ""));
	
	}

	public void preEditarUsuario(Usuario usuario) throws Exception {
		setUsuario(usuarioModel.getEntidade(usuario.getId()));
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


	public DTO<TipoUsuarioEnum> getDto() {
		return dto;
	}


	public void setDto(DTO<TipoUsuarioEnum> dto) {
		this.dto = dto;
	}
	
	
}
