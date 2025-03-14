package com.harison.cursomc.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1,"Pessoa Física"), //PADRAO 0 (COMECA EM ZERO), essa implementação, controlamos os valores de cada enums. 
	PESSOAJURIDICA(2, "Pessoa Juríca") ;

	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao; 
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	public static TipoCliente toEnum(Integer cod) {
		
		if(cod ==null) {
			return null;
		}
		//Percorrer todos os enums
		for( TipoCliente x : TipoCliente.values())
		{
			if(cod.equals(x.getCod()))
			{
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido" +cod); //Se for um código inválido
		
	}
	
}


