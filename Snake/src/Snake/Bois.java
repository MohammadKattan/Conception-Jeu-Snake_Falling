package Snake;

import java.awt.Color;

public class Bois extends Obstacle {
	private Color color ; 
	public Bois() {
		color = Color.orange;
	}
	public Color getColor() {
		return color;
	}
	/*reaction en cas de collusion avec snake 
	 dans le cas de collusion avec bois le snake descend vers la ligne suivante 
	 en appelant la addB() dans snake*/
	@Override
	public void colision(Snake snake) {
		SnakePart first = snake.snakebody.get(0);
		int last =snake.snakebody.size()-1;
		int posLast =snake.snakebody.get(last).getX()/ Grille.TAILLE_BLOC + Grille.N_BLOCS * (int) (snake.snakebody.get(last).getY() / Grille.TAILLE_BLOC);
		snake.addB(first, Grille.TAILLE_BLOC);
		snake.supPart(posLast);
		
	}

}
