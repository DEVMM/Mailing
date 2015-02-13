package br.com.grupomm.mailing.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Departamento implements Serializable{

	private static final long serialVersionUID = 8540646553098908266L;
	@Id @GeneratedValue
	Integer id;
    String nome;
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	} 
}
