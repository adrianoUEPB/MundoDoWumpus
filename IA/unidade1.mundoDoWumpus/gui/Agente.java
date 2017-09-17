package gui;

import baseDeConhecimento.BaseConhecimento;
import baseDeConhecimento.Pontos;

public class Agente {
	private Direcao direcao;
	private boolean flecha;
	private boolean ouro;
	private boolean wumpusDead;
	private boolean subirEscada;
	private Movimentos movimentos;
	private Pontuacao pontuacao;
	private BaseConhecimento base;
	
	public Agente() {
		this.direcao = new Direcao();
		this.movimentos = new Movimentos();
		this.pontuacao = new Pontuacao();
		this.direcao.setDireita(true);
		this.flecha = true;
		this.ouro = false;
		this.wumpusDead = false;
		this.subirEscada = false;
		if(base == null) this.base = new BaseConhecimento();
	}
	
	public void iniciarIa(){
		
		for(int i = 0; i < 4; i++){
			try {
				
				this.checarAmbiente();
				Thread.sleep(0);
				this.movimentos();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void movimentos(){
		
		int x = TelaInicial.x_atual;
		int y = TelaInicial.y_atual;

		for (Pontos ponto : this.base.getCaminhoOk()) {
			
			if(ponto.compareTo(new Pontos(x, y+1))){
				System.out.println("entrou na direita");
				if(this.getDirecao().isDireita()){
					this.movimentos.mover();					
				}else if(this.getDirecao().isBaixo()){
					this.movimentos.girar("anti-horario");
					this.movimentos.mover();
				}else if(this.getDirecao().isCima()){
					this.movimentos.girar("horario");
					this.movimentos.mover();
				}else if(this.getDirecao().isEsquerda()){
					this.movimentos.girar("horario");
					this.movimentos.girar("horario");
					this.movimentos.mover();
				}
				
				break;
				
			}else if(ponto.compareTo(new Pontos(x+1, y))){
				System.out.println("entrou pra cima");
				if(this.getDirecao().isCima()){
					this.movimentos.mover();					
				}else if(this.getDirecao().isDireita()){
					this.movimentos.girar("anti-horario");
					this.movimentos.mover();
				}else if(this.getDirecao().isEsquerda()){
					this.movimentos.girar("horario");
					this.movimentos.mover();
				}else if(this.getDirecao().isBaixo()){
					this.movimentos.girar("horario");
					this.movimentos.girar("horario");
					this.movimentos.mover();
				}
				break;
			}else if(ponto.compareTo(new Pontos(x-1, y))){
				System.out.println("entrou pra baixo");
				if(this.getDirecao().isBaixo()){
					this.movimentos.mover();					
				}else if(this.getDirecao().isDireita()){
					this.movimentos.girar("horario");
					this.movimentos.mover();
				}else if(this.getDirecao().isEsquerda()){
					this.movimentos.girar("anti-horario");
					this.movimentos.mover();
				}else if(this.getDirecao().isCima()){
					this.movimentos.girar("horario");
					this.movimentos.girar("horario");
					this.movimentos.mover();
				}
				break;
			}else if(ponto.compareTo(new Pontos(x, y-1))){
				System.out.println("entrou pra esquerda");
				if(this.getDirecao().isEsquerda()){
					this.movimentos.mover();					
				}else if(this.getDirecao().isCima()){
					this.movimentos.girar("anti-horario");
					this.movimentos.mover();
				}else if(this.getDirecao().isBaixo()){
					this.movimentos.girar("horario");
					this.movimentos.mover();
				}else if(this.getDirecao().isDireita()){
					this.movimentos.girar("horario");
					this.movimentos.girar("horario");
					this.movimentos.mover();
				}
				break;
			}
			
		}
	}
	
	public void checarAmbiente(){
		
		int x = TelaInicial.x_atual;
		int y = TelaInicial.y_atual;
		LabelCelula atual = TelaInicial.matriz[x][y];

		if(!atual.isBrisa() && !atual.isFedor()){
			this.getBase().setCaminhoOk(x, y);
			if(!(x+1>3)){
				this.getBase().setCaminhoOk(x+1, y);
			}
			
			if(!(x-1<0)){
				this.getBase().setCaminhoOk(x-1, y);
			}
			
			if(!(y+1>3)){
				this.getBase().setCaminhoOk(x, y+1);
			}
			
			if(!(y-1<0)){
				this.getBase().setCaminhoOk(x, y-1);
			}
		} else {
			
			if(atual.isBrisa()){
				Pontos novo = null;
				if(this.base.getPoco().isEmpty()){
					if(!(x+1>3)){
						novo = new Pontos(x+1, y);
						if(!this.verificaOk(novo))
							this.getBase().setPoco(x+1, y);
					}
					
					if(!(x-1<0)){
						novo = new Pontos(x-1, y);
						if(!this.verificaOk(novo))
							this.getBase().setPoco(x-1, y);
					}
					
					if(!(y+1>3)){
						novo = new Pontos(x, y+1);
						if(!this.verificaOk(novo))
							this.getBase().setPoco(x, y+1);
					}
					
					if(!(y-1<0)){
						novo = new Pontos(x, y-1);
						if(!this.verificaOk(novo))
							this.getBase().setPoco(x, y-1);
					}
				}else{
					//tenho que verificar se tem algo já no poço
					for (Pontos ponto : this.base.getPoco()) {
						if(ponto.getY()-1 == y && ponto.getX()==x){
							if(!atual.isBrisa()){
								this.base.removerPoco(ponto);
								this.base.addCaminho(ponto);
							}
						}
					}
				}

			}
			
			if(atual.isFedor()){
				
				Pontos novo = null;
				if(this.base.getWumpus().isEmpty()){
					System.out.println("está vazia");
					if(!(x+1>3)){
						novo = new Pontos(x+1, y);
						if(!this.verificaOk(novo))
							this.getBase().setWumpus(x+1, y);
					}
					
					if(!(x-1<0)){
						novo = new Pontos(x-1, y);
						if(!this.verificaOk(novo))
							this.getBase().setWumpus(x-1, y);
					}
					
					if(!(y+1>3)){
						novo = new Pontos(x, y+1);
						if(!this.verificaOk(novo))
							this.getBase().setWumpus(x, y+1);
					}
					
					if(!(y-1<0)){
						novo = new Pontos(x, y-1);
						if(!this.verificaOk(novo))
							this.getBase().setWumpus(x, y-1);
					}
				}else{
					for (Pontos ponto : this.base.getWumpus()) {
						if(ponto.getY()-1 == y && ponto.getX()-1 ==x){
							if(!atual.isWumpus()){
								this.base.removerWumpus(ponto);
								this.base.addCaminho(ponto);
							}
						}
					}
				}
				
				for (Pontos ponto : this.base.getCaminhoOk()) {
					System.out.println("caminho x " + ponto.getX() + " y " + ponto.getY() );
				}
				
				for (Pontos ponto : this.base.getWumpus()) {
					System.out.println("wumpus x " + ponto.getX() + " y " + ponto.getY() );
				}
				
				for (Pontos ponto : this.base.getPoco()) {
					System.out.println("poço x " + ponto.getX() + " y " + ponto.getY() );
				}
				
				
			}
		}
	}
	
	private void esperar(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean verificaOk(Pontos outro){
		for (Pontos ponto : this.base.getCaminhoOk()) {
			if(ponto.compareTo(outro)){
				return true; 
			}
		}
		return false;
	}
	
	public BaseConhecimento getBase() {
		return base;
	}
	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public boolean isFlecha() {
		return flecha;
	}

	public void setFlecha(boolean flecha) {
		this.flecha = flecha;
	}

	public boolean isOuro() {
		return ouro;
	}

	public void setOuro(boolean ouro) {
		this.ouro = ouro;
	}

	public boolean isWumpusDead() {
		return wumpusDead;
	}

	public void setWumpusDead(boolean wumpusDead) {
		this.wumpusDead = wumpusDead;
	}

	public boolean isSubirEscada() {
		return subirEscada;
	}

	public void setSubirEscada(boolean subirEscada) {
		this.subirEscada = subirEscada;
	}

	public Movimentos getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(Movimentos movimentos) {
		this.movimentos = movimentos;
	}
	
	/*
	 * Não seta diretamente a pontuação
	 */
	public Pontuacao getPontuacao() {
		return pontuacao;
	}
}
