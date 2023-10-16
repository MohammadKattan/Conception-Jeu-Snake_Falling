package Snake;

import java.awt.Color;

public class Fraise extends Obstacle {
	private Color color ;
	public Fraise() {
		color = Color.magenta;
	}

	public Color getColor() {
		return color;
	}
	/*reaction en cas de collusion avec snake 
	 dans le cas de collusion avec fraise le snake augumente d'un part 
	 en appelant  addPart() dans snake*/
	@Override
	public void colision(Snake snake) {
		int pos =snake.snakebody.get(0).getX()/ Grille.TAILLE_BLOC + Grille.N_BLOCS * (int) (snake.snakebody.get(0).getY() / Grille.TAILLE_BLOC);
		snake.addPart(pos);
		snake.setNombreVies(snake.getNombreVies()+1);
		
	}

}
