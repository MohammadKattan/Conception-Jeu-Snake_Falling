package Snake;

import java.util.ArrayList;


public class  Snake{
	// classe Snake ayant , ArrayList des positions, nombre de vies et un direction,un etat invisible 
	private int invisible ; 
    private int nombreVies ;
    public ArrayList<SnakePart> snakebody;   
    private int dirction ; 
    
    
    // constructeur Snake
    public Snake() {
		super();
		this.nombreVies=3;
		this.invisible =0;
		this.snakebody = new  ArrayList<SnakePart>() ;
		for(int i = 0 ; i<this.nombreVies ; i++) {
			this.snakebody.add(new SnakePart((this.nombreVies-1-i)*Grille.TAILLE_BLOC,0));
		}
		this.dirction = 1 ; 
		
    }
	public int getDirction() {
		return dirction;
	}
	public void setDirction(int dirction) {
		this.dirction = dirction;
	}
	public int getInvisible() {
		return invisible;
	}
	public void setInvisible(int invisible) {
		this.invisible = invisible;
	}
	public int getNombreVies() {
		return nombreVies;
	}
	public void setNombreVies(int nombreVies) {
		this.nombreVies = nombreVies;
	}

	//le mouvement de snake est definie par ajouter un morceau au bébut du snake et en suprimant un morceau de la fin en 
	// en appelant addPart() et supPart()
	public void bougerSnake() {
		int TAILLE_BLOC = Grille.TAILLE_BLOC;
		int N_BLOCS = Grille.N_BLOCS;
    	int pos =this.snakebody.get(0).getX()/ TAILLE_BLOC + N_BLOCS * (int) (this.snakebody.get(0).getY() / TAILLE_BLOC);
    	int last =this.snakebody.size()-1;
    	int posLast =this.snakebody.get(last).getX()/ TAILLE_BLOC + N_BLOCS * (int) (this.snakebody.get(last).getY() / TAILLE_BLOC);
    	addPart(pos);
    	supPart(posLast);
    	
    	if(Grille.donneesLabyrinthe.get(pos).isContientObstacle()) {
    		Grille.donneesLabyrinthe.get(pos).getObstacle().colision(this);
    		Grille.donneesLabyrinthe.get(pos).setObstacle(null);
    	}
    }
	//ajjjouter un morceau en fonction de son direction en appelant addG() ou addB() ou addD()
	public void addPart(int pos) {
		int TAILLE_BLOC = Grille.TAILLE_BLOC;
		int N_BLOCS = Grille.N_BLOCS;
    	SnakePart first =this.snakebody.get(0);
    	Grille.donneesLabyrinthe.get(pos).setSnake(true);
    	if(this.getDirction()==1&&first.getX()!=(N_BLOCS-1)*TAILLE_BLOC) addD(first, TAILLE_BLOC, N_BLOCS);
    	else if(this.getDirction()==-1&&first.getX()!=0) addG(first, TAILLE_BLOC, N_BLOCS);
    	else addB(first,TAILLE_BLOC);
    	
    }
	// ajjouter un morceau a droite si le snake se deplace vers la droite 
    public void addD(SnakePart first,int TAILLE_BLOC,int N_BLOCS) {
    	this.snakebody.add(0,new SnakePart(first.getX()+TAILLE_BLOC ,first.getY()));
    }
    //ajjouter un morceau à gauche si le snake deplace vers le gauche 
    public void addG(SnakePart first,int TAILLE_BLOC,int N_BLOCS) {
    	this.snakebody.add(0,new SnakePart(first.getX()-TAILLE_BLOC ,first.getY()));
    }
    //ajouter un morceau un morceau au snake sur la ligne suinvante, on as utiliser aussi dans le cas de collusion avec bois 
    public void addB(SnakePart first,int TAILLE_BLOC) {
    	this.snakebody.add(0,new SnakePart(first.getX() ,first.getY()+TAILLE_BLOC));
    	this.setDirction(this.getDirction()*(-1));
    }
    //il permet de suprimer le dernier morceau du snake 
    public void supPart(int posLast) {
    	Grille.donneesLabyrinthe.get(posLast).setSnake(false);
    	this.snakebody.remove(this.snakebody.size()-1);
    	
    }
}