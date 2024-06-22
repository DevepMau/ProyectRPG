package objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Llave extends ObjetoBase {

	public OBJ_Llave() {

		nombre = "Llave";
		try {
			imagen = ImageIO.read(getClass().getResourceAsStream("/objetos/object_key.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
