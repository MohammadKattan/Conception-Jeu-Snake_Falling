  package Snake;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
// classe principale, qui lance un jeu 
public class Main extends JFrame {
    private static Main fenetre;
    
	public Main() {
        initUI();
    }
	// créer une fenetre du jeu
    protected void initUI() {
        add(new Grille());
        setTitle("Snake");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 420);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            fenetre = new Main();
            fenetre.setVisible(true);
        });
    }
    //afficher la fenetre de fin jeu 
	public static void finJeu(int x) {
		int dialogResult ; 
		// TODO : fin du jeu 
		if(x==0) {
			dialogResult = JOptionPane.showConfirmDialog (null, "Vous avez perdu, Envie de rejouer?");
		}else {
			dialogResult = JOptionPane.showConfirmDialog (null, "Super vous avez gagnée, Envie de rejouer?");
		}
    	
    	if(dialogResult == JOptionPane.YES_OPTION){
    		System.exit(0);
    	}else {
    		System.exit(0);
    	}
	}
}

