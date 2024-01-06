package br.com.onsys.model.basico;

import javax.enterprise.context.RequestScoped;

import br.com.bb.amb.jpa.constantes.Constantes;
import br.com.bb.amb.jpa.persistencia.BBTSQuery;
import br.com.onsys.ejb.ManterEmpresaRepository;
import br.com.onsys.entidades.basico.Usuario;

@RequestScoped
public class UsuarioModel extends ManterEmpresaRepository<Usuario>{
	private static final long serialVersionUID = 1L;

	public Usuario consultarUsuarioPorLoginESenha(String email, String senha) throws Exception {
		BBTSQuery <Usuario> query = super.inicializaBbtsQuery();
		query.adicionarFiltro("email", email, Constantes.OPERACAO_IGUAL);
		query.adicionarFiltro("senha", senha, Constantes.OPERACAO_IGUAL);
		return (Usuario) super.consultarPorParametrosAND(query);
	}


}
  