package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import objetos.OBJ_Llave;

public class UI {

	PanelDeJuego pdj;
	Graphics2D g2;
	Font arial_40;
	public boolean mensajeActivo = false;
	public String mensaje = "";
	int contadorMensaje = 0;
	public boolean juegoTerminado = false;

	public UI(PanelDeJuego pdj) {

		this.pdj = pdj;
		arial_40 = new Font("Arial", Font.PLAIN, 40);

	}

	public void mostrarMensaje(String texto) {

		mensaje = texto;
		mensajeActivo = true;

	}

	public void dibujar(Graphics2D g2) {

		this.g2 = g2;

		g2.setFont(arial_40);
		g2.setColor(Color.white);

		if (pdj.estadoDeJuego == pdj.modoJuego) {

		}
		if (pdj.estadoDeJuego == pdj.modoPausa) {
			dibujarPantallaPausa();
		}

	}

	public void dibujarPantallaPausa() {

		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80f));
		String texto = "PAUSADO";
		int x = obtenerXParaTextoCentrado(texto);
		int y = pdj.altoDePantalla / 2;

		g2.drawString(texto, x, y);

	}

	public int obtenerXParaTextoCentrado(String texto) {

		int longitud = (int) g2.getFontMetrics().getStringBounds(texto, g2).getWidth();
		int x = pdj.anchoDePantalla / 2 - longitud / 2;
		return x;

	}

}
