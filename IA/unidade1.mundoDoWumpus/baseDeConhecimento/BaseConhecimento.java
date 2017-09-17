package baseDeConhecimento;

import java.util.ArrayList;
import java.util.List;

public class BaseConhecimento {
	private Sensores sensores;
	private List<Pontos> caminhoOk, wumpus, poco;
	
	public BaseConhecimento() {
		this.caminhoOk = new ArrayList<>();
		this.wumpus = new ArrayList<>();
		this.poco = new ArrayList<>();
	}
	
	public void addCaminho(Pontos ponto){
		this.caminhoOk.add(ponto);
	}
	
	public void removerOk(Pontos ponto){
		for (Pontos pontos : caminhoOk) {
			if(pontos.equals(ponto)){
				this.caminhoOk.remove(pontos);
				System.out.println("removeu wumpus x " + pontos.getX() + " y " + pontos.getY());
			}
				
		}
	}
	
	public void removerWumpus(Pontos ponto){
		for (Pontos pontos : wumpus) {
			if(pontos.equals(ponto)){
				this.wumpus.remove(pontos);
				System.out.println("removeu wumpus x " + pontos.getX() + " y " + pontos.getY());
			}
				
		}
	}

	public void removerPoco(Pontos ponto){
		for (Pontos pontos : poco) {
			if(pontos.equals(ponto)){
				this.poco.remove(pontos);
				System.out.println("removeu wumpus x " + pontos.getX() + " y " + pontos.getY());
			}
				
		}
	}
	
	public Sensores getSensores() {
		return sensores;
	}
	public void setSensores(Sensores sensores) {
		this.sensores = sensores;
	}
	public List<Pontos> getCaminhoOk() {
		return caminhoOk;
	}
	public void setCaminhoOk(int x, int y) {
		System.out.println("Adicionou caminho x " + x + " y " + y);
		this.caminhoOk.add(new Pontos(x, y));
	}
	public List<Pontos> getWumpus() {
		return wumpus;
	}
	public void setWumpus(int x, int y) {
		System.out.println("Adicionou Wumpus x " + x + " y " + y);
		this.wumpus.add(new Pontos(x, y));
	}
	public List<Pontos> getPoco() {
		return poco;
	}
	public void setPoco(int x, int y) {
		System.out.println("Adicionou poço x " + x + " y " + y);
		this.poco.add(new Pontos(x, y));
	}
}
