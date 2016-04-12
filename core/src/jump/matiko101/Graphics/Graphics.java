package jump.matiko101.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import jump.matiko101.Objects.Background;
import jump.matiko101.Objects.Object;

/**
 * Created by mateusz on 2016-01-22.
 */
public class Graphics
{
        static SpriteBatch spriteBatch;
        static OrthographicCamera camera;

        public Graphics() {
            spriteBatch = new SpriteBatch();
            camera = new OrthographicCamera(1200, 1920f);
            camera.setToOrtho(false, 12f, 19.2f);
            spriteBatch.setProjectionMatrix(camera.combined);
        }

        public static void draw(Object o) {
            spriteBatch.begin();
            o.getSprite().setPosition(o.getBody().getPosition().x - o.getSprite().getWidth() / 2, o.getBody().getPosition().y - o.getSprite().getHeight() / 2);
            o.getSprite().draw(spriteBatch);
            spriteBatch.end();
        }

        public static void draw(Background b, float y)
        {
            spriteBatch.begin();
            b.getSprite().setPosition(b.getSprite().getX(), y);
            b.getSprite().draw(spriteBatch);
            spriteBatch.end();
        }

        public static void setCameraToHero(float y)
        {
                camera.position.set(camera.viewportWidth / 2, y + camera.viewportHeight * 100 / 275, 0);
                spriteBatch.setProjectionMatrix(camera.combined);
        }

        public void update() {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
            camera.update();
        }

        public static SpriteBatch getSpriteBatch()
        {
            return  spriteBatch;
        }

        public static OrthographicCamera getCamera()
        {
            return camera;
        }
}
