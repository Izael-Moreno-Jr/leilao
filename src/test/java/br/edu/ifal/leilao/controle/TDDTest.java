package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.ifal.leilao.construtor.CriadorDeLeilao;
import br.edu.ifal.leilao.construtor.CriadorDeUsuario;
import br.edu.ifal.leilao.modelo.Lance;
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
	@Test
	public void deveAceitarOPrimeiroLanceDoLeilao() {
		criadorDeUsuario = new CriadorDeUsuario();
		
		usuario1 = criadorDeUsuario.com("Ana", "ana@hotmail.com").constroi();
		usuario2 = criadorDeUsuario.com("Zé", "zezinho@gmail.com").constroi();
		
		criadorDeLeilao = new CriadorDeLeilao();
		
		Lance lance = new Lance(usuario1, 2);
		
		leilao = criadorDeLeilao.para(new Produto("Melão")).constroi();
		
		avaliador = new Avaliador();
		
		boolean aceitacaoObtida = avaliador.aceitarLance(leilao, lance);
		boolean aceitacaoEsperada = true;
		
		assertEquals(aceitacaoEsperada, aceitacaoObtida);
	}
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		criadorDeUsuario = new CriadorDeUsuario();
		
		usuario1 = criadorDeUsuario.com("Ana", "ana@hotmail.com").constroi();
		usuario2 = criadorDeUsuario.com("Zé", "zezinho@gmail.com").constroi();
		
		criadorDeLeilao = new CriadorDeLeilao();
		
		leilao = criadorDeLeilao.para(new Produto("Melão"))
				.lance(usuario1, 2)
				.constroi();
		
		Lance lance = new Lance(usuario1, 3);
		
		avaliador = new Avaliador();
		
		boolean aceitacaoObtida = avaliador.aceitarLance(leilao, lance);
		boolean aceitacaoEsperada = false;
		
		assertEquals(aceitacaoEsperada, aceitacaoObtida);
	}
	@Test
	public void deveAceitarDoisLancesSeguidosDeDoisUsuariosDiferentes() {
		criadorDeUsuario = new CriadorDeUsuario();
		
		usuario1 = criadorDeUsuario.com("Ana", "ana@hotmail.com").constroi();
		usuario2 = criadorDeUsuario.com("Zé", "zezinho@gmail.com").constroi();
		
		criadorDeLeilao = new CriadorDeLeilao();
		
		leilao = criadorDeLeilao.para(new Produto("Melão"))
				.lance(usuario1, 2)
				.constroi();
		
		Lance lance = new Lance(usuario2, 3);
		
		avaliador = new Avaliador();
		
		boolean aceitacaoObtida = avaliador.aceitarLance(leilao, lance);
		boolean aceitacaoEsperada = true;
		
		assertEquals(aceitacaoEsperada, aceitacaoObtida);
	}
	@Test
	public void naoDeveFunionarComVariosLancesValidosSeguidosDeDoisLancesDoMesmoUsuarios() {
		criadorDeUsuario = new CriadorDeUsuario();
		
		usuario1 = criadorDeUsuario.com("Ana", "ana@hotmail.com").constroi();
		usuario2 = criadorDeUsuario.com("Zé", "zezinho@gmail.com").constroi();
		usuario3 = criadorDeUsuario.com("Maria", "maria2018@gmail.com").constroi();
		
		criadorDeLeilao = new CriadorDeLeilao();
		
		leilao = criadorDeLeilao.para(new Produto("Melão"))
				.lance(usuario1, 2)
				.lance(usuario2, 3)
				.lance(usuario3, 4)
				.constroi();
		
		Lance lance = new Lance(usuario3, 5);
		
		avaliador = new Avaliador();
		
		boolean aceitacaoObtida = avaliador.aceitarLance(leilao, lance);
		boolean aceitacaoEsperada = false;
		
		assertEquals(aceitacaoEsperada, aceitacaoObtida);
	}
	
	@Test
	public void naoDeveAceitarLanceMenorQueOAnterior() {
		criadorDeUsuario = new CriadorDeUsuario();
		
		usuario1 = criadorDeUsuario.com("Ana", "ana@hotmail.com").constroi();
		usuario2 = criadorDeUsuario.com("Zé", "zezinho@gmail.com").constroi();
		usuario3 = criadorDeUsuario.com("Maria", "maria2018@gmail.com").constroi();
		
		criadorDeLeilao = new CriadorDeLeilao();
		
		leilao = criadorDeLeilao.para(new Produto("Melão"))
				.lance(usuario1, 2)
				.lance(usuario2, 3)
				.lance(usuario3, 4)
				.constroi();
		
		Lance lance = new Lance(usuario2, 1);
		
		avaliador = new Avaliador();
		
		boolean aceitacaoObtida = avaliador.aceitarLance(leilao, lance);
		boolean aceitacaoEsperada = false;
		
		assertEquals(aceitacaoEsperada, aceitacaoObtida);
	}
	
	@Test
	public void naoDeveAceitarUmNovoLanceComUmValorIgualAoUltimoLance() {
		criadorDeUsuario = new CriadorDeUsuario();
		
		usuario1 = criadorDeUsuario.com("Ana", "ana@hotmail.com").constroi();
		usuario2 = criadorDeUsuario.com("Zé", "zezinho@gmail.com").constroi();
		usuario3 = criadorDeUsuario.com("Maria", "maria2018@gmail.com").constroi();
		
		criadorDeLeilao = new CriadorDeLeilao();
		
		leilao = criadorDeLeilao.para(new Produto("Melão"))
				.lance(usuario1, 2)
				.lance(usuario2, 3)
				.lance(usuario3, 4)
				.constroi();
		
		Lance lance = new Lance(usuario2, 4);
		
		avaliador = new Avaliador();
		
		boolean aceitacaoObtida = avaliador.aceitarLance(leilao, lance);
		boolean aceitacaoEsperada = false;
		
		assertEquals(aceitacaoEsperada, aceitacaoObtida);
	}
}
