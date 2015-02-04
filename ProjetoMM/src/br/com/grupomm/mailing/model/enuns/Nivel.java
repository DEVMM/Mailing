package br.com.grupomm.mailing.model.enuns;

public enum Nivel  {

	Assit(1,"Assitente Auxiliar"),
	Cons(2, "Consultor / Assessor"),
	Dir(3, "Diretor"),
	Estudant(4, "Estudante Estagi�rio"),
	FuncPublico(5, "Funcion�rio P�blico"),
	Ger(6, "Gerente Opera��es / Chefe de Se��o"),
	Pres(7, "Presidente Superintendente / CEO"),
	SocioProp(8, "S�cio Propriet�rio"),
	Super(9, "Supervisor Coordenador"),
	VicePre(10, "Vice-Presidente"),
	Cri(11, "Cria��o (Diretor de Arte / Redator)");

	private final Integer id;
	private final String nome;

	Nivel(Integer i, String s){
		id=i;
		nome=s;
	}
	
	public String getNome(){
		return nome;
	}
  
	public Integer getId(){
	   return id;
   }
   
    

}
