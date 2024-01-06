/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.onsys.entidades.basico;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 * @author Assis
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {    
    
    private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idEmpresa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
    
    //@Basic(optional = false)
    //@NotEmpty(message="O código não pode ser branco")
    @Column(length=20)
    private String codigo;

    //@Basic(optional = false)
    //@NotEmpty(message="A descrição não pode ser branco")
    @Column(length=60)
    private String descricao;

    @Column(length=20)
    private String situacao;  //VERIFICAR AONDE É UTILIZADO
    
    @Column(length=60)
    private String urlLogo;    

    @Column(length=60)
    private String urlImagemProduto;    
    
    @Column(length=60)
    private String urlRelatorio;       

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] logoimg;    
    
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imgfundo; 
    
    @Column(length=60)
    private String logotop;
    
    @Column(length=1)
    private String inativo;    
    
    @Column(length=1)
    private String modificado;    
    
    @Column()
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datainativo;    
    
    @Column(length=1)
    private String deletado;  
    
    //@Length(max=200, message="Tamanho máximo da observação é 200.")     
    @Column(length=200)
    private String obs;  
    
    @Column(length=200)
    private String login;  

    @Column(length=60)
    private String mensagem;   //MENSAGEM PADRÃO PARA TODOS OS USU�RIOS LOGADOS 

    @Column(length=18)
    private String cnpjcpfmatriz;  //SEM FORMATAÇÃO

    //@NotNull(message="O nome fantasia não pode ser nula")
    //@NotEmpty(message="O nome fantasia não pode ser branco")
    @Column(length=30)
    private String nomeFantasia;   
    
    @Column()
    private boolean expandeMenu = false;    

    @Column()
    private boolean usaCentroCustos = false;
    
    @Column()
    private boolean validaCPFCNPJ = false;

    @Column()
    private boolean preencheZeros = false; 

    //@Enumerated(EnumType.STRING)
    @Column(length=20)
    private String  tpRegimeTributario; 

    @Column(precision=12, scale=6)
    private BigDecimal percSimples;

    @Column(length=1)
    private String tipoCodigoParticip;  

    @Column(length=30)
    private String formatoParticip;  //FORMATAÇÃO PARA O CÓDIGO DE CLIENTE E FORNECEDOR

    @Column(length=30)
    private String formatoConta; 

    @Column(length=30)
    private String formatoCentroCustos; 

    @Column(length=30)
    private String formatoProduto; 

    @Column(length=30)
    private String formatoEndereco; 

    @Column(length=30)
    private String formatoLote; 


  
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatainativo() {
        return datainativo;
    }

    public void setDatainativo(Date datainativo) {
        this.datainativo = datainativo;
    }

    public byte[] getImgfundo() {
        return imgfundo;
    }

    public void setImgfundo(byte[] imgfundo) {
        this.imgfundo = imgfundo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrlRelatorio() {
        return urlRelatorio;
    }

    public void setUrlRelatorio(String urlRelatorio) {
        this.urlRelatorio = urlRelatorio;
    }

    public String getModificado() {
        return modificado;
    }

    public void setModificado(String modificado) {
        this.modificado = modificado;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public byte[] getLogoimg() {
        return logoimg;
    }

    public void setLogoimg(byte[] logoimg) {
        this.logoimg = logoimg;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getUrlImagemProduto() {
        return urlImagemProduto;
    }

    public void setUrlImagemProduto(String urlImagemProduto) {
        this.urlImagemProduto = urlImagemProduto;
    }

//  public byte[] getLogoTop() {
//      return logoTop;
//  }

//  public void setLogoTop(byte[] logoTop) {
//      this.logoTop = logoTop;
//  }

    public boolean isValidaCPFCNPJ() {
        return validaCPFCNPJ;
    }

    public void setValidaCPFCNPJ(boolean validaCPFCNPJ) {
        this.validaCPFCNPJ = validaCPFCNPJ;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    public String getInativo() {
        return inativo;
    }

    public void setInativo(String inativo) {
        this.inativo = inativo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCnpjcpfmatriz() {
        return cnpjcpfmatriz;
    }

    public void setCnpjcpfmatriz(String cnpjcpfmatriz) {
        this.cnpjcpfmatriz = cnpjcpfmatriz;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public boolean isUsaCentroCustos() {
        return usaCentroCustos;
    }

    public void setUsaCentroCustos(boolean usaCentroCustos) {
        this.usaCentroCustos = usaCentroCustos;
    }

    public boolean isPreencheZeros() {
        return preencheZeros;
    }

    public void setPreencheZeros(boolean preencheZeros) {
        this.preencheZeros = preencheZeros;
    }

    public String getTpRegimeTributario() {
        return tpRegimeTributario;
    }

    public void setTpRegimeTributario(String tpRegimeTributario) {
        this.tpRegimeTributario = tpRegimeTributario;
    }
    
    public BigDecimal getPercSimples() {
        return percSimples;
    }

    public void setPercSimples(BigDecimal percSimples) {
        this.percSimples = percSimples;
    }

    public String getTipoCodigoParticip() {
        return tipoCodigoParticip;
    }

    public void setTipoCodigoParticip(String tipoCodigoParticip) {
        this.tipoCodigoParticip = tipoCodigoParticip;
    }

    public String getFormatoParticip() {
        return formatoParticip;
    }

    public void setFormatoParticip(String formatoParticip) {
        this.formatoParticip = formatoParticip;
    }

    public String getFormatoConta() {
        return formatoConta;
    }

    public void setFormatoConta(String formatoConta) {
        this.formatoConta = formatoConta;
    }

    public String getFormatoCentroCustos() {
        return formatoCentroCustos;
    }

    public void setFormatoCentroCustos(String formatoCentroCustos) {
        this.formatoCentroCustos = formatoCentroCustos;
    }

    public String getFormatoProduto() {
        return formatoProduto;
    }

    public void setFormatoProduto(String formatoProduto) {
        this.formatoProduto = formatoProduto;
    }

    public String getFormatoEndereco() {
        return formatoEndereco;
    }

    public void setFormatoEndereco(String formatoEndereco) {
        this.formatoEndereco = formatoEndereco;
    }

    public String getFormatoLote() {
        return formatoLote;
    }

    public void setFormatoLote(String formatoLote) {
        this.formatoLote = formatoLote;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getLogotop() {
        return logotop;
    }

    public void setLogotop(String logotop) {
        this.logotop = logotop;
    }

    public Empresa() {
    }

  
    public boolean isExpandeMenu() {
        return expandeMenu;
    }

    public void setExpandeMenu(boolean expandeMenu) {
        this.expandeMenu = expandeMenu;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.onsys.entidades.basico.Empresa[ id=" + id + " ]";
    }
    
}
