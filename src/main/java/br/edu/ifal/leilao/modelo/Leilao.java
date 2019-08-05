package br.edu.ifal.leilao.modelo;

import java.util.List;

public class Leilao {
	
	private List<Lance> lances;

	public Leilao() {
		super();
	}

	public List<Lance> getLances() {
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}
}
