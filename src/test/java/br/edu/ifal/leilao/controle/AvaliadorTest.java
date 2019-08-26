package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifal.leilao.construtor.CriadorDeLeilao;
import br.edu.ifal.leilao.construtor.CriadorDeUsuario;
import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Produto;
import br.edu.ifal.leilao.modelo.Usuario;

public class AvaliadorTest {
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private Usuario usuario4;
	
	private Leilao leilao;
	
	private Avaliador avaliador;
	
	private CriadorDeLeilao criadorDeLeilao;
	
	private CriadorDeUsuario criadorDeUsuario;
	
	@Before
	public void inicializacao() {
		criadorDeUsuario = new CriadorDeUsuario();
		usuario1 = criadorDeUsuario.com("Ana", "ana@hotmail.com").constroi();
		usuario2 = criadorDeUsuario.com("Zé", "zezinho@gmail.com").constroi();
		usuario3 = criadorDeUsuario.com("Maria", "maria2018@gmail.com").constroi();
		usuario4 = criadorDeUsuario.com("João","joao@hotmail.com").constroi();
		
		avaliador = new Avaliador();
		
		criadorDeLeilao = new CriadorDeLeilao();
	}
	
	@Test
	public void avaliadorDeveFuncionarComLancesDeFormaAleatoria(){
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 300)
				.lance(usuario2, 400)
				.lance(usuario3, 250)
				.constroi();
		
		avaliador.avalia(leilao);
		double maiorLanceObtido = avaliador.getMaiorLance();
		double maiorLanceEsperado = 400;
		
		double menorLanceObtido = avaliador.getMenorLance();
		double menorLanceEsperado = 250;
		
		assertEquals(maiorLanceEsperado, maiorLanceObtido, 0.00001);
		assertEquals(menorLanceEsperado, menorLanceObtido, 0.00001);
	}
	
	@Test
	public void avaliadorDeveFuncionarComLancesDeFormaCrescente() {
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 250)
				.lance(usuario2, 300)
				.lance(usuario3, 400)
				.constroi();
		
		avaliador.avalia(leilao);
		double menorLanceObitido = avaliador.getMenorLance();
		double menorLanceEsperado = 250;
		
		double maiorLanceObtido = avaliador.getMaiorLance();
		double maiorLanceEsperado = 400;
		
		assertEquals(menorLanceEsperado, menorLanceObitido, 0.0001);
		assertEquals(maiorLanceEsperado, maiorLanceObtido, 0.0001);
		
		
	}
	@Test
	public void avaliadorDeveFuncionarComLancesDeFormaDecrescente() {
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 400)
				.lance(usuario2, 300)
				.lance(usuario3, 250)
				.constroi();
		
		avaliador.avalia(leilao);
		
		double maiorLanceObtido = avaliador.getMaiorLance();
		double maiorLanceEsperado = 400;
		
		double menorLanceObitido = avaliador.getMenorLance();
		double menorLanceEsperado = 250;
		
		assertEquals(maiorLanceEsperado, maiorLanceObtido, 0.0001);
		assertEquals(menorLanceEsperado, menorLanceObitido, 0.0001);
		
	}
	
	@Test
	public void top3LancesdeveFuncionarComLancesAleatorios() {
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 300)
				.lance(usuario2, 400)
				.lance(usuario3, 250)
				.constroi();
		
		avaliador.setTop3MaioresLances(leilao);
		
		List<Lance> top3 = avaliador.getTop3MaioresLances();
		
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 400;
		double segundoLanceEsperado = 300;
		double terceiroLanceEsperado = 250;
		int tamanhoTop3esperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.0001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.0001);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.0001);
		assertEquals(tamanhoTop3esperado, tamanhoTop3Obtido);
	}
	
	@Test
	public void top3LancesdeveFuncionarComLancesCrescentes() {
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 250)
				.lance(usuario2, 300)
				.lance(usuario3, 400)
				.constroi();
		
		avaliador.setTop3MaioresLances(leilao);
		
		List<Lance> top3 = avaliador.getTop3MaioresLances();
		
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 400;
		double segundoLanceEsperado = 300;
		double terceiroLanceEsperado = 250;
		int tamanhoTop3esperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.0001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.0001);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.0001);
		assertEquals(tamanhoTop3esperado, tamanhoTop3Obtido);
	}
	@Test
	public void top3LancesdeveFuncionarComLancesDecrescentes() {
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 400)
				.lance(usuario2, 300)
				.lance(usuario3, 250)
				.constroi();	
		avaliador.setTop3MaioresLances(leilao);
		
		List<Lance> top3 = avaliador.getTop3MaioresLances();
		
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 400;
		double segundoLanceEsperado = 300;
		double terceiroLanceEsperado = 250;
		int tamanhoTop3esperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.0001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.0001);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.0001);
		assertEquals(tamanhoTop3esperado, tamanhoTop3Obtido);
	}
	@Test
	public void top3LancesdeveFuncionarComLancesiguais() {		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 250)
				.lance(usuario2, 250)
				.lance(usuario3, 250)
				.constroi();
		
		avaliador.setTop3MaioresLances(leilao);
		
		List<Lance> top3 = avaliador.getTop3MaioresLances();
		
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 250;
		double segundoLanceEsperado = 250;
		double terceiroLanceEsperado = 250;
		int tamanhoTop3esperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.0001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.0001);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.0001);
		assertEquals(tamanhoTop3esperado, tamanhoTop3Obtido);
	}
	@Test
	public void top3LancesdeveFuncionarCom1Lance() {
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 250)
				.constroi();
				
		avaliador.setTop3MaioresLances(leilao);
		
		List<Lance> top3 = avaliador.getTop3MaioresLances();
		
		double primeiroLanceObtido = top3.get(0).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 250;
		int tamanhoTop3esperado = 1;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.0001);
		assertEquals(tamanhoTop3esperado, tamanhoTop3Obtido);
	}
	@Test
	public void top3LancesdeveFuncionarCom2Lances() {
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 250)
				.lance(usuario2, 300)
				.constroi();
		
		avaliador.setTop3MaioresLances(leilao);
		
		List<Lance> top3 = avaliador.getTop3MaioresLances();
		
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 300;
		double segundoLanceEsperado = 250;
		int tamanhoTop3esperado = 2;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.0001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.0001);
		assertEquals(tamanhoTop3esperado, tamanhoTop3Obtido);
	}
	@Test
	public void top3LancesdeveFuncionarSemLances() {
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.constroi();
		
		avaliador.setTop3MaioresLances(leilao);
		
		List<Lance> top3 = avaliador.getTop3MaioresLances();
		
		
		int tamanhoTop3Obtido = top3.size();
		
		int tamanhoTop3esperado = 0;
		
		assertEquals(tamanhoTop3esperado, tamanhoTop3Obtido);
	}
	
	@Test
	public void top3LancesdeveFuncionarCom4LancesAleatorios() {
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 300)
				.lance(usuario2, 400)
				.lance(usuario3, 250)
				.lance(usuario4, 500)
				.constroi();
		
		avaliador.setTop3MaioresLances(leilao);
		
		List<Lance> top3 = avaliador.getTop3MaioresLances();
		
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();
		
		int tamanhoTop3Obtido = top3.size();
		
		double primeiroLanceEsperado = 500;
		double segundoLanceEsperado = 400;
		double terceiroLanceEsperado = 300;
		int tamanhoTop3esperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.0001);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.0001);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.0001);
		assertEquals(tamanhoTop3esperado, tamanhoTop3Obtido);
	}
}