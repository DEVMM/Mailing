package br.com.grupomm.mailing.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MapeamentoMM implements Serializable{
 
	private static final long serialVersionUID = -3295587505943017241L;
	@Id 
	private String ID_USUARIO;
	private String PRI_NOME;
	private String SOBRENOME;
	private String EMAIL_LOGIN;
	private String AREA_ATUACAO;
	private String CARGO;
	private String ESTADO;
	private String SEXO;
	private String NASCIMENTO;
	private String NIVEL_HIERARQUICO;
	private String AREA_DE_ATUACAO;
	private String RAMO_DE_ATIVIDADE;
	private String PORTE_EMPRESA;
	
	public String getID_USUARIO() {
		return ID_USUARIO;
	}
	public void setID_USUARIO(String iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}
	public String getPRI_NOME() {
		return PRI_NOME;
	}
	public void setPRI_NOME(String pRI_NOME) {
		PRI_NOME = pRI_NOME;
	}
	public String getSOBRENOME() {
		return SOBRENOME;
	}
	public void setSOBRENOME(String sOBRENOME) {
		SOBRENOME = sOBRENOME;
	}
	public String getEMAIL_LOGIN() {
		return EMAIL_LOGIN;
	}
	public void setEMAIL_LOGIN(String eMAIL_LOGIN) {
		EMAIL_LOGIN = eMAIL_LOGIN;
	}
	public String getAREA_ATUACAO() {
		return AREA_ATUACAO;
	}
	public void setAREA_ATUACAO(String aREA_ATUACAO) {
		AREA_ATUACAO = aREA_ATUACAO;
	}
	public String getCARGO() {
		return CARGO;
	}
	public void setCARGO(String cARGO) {
		CARGO = cARGO;
	}
	public String getESTADO() {
		return ESTADO;
	}
	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}
	public String getSEXO() {
		return SEXO;
	}
	public void setSEXO(String sEXO) {
		SEXO = sEXO;
	}
	public String getNASCIMENTO() {
		return NASCIMENTO;
	}
	public void setNASCIMENTO(String nASCIMENTO) {
		NASCIMENTO = nASCIMENTO;
	}
	public String getNIVEL_HIERARQUICO() {
		return NIVEL_HIERARQUICO;
	}
	public void setNIVEL_HIERARQUICO(String nIVEL_HIERARQUICO) {
		NIVEL_HIERARQUICO = nIVEL_HIERARQUICO;
	}
	public String getAREA_DE_ATUACAO() {
		return AREA_DE_ATUACAO;
	}
	public void setAREA_DE_ATUACAO(String aREA_DE_ATUACAO) {
		AREA_DE_ATUACAO = aREA_DE_ATUACAO;
	}
	public String getRAMO_DE_ATIVIDADE() {
		return RAMO_DE_ATIVIDADE;
	}
	public void setRAMO_DE_ATIVIDADE(String rAMO_DE_ATIVIDADE) {
		RAMO_DE_ATIVIDADE = rAMO_DE_ATIVIDADE;
	}
	public String getPORTE_EMPRESA() {
		return PORTE_EMPRESA;
	}
	public void setPORTE_EMPRESA(String pORTE_EMPRESA) {
		PORTE_EMPRESA = pORTE_EMPRESA;
	}

	
}
