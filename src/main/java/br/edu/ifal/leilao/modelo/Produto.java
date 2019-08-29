package br.edu.ifal.leilao.modelo;

public class Produto {
	
	private String nome;
	private String descricao;
	private double valorInicial;

	public Produto(String nome) {
		super();
		this.nome = nome;
	}
	
	public Produto(String nome, double valorInicial) {
		super();
		this.nome = nome;
		this.valorInicial = valorInicial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}
	
}
