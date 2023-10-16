package Snake;

import java.awt.Color;

public class Myrtille extends Obstacle {
	private Color color ; 
	public Myrtille() {
		color = Color.blue;
	}
	public Color getColor() {
		return color;
	}
	/*reaction en cas de collusion avec snake 
	 dans le cas de collusion avec myrtille le snake devient invisible pendant 15 step */
	@Override
	public void colision(Snake snake) {
		snake.setInvisible(15);
	}

}
