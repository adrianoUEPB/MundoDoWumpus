package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LabelCelula extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean brisa = false;
	private boolean fedor = false;
	private boolean ouro = false;
	private boolean poco = false;
	private boolean wumpus = false;
	private boolean wumpusDead = false;
	private Agente agente;
	
	public LabelCelula() {
	}
	
	public boolean isBrisa() {
		return brisa;
	}
	public void setBrisa(boolean brisa) {
		this.brisa = brisa;
	}
	public boolean isFedor() {
		return fedor;
	}
	public void setFedor(boolean fedor) {
		this.fedor = fedor;
	}
	public boolean isOuro() {
		return ouro;
	}
	public void setOuro(boolean ouro) {
		this.ouro = ouro;
	}
	public boolean isPoco() {
		return poco;
	}
	public void setPoco(boolean poco) {
		this.poco = poco;
	}
	public boolean isWumpus() {
		return wumpus;
	}
	public void setWumpus(boolean wumpus) {
		this.wumpus = wumpus;
	}
	public boolean isWumpusDead() {
		return wumpusDead;
	}

	public void setWumpusDead(boolean wumpusDead) {
		this.wumpusDead = wumpusDead;
	}

	public Agente getAgente() {
		return agente;
	}
	public void setAgente(Agente agente) {
		String flecha = null, direcao = null;
		
		if(agente != null){
			if(this.isWumpus()){
				setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/wumpus-icon.png")));
				agente.getPontuacao().setMorreu();
				agente = null;
				JOptionPane.showMessageDialog(null, "Você foi comido pelo Wumpus, perdeu o jogo!");
				
			}else if(this.isPoco()){
				setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/poco-icon.png")));
				agente.getPontuacao().setMorreu();
				agente = null;
				JOptionPane.showMessageDialog(null, "Você caiu no poço, perdeu o jogo!");
			}else{
				if(agente.isFlecha()){
					flecha = "flecha";
				}else{
					flecha = "sem-flecha";
				}
				
				if(agente.getDirecao().isDireita()){
					direcao = "direita";
				}else if(agente.getDirecao().isEsquerda()){
					direcao = "esquerda";
				}else if(agente.getDirecao().isBaixo()){
					direcao = "baixo";
				}else if(agente.getDirecao().isCima()){
					direcao = "cima";
				}
				
				if(this.isOuro() && this.isBrisa() && this.isFedor()){
					setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/agente-"+ flecha +"/agente-"+ direcao +"-fedor-brisa-ouro.png")));
				}else if(this.isOuro() && this.isBrisa()){
					setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/agente-"+ flecha +"/agente-"+ direcao +"-brisa-ouro.png")));
				}else if(this.isOuro() && this.fedor){
					setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/agente-"+ flecha +"/agente-"+ direcao +"-fedor-ouro.png")));
				}else if(this.isBrisa() && this.fedor){
					setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/agente-"+ flecha +"/agente-"+ direcao +"-fedor-brisa.png")));
				}else if(this.isBrisa()){
					setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/agente-"+ flecha +"/agente-"+ direcao +"-brisa.png")));
				}else if(this.isFedor()){
					setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/agente-"+ flecha +"/agente-"+ direcao +"-fedor.png")));
				}else if(this.isOuro()){
					setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/agente-"+ flecha +"/agente-"+ direcao +"-ouro.png")));
				}else{
					setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/agente-"+ flecha +"/agente-"+ direcao +".png")));
				}
			}

		}else{
			if(this.isOuro() && this.isBrisa() && this.isFedor()){
				setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/fedor-brisa-gold-icon.png")));
			}else if(this.isOuro() && this.isBrisa()){
				setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/brisa-gold-icon.png")));
			}else if(this.isOuro() && this.fedor){
				setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/fedor-gold-icon.png")));
			}else if(this.isBrisa() && this.fedor){
				setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/fedor-brisa-icon-pequeno.png")));
			}else if(this.isBrisa()){
				setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/brisa-icon-pequeno.png")));
			}else if(this.isFedor()){
				setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/fedor-icon-pequeno.png")));
			}else if(this.isOuro()){
				setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/gold-icon-pequeno.png")));
			}else{
				setIcon(new ImageIcon());
			}
		}

		this.agente = agente;
	}

//	public Direcao getDirecao() {
//		return direcao;
//	}
//
//	public void setDirecao(Direcao direcao) {
//		this.direcao = direcao;
//		this.setAgente(true);
//	}
	
	
	
}
