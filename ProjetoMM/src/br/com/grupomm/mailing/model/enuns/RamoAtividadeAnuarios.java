package br.com.grupomm.mailing.model.enuns;

public enum RamoAtividadeAnuarios {

	EmpresaMidiaExterior(1,"Mídia Exterior"),
	EmpresaRepresentante(2,"Representante"),
	EmpresaAgencia(3,"Agência"),
	EmpresaAnunciante(4,"Anunciante"),
	EmpresaFornecedor(5,"Fornecedor"),
	EmpresaRevista(6,"Revista"),
	EmpresaInternet(7,"Internet"),
	EmpresaTvAberta(8,"TV Aberta"),
	EmpresaCinema(9,"Cinema"),
	EmpresaGuiaLista(10,"Guias e Listas"),
	EmpresaJornal(11,"Jornal"),
	EmpresaTvAssinatura(12,"TV por Assinatura"),
	EmpresaOutdoor(13,"Outdoor"),
	EmpresaRadio(14,"Rádio");


	private final String nome;
	private final Integer id;

	private RamoAtividadeAnuarios( Integer i, String s) {
		id=i;
		nome = s;
	}

	public String getNome(){
		return nome;
	}
	public Integer getId(){
		return id;
	}
}
