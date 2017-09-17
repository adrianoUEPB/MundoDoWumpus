package gui;

public class Start {
	public static void main(String[] args) {
		Agente agente = new Agente();
		new TelaInicial(agente).setVisible(true);
	}
}
