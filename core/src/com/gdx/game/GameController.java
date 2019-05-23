package com.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameController extends ApplicationAdapter {
	private SpriteBatch spriteBatch;
	private Background background;
	private Bird bird;
	private Obstacles obstacles;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		background = new Background();
		bird = new Bird();
		obstacles = new Obstacles();
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		background.draw(spriteBatch);
		bird.draw(spriteBatch);
		obstacles.draw(spriteBatch);
		spriteBatch.end();
	}

	public void update() {
		background.update();
		bird.update();
		obstacles.update();
	}

	@Override
	public void dispose () {
		spriteBatch.dispose();
	}
}
