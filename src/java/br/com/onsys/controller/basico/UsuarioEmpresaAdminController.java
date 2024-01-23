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
import javax.transaction.Transactional;

import org.primefaces.PrimeFaces;
import org.primefaces.model.DualListModel;

import br.com.onsys.dto.DTO;
import br.com.onsys.entidades.basico.Empresa;
import br.com.onsys.entidades.basico.Usuario;
import br.com.onsys.entidades.basico.UsuarioEmpresa;
import br.com.onsys.model.basico.EmpresaModel;
import br.com.onsys.model.basico.UsuarioEmpresaModel;
import br.com.onsys.model.basico.UsuarioModel;

@Named
@ViewScoped
public class UsuarioEmpresaAdminController  implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioEmpresa usuarioEmpresa;
	
	private List <Usuario> usuariosSelectOneMenu;
	
	private List <Usuario> usuariosDataTable;
	
	private List <UsuarioEmpresa> usuariosEmpresas;
		
	private DualListModel<Empresa> empresas;
		
	@Inject
	private UsuarioEmpresaModel usuarioEmpresaModel;
	
	@Inject
	private UsuarioModel usuarioModel;
	
	@Inject
	private EmpresaModel empresaModel;
	
	private DTO <UsuarioEmpresa> dto;
		
	
	@PostConstruct
	public void onInit()  {
		try {	
			setUsuarioEmpresa(new UsuarioEmpresa());	
			setDto(new DTO<>());
			setUsuariosEmpresas(usuarioEmpresaModel.getEntidades());
			setEmpresas(new DualListModel<>(empresaModel.getEntidades(), Collections.emptyList()));
			this.initCombosEDataTable();
		} catch (Exception e) {
			e.printStackTrace();	
		}	
	}
	
	
	private void initCombosEDataTable() throws Exception {
		
		List <Usuario> listaUsuarios = usuarioModel.getEntidades();
		
		setUsuariosSelectOneMenu(listaUsuarios);
		//listar todos os usuarios que ja tem vínculo com a tabela usuarioEmpresa
		setUsuariosDataTable(usuarioModel.listarUsuariosSemEmpresasVinculadas(listaUsuarios));
		
	}


	@Transactional
	public void salvarOuAlterar() throws Exception {

		// excluir as empresas primeiro vinculadas ao usuario selecionadl
		if(getUsuarioEmpresa().getUsuario().getId() != null) {
			usuarioEmpresaModel.excluirEntidades(usuarioModel.getEntidade(getUsuarioEmpresa().getUsuario().getId()).getUsuariosEmpresas());	
		}
		//usuarioEmpresaModel.excluirEntidades(usuarioModel.getEntidade(getUsuarioEmpresa().getUsuario().getId()).getUsuariosEmpresas());	
		usuarioEmpresaModel.salvarUsuarioEmpresas(getUsuarioEmpresa().getUsuario(),getEmpresas().getTarget());
		
		if("Salvar".equals(getDto().getLabel())){
			
			FacesContext.getCurrentInstance().
			addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Empresa salvo.", ""));
		} else {
			
			FacesContext.getCurrentInstance().
			addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Empresa alterada.", ""));
		}
		
		
		onInit();
		
		PrimeFaces.current().ajax().update("idFormUsuarioEmpresaAdmin");
		
		//PrimeFaces.current().executeScript("location.reload();");
		
		PrimeFaces.current().executeScript("PF('widgetVarDialogAdminUsuarioEmpresa').hide()");
	
		

	}
	@Transactional
	public void excluirUsuarioEmpresa() throws Exception {
		
		usuarioEmpresaModel.excluirEntidades(getUsuarioEmpresa().getUsuario().getUsuariosEmpresas());
				
		this.onInit();
		
		PrimeFaces.current().ajax().update("idFormUsuarioEmpresaAdmin");
		
		//PrimeFaces.current().executeScript("location.reload();");
		
		FacesContext.getCurrentInstance().
		addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Empresa excluída.", ""));
		
	}
	
	public void preExcluirUsuarioEmpresa(Usuario usuario) throws Exception {
		getUsuarioEmpresa().setUsuario(usuarioModel.getEntidade(usuario.getId()));
	}

	public void preEditarUsuarioEmpresa(Usuario usuario) throws Exception {
		getDto().setLabel("Alterar");	
		getUsuarioEmpresa().setUsuario(usuario);
		setUsuariosSelectOneMenu(usuarioModel.getEntidades());
		setEmpresas(empresaModel.montarListaEmpresasPreEditar(usuario,getUsuariosDataTable()));		
		PrimeFaces.current().ajax().update("idDialogAdminUsuarioEmpresaEditar");
	}
	
	public void preSalvarUsuarioEmpresa() throws Exception {
		getDto().setLabel("Salvar");
		setEmpresas(new DualListModel<>(empresaModel.getEntidades(), Collections.emptyList()));
		setUsuarioEmpresa(new UsuarioEmpresa());
		getUsuarioEmpresa().setUsuario(new Usuario());
		
		List <Usuario> listaUsuariosSemEmpresasVinculadas = usuarioModel.getEntidades().stream().filter(usu -> usu.getUsuariosEmpresas()
				.isEmpty()).collect(Collectors.toList());

		setUsuariosSelectOneMenu(listaUsuariosSemEmpresasVinculadas);
		PrimeFaces.current().ajax().update("idDialogAdminUsuarioEmpresaEditar");
	}


	


	public UsuarioEmpresa getUsuarioEmpresa() {
		return usuarioEmpresa;
	}


	public void setUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
		this.usuarioEmpresa = usuarioEmpresa;
	}



	public List<Usuario> getUsuariosSelectOneMenu() {
		return usuariosSelectOneMenu;
	}


	public void setUsuariosSelectOneMenu(List<Usuario> usuariosSelectOneMenu) {
		this.usuariosSelectOneMenu = usuariosSelectOneMenu;
	}


	public DualListModel<Empresa> getEmpresas() {
		return empresas;
	}


	public void setEmpresas(DualListModel<Empresa> empresas) {
		this.empresas = empresas;
	}


	public DTO<UsuarioEmpresa> getDto() {
		return dto;
	}


	public void setDto(DTO<UsuarioEmpresa> dto) {
		this.dto = dto;
	}


	public List<UsuarioEmpresa> getUsuariosEmpresas() {
		return usuariosEmpresas;
	}


	public void setUsuariosEmpresas(List<UsuarioEmpresa> usuariosEmpresas) {
		this.usuariosEmpresas = usuariosEmpresas;
	}


	public List<Usuario> getUsuariosDataTable() {
		return usuariosDataTable;
	}


	public void setUsuariosDataTable(List<Usuario> usuariosDataTable) {
		this.usuariosDataTable = usuariosDataTable;
	}
	
	

	
}
