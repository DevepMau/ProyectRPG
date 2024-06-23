package principal;

import objetos.OBJ_Llave;

public class InicializadorDeRecursos {

	PanelDeJuego pdj;

	public InicializadorDeRecursos(PanelDeJuego pdj) {
		this.pdj = pdj;
	}

	public void establecerObjetos() {

		pdj.obj[0] = new OBJ_Llave(pdj);
		pdj.obj[0].xMundo = 13 * pdj.tamañoDeBaldosa;
		pdj.obj[0].yMundo = 6 * pdj.tamañoDeBaldosa;
		pdj.obj[0].colision = true;


	}

}
