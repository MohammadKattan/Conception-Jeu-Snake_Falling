package Snake;

import java.awt.Color;
// une classe abstract qui contient deux methodes abstract getColor() et colision()
public abstract class Obstacle {

	protected abstract Color getColor();
	public abstract void colision(Snake snkae);

}
