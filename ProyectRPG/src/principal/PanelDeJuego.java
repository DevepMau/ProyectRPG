package principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import baldosa.GestorDeBaldosas;
import entidades.Jugador;

public class PanelDeJuego extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	// CONFIGURACIÓN DE PANTALLA
	final int tamañoOriginalDeTile = 16;
	final int escala = 3;

	public final int tamañoDeTile = tamañoOriginalDeTile * escala;
	public final int maxColDePantalla = 16;
	public final int maxFilaDePantalla = 12;
	public final int anchoDePantalla = tamañoDeTile * maxColDePantalla;
	public final int altoDePantalla = tamañoDeTile * maxFilaDePantalla;

	GestorDeBaldosas gestorDeTiles = new GestorDeBaldosas(this);
	Teclado teclado = new Teclado();
	Thread hiloDeJuego;
	Jugador jugador = new Jugador(this, teclado);

	// FPS
	int FPS = 60;

	public PanelDeJuego() {

		this.setPreferredSize(new Dimension(anchoDePantalla, altoDePantalla));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(teclado);
		this.setFocusable(true);

	}

	public void iniciarHiloDeJuego() {
		hiloDeJuego = new Thread(this);
		hiloDeJuego.start();

	}

	@Override
	public void run() {

		double intervaloDeDibujo = 1000000000 / FPS;
		double delta = 0;
		long ultimoTiempo = System.nanoTime();
		long tiempoActual;

		while(hiloDeJuego != null) {

			tiempoActual = System.nanoTime();
			delta += (tiempoActual - ultimoTiempo) / intervaloDeDibujo;
			ultimoTiempo = tiempoActual;

			if(delta >= 1) {
				actualizar();
				repaint();
				delta--;
			}
		}

	}

	public void actualizar() {

		jugador.actualizar();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		gestorDeTiles.dibujar(g2);

		jugador.dibujar(g2);

		g2.dispose();

	}

}