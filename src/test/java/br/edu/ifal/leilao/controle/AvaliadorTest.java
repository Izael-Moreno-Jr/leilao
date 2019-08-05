package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Usuario;

public class AvaliadorTest {
	
	@Test
	public void teste() {
		Usuario usuario1 = new Usuario("Ana");
		Usuario usuario2 = new Usuario("Zé");
		Usuario usuario3 = new Usuario("Maria");
		
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(usuario1, 300));
		leilao.propoe(new Lance(usuario2, 400));
		leilao.propoe(new Lance(usuario3, 250));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		double maiorLanceObtido = avaliador.getMaiorDeTodos();
		double maiorLanceEsperado = 400;
		
		assertEquals(maiorLanceEsperado, maiorLanceObtido, 0.00001);
	}

}
