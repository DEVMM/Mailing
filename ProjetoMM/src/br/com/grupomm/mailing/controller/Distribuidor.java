package br.com.grupomm.mailing.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.grupomm.mailing.model.enuns.Estados;

@ManagedBean
@ViewScoped
public class Distribuidor {
    
	public static List<String> listEstados = new ArrayList<String>();
	
	
	public  Distribuidor(Estados e){
		listEstados.add(e.toString());
	}
}
