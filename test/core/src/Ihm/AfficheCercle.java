package Ihm;

import Outils.Point;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class AfficheCercle {
	
	private ShapeRenderer shapeRenderer;
	
	public void init()
	{
		this.shapeRenderer  = new ShapeRenderer();
	}
	
	public void begin() {
		this.shapeRenderer.begin(ShapeType.Filled);
	}
	
	public void end() {
		this.shapeRenderer.end();
	}
	
	public void affiche(final Point pt) {
        this.shapeRenderer.setColor(1, 0, 0, 1);
		this.shapeRenderer.circle(pt.getX(), pt.getY(), 4);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
