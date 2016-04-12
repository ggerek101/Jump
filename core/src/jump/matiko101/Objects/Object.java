package jump.matiko101.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

import jump.matiko101.Box2D.MyWorld;

/**
 * Created by mateusz on 2016-01-22.
 */
public abstract class Object
{
    Sprite sprite;
    Texture texture;
    Body body;
    float V;
    public boolean disappear;

    public Object(float x, float y, String pathToFile)
    {
        texture = new Texture(Gdx.files.internal(pathToFile));
        sprite = new Sprite(texture);
        sprite.setPosition(x * MyWorld.SCALE, y * MyWorld.SCALE);
        sprite.setSize(sprite.getWidth() * MyWorld.SCALE, sprite.getHeight() * MyWorld.SCALE);
        sprite.flip(false, false);

        V = 0;
        disappear = false;
    }

    public void setBody(Body body)
    {
        this.body = body;
        body.setUserData(this);
    }
    public void setObjectProperties(float density, float friction, float restitution )
    {
        body.getFixtureList().first().setDensity(density);
        body.getFixtureList().first().setFriction(friction);
        body.getFixtureList().first().setRestitution(restitution);
    }

    public abstract void action();


    public Sprite getSprite()
    {
        return sprite;
    }
    public Texture getTexture()
    {
        return texture;
    }
    public Body getBody()
    {
        return body;
    }
}

