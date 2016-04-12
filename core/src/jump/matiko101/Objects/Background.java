package jump.matiko101.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import jump.matiko101.Box2D.MyWorld;

/**
 * Created by mateusz on 2016-03-07.
 */
public class Background
{
    Texture texture;
    Sprite sprite;
    public Background(float x, float y, String pathToFile)
    {
        texture = new Texture(Gdx.files.internal(pathToFile));
        sprite = new Sprite(texture);
        sprite.setPosition(x * MyWorld.SCALE, y * MyWorld.SCALE);
        sprite.setSize(sprite.getWidth() * MyWorld.SCALE, sprite.getHeight() * MyWorld.SCALE);
        sprite.flip(false, true);
    }

    public Sprite getSprite()
    {
        return sprite;
    }
}
