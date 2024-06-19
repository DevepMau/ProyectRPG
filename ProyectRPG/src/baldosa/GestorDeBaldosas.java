package baldosa;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import principal.PanelDeJuego;

public class GestorDeBaldosas {

	PanelDeJuego panelDeJuego;
	Baldosa[] baldosa;
	int mapaDeBaldosas[][];

	public GestorDeBaldosas(PanelDeJuego panelDeJuego) {

		this.panelDeJuego = panelDeJuego;
		baldosa = new Baldosa[10];
		mapaDeBaldosas = new int[panelDeJuego.maxColDeMundo][panelDeJuego.maxFilaDeMundo];
		obtenerImagenDeBaldosa();
		cargarMapa("/mapas/mapa00.txt");
	}

	public void obtenerImagenDeBaldosa() {

		try {

			baldosa[0] = new Baldosa();
			baldosa[0].imagen = ImageIO.read(getClass().getResourceAsStream("/baldosas/tiles_grass.png"));

			baldosa[1] = new Baldosa();
			baldosa[1].imagen = ImageIO.read(getClass().getResourceAsStream("/baldosas/tiles_water.png"));

			baldosa[2] = new Baldosa();
			baldosa[2].imagen = ImageIO.read(getClass().getResourceAsStream("/baldosas/tiles_brick.png"));

		}catch(IOException e) {
			e.printStackTrace();
		}

	}

	public void cargarMapa(String rutaArchivo) {

		try {

			InputStream is = getClass().getResourceAsStream(rutaArchivo);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int fil = 0;

			while(col < panelDeJuego.maxColDeMundo && fil < panelDeJuego.maxFilaDeMundo) {

				String linea = br.readLine();
				
				while(col < panelDeJuego.maxColDeMundo) {
					String numeros[] = linea.split(" ");

					int num = Integer.parseInt(numeros[col]);

					mapaDeBaldosas[col][fil] = num;
					col++;
				}
				if(col == panelDeJuego.maxColDeMundo) {
					col = 0;
					fil++;
				}
			}
			br.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void dibujar(Graphics2D g2) {

		int colDeMundo = 0;
		int filaDeMundo = 0;

		while(colDeMundo < panelDeJuego.maxColDeMundo && filaDeMundo < panelDeJuego.maxFilaDeMundo) {

			int numeroDeBaldosa = mapaDeBaldosas[colDeMundo][filaDeMundo];

			int xMundo = colDeMundo * panelDeJuego.tamañoDeBaldosa;
			int yMundo = filaDeMundo * panelDeJuego.tamañoDeBaldosa;
			int xPantalla = xMundo - panelDeJuego.jugador.xMundial + panelDeJuego.jugador.xPantalla;
			int yPantalla = yMundo - panelDeJuego.jugador.yMundial + panelDeJuego.jugador.yPantalla;

			if(xMundo + panelDeJuego.tamañoDeBaldosa > panelDeJuego.jugador.xMundial - panelDeJuego.jugador.xPantalla &&
			   xMundo - panelDeJuego.tamañoDeBaldosa < panelDeJuego.jugador.xMundial + panelDeJuego.jugador.xPantalla &&
			   yMundo + panelDeJuego.tamañoDeBaldosa > panelDeJuego.jugador.yMundial - panelDeJuego.jugador.yPantalla &&
			   yMundo - (panelDeJuego.tamañoDeBaldosa + (panelDeJuego.tamañoDeBaldosa/2)) < panelDeJuego.jugador.yMundial + panelDeJuego.jugador.yPantalla) {

				g2.drawImage(baldosa[numeroDeBaldosa].imagen, xPantalla, yPantalla, panelDeJuego.tamañoDeBaldosa, panelDeJuego.tamañoDeBaldosa, null);

			}

			colDeMundo ++;

			if(colDeMundo == panelDeJuego.maxColDeMundo) {
				colDeMundo = 0;
				filaDeMundo++;
			}

		}

	}

}
