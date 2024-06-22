package entidades;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entidad {

	public int xMundo, yMundo;
	public int velocidad;

	public BufferedImage abajo1, abajo2, abajo3, abajo4, arriba1, arriba2, arriba3, arriba4, izquierda1, izquierda2, derecha1, derecha2;
	public String direccion;

	public int contadorDeSprites = 0;
	public int numeroDeSprite = 2;
	
	public Rectangle areaSolida;
	public int areaSolidaPredeterminadaX, areaSolidaPredeterminadaY;
	public boolean colisionActivada = false;

}
