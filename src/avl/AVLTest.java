package avl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AVLTest {

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
		assertEquals("18(0)6(0)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remover nó qualquer quando não possui filhos")
	void remocao_quandoNaoPossuiFilhos_deveRemoverNo() {
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
	@DisplayName("Remover nó qualquer quando não possui sucessor")
	void remocao_quandoNaoPossuiSucessor_deveRemoverNo() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(9);
		avl.insere(16);
		avl.insere(22);
		avl.insere(7);
		avl.insere(14);
		avl.remove(22);
		assertEquals("15(1)6(-1)1(0)9(0)7(0)14(0)18(1)16(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remover nó qualquer quando possui filho a esquerda")
	void remocao_quandoPossuiFilhoAEsquerda_deveRemoverNo() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(9);
		avl.insere(16);
		avl.insere(22);
		avl.insere(7);
		avl.insere(17);
		avl.remove(9);
		assertEquals("15(-1)6(0)1(0)7(0)18(1)16(-1)17(0)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remover nó qualquer quando possui filho a direita")
	void remocao_quandoPossuiFilhoADireita_deveRemoverNo() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(9);
		avl.insere(16);
		avl.insere(22);
		avl.insere(7);
		avl.insere(14);
		avl.insere(17);
		avl.remove(16);
		assertEquals("15(1)6(-1)1(0)9(0)7(0)14(0)18(0)17(0)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Remover nó qualquer quando possui dois filhos")
	void remocao_quandoPossuiDoisFilhos_deveRemoverNo() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(9);
		avl.insere(16);
		avl.insere(22);
		avl.insere(7);
		avl.insere(14);
		avl.insere(17);
		avl.remove(9);
		assertEquals("15(0)6(-1)1(0)14(1)7(0)18(1)16(-1)17(0)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação simples a esquerda na raiz quando inserir")
	void rotacaoNaInsercao_quandoNecessarioRotacaoSimplesAEsquerdaNaRaiz_deveTornarAVL() {
		avl.insere(18);
		avl.insere(22);
		assertEquals("18(0)15(0)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação simples a direita na raiz quando inserir")
	void rotacaoNaInsercao_quandoNecessarioRotacaoSimplesADireitaNaRaiz_deveTornarAVL() {
		avl.insere(6);
		avl.insere(1);
		assertEquals("6(0)1(0)15(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação dupla a esquerda na raiz quando inserir")
	void rotacaoNaInsercao_quandoNecessarioRotacaoDuplaAEsquerdaNaRaiz_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(16);
		avl.insere(22);
		avl.insere(16);
		assertEquals("16(0)15(0)6(0)16(0)18(-1)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação dupla a direita na raiz quando inserir")
	void rotacaoNaInsercao_quandoNecessarioRotacaoDuplaADireitaNaRaiz_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(9);
		avl.insere(7);
		assertEquals("9(0)6(0)1(0)7(0)15(-1)18(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação simples a esquerda quando inserir")
	void rotacaoNaInsercao_quandoNecessarioRotacaoSimplesAEsquerda_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(22);
		avl.insere(30);
		assertEquals("15(-1)6(0)22(0)18(0)30(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação simples a direita quando inserir")
	void rotacaoNaInsercao_quandoNecessarioRotacaoSimplesADireita_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(0);
		assertEquals("15(1)1(0)0(0)6(0)18(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação dupla a esquerda quando inserir")
	void rotacaoNaInsercao_quandoNecessarioRotacaoDuplaAEsquerda_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(22);
		avl.insere(20);
		assertEquals("15(-1)6(0)20(0)18(0)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação dupla a direita quando inserir")
	void rotacaoNaInsercao_quandoNecessarioRotacaoDuplaADireita_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(3);
		assertEquals("15(1)3(0)1(0)6(0)18(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação simples a esquerda na raiz quando remover")
	void rotacaoNaRemocao_quandoNecessarioRotacaoSimplesAEsquerdaNaRaiz_deveTornarAVL() {
		avl.insere(18);
		avl.insere(6);
		avl.insere(22);
		avl.remove(6);
		assertEquals("18(0)15(0)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação simples a direita na raiz quando remover")
	void rotacaoNaRemocao_quandoNecessarioRotacaoSimplesADireitaNaRaiz_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.remove(18);
		assertEquals("6(0)1(0)15(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação dupla a esquerda na raiz quando remover")
	void rotacaoNaRemocao_quandoNecessarioRotacaoDuplaAEsquerdaNaRaiz_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(16);
		avl.insere(22);
		avl.insere(16);
		avl.remove(1);
		assertEquals("16(0)15(0)6(0)16(0)18(-1)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação dupla a direita na raiz quando remover")
	void rotacaoNaRemocao_quandoNecessarioRotacaoDuplaADireitaNaRaiz_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(16);
		avl.insere(1);
		avl.insere(9);
		avl.insere(7);
		avl.remove(16);
		assertEquals("9(0)6(0)1(0)7(0)15(-1)18(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação simples a esquerda quando remover")
	void rotacao_quandoNecessarioRotacaoSimplesAEsquerdaNaRaiz_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(22);
		avl.insere(30);
		avl.remove(1);
		assertEquals("15(-1)6(0)22(0)18(0)30(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação simples a direita quando remover")
	void rotacao_quandoNecessarioRotacaoSimplesADireitaNaRaiz_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(20);
		avl.insere(1);
		avl.insere(0);
		avl.remove(20);
		assertEquals("15(1)1(0)0(0)6(0)18(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação dupla a esquerda quando remover")
	void rotacao_quandoNecessarioRotacaoDuplaAEsquerdaNaRaiz_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(1);
		avl.insere(22);
		avl.insere(20);
		avl.remove(1);
		assertEquals("15(-1)6(0)20(0)18(0)22(0)", avl.preOrdem());
	}
	
	@Test
	@DisplayName("Rotação dupla a direita quando remover")
	void rotacao_quandoNecessarioRotacaoDuplaADireitaNaRaiz_deveTornarAVL() {
		avl.insere(6);
		avl.insere(18);
		avl.insere(9);
		avl.insere(1);
		avl.insere(22);
		avl.insere(3);
		avl.remove(9);
		assertEquals("15(0)3(0)1(0)6(0)18(-1)22(0)", avl.preOrdem());
	}
	
}
