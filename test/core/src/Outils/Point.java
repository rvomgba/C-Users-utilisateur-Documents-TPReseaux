package Outils;

import java.util.Random;

public class Point  {
	private float x ;
	private float y ;
	private final static String separateur = "-_-_-" ;
	private final static int xMin = 1 ;
	private final static int yMin = 1 ;
	private final static int xMax = 500 ;
	private final static int yMax = 340 ;
	public Point() {
		Random rd = new Random();
		x = rd.nextInt(xMax)+xMin ; 
		y = rd.nextInt(yMax)+yMin ; 
	}
	
	public Point(final String s) {
		System.out.println("string s : "+s);
		String[] tab = s.split(separateur) ;
		System.out.println("x : "+tab[0]+" ----- y : "+tab[1]);
		x = Float.valueOf(tab[0])  ;
		y = Float.valueOf(tab[1])  ;
	}
	
	public Point(final float _x, final float _y) {
		x = _x ;
		y = _y ;
	}
	
	public String toString() {
		return (x+separateur+y+separateur);
	}
	
	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
	
}
