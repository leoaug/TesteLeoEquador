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
import br.com.onsys.dto.DTO;
import br.com.onsys.entidades.basico.Empresa;
import br.com.onsys.model.basico.EmpresaModel;

@Named
@ViewScoped
public class EmpresaAdminController  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Empresa empresa;
	
	private List <Empresa> empresas;
	
	private DTO <Empresa> dto;
		
	@Inject
	private EmpresaModel empresaModel;
	
	@PostConstruct
	public void onInit()  {
		try {	
			setEmpresa(new Empresa());	
			setDto(new DTO<>());
			setEmpresas(empresaModel.getEntidades());
		} catch (Exception e) {
			e.printStackTrace();	
		}	
	}
	
	
	@Transactional
	public void salvarOuAlterar() throws Exception {


		setEmpresa(getEmpresa().getId() == null ? empresaModel.salvar(getEmpresa()) : empresaModel.alterar(getEmpresa()));

		onInit();
		
		PrimeFaces.current().ajax().update("idFormEmpresaAdmin");

		PrimeFaces.current().executeScript("PF('widgetVarDialogAdminEmpresa').hide()");

		FacesContext.getCurrentInstance().
		addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa alterada.", ""));

	}
	@Transactional
	public void excluirEmpresa() throws Exception {
		
		empresaModel.excluir(empresaModel.getEntidade(getEmpresa().getId()));
		
		onInit();


		FacesContext.getCurrentInstance().
		addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa excluída.", ""));
		
	}
	
	public void preExcluirEmpresa(Empresa Empresa) {
		setEmpresa(Empresa);
	}

	public void preEditarEmpresa(Empresa Empresa) throws Exception {
		getDto().setLabel("Alterar");
		setEmpresa(empresaModel.getEntidade(Empresa.getId()));
	}
	
	public void preSalvarEmpresa() throws Exception {
		getDto().setLabel("Salvar");
		setEmpresa(new Empresa());
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}


	public DTO<Empresa> getDto() {
		return dto;
	}


	public void setDto(DTO<Empresa> dto) {
		this.dto = dto;
	}


	
}
