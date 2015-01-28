package br.com.grupomm.mailing.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.grupomm.mailing.dao.AnuariosDAO;
import br.com.grupomm.mailing.enuns.AreaAnuarios;
import br.com.grupomm.mailing.enuns.Estados;
import br.com.grupomm.mailing.enuns.NivelAnuarios;
import br.com.grupomm.mailing.enuns.Porte;
import br.com.grupomm.mailing.enuns.RamoAtividadeAnuarios;
import br.com.grupomm.mailing.message.GrowlView;

public class AnuariosControl {
       
	List<Estados> estados = (List<Estados>) Arrays.asList(Estados.values());
	List<NivelAnuarios> nivelAnuarios = (List<NivelAnuarios>) Arrays.asList(NivelAnuarios.values());
	List<RamoAtividadeAnuarios> ramoAtividadeAnuarios = (List<RamoAtividadeAnuarios>) Arrays.asList(RamoAtividadeAnuarios.values());
	List<AreaAnuarios> areaAnuarios = (List<AreaAnuarios>) Arrays.asList(AreaAnuarios.values());
	List<Porte> porte = (List<Porte>) Arrays.asList(Porte.values());
	
	
	public String gerarRelatorio(List<String> valida, int idUsuario){
		
	List<String> ckEstados = new ArrayList<String>();
	List<Integer> ckNivel= new ArrayList<Integer>();
	List<String> ckRamoAtividade = new ArrayList<String>();
	List<Integer> ckArea = new ArrayList<Integer>();
	List<Integer> ckPorte= new ArrayList<Integer>();
	
	for(String v : valida){
		
		for(Estados s : estados){
			String chkBox = String.valueOf(s);
			if(v.equals(chkBox)){
				ckEstados.add(s.toString());
			}
		} 
		for(NivelAnuarios s : nivelAnuarios){
			String chkBox = String.valueOf(s);
			if(v.equals(chkBox)){
				ckNivel.add(s.getId());
			}
		} 
		for(RamoAtividadeAnuarios s : ramoAtividadeAnuarios){
			String chkBox = String.valueOf(s);
			if(v.equals(chkBox)){
				ckRamoAtividade.add(s.toString());
			}
		} 
		for(AreaAnuarios s : areaAnuarios ){
			String chkBox = String.valueOf(s);
			if(v.equals(chkBox)){
				ckArea.add(s.getId());
			}
		} 
	
		for(Porte s : porte ){
			String chkBox = String.valueOf(s);
			if(v.equals(chkBox)){
				ckPorte.add(s.getId());
			}
		}
	}	
	 
	System.out.println("estados: "+ckEstados);
	 System.out.println("Ramos: "+ckRamoAtividade);
	 System.out.println("nivel:"+ckNivel);
	 System.out.println("porte:"+ckPorte);
	 System.out.println("Area"+ckArea);
	
	
	if(ckEstados.isEmpty() || ckArea.isEmpty() || ckNivel.isEmpty() || ckPorte.isEmpty() || ckRamoAtividade.isEmpty()){
		GrowlView.msgValidaCheckBox();
		return "";
	}
	else{
		
		AnuariosDAO teste = new AnuariosDAO();
		GrowlView.msgValidaCheckBox();
		teste.TesteMap(idUsuario, ckEstados, ckRamoAtividade, ckNivel, ckPorte, ckArea);
		 GrowlView.msgRelatorio();
		 return "index";
	}	
}
}
