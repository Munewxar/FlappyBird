package com.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles {

    class WallPair{
        private static final int SCREEN_BEGIN = -50;
        private static final int SCREEN_END = 800;
        Vector2 position;
        float speed;
        int offset;

        public WallPair(Vector2 position) {
            this.position = position;
            speed = 2;
            offset = new Random().nextInt(250);
        }

        public void update() {
            position.x -= speed;

            if (position.x < SCREEN_BEGIN) {
                position.x = SCREEN_END;
                offset = new Random().nextInt(250);
            }
        }
    }

    private WallPair[] obstacles;
    private Texture wallImage;
    private final static int BETWEEN = 250;

    public Obstacles() {
        obstacles = new WallPair[4];
        wallImage = new Texture("wall.png");

        initializeObs();
    }

    private void initializeObs() {
        int length = obstacles.length;
        int startPoint = 400;
        int distance = 220;

        for (int i = 0; i < length; i++) {
            obstacles[i] = new WallPair(new Vector2(startPoint, 0));
            startPoint += distance;
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        int length = obstacles.length;
        for (int i = 0; i < length; i++) {
            spriteBatch.draw(wallImage,
                    obstacles[i].position.x,
                    obstacles[i].position.y);

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
}
