package br.edu.ifal.leilao.controle;

import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;

public class Avaliador {
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	
	public void avalia(Leilao leilao) {
		for (Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			}
		}
	}

	public double getMaiorDeTodos() {
		return maiorDeTodos;
	}
	
}
