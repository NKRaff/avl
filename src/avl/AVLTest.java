package avl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AVLTest {
	
	/*
	 	- INSERÇÃO -
	 
 		SEM ROTAÇÃO

		ROTAÇÃO SIMPLES A ESQUERDA NA RAIZ, SEM FILHO
		ROTAÇÃO SIMPLES A ESQUERDA NA RAIZ, COM FILHO
		ROTAÇÃO SIMPLES A DIREITA NA RAIZ, SEM FILHO
		ROTAÇÃO SIMPLES A DIREITA NA RAIZ, COM FILHO
		ROTAÇÃO DUPLA A ESQUERDA NA RAIZ, SEM FILHO
		ROTAÇÃO DUPLA A ESQUERDA NA RAIZ, COM FILHO
		ROTAÇÃO DUPLA A DIREITA NA RAIZ, SEM FILHO
		ROTAÇÃO DUPLA A DIREITA NA RAIZ, COM FILHO
		
		ROTAÇÃO SIMPLES A ESQUERDA NO MEIO, SEM FILHO
		ROTAÇÃO SIMPLES A ESQUERDA NO MEIO, COM FILHO
		ROTAÇÃO SIMPLES A DIREITA NO MEIO, SEM FILHO
		ROTAÇÃO SIMPLES A DIREITA NO MEIO, COM FILHO
		ROTAÇÃO DUPLA A ESQUERDA NO MEIO, SEM FILHO
		ROTAÇÃO DUPLA A ESQUERDA NO MEIO, COM FILHO
		ROTAÇÃO DUPLA A DIREITA NO MEIO, SEM FILHO
		ROTAÇÃO DUPLA A DIREITA NO MEIO, COM FILHO
		
		- REMOÇÃO -
	*/

	private AVL avl;
	
	@BeforeEach
	public void setUp() {
		avl = new AVL();
	}
	/*
	@Test
	@DisplayName("Inserção equilibrada sem a necessidade de rotação")
	void inserir_quandoNaoRotaciona_deveRetornarPreOrdemEquilibrado() {
		avl.insere(5);
		avl.insere(2);
		avl.insere(7);
		avl.insere(3);
		avl.insere(8);
		avl.insere(6);
		assertEquals("5(0)2(-1)3(0)7(0)6(0)8(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Inserção equilibrada com a necessidade de rotação simples a direita sem filho, na raiz")
	void inserir_quandoRotacaoSimplesADireitaNaRaiz_deveRetornarPreOrdemEquilibrado() {
		avl.insere(4);
		avl.insere(3);
		avl.insere(2);
		avl.insere(1);
		assertEquals("3(1)2(1)1(0)4(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Inserção equilibrada com a necessidade de rotação simples a esquerda sem filho, na raiz")
	void inserir_quandoRotacaoSimplesAEsquerdaNaRaiz_deveRetornarPreOrdemEquilibrado() {
		avl.insere(1);
		avl.insere(2);
		avl.insere(3);
		avl.insere(4);
		assertEquals("2(-1)1(0)3(-1)4(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Inserção equilibrada com a necessidade de rotação simples a direita com filho, no meio")
	void inserir_quandoRotacaoSimplesADireitaComFilho_deveRetornarPreOrdemEquilibrado() {
		avl.insere(10);
		avl.insere(8);
		avl.insere(12);
		avl.insere(6);
		avl.insere(9);
		avl.insere(11);
		avl.insere(4);
		avl.insere(7);
		avl.insere(2);
		assertEquals("10(1)6(0)4(1)2(0)8(0)7(0)9(0)12(1)11(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Inserção equilibrada com a necessidade de rotação simples a esquerda com filho, no meio")
	void inserir_quandoRotacaoSimplesAEsquerdaComFilho_deveRetornarPreOrdemEquilibrado(){
		avl.insere(10);
		avl.insere(8);
		avl.insere(12);
		avl.insere(6);
		avl.insere(11);
		avl.insere(16);
		avl.insere(14);
		avl.insere(18);
		avl.insere(20);
		assertEquals("10(-1)8(1)6(0)16(0)12(0)11(0)14(0)18(-1)20(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Inserção equilibrada com a necessidade de rotação dupla a esquerda")
	void inserir_quandoRotacaoDuplaAEsquerda_deveRetornarPreOrdemEquilibrado() {
		avl.insere(10);
		avl.insere(8);
		avl.insere(12);
		avl.insere(6);
		avl.insere(11);
		avl.insere(16);
		avl.insere(14);
		avl.insere(18);
		avl.insere(13);
		assertEquals("10(-1)8(1)6(0)14(0)12(0)11(0)13(0)16(-1)18(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Inserção equilibrada com a necessidade de rotação dupla a direita")
	void inserir_quandoRotacaoDuplaADireita_deveRetornarPreOrdemEquilibrado(){
		avl.insere(10);
		avl.insere(8);
		avl.insere(12);
		avl.insere(5);
		avl.insere(9);
		avl.insere(11);
		avl.insere(4);
		avl.insere(6);
		avl.insere(7);
		assertEquals("10(1)6(0)5(1)4(0)8(0)7(0)9(0)12(1)11(0)", avl.preOrdem());
	}
	*/
	/////////////////////////////////////////////////
	
	@Test
	void remocao1() {
		avl.insere(15);
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(9);
		avl.insere(16);
		avl.insere(22);
		avl.insere(2);
		avl.insere(7);
		avl.insere(14);
		avl.insere(17);
		avl.insere(8);
		avl.remove(6);
		System.out.println(avl.preOrdem());
	}
}
