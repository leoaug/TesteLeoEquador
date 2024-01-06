package br.com.onsys.controller.basico;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.onsys.entidades.basico.Empresa;
import br.com.onsys.model.basico.EmpresaModel;

@Named
@ViewScoped
public class EmpresaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Empresa empresa;
	
	@Inject
	private EmpresaModel empresaModel;
	
	@PostConstruct
	public void onInit()  {
		try {	
			setEmpresa(new Empresa());		
		} catch (Exception e) {
			e.printStackTrace();	
		}	
	}
	
	@Transactional
	public void salvar() throws Exception {
		
		empresaModel.salvar(getEmpresa());
		
		onInit();
		
		FacesContext.getCurrentInstance().
  			addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa cadastrada.", ""));
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
	
	
}
