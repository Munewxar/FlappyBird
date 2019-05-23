package com.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Bird {
    private static final int UP = 6;
    private static final float GRAVITY = -0.5f;
    private Texture birdImage;
    private Vector2 position;
    private float vy;
    private float gravity;

    public Bird() {
        birdImage = new Texture("bird.png");
        position = new Vector2(new Random().nextInt(150),
                new Random().nextInt(300) );
        vy = 0;
        gravity = GRAVITY;
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(birdImage, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            vy = UP;
        }

        vy += gravity;
        position.y += vy;
    }
}
