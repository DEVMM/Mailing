package br.com.grupomm.mailing.util;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BuscaComposite {

	private Integer nrSolicitacao;
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Date dataFor;
	@Temporal(TemporalType.DATE)
	private Date dataFrom;
	private List <String> tipo;
	private List <String> status;
	
	public Integer getNrSolicitacao() {
		return nrSolicitacao;
	}
	public void setNrSolicitacao(Integer nrSolicitacao) {
		this.nrSolicitacao = nrSolicitacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataFor() {
		return dataFor;
	}
	public void setDataFor(Date dataFor) {
		this.dataFor = dataFor;
	}
	public Date getDataFrom() {
		return dataFrom;
	}
	public void setDataFrom(Date dataFrom) {
		this.dataFrom = dataFrom;
	}

	public List<String> getTipo() {
		return tipo;
	}
	public void setTipo(List<String> tipo) {
		this.tipo = tipo;
	}
	public List<String> getStatus() {
		return status;
	}
	public void setStatus(List<String> status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFor == null) ? 0 : dataFor.hashCode());
		result = prime * result
				+ ((dataFrom == null) ? 0 : dataFrom.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((nrSolicitacao == null) ? 0 : nrSolicitacao.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuscaComposite other = (BuscaComposite) obj;
		if (dataFor == null) {
			if (other.dataFor != null)
				return false;
		} else if (!dataFor.equals(other.dataFor))
			return false;
		if (dataFrom == null) {
			if (other.dataFrom != null)
				return false;
		} else if (!dataFrom.equals(other.dataFrom))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nrSolicitacao == null) {
			if (other.nrSolicitacao != null)
				return false;
		} else if (!nrSolicitacao.equals(other.nrSolicitacao))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BuscaComposite [nrSolicitacao=" + nrSolicitacao
				+ ", descricao=" + descricao + ", dataFor=" + dataFor
				+ ", dataFrom=" + dataFrom + ", tipo=" + tipo + ", status="
				+ status + "]";
	}
	
	
}
