package principal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	PanelDeJuego pdj;
	public boolean W, S, A, D;
	//DEBUG
	boolean comprobarTiempoDeDibujado = false;
	
	public Teclado(PanelDeJuego pdj) {
		this.pdj = pdj;
	}

	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int codigo = e.getKeyCode();
		//MODO JUEGO
		if(pdj.estadoDeJuego == pdj.modoJuego) {
			
			if(codigo == KeyEvent.VK_W) {
				W = true;
			}
			if(codigo == KeyEvent.VK_S) {
				S = true;
			}
			if(codigo == KeyEvent.VK_A) {
				A = true;
			}
			if(codigo == KeyEvent.VK_D) {
				D = true;
			}
			if(codigo == KeyEvent.VK_P) {
				if(pdj.estadoDeJuego == pdj.modoJuego) {
					pdj.estadoDeJuego = pdj.modoPausa;
				}
			}
			//MODO DEBUG
			if(codigo == KeyEvent.VK_T) {
				if(comprobarTiempoDeDibujado == false) {
					comprobarTiempoDeDibujado = true;
				}
				else if(comprobarTiempoDeDibujado == true) {
					comprobarTiempoDeDibujado = false;
				}
			}
		}
		//MODO PAUSA
		else if(pdj.estadoDeJuego == pdj.modoPausa) {
			if(codigo == KeyEvent.VK_P) {
				pdj.estadoDeJuego = pdj.modoJuego;
			}
		}
		//MODO DIALOGO
		else if(pdj.estadoDeJuego == pdj.modoDialogo) {
			if(codigo == KeyEvent.VK_ENTER) {
				pdj.estadoDeJuego = pdj.modoJuego;
			}
		}
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int codigo = e.getKeyCode();

		if(codigo == KeyEvent.VK_W) {
			W = false;
		}
		if(codigo == KeyEvent.VK_S) {
			S = false;
		}
		if(codigo == KeyEvent.VK_A) {
			A = false;
		}
		if(codigo == KeyEvent.VK_D) {
			D = false;
		}

	}

}