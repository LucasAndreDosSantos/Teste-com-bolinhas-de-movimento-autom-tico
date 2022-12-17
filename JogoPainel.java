import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class JogoPainel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private Thread animacao;
	private int tempoEspera = 10;
	private boolean jogando = false;
	/*
	 * variaveis com posicao e direcao iniciais utilizadas apenas para efeito de
	 * testes
	 */

	private ArrayList<Movel> bolinha = new ArrayList<Movel>();

	// Define informacoes da janela.
	public JogoPainel() {
		// cor de fundo.
		setBackground(Color.GREEN);
		setFocusable(true);

		bolinha.add(new Movel(50, 50, 30, Color.WHITE));
		Movel b2 = new Movel(140, 90, 40, Color.ORANGE);
		bolinha.add(b2);
		Movel b3 = new Movel(190, 150, 50, Color.PINK);
		bolinha.add(b3);
		Movel b4 = new Movel(240, 190, 60, Color.BLACK);
		bolinha.add(b4);
		Movel b5 = new Movel(290, 210, 70, Color.MAGENTA);
		bolinha.add(b5);
		Movel b6 = new Movel(390, 250, 80, Color.GRAY);
		bolinha.add(b6);
		Movel b7 = new Movel(440, 280, 90, Color.YELLOW);
		bolinha.add(b7);
		Movel b8 = new Movel(490, 320, 100, Color.RED);
		bolinha.add(b8);
		Movel b9 = new Movel(540, 360, 10, Color.BLUE);
		bolinha.add(b9);
		Movel b10 = new Movel(590, 410, 20, Color.CYAN);
		bolinha.add(b10);
	}

	// Controle de inicio do jogo.
	public void addNotify() {
		super.addNotify();
		iniciarJogo();
	}

	// Funcao que da start nas funcoes de inicio do jogo
	private void iniciarJogo() {
		if (animacao == null || !jogando) {
			animacao = new Thread(this);
			animacao.start();
		}
	}

	public void run() {
		jogando = true;
		/*
		 * Loop do jogo. Aqui as coisas acontecem.
		 */
		while (jogando) {
			/*
			 * Coloque aqui todas as acoes que queira que sejam executadas a cada
			 * loop do
			 * jogo
			 */
			for (int i = 0; i < bolinha.size(); i++) {
				bolinha.get(i).move();
				repaint();
			}
			/* fim acoes para testes */
			try {
				Thread.sleep(tempoEspera);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < bolinha.size(); i++) {
			bolinha.get(i).paintComponent(g);
		}
	}
}
