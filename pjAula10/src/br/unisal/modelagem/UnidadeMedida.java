package br.unisal.modelagem;

public enum UnidadeMedida {
	UN ("UN", "UNIDADE"), 
	PC ("PC", "Pe�a"),
	MT ("MT", "Metro"),
	TON ("TON", "Tonelada"),
	CX ("CX", "Caixa"),
	DZ ("DZ", "Duzia"),
	LT ("LT", "Litro"),
	RL ("RL", "Rolo");
	
	private String unidade;
	private String descricao;
	private UnidadeMedida(String unidade, String descricao) {
		this.unidade = unidade;
		this.descricao = descricao;
		
	}
	public String getValue (String UN) {
		for(UnidadeMedida un : UnidadeMedida.values()) {
			if(un.unidade.equals(UN)) {
				return un.descricao;
			}
		}
		return null;
	}
	public String getUnidade() {
		return unidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public static String []getUnidades(){
		String unidades[] = new String [
		         UnidadeMedida.values().length];
		for(UnidadeMedida un : UnidadeMedida.values()) {
			int cont = 0;
			unidades[cont ++] = un.getUnidade() + " - " + un.getDescricao();
		}
		return unidades;
		}
	}

