package baseDeConhecimento;

public class Sensores {
	private boolean brisa, fedor, brilho, poco, wumpus;

	public Sensores() {
		this.brisa = false;
		this.fedor = false;
		this.brilho = false;
		this.poco = false;
		this.wumpus = false;
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

	public boolean isbrilho() {
		return brilho;
	}

	public void setbrilho(boolean brilho) {
		this.brilho = brilho;
	}

	public boolean isBrilho() {
		return brilho;
	}

	public void setBrilho(boolean brilho) {
		this.brilho = brilho;
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
}
