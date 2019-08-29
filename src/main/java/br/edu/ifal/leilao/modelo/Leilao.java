package br.edu.ifal.leilao.modelo;

import java.util.ArrayList;
import java.util.List;

public class Leilao {
	
	private ArrayList<Lance> lances;
	private Produto produto;
	
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Leilao(Produto produto) {
		super();
		this.produto = produto;
		this.lances = new ArrayList<Lance>();
	}

	public Leilao() {
		super();
		this.lances = new ArrayList<Lance>();
	}

	public List<Lance> getLances() {
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = (ArrayList<Lance>) lances;
	}
	
	public void propoe(Lance lances) {
		this.lances.add(lances);
	}
}
