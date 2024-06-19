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
	int numMapaBaldosa[][];

	public GestorDeBaldosas(PanelDeJuego panelDeJuego) {

		this.panelDeJuego = panelDeJuego;
		baldosa = new Baldosa[10];
		numMapaBaldosa = new int[panelDeJuego.maxColDePantalla][panelDeJuego.maxFilaDePantalla];
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

			while(col < panelDeJuego.maxColDePantalla && fil < panelDeJuego.maxFilaDePantalla) {

				String linea = br.readLine();

				while(col < panelDeJuego.maxColDePantalla) {
					String numeros[] = linea.split(" ");

					int num = Integer.parseInt(numeros[col]);

					numMapaBaldosa[col][fil] = num;
					col++;
				}
				if(col == panelDeJuego.maxColDePantalla) {
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

		int col = 0;
		int fil = 0;
		int x = 0;
		int y = 0;

		while(col < panelDeJuego.maxColDePantalla && fil < panelDeJuego.maxFilaDePantalla) {

			int numBaldosa = numMapaBaldosa[col][fil];

			g2.drawImage(baldosa[numBaldosa].imagen, x, y, panelDeJuego.tamañoDeTile, panelDeJuego.tamañoDeTile, null);
			col++;
			x += panelDeJuego.tamañoDeTile;

			if(col == panelDeJuego.maxColDePantalla) {
				col = 0;
				x = 0;
				fil++;
				y += panelDeJuego.tamañoDeTile;
			}

		}

	}

}
