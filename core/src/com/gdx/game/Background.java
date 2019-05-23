package com.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background extends ApplicationAdapter {

    class BGImage {
        private Texture backgroundImg;
        private Vector2 position;

        public BGImage(Vector2 position) {
            backgroundImg = new Texture("back.png");
            this.position = position;
        }
    }

    private static final int X1_BEGIN_POSITION = 0;
    private static final int X2_BEGIN_POSITION = 800;
    private static final int Y_BEGIN_POSITION = 0;
    private static final int FIRST_IMAGE = 0;
    private static final int SECOND_IMAGE = 1;
    private static final int FIRST_IMAGE_LEFT_BOARDER = -800;
    private static final int SPEED = 4;

    private BGImage[] backgroundImgs = new BGImage[2];

    Background() {
        backgroundImgs[0] = new BGImage(new Vector2(X1_BEGIN_POSITION,
                Y_BEGIN_POSITION));
        backgroundImgs[1] = new BGImage(new Vector2(X2_BEGIN_POSITION,
                Y_BEGIN_POSITION));

    }

    void draw(SpriteBatch spriteBatch) {
        int length = backgroundImgs.length;

        for (int i = 0; i < length; i++) {
            spriteBatch.draw(backgroundImgs[i].backgroundImg,
                    backgroundImgs[i].position.x,
                    backgroundImgs[i].position.y);
        }
    }

    void update() {
        backgroundImgs[FIRST_IMAGE].position.x -= SPEED;
        backgroundImgs[SECOND_IMAGE].position.x -= SPEED;

        if (backgroundImgs[FIRST_IMAGE].position.x < FIRST_IMAGE_LEFT_BOARDER) {
            backgroundImgs[FIRST_IMAGE].position.x = X1_BEGIN_POSITION;
            backgroundImgs[SECOND_IMAGE].position.x = X2_BEGIN_POSITION;
        }
    }
}
