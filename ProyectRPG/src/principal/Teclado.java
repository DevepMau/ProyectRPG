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
			else if(pdj.estadoDeJuego == pdj.modoPausa) {
				pdj.estadoDeJuego = pdj.modoJuego;
			}
		}
		if(codigo == KeyEvent.VK_T) {
			if(comprobarTiempoDeDibujado == false) {
				comprobarTiempoDeDibujado = true;
			}
			else if(comprobarTiempoDeDibujado == true) {
				comprobarTiempoDeDibujado = false;
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