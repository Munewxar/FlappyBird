package com.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameController extends ApplicationAdapter {
	private SpriteBatch spriteBatch;
	private Background background;
	private Bird bird;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		background = new Background();
		bird = new Bird();
	}

	@Override
	public void render () {
		updateBackground();
		updateBird();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		background.draw(spriteBatch);
		bird.draw(spriteBatch);
		spriteBatch.end();
	}

	public void updateBackground() {
		background.update();
	}

	public void updateBird() {
		bird.update();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
	}
}
