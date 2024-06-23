package entidades;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import principal.PanelDeJuego;
import principal.Teclado;
import principal.Utilidades;

public class Jugador extends Entidad {

	PanelDeJuego pdj;
	Teclado teclado;
	public final int xPantalla;
	public final int yPantalla;

	public Jugador(PanelDeJuego pdj, Teclado teclado) {

		this.pdj = pdj;
		this.teclado = teclado;
		
		areaSolida = new Rectangle(8, 32, 32, 40);
		areaSolidaDefaultX = areaSolida.x;
		areaSolidaDefaultY = areaSolida.y;
		
		setValoresPorDefecto();
		obtenerImagenDelJugador();
		
		xPantalla = pdj.anchoDePantalla / 2 - (pdj.tamañoDeBaldosa/2);
		yPantalla = pdj.altoDePantalla / 2 - ((pdj.tamañoDeBaldosa + (pdj.tamañoDeBaldosa/2)) /2);
		

	}

	public void setValoresPorDefecto() {

		xMundo = pdj.tamañoDeBaldosa * 5;
		yMundo = pdj.tamañoDeBaldosa * 5;
		velocidad = 3;
		direccion = "abajo";
	}

	public void obtenerImagenDelJugador() {
		
		abajo1 = configurar("mc_down_1");
		abajo2 = configurar("mc_down_2");
		abajo3 = configurar("mc_down_3");
		abajo4 = configurar("mc_down_4");
		izquierda1 = configurar("mc_left_1");
		izquierda2 = configurar("mc_left_2");
		derecha1 = configurar("mc_right_1");
		derecha2 = configurar("mc_right_2");
		arriba1 = configurar("mc_up_1");
		arriba2 = configurar("mc_up_2");
		arriba3 = configurar("mc_up_3");
		arriba4 = configurar("mc_up_4");

	}

	public BufferedImage configurar(String imageName) {

		Utilidades uTool = new Utilidades();
		BufferedImage imagen = null;

		try {
			imagen = ImageIO.read(getClass().getResourceAsStream("/jugador/"+imageName+".png"));
			imagen = uTool.escalarImagen(imagen, pdj.tamañoDeBaldosa, pdj.tamañoDeBaldosa+(pdj.tamañoDeBaldosa/2));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return imagen;
	}

	public void actualizar() {

		if(teclado.W == true || teclado.S == true || teclado.A == true || teclado.D == true) {
			
			if(teclado.W == true) {
				direccion = "arriba";
			}
			if(teclado.S == true) {
				direccion = "abajo";
			}
			if(teclado.A == true) {
				direccion = "izquierda";
			}
			if(teclado.D == true) {
				direccion = "derecha";
			}
			
			//COMPROBAR COLISIONES CON LAS BALDOSAS
			colisionActivada = false;
			pdj.comprobadorDeColisiones.verificarBaldosa(this);
			
			//COMPROBAR COLISIONES CON OBJETOS
			int objIndex = pdj.comprobadorDeColisiones.verificarObjeto(this, true);
			recogerObjeto(objIndex);

			
			//SI LA COLISION ESTA DESACTIVADA, EL JUGADOR SE PODRA MOVER
			if(colisionActivada == false) {
				
				switch(direccion) {
				case "arriba": yMundo -= velocidad; break;
				case "abajo": yMundo += velocidad; break;
				case "izquierda": xMundo -= velocidad; break;
				case "derecha": xMundo += velocidad; break;
				}
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
	
	public void recogerObjeto(int i) {

	    if (i != 999) {

	        String nombreObjeto = pdj.obj[i].nombre;

	        switch (nombreObjeto) {
	            case "Llave":
	            	if(pdj.obj[i].colision == true) {
	            		pdj.ReproducirSE(0);
	            		pdj.obj[i] = null;
	            	} 
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
		g2.drawImage(imagen, xPantalla, yPantalla, null);

	}

}
