package objetos;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import principal.PanelDeJuego;

public class ObjetoBase {

	public BufferedImage imagen;
	public String nombre;
	public boolean colision = false;
	public int xMundo, yMundo;

	public void dibujar(Graphics2D g2, PanelDeJuego panelDeJuego) {

		int xPantalla = xMundo - panelDeJuego.jugador.xMundo + panelDeJuego.jugador.xPantalla;
		int yPantalla = yMundo - panelDeJuego.jugador.yMundo + panelDeJuego.jugador.yPantalla;

		if(xMundo + panelDeJuego.tamañoDeBaldosa > panelDeJuego.jugador.xMundo - panelDeJuego.jugador.xPantalla &&
		   xMundo - panelDeJuego.tamañoDeBaldosa < panelDeJuego.jugador.xMundo + panelDeJuego.jugador.xPantalla &&
		   yMundo + panelDeJuego.tamañoDeBaldosa > panelDeJuego.jugador.yMundo - panelDeJuego.jugador.yMundo &&
		   yMundo - (panelDeJuego.tamañoDeBaldosa + (panelDeJuego.tamañoDeBaldosa / 2)) < panelDeJuego.jugador.yMundo + panelDeJuego.jugador.yPantalla) {

			g2.drawImage(imagen, xPantalla, yPantalla, panelDeJuego.tamañoDeBaldosa, panelDeJuego.tamañoDeBaldosa, null);

		}

	}

}