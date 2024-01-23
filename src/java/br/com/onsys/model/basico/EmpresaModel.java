package br.com.onsys.model.basico;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import br.com.onsys.ejb.ManterEmpresaRepository;
import br.com.onsys.entidades.basico.Empresa;
import br.com.onsys.entidades.basico.Usuario;
import br.com.onsys.entidades.basico.UsuarioEmpresa;

@RequestScoped
public class EmpresaModel extends ManterEmpresaRepository <Empresa> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	UsuarioModel usuarioModel;
	
	@Inject
	UsuarioEmpresaModel usuarioEmpresaModel;

	public DualListModel<Empresa> montarListaEmpresasPreEditar(Usuario usuario,
			List<Usuario> usuarios) throws Exception {
			
		List <UsuarioEmpresa> listaUsuarioEmpresaLogado = usuarioEmpresaModel.
				consultarUsuarioEmpresaPorUsuarioLogado(usuario);
		List <Empresa> listaTotal = super.getEntidades();
		List <Empresa> listaEmpresasPorUsuario = listaUsuarioEmpresaLogado.stream().
				map(usuEmpresa -> usuEmpresa.getEmpresa()).collect(Collectors.toList());	
		listaTotal.removeAll(listaEmpresasPorUsuario);				
		return new DualListModel<>(listaTotal, listaEmpresasPorUsuario);
	}

}
