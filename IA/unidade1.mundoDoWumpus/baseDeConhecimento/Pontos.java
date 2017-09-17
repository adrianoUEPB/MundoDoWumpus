package baseDeConhecimento;

public class Pontos {
	private int x;
	private int y;
	private boolean visitado;

	public Pontos(int x, int y) {
		this.x = x;
		this.y = y;
		this.visitado = true;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public boolean compareTo(Pontos outro) {
		if(this.getX()==outro.getX() && this.getY()==outro.getY())
			return true;
		
		return false;
	}
}
