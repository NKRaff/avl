package avl;

public class AVL {

	private No raiz;
	
	public AVL() {
		this.raiz = null;
	}
	
	public AVL(int info) {
		this.raiz = new No(info);
	}
	
	public String preOrdem() {
		return this.preOrdem(this.raiz, "");
	}
	
	private String preOrdem(No subArvore, String ordem) {
		if(subArvore == null)
			return ordem;
		ordem += subArvore.getInfo() + "(" + subArvore.getFb() + ")";
		ordem = this.preOrdem(subArvore.getEsquerda(), ordem);
		ordem = this.preOrdem(subArvore.getDireita(), ordem);
		return ordem;
	}
	
	public void insere(int info) {
		if(this.raiz == null) {
			this.raiz = new No(info);
			return;
		}
		this.insere(this.raiz, info);
	}
	
	private void insere(No subArvore, int info) {
		if(info <= subArvore.getInfo()) {
			if(subArvore.getEsquerda() == null)
				subArvore.setEsquerda(new No(info));
			else
				this.insere(subArvore.getEsquerda(), info);
		} else
			if(subArvore.getDireita() == null)
				subArvore.setDireita(new No(info));
			else
				this.insere(subArvore.getDireita(), info);
		this.balancear();
	}
	
	public void remove(int info) {
		this.remove(this.raiz, null, info);
	}
	
