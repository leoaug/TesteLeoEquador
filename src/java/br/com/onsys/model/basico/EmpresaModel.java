package br.com.onsys.model.basico;

import javax.enterprise.context.RequestScoped;

import br.com.onsys.ejb.ManterEmpresaRepository;
import br.com.onsys.entidades.basico.Empresa;

@RequestScoped
public class EmpresaModel extends ManterEmpresaRepository <Empresa> {

	private static final long serialVersionUID = 1L;

}
