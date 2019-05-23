package com.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// TODO: Count score
// TODO: Refactor code

public class GameController extends ApplicationAdapter {
	private static final int RESTART_IMAGE_X_COORDINATE = 200;
	private static final int RESTART_IMAGE_Y_COORDINATE = 200;
	private static final int OBSTACLE_LENGTH = 50;
	private static final int SCREEN_BEGIN = 0;
	private static final int SCREEN_END = 600;
	private SpriteBatch spriteBatch;
	private Background background;
	private Bird bird;
	private Obstacles obstacles;
	private boolean gameOver;
	private Texture restartImage;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		background = new Background();
		bird = new Bird();
		obstacles = new Obstacles();
		gameOver = false;
		restartImage = new Texture("RestartBtn.png");
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		background.draw(spriteBatch);
		obstacles.draw(spriteBatch);

		if (!gameOver) {
			bird.draw(spriteBatch);
		} else {
			spriteBatch.draw(restartImage,
					RESTART_IMAGE_X_COORDINATE,
					RESTART_IMAGE_Y_COORDINATE);
		}

		spriteBatch.end();
	}

	public void update() {
		background.update();
		bird.update();
		obstacles.update();

		for (int i = 0; i < Obstacles.obstacles.length; i++) {
			if (bird.position.x > Obstacles.obstacles[i].position.x &&
					bird.position.x < Obstacles.obstacles[i].position.x + OBSTACLE_LENGTH) {
				if (!Obstacles.obstacles[i].emptySpace.contains(bird.position)) {
					gameOver = true;
				}
			}
		}

		if (bird.position.y < SCREEN_BEGIN || bird.position.y > SCREEN_END) {
			gameOver = true;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver) {
			reCreate();
		}
	}

	public void reCreate() {
		bird.reCreate();
		obstacles.reCreate();
		gameOver = false;
	}

	@Override
	public void dispose () {
		spriteBatch.dispose();
	}
}
