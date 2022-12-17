import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.*;

public class Movel extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;

	// Tamanho da janela - tamanho das bordas (640-15 = 625)
	private static final int LARGURA = 625;
	// Tamanho da janela - tamanho das bordas (480-35 = 445)
	private static final int ALTURA = 445;
	private int diametroBola;
	private int x, y, velocidadeX = 5, velocidadeY = 5;
	private Color color;

	public Movel(int xnovo, int ynovo, int diametroBolanovo, Color Novacolor) {
		this.x = xnovo;
		this.y = ynovo;
		this.diametroBola = diametroBolanovo;
		this.color = Novacolor;
		addKeyListener(this);
	}

	// Funcao que controla o movimento da bola.
	public void move() {
		// Testes que impedem que a bolinhas automaticas ultrapassem a parede
		if (x >= LARGURA - diametroBola)
			velocidadeX *= -1;
		if (x <= 0)
			velocidadeX *= -1;
		if (y >= ALTURA - diametroBola)
			velocidadeY *= -1;
		if (y <= 0)
			velocidadeY *= -1;
		x += velocidadeX;
		y += velocidadeY;
	}

	/* Funcao que desenha o fundo do painel . */
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, diametroBola, diametroBola);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				y += velocidadeY;
				break;
			case KeyEvent.VK_DOWN:
				y -= velocidadeY;
				break;
			case KeyEvent.VK_LEFT:
				x -= velocidadeX;

				break;
			case KeyEvent.VK_RIGHT:
				x += velocidadeX;
				break;
			default:
				break;
		}
	}

	// Quando a tecla for solta
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				y += velocidadeY;
				break;
			case KeyEvent.VK_DOWN:
				y -= velocidadeY;
				break;
			case KeyEvent.VK_LEFT:
				x -= velocidadeX;

				break;
			case KeyEvent.VK_RIGHT:
				x += velocidadeX;
				break;
			default:
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
