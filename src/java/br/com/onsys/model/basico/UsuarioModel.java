package br.com.onsys.model.basico;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.bb.amb.jpa.constantes.Constantes;
import br.com.bb.amb.jpa.persistencia.BBTSQuery;
import br.com.onsys.ejb.ManterEmpresaRepository;
import br.com.onsys.entidades.basico.Usuario;

@RequestScoped
public class UsuarioModel extends ManterEmpresaRepository<Usuario>{
	private static final long serialVersionUID = 1L;
	
	@Inject
	UsuarioEmpresaModel usuarioEmpresaModel;

	public Usuario consultarUsuarioPorLoginESenha(String email, String senha) throws Exception {
		BBTSQuery <Usuario> query = super.inicializaBbtsQuery();
		query.adicionarFiltro("email", email, Constantes.OPERACAO_IGUAL);
		query.adicionarFiltro("senha", senha, Constantes.OPERACAO_IGUAL);
		return (Usuario) super.consultarPorParametrosAND(query);
	}

	public List<Usuario> listarUsuariosSemEmpresasVinculadas(List<Usuario> listaUsuarios) {
		List <Usuario> listaSemVinculo = listaUsuarios.stream().filter(usu -> {
			try {
				return !usuarioEmpresaModel.consultarUsuarioEmpresaPorUsuarioLogado(usu).isEmpty();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
		return listaSemVinculo;
	}


}
  