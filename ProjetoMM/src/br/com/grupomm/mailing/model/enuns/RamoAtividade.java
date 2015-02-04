package br.com.grupomm.mailing.model.enuns;

public enum RamoAtividade {
          
	Veiculo(4,"Ve�culo de Comunica��o"),
	Agencia(1,"Ag�ncia"),
	Fornecedor(3,"Fornecedor da Comunica��o"),
	Comercio(5,"Com�rcio / Ind�stria / Servi�o");

	private final String nome;
	private final Integer  id;
    
  
	private RamoAtividade(Integer i,String s) {
        nome = s;
        id=i;
    }
    
    public String getNome(){
        return nome;
     }

	public Integer getId() {
		return id;
	}
}
