package br.com.onsys.entidades.basico;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuarioAcesso")
public class UsuarioAcesso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idUsuarioAcesso")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimoAcesso;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario" , referencedColumnName = "idUsuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "idEmpresa" , referencedColumnName = "idEmpresa")
	private Empresa empresa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
