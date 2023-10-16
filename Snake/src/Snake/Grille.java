 package Snake;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
/*le grille contient : 
                      Dimensiion 
                      etat de jeu (true flase)
                      Taille_Bloc qui represente la taille de case
                      N_Bloc le nombre de case dans chaque ligne
                      un Snake 
                      un Canon
                      des Bullets
                      donnesLabryrinthe pour répresenter les cases du grille
                      un Timer*/
public class Grille extends JPanel implements ActionListener,KeyListener{
	// dimention du plateau
    private Dimension d;
    // etat du jeu / fin de jeu
    private boolean enJeu = false;
    // données des bloc de plateau
    static final int TAILLE_BLOC = 24;
    static final int N_BLOCS = 15;		 
    static final int TAILLE_LABYRINTHE = N_BLOCS * TAILLE_BLOC;
	private Snake snake;
	private Canon canon;
	private Bullet bullet;
	private Draw draw ; 
	static ArrayList<Case> donneesLabyrinthe;    
	private Timer timerMouvements; // timer des animation de mouvements 
	// constructeur plateau 
	public Grille() {
        initVariables();
        initGrille();
    }
	//pour initialiser les données 
    private void initVariables() {
        d = new Dimension(400, 400);
        donneesLabyrinthe = new ArrayList<Case>();
        snake = new Snake();
        canon = new Canon();
        bullet = new Bullet();
        draw = new Draw() ;
        // timer pour l'animation des mouvement 
        timerMouvements = new Timer(100, this);
        timerMouvements.start();
    }
   
    private void initGrille() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setBackground(Color.gray);
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        enJeu = true;
        initLabyrinthe();
    }
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessiner(g);
    }
    // Ajouter les obstacles dans la grille
    private void initLabyrinthe() {
    	changerObstacle();
    }
    public void changerObstacle() {
    	Random random = new Random();
    	int int_rand = 70 ; 
    	int temps = -1;
    	int i = 0;
    	int first = snake.snakebody.get(0).getY();
    	Obstacle fraise = new Fraise();
        Obstacle pieceOr = new PieceOr(); 
        Obstacle bois = new Bois();
        Obstacle myrtille = new Myrtille();
    	for(int x=0 ;x<N_BLOCS;x++) {
        	for(int y=first ;y<N_BLOCS;y++) {
        		donneesLabyrinthe.add( new Case());  	
        		temps = random.nextInt(int_rand);
        		if(i>2 && i<N_BLOCS*(N_BLOCS-1)) {
	        		if((temps == 0 &&(i%N_BLOCS-14!=0&&i%N_BLOCS!=0)))donneesLabyrinthe.get(i).setObstacle(bois);
	        		else if (temps ==1||temps ==2 )donneesLabyrinthe.get(i).setObstacle(fraise);
	        		else if(temps == 3)donneesLabyrinthe.get(i).setObstacle(pieceOr);
	        		else if(temps == 4)donneesLabyrinthe.get(i).setObstacle(myrtille);
        			}
        		i++;
        	}
        }
    }
  //Dessiner le jeu
  	   
      private void dessiner(Graphics g) {
          Graphics2D g2d = (Graphics2D) g;
          g2d.fillRect(0, 0, d.width, d.height);
          draw.dessinerGrille(g2d);
          draw.dessinerScore(g2d,snake);
          if (enJeu) {
              lancerJeu(g2d);
          }
          Toolkit.getDefaultToolkit().sync();
          g2d.dispose();
      }
    // lancer le jeu en passant le dessin vers l'objet graphic2D
    private void lancerJeu(Graphics2D g2d) {
    	draw.dessinerSnake(g2d , snake);
        draw.dessinerCanon(g2d,canon);
        draw.dessinerBullet(g2d,bullet);
    	if(snake.snakebody.get(0).getY()== (N_BLOCS-1)*TAILLE_BLOC) {
    		mourir();
    	}
    }
    //fin de jeu en arretant le timer
    private void mourir() {
    	timerMouvements.stop();
        Main.finJeu(0);
    }
    //les trois sont utilisées pour le mouvement le canon en utilisant l'interface KEyListener
    @Override
    public void actionPerformed(ActionEvent e) {
    	canon.bougerCanon();
    	bullet.bougerBullet(snake);
    	snake.bougerSnake();
    repaint();
    }
   
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (enJeu) {
            if (key == KeyEvent.VK_LEFT) {
                canon.req_dx = -1;
            } else if (key == KeyEvent.VK_RIGHT) {
                canon.req_dx = 1;
            }else if(key ==KeyEvent.VK_SPACE) {
            	bullet.bullets.add(new BulletPart(canon.getX()+11,canon.getY()));
            }
        }
    }  
    @Override
    public void keyReleased(KeyEvent e) {
    	canon.req_dx = 0;
    }
    @Override
    public void keyTyped(KeyEvent e) {} 
}