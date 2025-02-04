package avl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AVLTest {
	
	/*
	 	TESTES
	 	
	 	- INSERÇAO
	 		INSERIR NA RAIZ
	 		INSERIR A ESQUERDA
	 		INSERIR A DIREITA
	 	- REMOÇÃO
	 		REMOVER NA RAIZ
	 			QUANDO ARVORE POSSUIR APENAS RAIZ
	 			QUANDO NÃO POSSUI SUCESSOR
	 			QUANDO POSSUI SUCESSOR
	 			QUANDO SUCESSOR POSSUIR FILHO
	 		REMOVE UMA FOLHA QUALQUER
	 			QUANDO NÃO TIVER FILHOS
	 			QUANDO TIVER 1 FILHO
 					FILHO NA ESQUERDA
			 			QUANDO NÃO POSSUIR SUCESSOR
			 			QUANDO POSSUI SUCESSOR
	 				FILHO NA DIREITA
	 			QUANDO TIVER 2 FILHOS
	 	- ROTAÇÃO
	 		ROTAÇÃO NA RAIZ
	 			QUANDO CRITICO NÃO TIVER FILHO
	 				ROTAÇÃO SIMPLES A ESQUERDA
	 				ROTAÇÃO SIMPLES A DIREITA
	 				ROTAÇÃO DUPLA A ESQUERDA
	 				ROTAÇÃO DUPLA A DIREITA
	 			QUANDO CRITICO TIVER FILHO
	 				ROTAÇÃO SIMPLES A ESQUERDA
	 				ROTAÇÃO SIMPLES A DIREITA
	 				ROTAÇÃO DUPLA A ESQUERDA
	 				ROTAÇÃO DUPLA A DIREITA
	 		ROTAÇÃO EM UM NO QUALQUER
	 			QUANDO CRITICO NÃO TIVER FILHO
	 				ROTAÇÃO SIMPLES A ESQUERDA
	 				ROTAÇÃO SIMPLES A DIREITA
	 				ROTAÇÃO DUPLA A ESQUERDA
	 				ROTAÇÃO DUPLA A DIREITA
	 			QUANDO CRITICO TIVER FILHO
	 				ROTAÇÃO SIMPLES A ESQUERDA
	 				ROTAÇÃO SIMPLES A DIREITA
	 				ROTAÇÃO DUPLA A ESQUERDA
	 				ROTAÇÃO DUPLA A DIREITA
	*/

	private AVL avl;
	
	@BeforeEach
	public void setUp() {
		avl = new AVL(15);
	}
	
	@Test
	@DisplayName("Inserir na raiz")
	void insercao_quandoRaizNull_deveInserirNaAVL() {
		assertEquals("15(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Inserir a esquerda")
	void insercao_quandoInserirAEsquerda_deveInserirAEsquerda() {
		avl.insere(6);
		assertEquals("15(1)6(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Inserir a direita")
	void insercao_quandoInserirADireita_deveInserirADireita() {
		avl.insere(18);
		assertEquals("15(-1)18(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remover raiz quando possui apenas a raiz")
	void removerRaiz_quandoPossuiApenasARaiz_deveRetornaArvoreVazia() {
		avl.remove(15);
		assertEquals("", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remover raiz quando não possui sucessor")
	void removerRaiz_quandoNaoPossuiSucessor_deveRemoverARaiz() {
		avl.insere(6);
		avl.remove(15);
		assertEquals("6(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remover raiz quando possui sucessor")
	void removerRaiz_quandoPossuiSucessor_deveRemoverARaiz() {
		avl.insere(18);
		avl.remove(15);
		assertEquals("18(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remover raiz quando raiz possui 2 filhos")
	void removerRaiz_quandoPossuiDoisFilhos_deveRemoverARaiz() {
		avl.insere(6);
		avl.insere(18);
		avl.remove(15);
		assertEquals("18(1)6(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remover raiz quando sucessor possui filho")
	void removerRaiz_quandoSucessorPossuiFilho_deveRemoverARaiz() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(22);
		avl.remove(15);
		assertEquals("18(0)6(0)22(0)", null);
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
	/////////////////////////////////////////
	
	@Test
	@DisplayName("Remoção equilibrada com nenhum filho")
	void remocao_quandoNãoTiverFilhosNoMeio_deveRetornarPreORdemEquilibrado() {
		avl.insere(15);
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(9);
		avl.insere(16);
		avl.insere(22);
		avl.insere(7);
		avl.insere(14);
		avl.insere(17);
		avl.remove(14);
		assertEquals("15(0)6(-1)1(0)9(1)7(0)18(1)16(-1)17(0)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remoção equilibrada com um filho")
	void remocao_quandoTiverUmFilhoNoMeio_deveRetornarPreOrdemEquilibrado() {
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
		avl.remove(7);
		assertEquals("15(0)6(0)1(-1)2(0)9(0)8(0)14(0)18(1)16(-1)17(0)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remoção equilibrada com 2 filhos")
	void remocao_quandoTiverDoisFilhosNoMeio_deveRetornarPreOrdemEquilibrado() {
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
		assertEquals("15(0)7(0)1(-1)2(0)9(0)8(0)14(0)18(1)16(-1)17(0)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remoção equilibrada sem filho na raiz")
	void remocao_quandoRemoveRaizQueNaoTemFilho_deveRetornarPreOrdemEquilibrado() {
		avl.insere(15);
		avl.remove(15);
		assertEquals("", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remoção equilibrado na raiz quando não tem sucessor")
	void remocao_naRaizQuandoNaoPossuiSucessor_deveRetornarPreOrdemEquilibrado() {
		avl.insere(15);
		avl.insere(6);
		avl.remove(15);
		assertEquals("6(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remoção equilibrado raiz quando possui sucessor")
	void remocao_naRaizQuandoPossuiSucessor_deveRetornarPreORdemEquilibrado() {
		avl.insere(15);
		avl.insere(18);
		avl.remove(15);
		assertEquals("18(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remoção equilibrado na raiz quando sucesso possui filho")
	void remocao_naRaizQuandoSucessorTemFilho() {
		avl.insere(15);
		avl.insere(7);
		avl.insere(18);
		avl.insere(1);
		avl.insere(9);
		avl.insere(16);
		avl.insere(22);
		avl.insere(8);
		avl.insere(14);
		avl.insere(17);
		avl.remove(15);
		assertEquals("16(1)7(-1)1(0)9(0)8(0)14(0)18(0)17(0)22(0)", avl.preOrdem());
	}
	*/
}
