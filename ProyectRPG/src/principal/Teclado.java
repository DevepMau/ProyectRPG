package principal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	public boolean W, S, A, D;

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