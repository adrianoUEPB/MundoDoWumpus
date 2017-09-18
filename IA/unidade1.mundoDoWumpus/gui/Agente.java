package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
	
	public Agente() {
		this.direcao = new Direcao();
		this.movimentos = new Movimentos();
		this.pontuacao = new Pontuacao();
		this.direcao.setDireita(true);
		this.flecha = true;
		this.ouro = false;
		this.wumpusDead = false;
		this.subirEscada = false;
		this.base = new BaseConhecimento();
	}
	
	public void iniciarIa(){
		
		while(!this.subirEscada){
			try {
				this.checarAmbiente();
				this.pegarOuro();
				this.movimentos();
				
			} catch (NullPointerException ex){
				this.subirEscada = true;
			}
			
		}
		JOptionPane.showMessageDialog(null, this.pontuacao.mostrarPontuacao());
	}
	
	private void pegarOuro(){
		if(this.ouro){
			this.movimentos.pegarOuro();
			this.setOuro(false);
			this.subirEscada = true;
		}
	}
	
	private void matarWumpus(Pontos agente){
		System.out.println("Chamou matar wumpus");
		Pontos wumpus = null;
		System.out.println("tamanho da lista do wumpus " + this.base.getWumpus().size());
		for (Pontos pontos : this.base.getWumpus()) {
			wumpus = pontos;
		}
		
		if(wumpus.compareTo(new Pontos(agente.getX(), agente.getY()-1))){
			
			if(this.getDirecao().isEsquerda()){
				this.movimentos.atirarFlecha();
			}else if(this.getDirecao().isDireita()){
				this.movimentos.girar("horaio");
				this.movimentos.girar("horario");
				this.movimentos.atirarFlecha();
			}else if(this.getDirecao().isCima()){
				this.movimentos.girar("anti-horario");
				this.movimentos.atirarFlecha();
			}else if(this.getDirecao().isBaixo()){
				this.movimentos.girar("horario");
				this.movimentos.atirarFlecha();
			}
			
		}else if(wumpus.compareTo(new Pontos(agente.getX(), agente.getY()+1))){
			
			if(this.getDirecao().isEsquerda()){
				
			}else if(this.getDirecao().isDireita()){
				
			}else if(this.getDirecao().isCima()){
				
			}else if(this.getDirecao().isBaixo()){
				
			}
			
		}else if(wumpus.compareTo(new Pontos(agente.getX()+1, agente.getY()))){
			
			if(this.getDirecao().isEsquerda()){
				
			}else if(this.getDirecao().isDireita()){
				
			}else if(this.getDirecao().isCima()){
				
			}else if(this.getDirecao().isBaixo()){
				
			}
			
		}else if(wumpus.compareTo(new Pontos(agente.getX()-1, agente.getY()))){
			
			if(this.getDirecao().isEsquerda()){
				
			}else if(this.getDirecao().isDireita()){
				
			}else if(this.getDirecao().isCima()){
				
			}else if(this.getDirecao().isBaixo()){
				
			}
			
		}
		
		
	}
	
	
	public void movimentos(){
		
		
		
		int x = TelaInicial.x_atual;
		int y = TelaInicial.y_atual;
		
		for (Pontos ponto : this.base.getCaminhoOk()) {

			if(!ponto.compareTo(new Pontos(x, y))){
				if(!ponto.isVisitado() && !TelaInicial.matriz[ponto.getX()][ponto.getY()].isPoco() &&
						!TelaInicial.matriz[ponto.getX()][ponto.getY()].isPoco()){
					
					if(ponto.compareTo(new Pontos(x, y+1))){
						
						this.movimentoDireita();
						this.base.setVisitado(x, y+1);
						ponto.setVisitado(true);
						break;
						
					}else if(ponto.compareTo(new Pontos(x+1, y))){
						
						this.movimentoCima();
						this.base.setVisitado(x+1, y);
						ponto.setVisitado(true);
						break;
						
					}else if(ponto.compareTo(new Pontos(x-1, y))){
						
						this.movimentoBaixo();
						this.base.setVisitado(x-1, y);
						ponto.setVisitado(true);
						break;
						
					}else if(ponto.compareTo(new Pontos(x, y-1))){
						
						this.movimentoEsquerda();
						this.ultimoMovimento = new Pontos(x, y-1);
						ponto.setVisitado(true);
						break;
					}else if(ponto.compareTo(new Pontos(x-1, y-1))){ 
					
//=======================================VISITAR DIAGONAIS===================================================					
					/**
					 * Não visitado nas diagonais
					 */
					
					
						
						this.movimentoBaixo();
						this.movimentoEsquerda();
						this.base.setVisitado(x-1, y-1);
						ponto.setVisitado(true);
						break;
						
					}else if(ponto.compareTo(new Pontos(x+1, y-1))){
						
						this.movimentoCima();
						this.movimentoEsquerda();
						this.base.setVisitado(x+1, y-1);
						ponto.setVisitado(true);
						break;
						
					}else if(ponto.compareTo(new Pontos(x-1, y+1))){
						
						this.movimentoBaixo();
						this.movimentoDireita();
						this.base.setVisitado(x-1, y+1);
						ponto.setVisitado(true);
						break;
						
					}else if(ponto.compareTo(new Pontos(x+1, y+1))){
						
						this.movimentoCima();
						this.movimentoDireita();
						this.ultimoMovimento = new Pontos(x+1, y+1);
						ponto.setVisitado(true);
						break;
					}
					
					
//====================================TERMINA QUADRADOS DIAGONAIS=============================================				
					
					this.base.setVisitado(x, y);
				}
				
			}
				
				
			}
			
		}
			
