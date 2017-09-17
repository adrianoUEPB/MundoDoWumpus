package gui;

public class Pontuacao {
	private int movimento;
	private int atirouFlecha;
	private int morreu;
	private int pegouOuro;
	
	public Pontuacao() {
		this.movimento = 0;
		this.atirouFlecha = 0;
		this.morreu = 0;
		this.pegouOuro = 0;
	}
	
	public String mostrarPontuacao(){
		StringBuilder str = new StringBuilder();
		
		str.append("-1 por movimento: " + this.getMovimento());
		str.append("\n-1000 por cair no poço ou ser comido pelo Wumpus: " + this.getMorreu());
		str.append("\n-10 por atirar a flecha: " + this.getAtirouFlecha());
		str.append("\n+1000 por pegar o ouro: " + this.getPegouOuro());
		str.append("\nPontuação: " + (this.getMovimento() + this.getAtirouFlecha() + this.getMorreu() + this.getPegouOuro()));
		
		return str.toString();
	}
	
	public int getMovimento() {
		return movimento;
	}
	public void setMovimento() {
		this.movimento--;;
	}
	public int getAtirouFlecha() {
		return atirouFlecha;
	}
	public void setAtirouFlecha() {
		this.atirouFlecha -= 10;
	}
	public int getMorreu() {
		return morreu;
	}
	public void setMorreu() {
		this.morreu -= 1000;
	}
	public int getPegouOuro() {
		return pegouOuro;
	}
	public void setPegouOuro() {
		this.pegouOuro += 1000;
	}
	
	
}
