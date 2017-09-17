package gui;

/**
 * A classe irá direcionar o agente
 * @author adriano
 *
 */

public class Direcao {
	private boolean cima = false;
	private boolean baixo = false;
	private boolean esquerda = false;
	private boolean direita = false;
	public boolean isCima() {
		return cima;
	}
	public void setCima(boolean cima) {
		this.cima = cima;
	}
	public boolean isBaixo() {
		return baixo;
	}
	public void setBaixo(boolean baixo) {
		this.baixo = baixo;
	}
	public boolean isEsquerda() {
		return esquerda;
	}
	public void setEsquerda(boolean esquerda) {
		this.esquerda = esquerda;
	}
	public boolean isDireita() {
		return direita;
	}
	public void setDireita(boolean direita) {
		this.direita = direita;
	}
}
