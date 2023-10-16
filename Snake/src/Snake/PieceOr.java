package Snake;

import java.awt.Color;
import java.util.Random;

public class PieceOr extends Obstacle{
	private Color color ;
	public PieceOr() {
		color = Color.yellow;
	}
	public Color getColor() {
		return color;
	}
	/*reaction en cas de collusion avec snake 
	 dans le cas de collusion avec piecedor tout les obstacles se changent d'une mmanière random 
	 en appelant changerObstacle(Snake s)*/
	@Override
	public void colision(Snake snake) {
		changerObstacle( snake);
	}
	private void changerObstacle(Snake snake) {
    	Random random = new Random();
    	int int_rand = 70 ; 
    	int temps = -1;
    	int first = snake.snakebody.get(0).getY();
    	for (int i =first; i <Grille.donneesLabyrinthe.size()-Grille.N_BLOCS; i++) {
    		temps = random.nextInt(int_rand);
    		if(temps == 0&&i%Grille.N_BLOCS-1!=0&&i%Grille.N_BLOCS!=0)Grille.donneesLabyrinthe.get(i).setObstacle(new Bois());
    		else if (temps ==1||temps ==2 )Grille.donneesLabyrinthe.get(i).setObstacle(new Fraise());
    		else if(temps == 3)Grille.donneesLabyrinthe.get(i).setObstacle(new PieceOr());
    		else if(temps == 4)Grille.donneesLabyrinthe.get(i).setObstacle(new Myrtille());
    		else Grille.donneesLabyrinthe.get(i).setObstacle(null);
		}
    }

}
