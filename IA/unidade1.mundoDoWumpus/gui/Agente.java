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
	private Pontos ultimoMovimento;
	
	/**
	 * Flags para definir o último movimento feito e para onde poderá se mover
	 */
	private boolean direita, esquerda, cima, baixo;
	
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
		this.direita = this.esquerda = this.cima = this.baixo = false;
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
			if(!ponto.isVisitado()){
				if(ponto.compareTo(new Pontos(x, y+1))){
					System.out.println("movimentou pra direita");
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
					this.base.setVisitado(x, y+1);
					ponto.setVisitado(true);
					break;
					
				}else if(ponto.compareTo(new Pontos(x+1, y))){
					System.out.println("movimentou pra cima");
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
					this.base.setVisitado(x+1, y);
					ponto.setVisitado(true);
					break;
				}else if(ponto.compareTo(new Pontos(x-1, y))){
					System.out.println("movimentou pra baixo");
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
					this.base.setVisitado(x-1, y);
					ponto.setVisitado(true);
					break;
				}else if(ponto.compareTo(new Pontos(x, y-1))){
					System.out.println("movimentou pra esquerda");
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
					this.ultimoMovimento = new Pontos(x, y-1);
					ponto.setVisitado(true);
					break;
				}
				
				this.base.setVisitado(x, y);
			}else{
				
				System.out.println("todos os pontos visitados");
				
				if(ultimoMovimento.compareTo(new Pontos(x, y+1))){
					System.out.println("movimentou pra direita");
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
//					this.base.setVisitado(x, y+1);
//					ponto.setVisitado(true);
					break;
					
				}else if(this.ultimoMovimento.compareTo(new Pontos(x+1, y))){
					System.out.println("movimentou pra cima");
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
//					this.base.setVisitado(x+1, y);
//					ponto.setVisitado(true);
					break;
				}else if(this.ultimoMovimento.compareTo(new Pontos(x-1, y))){
					System.out.println("movimentou pra baixo");
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
//					this.base.setVisitado(x-1, y);
//					ponto.setVisitado(true);
					break;
				}else if(this.ultimoMovimento.compareTo(new Pontos(x, y-1))){
					System.out.println("movimentou pra esquerda");
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
//					this.base.setVisitado(x, y-1);
//					ponto.setVisitado(true);
					break;
				
				}
			}
		}
			
	}
	
	public void checarAmbiente(){
		
		int x = TelaInicial.x_atual;
		int y = TelaInicial.y_atual;
		LabelCelula atual = TelaInicial.matriz[x][y];
		Pontos ponto = null;

		if(!atual.isBrisa() && !atual.isFedor()){
			ponto = new Pontos(x, y);
			this.ultimoMovimento = ponto;
			ponto.setVisitado(true);
			this.getBase().setCaminhoOk(ponto);
			
			if(!(x+1>3)){
				ponto = new Pontos(x+1, y);
				this.getBase().setCaminhoOk(ponto);
			}
			
			if(!(x-1<0)){
				ponto = new Pontos(x-1, y);
				this.getBase().setCaminhoOk(ponto);
			}
			
			if(!(y+1>3)){
				ponto = new Pontos(x, y+1);
				this.getBase().setCaminhoOk(ponto);
			}
			
			if(!(y-1<0)){
				ponto = new Pontos(x, y-1);
				this.getBase().setCaminhoOk(ponto);
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
					for (Pontos poco : this.base.getPoco()) {
						if(poco.getY()-1 == y && poco.getX()==x){
							if(!atual.isBrisa()){
								this.base.removerPoco(poco);
								this.base.setCaminhoOk(poco);
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
					for (Pontos wumpus : this.base.getWumpus()) {
						if(wumpus.getY()-1 == y && wumpus.getX()-1 ==x){
							if(!atual.isWumpus()){
								this.base.removerWumpus(wumpus);
								this.base.setCaminhoOk(wumpus);
							}
						}
					}
				}
				
				for (Pontos caminho : this.base.getCaminhoOk()) {
					System.out.println("caminho x " + caminho.getX() + " y " + caminho.getY() );
				}
				
				for (Pontos wumpus : this.base.getWumpus()) {
					System.out.println("wumpus x " + wumpus.getX() + " y " + wumpus.getY() );
				}
				
				for (Pontos poco : this.base.getPoco()) {
					System.out.println("poço x " + poco.getX() + " y " + poco.getY() );
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
