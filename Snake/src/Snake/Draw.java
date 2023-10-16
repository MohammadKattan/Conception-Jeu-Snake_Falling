package Snake;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Draw {

	public Draw() {
		// TODO Auto-generated constructor stub
	}
	//dessine les bullets , elle utilise les coordonnées des bullets
	public void dessinerBullet(Graphics2D g,Bullet bullet) {
        g.setColor(Color.pink);
        for (int i = 0; i < bullet.bullets.size(); i++) {
        	g.fillOval(bullet.bullets.get(i).getX() ,bullet.bullets.get(i).getY() , 5, 15);
		}
    }
	//déssine les bords du grille en appelant les fonctions dessinerLines() et dessinerObstacle() pour les obstacles 
	public void dessinerGrille(Graphics2D g2d) {
    	dessinerLines(g2d);
    	dessinerObstacle(g2d);
    }
    public void dessinerLines(Graphics2D g2d) {
    	int N_BLOCS = Grille.N_BLOCS;
    	int TAILLE_BLOC = Grille.TAILLE_BLOC;
    	g2d.setColor(Color.cyan);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(0, 0, 0, N_BLOCS* TAILLE_BLOC);
        g2d.drawLine(0, 0, N_BLOCS* TAILLE_BLOC , 0);
        g2d.drawLine(N_BLOCS* TAILLE_BLOC, 0,N_BLOCS* TAILLE_BLOC, N_BLOCS* TAILLE_BLOC);
        g2d.drawLine(0, N_BLOCS* TAILLE_BLOC, N_BLOCS* TAILLE_BLOC, N_BLOCS* TAILLE_BLOC);
    }
    // dessine le snake , si le snake est invisible il a le couleur rouge sinon jaune 
	 public void dessinerSnake(Graphics2D g,Snake snake) {
    	if(snake.getInvisible()>0) {
    		g.setColor(Color.red);
			snake.setInvisible(snake.getInvisible()-1);
		}
    	else g.setColor(Color.yellow);
        for (int i = 0; i < snake.snakebody.size(); i++) {
        	g.fillOval(snake.snakebody.get(i).getX() ,snake.snakebody.get(i).getY() , Grille.TAILLE_BLOC, Grille.TAILLE_BLOC);
		}
    }
	 //pour dessiner le canon
	 public void dessinerCanon(Graphics2D g,Canon canon) {
    	 g.setColor(Color.blue);
    	g.fillRect(canon.getX(), canon.getY(), Grille.TAILLE_BLOC, Grille.TAILLE_BLOC);
    	
    }
	 //dessiner les differents obstacles en fonction de leur couleur 
	 public void dessinerObstacle(Graphics2D g2d) {
	    	int i =0; 
	        for (int y = 0; y < Grille.TAILLE_LABYRINTHE; y += Grille.TAILLE_BLOC) {
	            for (int x = 0; x < Grille.TAILLE_LABYRINTHE; x += Grille.TAILLE_BLOC) {
	                if (Grille.donneesLabyrinthe.get(i).isContientObstacle()) {
	                    g2d.setColor(Grille.donneesLabyrinthe.get(i).getObstacle().getColor());
	                    g2d.fillRect(x + Grille.N_BLOCS/2, y +  Grille.N_BLOCS/2, 10, 10);
	                }
	                i++;
	            }
	        }
	    }
	//dessiner score snake pour comparer le nombre de vie de snake avec la taille du snake , ils doivent etre egaus tout le temps
	   public void dessinerScore(Graphics2D g,Snake snake) {	
	        String snakeScore;
	        String snakeBody ; 
	        //dessiner snake score
	        g.setColor(new Color(96, 128, 255));
	        snakeScore= "Snake Score: " + snake.getNombreVies();
	        g.drawString(snakeScore, Grille.TAILLE_LABYRINTHE / 2 + 90, Grille.TAILLE_LABYRINTHE + 16);
	        //dessiner snake body
	        g.setColor(new Color(96, 128, 255));
	        snakeBody = "Snake body: " + snake.snakebody.size();
	        g.drawString(snakeBody, Grille.TAILLE_LABYRINTHE / 2 - 70, Grille.TAILLE_LABYRINTHE + 16);
	        
	    }

}
