package principal;

import objetos.OBJ_Llave;

public class InicializadorDeRecursos {

	PanelDeJuego panelDeJuego;

	public InicializadorDeRecursos(PanelDeJuego panelDeJuego) {
		this.panelDeJuego = panelDeJuego;
	}

	public void establecerObjetos() {

		panelDeJuego.obj[0] = new OBJ_Llave();
		panelDeJuego.obj[0].xMundo = 13 * panelDeJuego.tamañoDeBaldosa;
		panelDeJuego.obj[0].yMundo = 6 * panelDeJuego.tamañoDeBaldosa;
		panelDeJuego.obj[0].colision = true;


	}

}
