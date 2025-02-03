package avl;

public class No {

	private int info;
	private int fb;
	private No esquerda;
	private No direita;
	
	public No(int info) {
		this.info = info;
		this.fb = 0;
		this.esquerda = null;
		this.direita = null;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public int getFb() {
		return fb;
	}

	public void setFb(int fb) {
		this.fb = fb;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}
	
}
