package br.com.grupomm.mailing.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.grupomm.mailing.dao.AnuariosDAO;
import br.com.grupomm.mailing.dao.MMDAO;
import br.com.grupomm.mailing.enuns.Area;
import br.com.grupomm.mailing.enuns.AreaAnuarios;
import br.com.grupomm.mailing.enuns.Estados;
import br.com.grupomm.mailing.enuns.Nivel;
import br.com.grupomm.mailing.enuns.NivelAnuarios;
import br.com.grupomm.mailing.enuns.Porte;
import br.com.grupomm.mailing.enuns.RamoAtividade;
import br.com.grupomm.mailing.enuns.RamoAtividadeAnuarios;
import br.com.grupomm.mailing.enuns.Sexo;
import br.com.grupomm.mailing.message.GrowlView;

public class MMControl {
       
	 List<Estados> estados = (List<Estados>) Arrays.asList(Estados.values());
	 List<Nivel> nivel = (List<Nivel>) Arrays.asList(Nivel.values());
	 List<RamoAtividade> ramoAtividade = (List<RamoAtividade>) Arrays.asList(RamoAtividade.values());
	 List<Area> area = (List<Area>) Arrays.asList(Area.values());
	 List<Porte> porte = (List<Porte>) Arrays.asList(Porte.values());
	 List<Sexo> sexo = (List<Sexo>) Arrays.asList(Sexo.values());
	
	
	public  String gerarRelatorio(List<String> valida, int idUsuario){
		
	List<String> ckEstados = new ArrayList<String>();
	List<Integer> ckNivel= new ArrayList<Integer>();
	List<Integer> ckRamoAtividade = new ArrayList<Integer>();
	List<Integer> ckArea = new ArrayList<Integer>();
	List<Integer> ckPorte= new ArrayList<Integer>();
	List<String> ckSexo= new ArrayList<String>();
	
	for(String v : valida){
		
		for(Estados s : estados){
			String chkBox = String.valueOf(s);
			if(v.equals(chkBox)){
				ckEstados.add(s.toString());
			}
		} 
		for(Nivel s : nivel){
			String chkBox = String.valueOf(s);
			if(v.equals(chkBox)){
				ckNivel.add(s.getId());
			}
		} 
		for(RamoAtividade s : ramoAtividade){
			String chkBox = String.valueOf(s);
			if(v.equals(chkBox)){
				ckRamoAtividade.add(s.getId());
			}
		} 
		for(Area s : area ){
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
		
		for(Sexo s : sexo ){
			String chkBox = String.valueOf(s);
			if(v.equals(chkBox)){
				ckSexo.add(s.toString());
			}
		}
	}	
	
	System.out.println(ckEstados);
	System.out.println(ckNivel);
	System.out.println(ckArea);
	System.out.println(ckRamoAtividade);
	System.out.println(ckPorte);
	System.out.println(ckSexo);
	
	if(ckEstados.isEmpty() || ckArea.isEmpty() || ckNivel.isEmpty() || ckPorte.isEmpty() || ckRamoAtividade.isEmpty() || ckSexo.isEmpty()){
		GrowlView.msgValidaCheckBox();
		return "";
	}
	else{
		
		MMDAO teste = new MMDAO();
		 teste.TesteMap(idUsuario, ckEstados, ckNivel, ckRamoAtividade, ckPorte, ckArea, ckSexo);
		 GrowlView.msgRelatorio();
		 return "index";
	}	
}
}
