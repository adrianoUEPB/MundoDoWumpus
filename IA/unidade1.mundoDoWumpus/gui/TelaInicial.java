package gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int x_atual = 0;
	public static int y_atual = 0;
	public static LabelCelula matriz[][];

	/**
	 * Create the frame.
	 */
	public TelaInicial(Agente agente) {
		matriz = new LabelCelula[4][4];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 506);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(208, 37, 400, 400);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 4));
		/*
		 * A contagem da linha é decrescente porque o gridlayout adiciona de cima para baixo.
		 * Para que seja adicionado de acordo com a posição correta, conhecida, do array, foi invertido.
		 */
		//linha 4
		LabelCelula label1 = new LabelCelula();
		label1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label1);
		
		LabelCelula label2 = new LabelCelula();
		label2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label2);
		
		LabelCelula label3 = new LabelCelula();
		label3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label3);
		
		LabelCelula label4 = new LabelCelula();
		label4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label4);
		
		matriz[3][0] = label1;
		matriz[3][1] = label2;
		matriz[3][2] = label3;
		matriz[3][3] = label4;
		
		//linha 3
		LabelCelula label5 = new LabelCelula();
		label5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label5);
		
		LabelCelula label6 = new LabelCelula();
		label6.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label6);
		
		LabelCelula label7 = new LabelCelula();
		label7.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label7);
		
		LabelCelula label8 = new LabelCelula();
		label8.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label8);
		
		matriz[2][0] = label5;
		matriz[2][1] = label6;
		matriz[2][2] = label7;
		matriz[2][3] = label8;

		//linha 2
		LabelCelula label9 = new LabelCelula();
		label9.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label9);
		
		LabelCelula label10 = new LabelCelula();
		label10.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label10);
		
		LabelCelula label11 = new LabelCelula();
		label11.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label11);
		
		LabelCelula label12 = new LabelCelula();
		label12.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label12);
		
		matriz[1][0] = label9;
		matriz[1][1] = label10;
		matriz[1][2] = label11;
		matriz[1][3] = label12;
		
		//linha 1
		
		LabelCelula label13 = new LabelCelula();
		label13.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label13);
		
		LabelCelula label14 = new LabelCelula();
		label14.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label14);
		
		LabelCelula label15 = new LabelCelula();
		label15.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label15);
		
		LabelCelula label16 = new LabelCelula();
		label16.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(label16);
		
		
		
		matriz[0][0] = label13;
		matriz[0][1] = label14;
		matriz[0][2] = label15;
		matriz[0][3] = label16;
		
//		label15.setPoco(true);
//		label7.setPoco(true);
//		label11.setOuro(true);
//		label5.setWumpus(true);
//		label4.setPoco(true);
		
		/*
		 * Adiciona os elementos no campo
		 */
		this.posicionarnPoco(0, 2);
		this.posicionarnPoco(2, 2);
		this.posicionarnPoco(3, 3);
		this.posicionarOuro(2, 1);
		this.posicionarWumpus(2, 0);

		
		
		/*
		 * Setar o agente neste ponto faz com que apareça possíveis sensibilidades (brilho, fedor, brisa) que não é percebida
		 * se for colocada antes de posicionar os sensores.
		 */
		label13.setAgente(agente);
		
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agente.getMovimentos().mover();				
			}
		});
		btnAvancar.setBounds(12, 96, 117, 25);
		getContentPane().add(btnAvancar);
		
		JButton btnPegarOuro = new JButton("Pegar Ouro");
		btnPegarOuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agente.getMovimentos().pegarOuro();
			}
		});
		btnPegarOuro.setBounds(12, 133, 117, 25);
		getContentPane().add(btnPegarOuro);
		
		JButton btnEscada = new JButton("Subir Escada");
		btnEscada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agente.getMovimentos().subirEscada();
			}
		});
		btnEscada.setBounds(22, 170, 117, 25);
		getContentPane().add(btnEscada);
		
		JButton btnFlecha = new JButton("Atirar");
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agente.getMovimentos().atirarFlecha();
			}
		});
		btnFlecha.setBounds(12, 205, 117, 25);
		getContentPane().add(btnFlecha);
		
		JButton btnGiraHor = new JButton("Horário");
		btnGiraHor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agente.getMovimentos().girar("horario");
			}
		});
		btnGiraHor.setBounds(12, 242, 117, 25);
		getContentPane().add(btnGiraHor);
		
		JButton btnGiraAnt = new JButton("Anti-horário");
		btnGiraAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agente.getMovimentos().girar("anti");
			}
		});
		btnGiraAnt.setBounds(12, 279, 117, 25);
		getContentPane().add(btnGiraAnt);
		
		JButton btnIniciarIa = new JButton("Iniciar IA");
		btnIniciarIa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agente.iniciarIa();
			}
		});
		btnIniciarIa.setBounds(0, 37, 117, 25);
		getContentPane().add(btnIniciarIa);
		
	}
	
	private void posicionarOuro(int x, int y){
//		boolean continua = true;
//		Random random = new Random();
//		do{
//			int x = random.nextInt(3);
//			int y = random.nextInt(3);
			
			if(!(matriz[x][y].isPoco() && !(matriz[x][y].isWumpus()))){
				matriz[x][y].setOuro(true);
//				continua = false;
				System.out.println("Adicionou em x="+ x + " y="+y);
			}
				
//		}while(continua);
		
		
		
	}
	private void posicionarWumpus(int x, int y){
		matriz[x][y].setWumpus(true);
		
		if(x+1 <=3)
			matriz[x+1][y].setFedor(true);
		
		if(x-1 >= 0)
			matriz[x-1][y].setFedor(true);
		
		if(y+1 <=3)
			matriz[x][y+1].setFedor(true);
		
		if(y-1 >= 0)
			matriz[x][y-1].setFedor(true);
		
		System.out.println("Adicionou em x="+ x + " y="+y);

			
	}
	private void posicionarnPoco(int x, int y){
		matriz[x][y].setPoco(true);
		
		if(x+1 <=3)
			matriz[x+1][y].setBrisa(true);
		
		if(x-1 >= 0)
			matriz[x-1][y].setBrisa(true);
		
		if(y+1 <=3)
			matriz[x][y+1].setBrisa(true);
		
		if(y-1 >= 0)
			matriz[x][y-1].setBrisa(true);
		
		System.out.println("Adicionou em x="+ x + " y="+y);
	}
}