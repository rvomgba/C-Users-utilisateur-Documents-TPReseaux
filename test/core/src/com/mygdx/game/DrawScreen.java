package com.mygdx.game;

import java.io.IOException;
import java.util.ArrayList;

import Ihm.AfficheCercle;
import Outils.Point;
import ServeurClient.Client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class DrawScreen extends ApplicationAdapter {
	final static String adresseClientDraw = "127.0.0.2";
	final static int portClientDraw = 10667;
	
	private Client clientDessine;
	private ArrayList<Point> world;
	private AfficheCercle affCercle;
	
	
	ShapeRenderer shapeRenderer;	
	
	@Override
	public void create() {
		shapeRenderer = new ShapeRenderer();
		try {
			clientDessine = new Client(adresseClientDraw, portClientDraw);
			world = new ArrayList<Point>();
			affCercle = new AfficheCercle();
			affCercle.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void render() {
		
		try{
			final String s = clientDessine.litInfo();
			if(s!=""){
						// Test
				//System.out.println("CLIENT 2 A RECUE SON MESSAGE (YEAH)");
				//System.out.println("MESSAGE RECU DANS CLIENT 2 : "+s);
				
				
				final Point p = new Point(s);
				//world.addCercle(p);
				world.add(p);
			}
		}
		catch(Exception e){
			System.out.println("main client"+e);
		}
		
		Gdx.graphics.getGL20().glClearColor(0, 1, 1, 1);
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		if(world.size()>0){
			affCercle.begin();
			for(int i=0; i<world.size(); i++){
				affCercle.affiche(world.get(i));
			}
			affCercle.end();
		}
	}
}
