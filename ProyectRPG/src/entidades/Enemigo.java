package entidades;

import java.awt.Rectangle;

import principal.PanelDeJuego;

public class Enemigo extends Entidad {

	public Enemigo(PanelDeJuego pdj) {
		super(pdj);
		direccion = "abajo";
		velocidad = 1;

		areaSolida = new Rectangle(8, 32, 32, 40);
		areaSolidaDefaultX = areaSolida.x;
		areaSolidaDefaultY = areaSolida.y;

		obtenerImagen();
	}
	
	public void obtenerImagen() {
		abajo1 = configurarImagen("/jugador/mc_down_1");
		abajo2 = configurarImagen("/jugador/mc_down_2");
		abajo3 = configurarImagen("/jugador/mc_down_3");
		abajo4 = configurarImagen("/jugador/mc_down_4");
		izquierda1 = configurarImagen("/jugador/mc_left_1");
		izquierda2 = configurarImagen("/jugador/mc_left_2");
		derecha1 = configurarImagen("/jugador/mc_right_1");
		derecha2 = configurarImagen("/jugador/mc_right_2");
		arriba1 = configurarImagen("/jugador/mc_up_1");
		arriba2 = configurarImagen("/jugador/mc_up_2");
		arriba3 = configurarImagen("/jugador/mc_up_3");
		arriba4 = configurarImagen("/jugador/mc_up_4");
	}

}