	private void remove(No subArvore, No pai, int info) {
		if(subArvore == null)
			return;
		else if(subArvore.getInfo() == info) {
			if(pai == null) {
				if(subArvore.getEsquerda() != null && subArvore.getDireita() != null) {
					No sucessor = this.sucessor(this.raiz, info, null);
					if(sucessor != null) {
						No paiDoSucessor = this.getPai(this.raiz, sucessor);
						if(paiDoSucessor.getEsquerda() != this.raiz)
							paiDoSucessor.setEsquerda(sucessor.getDireita());
						sucessor.setEsquerda(this.raiz.getEsquerda());
						sucessor.setDireita(this.raiz.getDireita());
						this.raiz = sucessor;
					} else
						this.raiz = this.raiz.getEsquerda();
				} else {
					if(this.raiz.getEsquerda() != null)
						this.raiz = this.raiz.getEsquerda();
					else
						this.raiz = this.raiz.getDireita();
				}
			} else {
				if(subArvore.getEsquerda() != null && subArvore.getDireita() != null) {
					No sucessor = this.sucessor(subArvore, info, null);
					No paiDoSucessor = this.getPai(this.raiz, sucessor);
					paiDoSucessor.setEsquerda(sucessor.getDireita());
					if(pai.getEsquerda() == subArvore)
						pai.setEsquerda(sucessor);
					else
						pai.setDireita(sucessor);
					sucessor.setEsquerda(subArvore.getEsquerda());
					sucessor.setDireita(subArvore.getDireita());
					
				} else {
					if(pai.getEsquerda() == subArvore) {
						if(subArvore.getEsquerda() != null)
							pai.setEsquerda(subArvore.getEsquerda());
						else
							pai.setEsquerda(subArvore.getDireita());
					} else {
						if(subArvore.getEsquerda() != null)
							pai.setDireita(subArvore.getEsquerda());
						else
							pai.setDireita(subArvore.getDireita());
					}
				}
			}
			this.balancear();
		} else {
			if(info <= subArvore.getInfo())
				this.remove(subArvore.getEsquerda(), subArvore, info);
			else
				this.remove(subArvore.getDireita(), subArvore, info);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	private void remove(No subArvore, No pai, int info) {
		if(subArvore == null)
			return;
		else if(subArvore.getInfo() == info) {
			if(pai == null) {
				if(this.raiz.getEsquerda() == null && subArvore.getDireita() == null)
					this.raiz = null;
				else if(this.raiz.getEsquerda() != null && subArvore.getDireita() != null) {
					No sucessor = this.sucessor(subArvore, info, null);
					subArvore.getDireita().setEsquerda(sucessor.getDireita());
					this.raiz = sucessor;
					sucessor.setEsquerda(subArvore.getEsquerda());
					sucessor.setDireita(subArvore.getDireita());
				}
			} else {
				// SE FOR REMOVER QUALQUER OUTRO
				if(subArvore.getEsquerda() == null && subArvore.getDireita() == null) {
					// SE NÃO TIVER FILHOS
					if(pai.getEsquerda() == subArvore) {
						pai.setEsquerda(null);
					} else {
						pai.setDireita(null);
					}
				} else if(subArvore.getEsquerda() != null && subArvore.getDireita() != null) {
					// SE TIVER 2 FILHOS
					No sucessor = this.sucessor(subArvore, info, null);
					subArvore.getDireita().setEsquerda(sucessor.getDireita());
					if(pai.getEsquerda() == subArvore)
						pai.setEsquerda(sucessor);
					else
						pai.setDireita(sucessor);
					sucessor.setEsquerda(subArvore.getEsquerda());
					sucessor.setDireita(subArvore.getDireita());
				} else {
					// SE TIVER 1 FILHO
					if(pai.getEsquerda() == subArvore) {
						if(subArvore.getEsquerda() != null)
							pai.setEsquerda(subArvore.getEsquerda());
						else
							pai.setEsquerda(subArvore.getDireita());
					} else {
						if(subArvore.getEsquerda() != null)
							pai.setDireita(subArvore.getEsquerda());
						else
							pai.setDireita(subArvore.getDireita());
					}
				}
			}
		} else {
			if(info <= subArvore.getInfo())
				this.remove(subArvore.getEsquerda(), subArvore, info);
			else
				this.remove(subArvore.getDireita(), subArvore, info);
		}
	}
	 */
	
	// SO É POSSIVEL ACHO O NO CRITICO APOS ATUALIZAR FB
	// SO É POSSIVEL ACHO O PAI DO CRITICO SE ACHAR O CRITICO
	// SO É POSSIVEL ATUALIZAR SE TIVER O PAI DO CRITICO
	/*
	TIPO DE ROTAÇÕES
	 * 		ROTAÇÃO A ESQUERDA -> QUANDO DESBALANCEADO PARA A DIREITA
	 * 			-> DUPLA -> QUANDO FILHO A DIREITA DO CRITICO TIVER UM FB (POSITIVO)
	 * 		ROTAÇÃO A DIREITA -> QUANDO DESBALANCEADO PARA A ESQUERDA
	 * 			-> DUPLA -> QUANDO FILHO A ESQUERDA DO CRITICO TIVER UM FB (NEGATIVO)
	*/
	private void balancear() {
		this.atualizarFB(this.raiz);
		No noCritico = this.getNoCritico(this.raiz, null);
		
		while(noCritico != null) {
			No paiDoNoCritico = this.getPai(this.raiz, noCritico);
			if(noCritico.getFb() > 0) { // DESBALANCEADO PARA ESQUERDA
				// ROTAÇÃO DIREITA
				if(noCritico.getEsquerda().getFb() < 0) // ROTAÇÃO DUPLA DIREITA
					this.rotacaoEsquerda(noCritico.getEsquerda(), noCritico);
				this.rotacaoDireita(noCritico, paiDoNoCritico);
			} else { // DESBALANCEADO PARA DIREITA
				// ROTAÇÃO ESQUERDA
				if(noCritico.getDireita().getFb() > 0) // ROTAÇÃO DUPLA ESQUERDA
					this.rotacaoDireita(noCritico.getDireita(), noCritico);
				this.rotacaoEsquerda(noCritico, paiDoNoCritico);
			}
			this.atualizarFB(this.raiz);
			noCritico = this.getNoCritico(this.raiz, null);
		}
		
	}
	
	private void rotacaoEsquerda(No noCritico, No paiDoNoCritico) {
		No filho = noCritico.getDireita().getEsquerda();
		if(paiDoNoCritico == null) { // ROTAÇÃO NA RAIZ
			this.raiz = noCritico.getDireita();
			this.raiz.setEsquerda(noCritico);
		} else { // ROTAÇÃO NO MEIO
			if(paiDoNoCritico.getEsquerda() == noCritico) { // CRITICO A ESQUERDA DO PAI
				paiDoNoCritico.setEsquerda(noCritico.getDireita());
				paiDoNoCritico.getEsquerda().setEsquerda(noCritico);
			} else { // CRITICO A DIREITA DO PAI
				paiDoNoCritico.setDireita(noCritico.getDireita());
				paiDoNoCritico.getDireita().setEsquerda(noCritico);
			}			
		}
		noCritico.setDireita(filho);
	}
	
	private void rotacaoDireita(No noCritico, No paiDoNoCritico) {
		No filho = noCritico.getEsquerda().getDireita();
		if(paiDoNoCritico == null) { // ROTAÇÃO NA RAIZ
			this.raiz = noCritico.getEsquerda();
			this.raiz.setDireita(noCritico);
		} else { // ROTAÇÃO NO MEIO
			if(paiDoNoCritico.getEsquerda() == noCritico) { // CRITICO A ESQUERDA DO PAI
				paiDoNoCritico.setEsquerda(noCritico.getEsquerda());
				paiDoNoCritico.getEsquerda().setDireita(noCritico);
			} else { // CRITICO A DIREITA DO PAI
				paiDoNoCritico.setDireita(noCritico.getEsquerda());
				paiDoNoCritico.getDireita().setDireita(noCritico);
			}
		}
		noCritico.setEsquerda(filho);
	}
		
	private No getNoCritico(No subArvore, No noCritico) {
		if(subArvore == null)
			return noCritico;
		else if(subArvore.getFb() > 1 || subArvore.getFb() < -1)
			noCritico = subArvore;
		noCritico = this.getNoCritico(subArvore.getEsquerda(), noCritico);
		noCritico = this.getNoCritico(subArvore.getDireita(), noCritico);
		return noCritico;
	}
	
	private No getPai(No subArvore, No noFilho) {
		if(subArvore == null || noFilho == this.raiz)
			return null;
		if(noFilho.getInfo() <= subArvore.getInfo()) {
			if(subArvore.getEsquerda() == noFilho)
				return subArvore;
			return this.getPai(subArvore.getEsquerda(), noFilho);
		} else {
			if(subArvore.getDireita() == noFilho)
				return subArvore;
			return this.getPai(subArvore.getDireita(), noFilho);
		}
	}
	
	private void atualizarFB(No subArvore) {
		if(subArvore == null)
			return;
		int fb = this.tamanho(subArvore.getEsquerda()) - this.tamanho(subArvore.getDireita());
		subArvore.setFb(fb);
		this.atualizarFB(subArvore.getEsquerda());
		this.atualizarFB(subArvore.getDireita());
	}
	
	private int tamanho(No subArvore) {
		if(subArvore == null)
			return -1;
		int esquerda = this.tamanho(subArvore.getEsquerda());
		int direita = this.tamanho(subArvore.getDireita());
		return (esquerda > direita) ? ++esquerda : ++direita;
	}
	
	private No sucessor(No subArvore, int info, No sucessor) {
		if(subArvore == null)
			return null;
		else if(subArvore.getInfo() == info) {
			if(subArvore.getDireita() == null)
				return sucessor;
			return this.minimo(subArvore.getDireita());
		}
		sucessor = (subArvore.getInfo() > info) ? subArvore : sucessor;
		if(info <= subArvore.getInfo())
			return this.sucessor(subArvore.getEsquerda(), info, sucessor);
		return this.sucessor(subArvore.getDireita(), info, sucessor);
	}
	
	private No minimo(No subArvore) {
		if(subArvore.getEsquerda() == null)
			return subArvore;
		return this.minimo(subArvore.getEsquerda());
	}
	
	/* 	QUAL LADO O DA ROTAÇÃO?
	 * 		SE DESBALANCEADA PARA ESQUERDA (FB POSITIVO) -> ROTAÇÃO A DIREITA
	 * 		SE DESBALANCEADA PARA DIREITA (FB NEGATIVO) -> ROTAÇÃO A ESQUERDA
	 * 
	 * 	TIPO DE ROTAÇÕES
	 * 		ROTAÇÃO A ESQUERDA -> QUANDO DESBALANCEADO PARA A DIREITA
	 * 			-> DUPLA -> QUANDO FILHO A DIREITA DO CRITICO TIVER UM FB (POSITIVO)
	 * 		ROTAÇÃO A DIREITA -> QUANDO DESBALANCEADO PARA A ESQUERDA
	 * 			-> DUPLA -> QUANDO FILHO A ESQUERDA DO CRITICO TIVER UM FB (NEGATIVO)
	 * 			
	 * 
	 * 	ROTAÇÃO SIMPLES ESQUERDA-> 
	 * 		-> 1º ARMAZENA FILHO ESQUERDO DO FILHO DIREITO DO CRITICO (mesmo se for null)
	 * 		-> NA RAIZ
	 * 			-> 2º RAIZ APONTA PARA FILHO DIREITO DO CRITICO
	 * 			-> 3º O FILHO ESQUERDO DO NOVO FILHO DA RAIZ SE TORNA O CRITICO
	 * 		-> NO MEIO DA ARVORE
	 * 			-> 2º PAI DO CRITICO APONTA PARA FILHO DIREITO DO CRITICO
	 * 			-> 3º O FILHO ESQUERDO DO NOVO FILHO DO PAI DO CRITICO SE TORNA O CRITICO
	 * 		-> 4º FILHO ARMAZENADO SE TORNA O NOVO FILHO A DIREITA DO CRITICO
	 * 	ROTAÇÃO SIMPLES DIREITA ->
	 * 		-> 1º ARMAZENA FILHO DIREITO DO FILHO ESQUERDO DO CRITICO (mesmo se for null)
	 * 		-> 2º PAI DO CRITICO APONTA PARA FILHO ESQUERDO DO CRITICO
	 * 		-> 3º O FILHO DIREITO DO NOVO FILHO DO PAI DO CRITICO SE TORNA O CRITICO
	 * 		-> 4º FILHO ARMAZENADO SE TORNA O NOVO FILHO A ESQUERDO DO CRITICO
	 * 	ROTAÇÃO DUPLA ESQUERDA 	-> 
	 * 		-> 1º ROTAÇÃO SIMPLES PARA DIREITA
	 * 		-> 2º ROTAÇÃO SIMPLES PARA ESQUERDA
	 * 	ROTAÇÃO DUPLA DIREITA 	->
	 * 		-> 1º ROTAÇÃO SIMPLES PARA ESQUERDA
	 * 		-> 2º ROTAÇÃO SIMPLES PARA DIREITA
	 * 
	 * */
	
}
