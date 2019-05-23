package com.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles {

    class WallPair{
        private static final int SCREEN_BEGIN = -50;
        private static final int SCREEN_END = 800;
        private static final int EMPTY_SPACE_START = 300;
        private static final int SPRITE_WIDTH = 50;
        Vector2 position;
        private float speed;
        private int offset;
        Rectangle emptySpace;


        public WallPair(Vector2 position) {
            this.position = position;
            speed = 2;
            offset = new Random().nextInt(250);
            emptySpace = new Rectangle(position.x,
                    position.y - offset + EMPTY_SPACE_START,
                    SPRITE_WIDTH, BETWEEN);
        }

        public void update() {
            position.x -= speed;

            if (position.x < SCREEN_BEGIN) {
                position.x = SCREEN_END;
                offset = new Random().nextInt(250);
            }

            emptySpace.x = position.x;
        }
    }

    static WallPair[] obstacles;
    private Texture wallImage;
    private final static int BETWEEN = 250;

    public Obstacles() {
        obstacles = new WallPair[4];
        wallImage = new Texture("wall.png");

        initializeObs();
    }

    private void initializeObs() {
        int length = obstacles.length;
        int startPosition = 400;
        int distance = 220;

        for (int i = 0; i < length; i++) {
            obstacles[i] = new WallPair(new Vector2(startPosition, 0));
            startPosition += distance;
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        int length = obstacles.length;
        for (int i = 0; i < length; i++) {
            spriteBatch.draw(wallImage,
                    obstacles[i].position.x,
                    obstacles[i].position.y - obstacles[i].offset);

            spriteBatch.draw(wallImage, obstacles[i].position.x,
                    obstacles[i].position.y + BETWEEN +
                            wallImage.getHeight() - obstacles[i].offset);
        }
    }

    public void update() {
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i].update();
        }
    }

    public void reCreate() {
        int startPosition = 400;
        int distance = 220;

        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = new WallPair(new Vector2(startPosition, 0));
            startPosition += distance;
        }
    }
}
