package br.com.onsys.model.basico;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.bb.amb.jpa.constantes.Constantes;
import br.com.bb.amb.jpa.persistencia.BBTSQuery;
import br.com.onsys.ejb.ManterEmpresaRepository;
import br.com.onsys.entidades.basico.Empresa;
import br.com.onsys.entidades.basico.Usuario;
import br.com.onsys.entidades.basico.UsuarioEmpresa;

@RequestScoped
public class UsuarioEmpresaModel extends ManterEmpresaRepository <UsuarioEmpresa> {

	private static final long serialVersionUID = 1L;

	public void salvarUsuarioEmpresas(Usuario usuario, List<Empresa> empresas) throws Exception {
		for(Empresa empresa : empresas) {
			UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
			usuarioEmpresa.setEmpresa(empresa);
			usuarioEmpresa.setUsuario(usuario);
			super.salvar(usuarioEmpresa);
		}
		
	}

	public List<UsuarioEmpresa> consultarUsuarioEmpresaPorUsuarioLogado(Usuario usuario) throws Exception {
		if(usuario == null) {
			return Collections.emptyList();
		} else {
			BBTSQuery<UsuarioEmpresa> query = super.inicializaBbtsQuery();
			query.adicionarFiltro("usuario.id", usuario.getId(), Constantes.OPERACAO_IGUAL);
			return super.consultarPorParametrosANDList(query);
		}

	}

}
