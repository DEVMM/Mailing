package br.com.grupomm.mailing.model.entity;




import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;





@Entity
public class Mapeamento implements Serializable {
 
	private static final long serialVersionUID = -6780269429079617083L;
	@Id 
	private String CNPJ;
	private String RAZAOSOCIAL;
	private String NOMEFANTASIA;
	private String EMAIL_EMPRESA;
	private String TELEFONE_EMPRESA;
	private String IDTIPOEMPRESA;
	private String PORTE_EMPRESA;
	private String TIPOLOGRADOURO;
	private String LOGRADOURO;
	private String NUMERO;
	private String CEP;
	private String BAIRRO;
	private String CIDADE;
	private String UF;
	private String NOMEEXECUTIVO;
	private String EMAIL_EXECUTIVO;
	private String TELEFONE_EXECUTIVO;
	private String AREA_EXECUTIVO;
	private String CARGO_EXECUTIVO;
	
	
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getRAZAOSOCIAL() {
		return RAZAOSOCIAL;
	}
	public void setRAZAOSOCIAL(String rAZAOSOCIAL) {
		RAZAOSOCIAL = rAZAOSOCIAL;
	}
	public String getNOMEFANTASIA() {
		return NOMEFANTASIA;
	}
	public void setNOMEFANTASIA(String nOMEFANTASIA) {
		NOMEFANTASIA = nOMEFANTASIA;
	}
	public String getEMAIL_EMPRESA() {
		return EMAIL_EMPRESA;
	}
	public void setEMAIL_EMPRESA(String eMAIL_EMPRESA) {
		EMAIL_EMPRESA = eMAIL_EMPRESA;
	}
	public String getTELEFONE_EMPRESA() {
		return TELEFONE_EMPRESA;
	}
	public void setTELEFONE_EMPRESA(String tELEFONE_EMPRESA) {
		TELEFONE_EMPRESA = tELEFONE_EMPRESA;
	}
	public String getIDTIPOEMPRESA() {
		return IDTIPOEMPRESA;
	}
	public void setIDTIPOEMPRESA(String iDTIPOEMPRESA) {
		IDTIPOEMPRESA = iDTIPOEMPRESA;
	}
	public String getPORTE_EMPRESA() {
		return PORTE_EMPRESA;
	}
	public void setPORTE_EMPRESA(String pORTE_EMPRESA) {
		PORTE_EMPRESA = pORTE_EMPRESA;
	}
	public String getTIPOLOGRADOURO() {
		return TIPOLOGRADOURO;
	}
	public void setTIPOLOGRADOURO(String tIPOLOGRADOURO) {
		TIPOLOGRADOURO = tIPOLOGRADOURO;
	}
	public String getLOGRADOURO() {
		return LOGRADOURO;
	}
	public void setLOGRADOURO(String lOGRADOURO) {
		LOGRADOURO = lOGRADOURO;
	}
	public String getNUMERO() {
		return NUMERO;
	}
	public void setNUMERO(String nUMERO) {
		NUMERO = nUMERO;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getBAIRRO() {
		return BAIRRO;
	}
	public void setBAIRRO(String bAIRRO) {
		BAIRRO = bAIRRO;
	}
	public String getCIDADE() {
		return CIDADE;
	}
	public void setCIDADE(String cIDADE) {
		CIDADE = cIDADE;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	public String getNOMEEXECUTIVO() {
		return NOMEEXECUTIVO;
	}
	public void setNOMEEXECUTIVO(String nOMEEXECUTIVO) {
		NOMEEXECUTIVO = nOMEEXECUTIVO;
	}
	public String getEMAIL_EXECUTIVO() {
		return EMAIL_EXECUTIVO;
	}
	public void setEMAIL_EXECUTIVO(String eMAIL_EXECUTIVO) {
		EMAIL_EXECUTIVO = eMAIL_EXECUTIVO;
	}
	public String getTELEFONE_EXECUTIVO() {
		return TELEFONE_EXECUTIVO;
	}
	public void setTELEFONE_EXECUTIVO(String tELEFONE_EXECUTIVO) {
		TELEFONE_EXECUTIVO = tELEFONE_EXECUTIVO;
	}
	public String getAREA_EXECUTIVO() {
		return AREA_EXECUTIVO;
	}
	public void setAREA_EXECUTIVO(String aREA_EXECUTIVO) {
		AREA_EXECUTIVO = aREA_EXECUTIVO;
	}
	public String getCARGO_EXECUTIVO() {
		return CARGO_EXECUTIVO;
	}
	public void setCARGO_EXECUTIVO(String cARGO_EXECUTIVO) {
		CARGO_EXECUTIVO = cARGO_EXECUTIVO;
	}


   
}
