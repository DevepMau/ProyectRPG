package principal;

import entidades.Entidad;

public class ComprobadorDeColisiones {

	PanelDeJuego panelDeJuego;

	public ComprobadorDeColisiones(PanelDeJuego panelDeJuego) {
		this.panelDeJuego = panelDeJuego;
	}

	public void verificarBaldosa(Entidad entidad) {

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
	
	public int verificarObjeto(Entidad entidad, boolean jugador) {

	    int indice = 999;

	    for (int i = 0; i < panelDeJuego.obj.length; i++) {

	        if (panelDeJuego.obj[i] != null) {

	            // Obtener la posición del área sólida de la entidad
	            entidad.areaSolida.x = entidad.xMundo + entidad.areaSolida.x;
	            entidad.areaSolida.y = entidad.yMundo + entidad.areaSolida.y;
	            // Obtener la posición del área sólida del objeto
	            panelDeJuego.obj[i].areaSolida.x = panelDeJuego.obj[i].xMundo + panelDeJuego.obj[i].areaSolida.x;
	            panelDeJuego.obj[i].areaSolida.y = panelDeJuego.obj[i].yMundo + panelDeJuego.obj[i].areaSolida.y;

	            switch (entidad.direccion) {
	                case "arriba":
	                    entidad.areaSolida.y -= entidad.velocidad;
	                    if (entidad.areaSolida.intersects(panelDeJuego.obj[i].areaSolida)) {
	                        if (panelDeJuego.obj[i].colision == true) {
	                            entidad.colisionActivada = true;
	                        }
	                        if (jugador == true) {
	                            indice = i;
	                        }
	                    }
	                    break;
	                case "abajo":
	                    entidad.areaSolida.y += entidad.velocidad;
	                    if (entidad.areaSolida.intersects(panelDeJuego.obj[i].areaSolida)) {
	                        if (panelDeJuego.obj[i].colision == true) {
	                            entidad.colisionActivada = true;
	                        }
	                        if (jugador == true) {
	                            indice = i;
	                        }
	                    }
	                    break;
	                case "izquierda":
	                    entidad.areaSolida.x -= entidad.velocidad;
	                    if (entidad.areaSolida.intersects(panelDeJuego.obj[i].areaSolida)) {
	                        if (panelDeJuego.obj[i].colision == true) {
	                            entidad.colisionActivada = true;
	                        }
	                        if (jugador == true) {
	                            indice = i;
	                        }
	                    }
	                    break;
	                case "derecha":
	                    entidad.areaSolida.x += entidad.velocidad;
	                    if (entidad.areaSolida.intersects(panelDeJuego.obj[i].areaSolida)) {
	                        if (panelDeJuego.obj[i].colision == true) {
	                            entidad.colisionActivada = true;
	                        }
	                        if (jugador == true) {
	                            indice = i;
	                        }
	                    }
	                    break;
	            }

	            // Restaurar las posiciones predeterminadas del área sólida de la entidad y del objeto
	            entidad.areaSolida.x = entidad.areaSolidaPredeterminadaX;
	            entidad.areaSolida.y = entidad.areaSolidaPredeterminadaY;
	            panelDeJuego.obj[i].areaSolida.x = panelDeJuego.obj[i].areaSolidaPredeterminadaX;
	            panelDeJuego.obj[i].areaSolida.y = panelDeJuego.obj[i].areaSolidaPredeterminadaY;

	        }

	    }

	    return indice;

	}


}
