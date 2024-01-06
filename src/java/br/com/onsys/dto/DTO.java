package br.com.onsys.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;




/**
 * 
 * @author Leonardo Silva
 * @version 3.0
 * @since   05/12/2016
 * @param <T> generics do java para fazer cast com as Entidades do SADC
 */
public class DTO <T extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private T entidade;

	private List <T> entidades;
	
	private List <T> entidades2;
	
	private List <T> filteredEntidades;
	
	private ScheduleModel eventModel;
	
	private ScheduleModel eventModelSelecionados;
	
	private ScheduleEvent event;
	
	private String aba;
	
	private Date dataAte;
	
	private Date minData;
	
	private Date maxData;
	
	private Date dataPeriodicidade;

	private String styleCss;
	
	private String datasString;
	
	private Date dataInicial;
	
	private String idComponente;
	
	private String mensagem;
	
	private String mensagemValidacaoCampos;
	
	private boolean rendered;
	
	private String mascaraChaveSisbb;

	private String label;
	
	private String stringJson;
	
	public T getEntidade() {
		return entidade;
	}

	public void setEntidade(T entidade) {
		this.entidade = entidade;
	}

	public List<T> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<T> entidades) {
		this.entidades = entidades;
	}
	
	
	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public ScheduleModel getEventModelSelecionados() {
		return eventModelSelecionados;
	}

	public void setEventModelSelecionados(ScheduleModel eventModelSelecionados) {
		this.eventModelSelecionados = eventModelSelecionados;
	}

	public String getAba() {
		return aba;
	}

	public void setAba(String aba) {
		this.aba = aba;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public Date getMinData() {
		return minData;
	}

	public void setMinData(Date minData) {
		this.minData = minData;
	}

	public Date getMaxData() {
		return maxData;
	}

	public void setMaxData(Date maxData) {
		this.maxData = maxData;
	}

	public Date getDataAte() {
		return dataAte;
	}

	public void setDataAte(Date dataAte) {
		this.dataAte = dataAte;
	}

	public String getStyleCss() {
		return styleCss;
	}

	public void setStyleCss(String styleCss) {
		this.styleCss = styleCss;
	}

	public String getDatasString() {
		return datasString;
	}

	public void setDatasString(String datasString) {
		this.datasString = datasString;
	}

	public Date getDataPeriodicidade() {
		return dataPeriodicidade;
	}

	public void setDataPeriodicidade(Date dataPeriodicidade) {
		this.dataPeriodicidade = dataPeriodicidade;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(String idComponente) {
		this.idComponente = idComponente;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public String getMensagemValidacaoCampos() {
		return mensagemValidacaoCampos;
	}

	public void setMensagemValidacaoCampos(String mensagemValidacaoCampos) {
		this.mensagemValidacaoCampos = mensagemValidacaoCampos;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMascaraChaveSisbb() {
		return mascaraChaveSisbb;
	}

	public void setMascaraChaveSisbb(String mascaraChaveSisbb) {
		this.mascaraChaveSisbb = mascaraChaveSisbb;
	}

	public String getStringJson() {
		return stringJson;
	}

	public void setStringJson(String stringJson) {
		this.stringJson = stringJson;
	}

	public List<T> getFilteredEntidades() {
		return filteredEntidades;
	}

	public void setFilteredEntidades(List<T> filteredEntidades) {
		this.filteredEntidades = filteredEntidades;
	}

	public List<T> getEntidades2() {
		return entidades2;
	}

	public void setEntidades2(List<T> entidades2) {
		this.entidades2 = entidades2;
	}

	

	
}

