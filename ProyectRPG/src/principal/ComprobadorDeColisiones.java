package principal;

import entidades.Entidad;

public class ComprobadorDeColisiones {

	PanelDeJuego panelDeJuego;

	public ComprobadorDeColisiones(PanelDeJuego panelDeJuego) {
		this.panelDeJuego = panelDeJuego;
	}

	public void comprobarBaldosa(Entidad entidad) {

		int entidadIzquierdaX = entidad.xMundo + entidad.areaSolida.x;
		int entidadDerechaX = entidad.xMundo + entidad.areaSolida.x + entidad.areaSolida.width;
		int entidadArribaY = entidad.yMundo + entidad.areaSolida.y;
		int entidadAbajoY = entidad.yMundo + entidad.areaSolida.y + entidad.areaSolida.height;

		int columnaIzquierda = entidadIzquierdaX / panelDeJuego.tamañoDeBaldosa;
		int columnaDerecha = entidadDerechaX / panelDeJuego.tamañoDeBaldosa;
		int filaArriba = entidadArribaY / panelDeJuego.tamañoDeBaldosa;
		int filaAbajo = entidadAbajoY / panelDeJuego.tamañoDeBaldosa;

		int numBaldosa1, numBaldosa2;

		switch(entidad.direccion) {
		//COLISION HACIA ARRIBA
		case "arriba":
			
			filaArriba = (entidadArribaY - entidad.velocidad) / panelDeJuego.tamañoDeBaldosa;
			numBaldosa1 = panelDeJuego.gestorDeBaldosas.mapaDeBaldosas[columnaIzquierda][filaArriba];
			numBaldosa2 = panelDeJuego.gestorDeBaldosas.mapaDeBaldosas[columnaDerecha][filaArriba];

			if(panelDeJuego.gestorDeBaldosas.baldosa[numBaldosa1].colision == true ||
			   panelDeJuego.gestorDeBaldosas.baldosa[numBaldosa2].colision == true) {
				entidad.colisionActivada = true;
			}
			break;
		//COLISION HACIA ABAJO
		case "abajo":
			
			filaAbajo = (entidadAbajoY + entidad.velocidad) / panelDeJuego.tamañoDeBaldosa;
			numBaldosa1 = panelDeJuego.gestorDeBaldosas.mapaDeBaldosas[columnaIzquierda][filaAbajo];
			numBaldosa2 = panelDeJuego.gestorDeBaldosas.mapaDeBaldosas[columnaDerecha][filaAbajo];
			
			if(panelDeJuego.gestorDeBaldosas.baldosa[numBaldosa1].colision == true ||
			   panelDeJuego.gestorDeBaldosas.baldosa[numBaldosa2].colision == true) {
				entidad.colisionActivada = true;
			}
			break;
		//COLISION HACIA LA IZQUIERDA
		case "izquierda":
			
			columnaIzquierda = (entidadIzquierdaX - entidad.velocidad) / panelDeJuego.tamañoDeBaldosa;
			numBaldosa1 = panelDeJuego.gestorDeBaldosas.mapaDeBaldosas[columnaIzquierda][filaArriba];
			numBaldosa2 = panelDeJuego.gestorDeBaldosas.mapaDeBaldosas[columnaIzquierda][filaAbajo];
			
			if(panelDeJuego.gestorDeBaldosas.baldosa[numBaldosa1].colision == true ||
			   panelDeJuego.gestorDeBaldosas.baldosa[numBaldosa2].colision == true) {
				entidad.colisionActivada = true;
			}
			break;
		//COLISION HACIA LA DERECHA
		case "derecha":
			
			columnaDerecha = (entidadDerechaX + entidad.velocidad) / panelDeJuego.tamañoDeBaldosa;
			numBaldosa1 = panelDeJuego.gestorDeBaldosas.mapaDeBaldosas[columnaDerecha][filaArriba];
			numBaldosa2 = panelDeJuego.gestorDeBaldosas.mapaDeBaldosas[columnaDerecha][filaAbajo];
			
			if(panelDeJuego.gestorDeBaldosas.baldosa[numBaldosa1].colision == true ||
			   panelDeJuego.gestorDeBaldosas.baldosa[numBaldosa2].colision == true) {
				entidad.colisionActivada = true;
			}
			break;

		}

	}

}
