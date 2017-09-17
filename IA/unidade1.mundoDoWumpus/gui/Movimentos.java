package gui;

import javax.swing.JOptionPane;

public class Movimentos {

	public void pegarOuro(){
		Agente agente = TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].getAgente();
		if(TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].isOuro()){
			TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setOuro(false);
			agente.getPontuacao().setPegouOuro();
			agente.setOuro(true);
			TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(agente);
		}
	}
	
	public void atirarFlecha(){
		Agente agente = TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].getAgente();
		agente.getPontuacao().setAtirouFlecha();
		if(agente.isFlecha()){
			agente.setFlecha(false);
			TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(agente);
			
			if(agente.getDirecao().isDireita()){
				for(int i = TelaInicial.y_atual; i < 4; i++){
					if(TelaInicial.matriz[TelaInicial.x_atual][i].isWumpus()){
						this.matouWumpus(TelaInicial.x_atual, i, agente);
						break;
					}
				}
			}else if(agente.getDirecao().isEsquerda()){
				for(int i = TelaInicial.y_atual; i >= 0; i--){
					if(TelaInicial.matriz[TelaInicial.x_atual][i].isWumpus()){
						this.matouWumpus(TelaInicial.x_atual, i, agente);
						break;
					}
				}
			}else if(agente.getDirecao().isCima()){
				for(int i = TelaInicial.x_atual; i < 4; i++){
					if(TelaInicial.matriz[i][TelaInicial.y_atual].isWumpus()){
						this.matouWumpus(i, TelaInicial.y_atual, agente);
						break;
					}
				}
			}else if(agente.getDirecao().isBaixo()){
				for(int i = TelaInicial.x_atual; i >= 0; i--){
					if(TelaInicial.matriz[i][TelaInicial.y_atual].isWumpus()){
						this.matouWumpus(i, TelaInicial.y_atual, agente);
						break;
					}
				}
			}
		}
	}
	
	private void matouWumpus(int x, int y, Agente agente){
		JOptionPane.showMessageDialog(null, "Você matou o Wumpus");
		TelaInicial.matriz[x][y].setWumpus(false);
		TelaInicial.matriz[x][y].setWumpusDead(true);
		agente.setWumpusDead(true);
	}
	
	public void subirEscada(){
		Agente agente = TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].getAgente();
		if(agente.isWumpusDead() && agente.isOuro() && TelaInicial.x_atual==0 && TelaInicial.y_atual==0){
			agente.setSubirEscada(true);
			TelaInicial.matriz[0][0].setAgente(null);
		}
		JOptionPane.showMessageDialog(null, agente.getPontuacao().mostrarPontuacao());
	}
	
	public void mover(){
		Agente agente = TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].getAgente();
		agente.getPontuacao().setMovimento();
		if(agente.getDirecao().isDireita()){
			try{
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(null);
				TelaInicial.y_atual++;
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(agente);
			}catch(ArrayIndexOutOfBoundsException e){
				TelaInicial.y_atual--;
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(agente);
				JOptionPane.showMessageDialog(null, "Bateu na parede!");
			}
		}else if(agente.getDirecao().isEsquerda()){
			try{
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(null);
				TelaInicial.y_atual--;
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(agente);
			}catch(ArrayIndexOutOfBoundsException e){
				TelaInicial.y_atual++;
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(agente);
				JOptionPane.showMessageDialog(null, "Bateu na parede!");
			}
		}else if(agente.getDirecao().isCima()){
			try{
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(null);
				TelaInicial.x_atual++;
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(agente);
			}catch(ArrayIndexOutOfBoundsException e){
				TelaInicial.x_atual--;
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(agente);
				JOptionPane.showMessageDialog(null, "Bateu na parede!");
			}
		}else if(agente.getDirecao().isBaixo()){
			try{
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(null);
				TelaInicial.x_atual--;
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(agente);
			}catch(ArrayIndexOutOfBoundsException e){
				TelaInicial.x_atual++;
				TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(agente);
				JOptionPane.showMessageDialog(null, "Bateu na parede!");
			}
		}
		
		if(TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].isWumpusDead()){
			JOptionPane.showMessageDialog(null, "Você esbarrou no Wumpus morto!");
		}
	}
	
	public void girar(String sentido){
		Direcao direcao = null;
		Agente agente = TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].getAgente();
		agente.getPontuacao().setMovimento();
		if(agente.getDirecao().isDireita()){
			direcao = new Direcao();
			if(sentido.equals("horario")){
				direcao.setBaixo(true);
			}else{
				direcao.setCima(true);
			}
			
		}else if(agente.getDirecao().isEsquerda()){
			direcao = new Direcao();
			
			if(sentido.equals("horario")){
				direcao.setCima(true);
			}else{
				direcao.setBaixo(true);
			}
			
		}else if(agente.getDirecao().isBaixo()){
			direcao = new Direcao();
			if(sentido.equals("horario")){
				direcao.setEsquerda(true);
			}else{
				direcao.setDireita(true);
			}
			
		}else if(agente.getDirecao().isCima()){
			direcao = new Direcao();
			if(sentido.equals("horario")){
				direcao.setDireita(true);
			}else{
				direcao.setEsquerda(true);
			}
		}
		
		agente.setDirecao(direcao);
		TelaInicial.matriz[TelaInicial.x_atual][TelaInicial.y_atual].setAgente(agente);
	}
}
