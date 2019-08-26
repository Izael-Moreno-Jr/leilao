package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.ifal.leilao.construtor.CriadorDeLeilao;
import br.edu.ifal.leilao.construtor.CriadorDeUsuario;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Produto;
import br.edu.ifal.leilao.modelo.Usuario;

public class TDDTest {
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private Usuario usuario4;
	private Usuario usuario5;
	
	private Leilao leilao;
	
	private CriadorDeLeilao criadorDeLeilao;
	
	private CriadorDeUsuario criadorDeUsuario;
	
	private Avaliador avaliador;
	
	@Test
	public void deveFuncionarComUsuriosELancesDiferentes() {
		criadorDeUsuario = new CriadorDeUsuario();
		
		usuario1 = criadorDeUsuario.com("Ana", "ana@hotmail.com").constroi();
		usuario2 = criadorDeUsuario.com("Zé", "zezinho@gmail.com").constroi();
		usuario3 = criadorDeUsuario.com("Maria", "maria2018@gmail.com").constroi();
		usuario4 = criadorDeUsuario.com("João", "joao@hotmail.com").constroi();
		usuario5 = criadorDeUsuario.com("Carlos", "carlos@hotmail.com").constroi();
		
		criadorDeLeilao = new CriadorDeLeilao();
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 300)
				.lance(usuario2, 400)
				.lance(usuario3, 250)
				.lance(usuario4, 500)
				.lance(usuario5, 600)
				.constroi();
		
		avaliador = new Avaliador();
		
		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = true;
		assertEquals(validadeEsperada, validadeObtida);
		
	}
	
	@Test
	public void naoDeveFuncionarComMaisDeCincoLancesDoMesmoUsuario() {
		criadorDeUsuario = new CriadorDeUsuario();
		
		usuario1 = criadorDeUsuario.com("Ana", "ana@hotmail.com").constroi();
		usuario2 = criadorDeUsuario.com("Zé", "zezinho@gmail.com").constroi();
		usuario3 = criadorDeUsuario.com("Maria", "maria2018@gmail.com").constroi();
		usuario4 = criadorDeUsuario.com("João", "joao@hotmail.com").constroi();
		usuario5 = criadorDeUsuario.com("Carlos", "carlos@hotmail.com").constroi();
		
		criadorDeLeilao = new CriadorDeLeilao();
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 300)
				.lance(usuario1, 400)
				.lance(usuario1, 250)
				.lance(usuario1, 500)
				.lance(usuario1, 550)
				.lance(usuario1, 600)
				.constroi();
		
		avaliador = new Avaliador();
		
		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = false;
		assertEquals(validadeEsperada, validadeObtida);
	}
	
	@Test
	public void deveFuncionarCom3LancesPorUsuarios() {
criadorDeUsuario = new CriadorDeUsuario();
		
		usuario1 = criadorDeUsuario.com("Ana", "ana@hotmail.com").constroi();
		usuario2 = criadorDeUsuario.com("Zé", "zezinho@gmail.com").constroi();
		usuario3 = criadorDeUsuario.com("Maria", "maria2018@gmail.com").constroi();
		usuario4 = criadorDeUsuario.com("João", "joao@hotmail.com").constroi();
		usuario5 = criadorDeUsuario.com("Carlos", "carlos@hotmail.com").constroi();
		
		criadorDeLeilao = new CriadorDeLeilao();
		
		leilao = criadorDeLeilao.para(new Produto("TV"))
				.lance(usuario1, 300)
				.lance(usuario1, 400)
				.lance(usuario1, 250)
				.lance(usuario2, 500)
				.lance(usuario2, 550)
				.lance(usuario2, 600)
				.constroi();
		
		avaliador = new Avaliador();
		
		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = true;
		assertEquals(validadeEsperada, validadeObtida);
	}
	
}
