package br.com.grupomm.mailing.enuns;

public enum Sexo {
	
	M("Masculino"),F("Feminino");
	
	private String nome;
	
	Sexo(String nome){
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}

}