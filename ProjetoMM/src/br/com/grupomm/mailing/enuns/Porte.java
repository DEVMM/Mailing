package br.com.grupomm.mailing.enuns;

public enum Porte {
   
	
	Micro(1,"1 a 9 funcion�rios"),
    Pequeno(2,"10 a 49 funcion�rios"),
    Medio(3,"50 a 99 funcion�rios"),
    Grande(4,"mais de 100 funcion�rios");
	
	private final String nome;
	private final Integer id;

	private Porte( Integer i, String s) {
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
