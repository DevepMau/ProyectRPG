package principal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import objetos.OBJ_Llave;

public class UI {

	PanelDeJuego pdj;
	Graphics2D g2;
	Font maruMonica;
	public boolean mensajeActivo = false;
	public String mensaje = "";
	int contadorMensaje = 0;
	public boolean juegoTerminado = false;
	public String dialogoActual = "";

	public UI(PanelDeJuego pdj) {

		this.pdj = pdj;
		
		try {
			InputStream is = getClass().getResourceAsStream("/fuentes/x12y16pxMaruMonica.ttf");
			maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mostrarMensaje(String texto) {

		mensaje = texto;
		mensajeActivo = true;

	}

	public void dibujar(Graphics2D g2) {

		this.g2 = g2;

		g2.setFont(maruMonica);
		g2.setColor(Color.white);

		//MODO JUEGO
		if (pdj.estadoDeJuego == pdj.modoJuego) {

		}
		//MODO PAUSA
		if (pdj.estadoDeJuego == pdj.modoPausa) {
			dibujarPantallaPausa();
		}
		//MODO DIALOGO
		if(pdj.estadoDeJuego == pdj.modoDialogo) {
			dibujarPantallaDeDialogo();
		}

	}

	public void dibujarPantallaPausa() {

		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80f));
		String texto = "PAUSADO";
		int x = obtenerXParaTextoCentrado(texto);
		int y = pdj.altoDePantalla / 2;

		g2.drawString(texto, x, y);

	}
	
	public void dibujarPantallaDeDialogo() {

		int x = pdj.tamañoDeBaldosa*2;
		int y = pdj.tamañoDeBaldosa*8;
		int width = pdj.anchoDePantalla - (pdj.tamañoDeBaldosa*4);
		int height = pdj.tamañoDeBaldosa*4;

		drawSubWindow(x, y, width, height);
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
		x += pdj.tamañoDeBaldosa;
		y += pdj.tamañoDeBaldosa;

		for(String line : dialogoActual.split("\n")) {
			g2.drawString(line, x, y);
			y += 40;
		}

	}

	public void drawSubWindow(int x, int y, int width, int height) {

		Color c = new Color(0,0,0, 200);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x, y, width-10, height-10, 25, 25);

	}

	public int obtenerXParaTextoCentrado(String texto) {

		int longitud = (int) g2.getFontMetrics().getStringBounds(texto, g2).getWidth();
		int x = pdj.anchoDePantalla / 2 - longitud / 2;
		return x;

	}

}
