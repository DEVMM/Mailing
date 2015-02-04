package br.com.grupomm.mailing.model.enuns;

public enum Area {

	Administrativo(1, "Administrativo / Financeiro"),
	Arqu(2, "Arquivo Biblioteca"),
	Atend(3, "Atendimento / Planejamento / Pesquisa / Desenvolvimento"),
	Circulacao(4, "Circula��o / Log�stica / Distribui��o"),
	Comercial(5, "Comercial / Vendas"),
	Criac(6, "Cria��o / Design / Arte / Est�dio"),
	Editorial(7, "Editorial / Reda��o / Programa��o / Jornalismo"),
	Governo(8, "Governo"),
	Industrial(9, "Industrial / Produ��o / Suprimentos / Compras"),
	Internacional(10, "Internacional / Exporta��o / Importa��o"),
	Juridico(11, "Jur�dico / Auditoria"),
	Marketing(12, "Marketing / Comunica��o / Produto / Publicidade / Telemkt"),
	Mid(13, "M�dia"),
	Presidencia(14, "Presid�ncia / Diretoria Geral / Superintend�ncia"),
	ProducaoG(15, "Produ��o Gr�fica"),
	Promocao(16, "Promo��o / Merchandising / Eventos / Rela��es P�blicas"),
	Rh(17, "Recursos Humanos / Pessoal / Treinamento"),
	RTV(18, "RT"),
	Sistemas(19, "Sistemas / Tecnologia / Inform�tica / CPD");

	private final String nome;
	private final Integer id;

	private Area(Integer i, String s) {
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
