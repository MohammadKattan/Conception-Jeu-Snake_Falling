package Snake;


// classe case d'un plateau de jeu, chaque case peut contenir soit un sanke ou un canon ou un obstacle, soit plusieurs en meme temps 

public class Case {
	private boolean snake;
	private boolean canon;
	private Obstacle obstacle; 
	// constructeur des murs
	public Case() {
	}
	//constructeur des obstacles
	public Case(Obstacle obstacle) {
		super();
		this.obstacle = obstacle;	
	}
	//constructeur snake body
	public Case(boolean snake) {
		super();
		this.snake = snake;
	}
	// setters & getters 
	public boolean isContientObstacle() {
		return obstacle != null;
	}

	public boolean isSnake() {
		return snake;
	}
	public boolean isCanon() {
		return canon;
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public void setSnake(boolean snake) {
		this.snake = snake;
	}
	public void setCanon(boolean canon) {
		this.canon = canon;
	}
	

	
	
}
