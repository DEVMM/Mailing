package br.com.grupomm.mailing.enuns;

public enum NivelAnuarios {

	Acionista(60,"Acionista"),
	Assessor(15,"Assessor"),
	Assistente(12,"Assistente"),
	Auxiliar(13,"Auxiliar"),
	Analista(55,"Analista"),
	CEO(4,"CEO"),
	ChDpto(8,"Ch. Dpto."),
	ChdeSecao(9,"Ch. de Seção"),
	Coordenador(11,"Coordenador"),
	Consultor(14,"Consultor"),
	Conselheiro(47,"Conselheiro"),
	Chefe(24,"Chefe"),
	ColSocial(31,"Col. Social"),
	Contato(38,"Contato"),
	Controller(34,"Controller"),
	Chairman(44,"Chairman"),
	Chairwoman(45,"Chairwoman"),
	CFO(51,"CFO"),
	CCO(52,"CCO"),
	CharisMan(50,"Charis-Man"),
	COO(56,"COO"),
	CMO(58,"CMO"),
	CTO(59,"CTO"),
	Diretor(6,"Diretor"),
	Designer(33,"Designer"),
	EditorChefe(42,"Editor Chefe"),
	Estudante(16,"Estudante"),
	Estagiario(17,"Estagiário"),
	Editor(25,"Editor"),
	Executivo(49,"Executivo"),
	Fundador(28,"Fundador"),
	FuncionarioPublico(18,"Funcionário Público"),
	Fotografo(29,"Fotógrafo"),
	Gerente(7,"Gerente"),
	Gal(39,"Gal."),
	Presidente(2,"Presidente"),
	Proprietario(23,"Proprietário"),
	Publisher(27,"Publisher"),
	Promotor(26,"Promotor"),
	Produtor(32,"Produtor"),
	Procurador(36,"Procurador"),
	RespDept(21,"Resp. Dept."),
	Reitor(37,"Reitor"),
	Redator(46,"Redator"),
	Reporter(53,"Repórter"),
	SocPropr(1,"Sóc. Propr."),
	Superint(3,"Superint."),
	Superv(10,"Superv."),
	SocDir(19,"Sóc. Dir."),
	SocEditor(43,"Sóc. Editor"),
	SocGer(20,"Sóc. Ger."),
	Subeditor(54,"Sub-editor"),
	Secr(40,"Secr."),
	Subgerente(41,"Subgerente"),
	Soc(22,"Sóc."),
	Tradutor(35,"Tradutor"),
	VP(5,"VP"),
	ViceDir(30,"Vice Dir."),
	Webmaster(57,"Webmaster");
	
	private final Integer id;
	private final String nome;
	
	NivelAnuarios(Integer i, String s){
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
