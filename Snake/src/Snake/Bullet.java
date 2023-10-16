package Snake;


import java.util.ArrayList;

public class Bullet {
	//elle prend un ArrayList de coordonnée récuppérer de BulletPart
	public  ArrayList<BulletPart> bullets;
	
	public Bullet() {
		super();
		this.bullets = new ArrayList<BulletPart>();
	}
	
	
	public ArrayList<BulletPart> getBullets() {
		return bullets;
	}
	public void setBullets(ArrayList<BulletPart> bullets) {
		this.bullets = bullets;
	}
	//ca definie le mouvement de bullets verticallement , le depart et le coordonnée de cannon en modifiant le y
	public void bougerBullet(Snake snake) {
    	int pos ; 
    	for (int i = 0; i < this.bullets.size(); i++) {	
    		if(this.bullets.get(i).getY()!=0) {
    			this.bullets.get(i).setY(this.bullets.get(i).getY()-Grille.TAILLE_BLOC);
    			pos=this.bullets.get(i).getX()/ Grille.TAILLE_BLOC + Grille.N_BLOCS * (int) (this.bullets.get(i).getY() / Grille.TAILLE_BLOC);
    			if(Grille.donneesLabyrinthe.get(pos).getObstacle()!=null) {
    				Grille.donneesLabyrinthe.get(pos).setObstacle(null);
    				this.bullets.remove(i);
    			}
    			if(snake.getInvisible()==0) {
    			if(Grille.donneesLabyrinthe.get(pos).isSnake()) {
    				snake.setNombreVies(snake.getNombreVies()-1);
    				snake.snakebody.remove(snake.snakebody.size()-1);
    				this.bullets.remove(i);
    			}
    			if(snake.getNombreVies()==0) {
    				Main.finJeu(1);
    			}
    			}	
    			
    		}else {
    			this.bullets.remove(i);
    		}
    	
    	}
    }
	
}

