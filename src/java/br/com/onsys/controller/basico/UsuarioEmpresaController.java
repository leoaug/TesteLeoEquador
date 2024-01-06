package br.com.onsys.controller.basico;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.primefaces.model.DualListModel;

import br.com.onsys.entidades.basico.Empresa;
import br.com.onsys.entidades.basico.Usuario;
import br.com.onsys.entidades.basico.UsuarioEmpresa;
import br.com.onsys.model.basico.EmpresaModel;
import br.com.onsys.model.basico.UsuarioEmpresaModel;
import br.com.onsys.model.basico.UsuarioModel;

@Named
@ViewScoped
public class UsuarioEmpresaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioEmpresa usuarioEmpresa;
	
	private List <Usuario> usuarios;
		
	private DualListModel<Empresa> empresas;
		
	@Inject
	private UsuarioEmpresaModel usuarioEmpresaModel;
	
	@Inject
	private UsuarioModel usuarioModel;
	
	@Inject
	private EmpresaModel empresaModel;
	 
	@PostConstruct
	public void onInit()  {
		try {	
			setUsuarioEmpresa(new UsuarioEmpresa());	
			HttpServletRequest requestObj = (HttpServletRequest)         
					FacesContext.getCurrentInstance().getExternalContext().getRequest();
			Usuario usuarioLogado = (Usuario) requestObj.getSession().getAttribute("usuarioLogado");
			 
			getUsuarioEmpresa().setUsuario(usuarioLogado);
			getUsuarioEmpresa().setEmpresa(new Empresa());
			setUsuarios(usuarioModel.getEntidades());	
			
			List <UsuarioEmpresa> listaUsuarioEmpresaLogado = usuarioEmpresaModel.
					consultarUsuarioEmpresaPorUsuarioLogado(usuarioLogado);
			List <Empresa> listaTotal = empresaModel.getEntidades();
			
			if(listaUsuarioEmpresaLogado.isEmpty()) {
				setEmpresas(new DualListModel<>(listaTotal, Collections.emptyList()));
			} else {
				List <Empresa> listaEmpresasUsuarioLogado = listaUsuarioEmpresaLogado.stream().
						map(usuarioEmpresa -> usuarioEmpresa.getEmpresa()).collect(Collectors.toList());	
				listaTotal.removeAll(listaEmpresasUsuarioLogado);				
				setEmpresas(new DualListModel<>(listaTotal, listaEmpresasUsuarioLogado));
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();	
		}	
	}
	
	@Transactional
	public void salvar() throws Exception {
		
		usuarioEmpresaModel.excluirEntidades(usuarioModel.getEntidade(getUsuarioEmpresa().getUsuario().getId()).getUsuariosEmpresas());	
		usuarioEmpresaModel.salvarUsuarioEmpresas(getUsuarioEmpresa().getUsuario(),getEmpresas().getTarget());
		
		onInit();
		
		FacesContext.getCurrentInstance().
      		addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Empresa(s) cadastrada(s).", ""));
	}

	public UsuarioEmpresa getUsuarioEmpresa() {
		return usuarioEmpresa;
	} 

	public void setUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
		this.usuarioEmpresa = usuarioEmpresa;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}	

	public DualListModel<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(DualListModel<Empresa> empresas) {
		this.empresas = empresas;
	}

	
	
}
