package br.com.onsys.entidades.basico;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.onsys.constants.TipoUsuarioEnum;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idUsuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false,length = 60)
	private String nome;
	
	@Column(nullable = false,length = 30)
	private String apelido;
	
	@Column(nullable = false,length = 16)
	private String senha;
	
	@Column(nullable = false,length = 60)
	private String email;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_usuario")
	private TipoUsuarioEnum tipoUsuarioEnum;
	
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List <UsuarioEmpresa> usuariosEmpresas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public TipoUsuarioEnum getTipoUsuarioEnum() {
		return tipoUsuarioEnum;
	}

	public void setTipoUsuarioEnum(TipoUsuarioEnum tipoUsuarioEnum) {
		this.tipoUsuarioEnum = tipoUsuarioEnum;
	}

	public List<UsuarioEmpresa> getUsuariosEmpresas() {
		return usuariosEmpresas;
	}

	public void setUsuariosEmpresas(List<UsuarioEmpresa> usuariosEmpresas) {
		this.usuariosEmpresas = usuariosEmpresas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apelido, email, id, nome, senha, tipoUsuarioEnum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apelido, other.apelido) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && tipoUsuarioEnum == other.tipoUsuarioEnum;
	}

	
	
}