//	}
	
	public void checarAmbiente(){
		
		int x = TelaInicial.x_atual;
		int y = TelaInicial.y_atual;
		LabelCelula atual = TelaInicial.matriz[x][y];
		Pontos pontoAtual = new Pontos(x, y);
				
		if(atual.isOuro()) this.setOuro(true);
		
		System.out.println("onde estou x " + x + " y " + y);

		if(!atual.isBrisa() && !atual.isFedor()){
			System.out.println("Não tenho brisa ou fedor, caminhos ok");
			this.ultimoMovimento = pontoAtual;
			pontoAtual.setVisitado(true);
			this.getBase().setCaminhoOk(pontoAtual);
			
			if(!(x+1>3)){
				pontoAtual = new Pontos(x+1, y);
				this.getBase().setCaminhoOk(pontoAtual);
			}
			
			if(!(x-1<0)){
				pontoAtual = new Pontos(x-1, y);
				this.getBase().setCaminhoOk(pontoAtual);
			}
			
			if(!(y+1>3)){
				pontoAtual = new Pontos(x, y+1);
				this.getBase().setCaminhoOk(pontoAtual);
			}
			
			if(!(y-1<0)){
				pontoAtual = new Pontos(x, y-1);
				this.getBase().setCaminhoOk(pontoAtual);
			}
		} else {

			if(atual.isBrisa()){
				System.out.println("Senti uma brisa");
				/*
				 * Interando em caminhos pra ver se encontra algum visitado
				 */				
				List<Pontos> aux = new ArrayList<>();
				List<Pontos> auxRemove = new ArrayList<>();
				System.out.println("valor antes do loop x " + x + " y " + y);
				
				System.out.println("===============caminhos");
				for (Pontos sala : this.base.getCaminhoOk()) {
					System.out.println("x " + sala.getX() + " y " + sala.getY());
				}
				
				for (Pontos sala : this.base.getCaminhoOk()) {
					
					System.out.println("if 1 " + (sala.compareTo(new Pontos(x+1, y-1)) && sala.isVisitado() && sala.getSensores().isBrisa()));
					System.out.println("if 2 " + (sala.compareTo(new Pontos(x-1, y+1)) && sala.isVisitado() && sala.getSensores().isBrisa()));
					if(sala.isVisitado()){
						if(sala.getSensores().isBrisa()){
							//esquerda superior
							if(sala.compareTo(new Pontos(x+1, y-1))){
								this.base.setPoco(x+1, y);
								this.base.removerPoco(new Pontos(x, y+1));
								aux.add(new Pontos(x, y+1));

								//direita inferior
							}else if(sala.compareTo(new Pontos(x-1, y+1))){
								this.base.setPoco(x, y+1);
								this.base.removerPoco(new Pontos(sala.getX(), sala.getY()+1));
								aux.add(new Pontos(sala.getX(), sala.getY()+1));

								//direita superior
							}else if(sala.compareTo(new Pontos(x+1, y+1))){
								//seto os dois pq um dos dois terei visitado, enão só será inserido no que não visitei
								auxRemove.add(new Pontos(x+1, y));
								auxRemove.add(new Pontos(x, y+1));
								this.base.setPoco(x+1, y);
								this.base.setPoco(x, y+1);
//								this.base.removerPoco(new Pontos(x, y+1));
//								aux.add(new Pontos(x, y+1));

								//esquerda inferior
							}else if(sala.compareTo(new Pontos(x-1, y-1))){
								//seto os dois pq um dos dois terei visitado, enão só será inserido no que não visitei
								auxRemove.add(new Pontos(x-1, y));
								auxRemove.add(new Pontos(x, y-1));
								this.base.setPoco(x-1, y);
								this.base.setPoco(x, y-1);
//								this.base.setPoco(x, y+1);
//								this.base.removerPoco(new Pontos(sala.getX(), sala.getY()+1));
//								aux.add(new Pontos(sala.getX(), sala.getY()+1));
							}
						}else{
						
							if(sala.compareTo(new Pontos(x+1, y-1))){
								
								System.out.println("acima x " + (x+1) + " -x " + (x-1));
								System.out.println("acima y " + (y+1) + " -y " + (y-1));
								
								this.base.setPoco(x, y+1);
								this.base.removerPoco(new Pontos(x+1, y));
								aux.add(new Pontos(x+1, y));
								break;
//								this.base.setCaminhoOk(new Pontos(x, y+1));
							}else if(sala.compareTo(new Pontos(x-1, y+1))){
								
								System.out.println("abaixo x " + (x+1) + " -x " + (x-1));
								System.out.println("abaixo y " + (y+1) + " -y " + (y-1));
								
								this.base.setPoco(sala.getX(), sala.getY()+1);
								this.base.removerPoco(new Pontos(x, y+1));
								aux.add(new Pontos(x, y+1));
								this.base.setCaminhoOk(new Pontos(x+1, y));
								break;
								//superior direito
							}else if(sala.compareTo(new Pontos(x+1, y+1))){
								
								//seto os dois pq um dos dois terei visitado, enão só será inserido no que não visitei
								this.base.removerPoco(new Pontos(x+1, y));
								this.base.removerPoco(new Pontos(x, y+1));
								aux.add(new Pontos(x+1, y));
//								aux.add(new Pontos(x, y+1));
//										this.base.removerPoco(new Pontos(x, y+1));
//										aux.add(new Pontos(x, y+1));
							
								
								

								//esquerda inferior
							}else if(sala.compareTo(new Pontos(x-1, y-1))){
								//seto os dois pq um dos dois terei visitado, enão só será inserido no que não visitei
								this.base.removerPoco(new Pontos(x-1, y));
								this.base.removerPoco(new Pontos(x, y-1));
								aux.add(new Pontos(x-1, y));
								aux.add(new Pontos(x, y-1));
//								this.base.setPoco(x, y+1);
//								this.base.removerPoco(new Pontos(sala.getX(), sala.getY()+1));
//								aux.add(new Pontos(sala.getX(), sala.getY()+1));
							}
						}
						
					}
					
				}
				
				/*
				 * Se auxiliar é vazio, é pq não há caminho ok, então seta os dois poços
				 * aux utilizado para poder inserir os pontos do caminho
				 * inserindo diretamente no loop ocorre o erro: ConcurrentModificatinoExpection
				 */
				if(aux.isEmpty()){
					if(!(x+1>3)) this.base.setPoco(x+1, y);
					if(!(x-1<0)) this.base.setPoco(x-1, y);
					if(!(y+1>3)) this.base.setPoco(x, y+1);
					if(!(y-1<0)) this.base.setPoco(x, y-1);
					
				}else{
					for (Pontos pontos : aux) {
						this.base.setCaminhoOk(pontos);
					}
				}
				
				if(!auxRemove.isEmpty()){
					for (Pontos pontos : auxRemove) {
						this.base.removerOk(pontos);
					}
				}
				
					
			}else if(atual.isFedor()){
				System.out.println("Atual x " + pontoAtual.getX() + " y " + pontoAtual.getY());
				System.out.println("Senti um fedor em x " + atual.getX() + " y " + atual.getY());
				/*
				 * Interando em caminhos pra ver se encontra algum visitado
				 */				
				List<Pontos> aux = new ArrayList<>();
				List<Pontos> auxRemove = new ArrayList<>();
				
				System.out.println("valor antes do loop x " + x + " y " + y);
				
				System.out.println("===============caminhos");
				for (Pontos sala : this.base.getCaminhoOk()) {
					System.out.println("x " + sala.getX() + " y " + sala.getY());
				}
				
				for (Pontos sala : this.base.getCaminhoOk()) {
					
					System.out.println("if 1 " + (sala.compareTo(new Pontos(x+1, y-1)) && sala.isVisitado() && sala.getSensores().isFedor()));
					System.out.println("if 2 " + (sala.compareTo(new Pontos(x-1, y+1)) && sala.isVisitado() && sala.getSensores().isFedor()));
					
					if(sala.isVisitado() && 
							(
								sala.compareTo(new Pontos(x+1, y-1)) || 
								sala.compareTo(new Pontos(x-1, y+1)) ||
								sala.compareTo(new Pontos(x+1, y+1)) ||
								sala.compareTo(new Pontos(x-1, y-1))
							)
					  ){
						System.out.println("Sala visitada x " + sala.getX() + " y " + sala.getY());
						if(sala.getSensores().isFedor()){
							System.out.println("Tem fedor na sala");
							//esquerda superior
							if(sala.compareTo(new Pontos(x+1, y-1))){
								System.out.println("esquerdo superior");
								this.matarWumpus(pontoAtual);
								this.base.setWumpus(x+1, y);
								this.base.removerWumpus(new Pontos(x, y+1));
								aux.add(new Pontos(x, y+1));

								//direita inferior
							}else if(sala.compareTo(new Pontos(x-1, y+1))){
								System.out.println("direito inferior");
								this.matarWumpus(pontoAtual);
								this.base.setWumpus(x, y+1);
								this.base.removerWumpus(new Pontos(sala.getX(), sala.getY()+1));
								aux.add(new Pontos(sala.getX(), sala.getY()+1));

								//direita superior
							}else if(sala.compareTo(new Pontos(x+1, y+1))){
								System.out.println("direito superior");
								//seto os dois pq um dos dois terei visitado, enão só será inserido no que não visitei
								
//								auxRemove.add(new Pontos(x+1, y));
//								auxRemove.add(new Pontos(x, y+1));
								this.base.setWumpus(x+1, y);
								this.base.setWumpus(x, y+1);
								this.matarWumpus(pontoAtual);
//								this.base.removerPoco(new Pontos(x, y+1));
//								aux.add(new Pontos(x, y+1));

								//esquerda inferior
							}else if(sala.compareTo(new Pontos(x-1, y-1))){
								System.out.println("esquerdo inferior");
								//seto os dois pq um dos dois terei visitado, enão só será inserido no que não visitei
								
//								auxRemove.add(new Pontos(x-1, y));
//								auxRemove.add(new Pontos(x, y-1));
								//apenas removo do caminho, pq embaixo ele seta corretamente
								this.base.setWumpus(x-1, y);
								this.base.setWumpus(x, y-1);
								
								this.matarWumpus(pontoAtual);
								
								
//								this.base.setPoco(x, y+1);
//								this.base.removerPoco(new Pontos(sala.getX(), sala.getY()+1));
//								aux.add(new Pontos(sala.getX(), sala.getY()+1));
							}
						}else{
							
							
							
							System.out.println("Sala não tem fedor x " + sala.getX() + " y " + sala.getY());
							if(sala.compareTo(new Pontos(x+1, y-1))){
								
								System.out.println("s esquerda");
								
								if(sala.compareTo(new Pontos(x, y+1)) && !sala.isVisitado()){
									this.base.setWumpus(x, y+1);
									this.base.removerWumpus(new Pontos(x+1, y));
									aux.add(new Pontos(x+1, y));	
								}
								
//								this.base.setCaminhoOk(new Pontos(x, y+1));
							}else if(sala.compareTo(new Pontos(x-1, y+1))){
								
								System.out.println("i direita");
								if(sala.compareTo(new Pontos(sala.getX(), sala.getY()+1)) && !sala.isVisitado()){
									this.base.setWumpus(sala.getX(), sala.getY()+1);
									this.base.removerWumpus(new Pontos(x, y+1));
									aux.add(new Pontos(x, y+1));
								}								
								
//								this.base.setCaminhoOk(new Pontos(x+1, y));
								break;
								//superior direito
							}else if(sala.compareTo(new Pontos(x+1, y+1))){
								System.out.println("superior direita");
								//seto os dois pq um dos dois terei visitado, enão só será inserido no que não visitei
								this.base.removerWumpus(new Pontos(x+1, y));
								this.base.removerWumpus(new Pontos(x, y+1));
								
								aux.add(new Pontos(x+1, y));
								aux.add(new Pontos(x, y+1));
//								this.base.removerPoco(new Pontos(x, y+1));
//								aux.add(new Pontos(x, y+1));

								//esquerda inferior
							}else if(sala.compareTo(new Pontos(x-1, y-1))){
								System.out.println("i esquerda");
								//seto os dois pq um dos dois terei visitado, enão só será inserido no que não visitei
								this.base.removerWumpus(new Pontos(x-1, y));
								this.base.removerWumpus(new Pontos(x, y-1));
								aux.add(new Pontos(x-1, y));
								aux.add(new Pontos(x, y-1));
//								this.base.setPoco(x, y+1);
//								this.base.removerPoco(new Pontos(sala.getX(), sala.getY()+1));
//								aux.add(new Pontos(sala.getX(), sala.getY()+1));
							}
							
							System.out.println("Tamanho do wumpus " + this.base.getWumpus().size());
							
						}
				}
				
				/*
				 * Se auxiliar é vazio, é pq não há caminho ok, então seta os dois poços
				 * aux utilizado para poder inserir os pontos do caminho
				 * inserindo diretamente no loop ocorre o erro: ConcurrentModificatinoExpection
				 */
				if(aux.isEmpty()){
					if(!(x+1>3)) this.base.setWumpus(x+1, y);
					if(!(x-1<0)) this.base.setWumpus(x-1, y);
					if(!(y+1>3)) this.base.setWumpus(x, y+1);
					if(!(y-1<0)) this.base.setWumpus(x, y-1);
					
				}else{
					for (Pontos pontos : aux) {
						this.base.setCaminhoOk(pontos);
					}
				}
				
				if(!auxRemove.isEmpty()){
					for (Pontos pontos : auxRemove) {
						this.base.removerOk(pontos);
					}
				}
				
				

			}
			
			System.out.println("=========caminho possiveis");
			System.out.println("caminho livre");
			for (Pontos caminho : this.base.getCaminhoOk()) {
				System.out.println("caminho x " + caminho.getX() + " y " + caminho.getY() );
			}
			
			System.out.println();
			System.out.println(this.base.getWumpus().isEmpty());
			for (Pontos wumpus : this.base.getWumpus()) {
				System.out.println("wumpus x " + wumpus.getX() + " y " + wumpus.getY() );
			}
			System.out.println();
			for (Pontos poco : this.base.getPoco()) {
				System.out.println("poço x " + poco.getX() + " y " + poco.getY() );
			}
			System.out.println("=======================");
			}
		}//fecha else de não brisa e fedor
	}
	
	private void movimentoEsquerda(){
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
	}
	
	private void movimentoDireita(){
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
	}
	
	private void movimentoBaixo(){
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
	}
	
	private void movimentoCima(){
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
