package br.com.grupomm.mailing.model.enuns;

public enum Area {

	Administrativo(1, "Administrativo / Financeiro"),
	Arqu(2, "Arquivo Biblioteca"),
	Atend(3, "Atendimento / Planejamento / Pesquisa / Desenvolvimento"),
	Circulacao(4, "Circulação / Logística / Distribuição"),
	Comercial(5, "Comercial / Vendas"),
	Criac(6, "Criação / Design / Arte / Estúdio"),
	Editorial(7, "Editorial / Redação / Programação / Jornalismo"),
	Governo(8, "Governo"),
	Industrial(9, "Industrial / Produção / Suprimentos / Compras"),
	Internacional(10, "Internacional / Exportação / Importação"),
	Juridico(11, "Jurídico / Auditoria"),
	Marketing(12, "Marketing / Comunicação / Produto / Publicidade / Telemkt"),
	Mid(13, "Mídia"),
	Presidencia(14, "Presidência / Diretoria Geral / Superintendência"),
	ProducaoG(15, "Produção Gráfica"),
	Promocao(16, "Promoção / Merchandising / Eventos / Relações Públicas"),
	Rh(17, "Recursos Humanos / Pessoal / Treinamento"),
	RTV(18, "RT"),
	Sistemas(19, "Sistemas / Tecnologia / Informática / CPD");

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
