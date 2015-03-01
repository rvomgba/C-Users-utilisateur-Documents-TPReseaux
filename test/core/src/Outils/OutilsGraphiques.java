package Outils;
import com.badlogic.gdx.Gdx;


public class OutilsGraphiques {

	static public Point getPositionCurseur() {
		return new Point(
					(float)   Gdx.input.getX()
					,(float) (Gdx.graphics.getHeight() - Gdx.input.getY())
				);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
