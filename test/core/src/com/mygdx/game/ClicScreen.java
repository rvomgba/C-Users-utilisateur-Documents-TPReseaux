package com.mygdx.game;

import java.io.IOException;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import Outils.OutilsGraphiques;
import Outils.Point;
import ServeurClient.Client;

public class ClicScreen extends ApplicationAdapter {
	final static String adresseClientClic = "127.0.0.1";
	final static int portClientClic = 10666;

	private Client clientClic;
	
	ShapeRenderer shapeRenderer;
	
	@Override
	public void create() {
		
		shapeRenderer = new ShapeRenderer();
		try {
			clientClic = new Client(adresseClientClic, portClientClic);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void render() {
	
		Gdx.graphics.getGL20().glClearColor(0, 1, 0, 1);
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		final Point position = OutilsGraphiques.getPositionCurseur();
		Gdx.input.setInputProcessor(new InputAdapter() {
			public boolean touchDown(int x, int y, int pointer, int button) {
				if (button == Input.Buttons.LEFT) {
					try {
						clientClic.envoiInfo(position.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return true;
			}
		});
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
