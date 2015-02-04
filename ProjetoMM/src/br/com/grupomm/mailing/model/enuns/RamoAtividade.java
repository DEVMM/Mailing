package br.com.grupomm.mailing.model.enuns;

public enum RamoAtividade {
          
	Veiculo(4,"Veículo de Comunicação"),
	Agencia(1,"Agência"),
	Fornecedor(3,"Fornecedor da Comunicação"),
	Comercio(5,"Comércio / Indústria / Serviço");

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
