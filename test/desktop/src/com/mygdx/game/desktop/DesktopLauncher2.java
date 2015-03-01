package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.DrawScreen;

/*
IMPORTANT LANCER LA CLASSE SERVEUR EN PREMI7RE

*/

public class DesktopLauncher2 {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new DrawScreen(), config);
	}
}
