package com.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameController extends ApplicationAdapter {
	private SpriteBatch batch;
	private Background background;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
	}

	@Override
	public void render () {
		updateBackground();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.draw(batch);
		batch.end();
	}

	public void updateBackground() {
		background.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
