package Snake;
public class  Canon{
    private int x, y;
    public int req_dx;
    public Canon() {
    	//le canon est dans le mileu da la grille au moment de lancement du jeu
		x= (Grille.N_BLOCS/2*Grille.TAILLE_BLOC);
       y = ((Grille.N_BLOCS-1)*Grille.TAILLE_BLOC);
        req_dx = 0;
    }
	// setters & getters 
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	//le canon se deplace d'une manière horyzentale au bas du grille
	public void bougerCanon() {
    	if(this.req_dx !=0) {
    		if ((this.req_dx == -1 && this.x!=0)) {
    			this.x=(this.x-Grille.TAILLE_BLOC);
    		}else if(this.req_dx == 1 &&this.x!=(Grille.N_BLOCS-1)*(Grille.TAILLE_BLOC)) {
    			this.x = (this.x+Grille.TAILLE_BLOC);
    		}
    	}
    }
	
	
	
}
