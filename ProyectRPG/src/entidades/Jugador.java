package entidades;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import principal.PanelDeJuego;
import principal.Teclado;

public class Jugador extends Entidad {

	PanelDeJuego panelDeJuego;
	Teclado teclado;
	public final int xPantalla;
	public final int yPantalla;

	public Jugador(PanelDeJuego panelDeJuego, Teclado teclado) {

		this.panelDeJuego = panelDeJuego;
		this.teclado = teclado;
		setValoresPorDefecto();
		obtenerImagenDelJugador();
		
		xPantalla = panelDeJuego.anchoDePantalla / 2 - (panelDeJuego.tamañoDeBaldosa/2);
		yPantalla = panelDeJuego.altoDePantalla / 2 - ((panelDeJuego.tamañoDeBaldosa + (panelDeJuego.tamañoDeBaldosa/2)) /2);
		

	}

	public void setValoresPorDefecto() {

		xMundial = panelDeJuego.tamañoDeBaldosa * 5;
		yMundial = panelDeJuego.tamañoDeBaldosa * 5;
		velocidad = 3;
		direccion = "abajo";
	}

	public void obtenerImagenDelJugador() {

		try {
			abajo1 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_down_1.png"));
			abajo2 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_down_2.png"));
			abajo3 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_down_3.png"));
			abajo4 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_down_4.png"));
			izquierda1 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_left_1.png"));
			izquierda2 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_left_2.png"));
			derecha1 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_right_1.png"));
			derecha2 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_right_2.png"));
			arriba1 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_up_1.png"));
			arriba2 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_up_2.png"));
			arriba3 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_up_3.png"));
			arriba4 = ImageIO.read(getClass().getResourceAsStream("/jugador/mc_up_4.png"));

		} catch(IOException e){
			e.printStackTrace();
		}
	}

	public void actualizar() {

		if(teclado.W == true || teclado.S == true || teclado.A == true || teclado.D == true) {

			if(teclado.W == true) {
				direccion = "arriba";
				yMundial -= velocidad;
			}
			if(teclado.S == true) {
				direccion = "abajo";
				yMundial += velocidad;
			}
			if(teclado.A == true) {
				direccion = "izquierda";
				xMundial -= velocidad;
			}
			if(teclado.D == true) {
				direccion = "derecha";
				xMundial += velocidad;
			}

			contadorDeSprites++;
			if(contadorDeSprites > 10) {
				if(numeroDeSprite == 1) {
					numeroDeSprite = 2;
				}
				else if(numeroDeSprite == 2) {
					numeroDeSprite = 3;
				}
				else if(numeroDeSprite == 3) {
					numeroDeSprite = 4;
				}
				else if(numeroDeSprite == 4) {
					numeroDeSprite = 1;
				}
				contadorDeSprites = 0;
			}

		}
		else {
			switch(direccion) {
			case "arriba":
				numeroDeSprite = 1;
				break;
			case "abajo":
				numeroDeSprite = 1;
				break;
			case "izquierda":
				numeroDeSprite = 1;
				break;
			case "derecha":
				numeroDeSprite = 1;
				break;
			}
		}

	}

	public void dibujar(Graphics2D g2) {

		BufferedImage imagen = null;

		switch(direccion) {
		case "arriba":
			if(numeroDeSprite == 1) {
				imagen = arriba1;
			}
			if(numeroDeSprite == 2) {
				imagen = arriba2;
			}
			if(numeroDeSprite == 3) {
				imagen = arriba3;
			}
			if(numeroDeSprite == 4) {
				imagen = arriba4;
			}
			break;
		case "abajo":
			if(numeroDeSprite == 1) {
				imagen = abajo1;
			}
			if(numeroDeSprite == 2) {
				imagen = abajo2;
			}
			if(numeroDeSprite == 3) {
				imagen = abajo3;
			}
			if(numeroDeSprite == 4) {
				imagen = abajo4;
			}
			break;
		case "izquierda":
			if(numeroDeSprite == 1) {
				imagen = izquierda1;
			}
			if(numeroDeSprite == 2) {
				imagen = izquierda2;
			}
			if(numeroDeSprite == 3) {
				imagen = izquierda1;
			}
			if(numeroDeSprite == 4) {
				imagen = izquierda2;
			}
			break;
		case "derecha":
			if(numeroDeSprite == 1) {
				imagen = derecha1;
			}
			if(numeroDeSprite == 2) {
				imagen = derecha2;
			}
			if(numeroDeSprite == 3) {
				imagen = derecha1;
			}
			if(numeroDeSprite == 4) {
				imagen = derecha2;
			}
			break;
		}
		g2.drawImage(imagen, xPantalla, yPantalla, panelDeJuego.tamañoDeBaldosa, (panelDeJuego.tamañoDeBaldosa + (panelDeJuego.tamañoDeBaldosa/2)), null);


	}

}
