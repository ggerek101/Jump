package jump.matiko101.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import jump.matiko101.Game.Game;
import jump.matiko101.Graphics.Graphics;


/**
 * Created by mateusz on 2015-11-12.
 */
public class Hero extends Object
{
    public float maxHeroY;
    public Hero(float x, float y, String pathToFile) {
        super(x, y, pathToFile);
        V = 8;
        maxHeroY = 0;
    }

    private void move()
    {
        if(Gdx.input.isTouched())
        {
                body.setLinearVelocity(0, V);
        }

        if(body.getPosition().x - sprite.getWidth() / 2 > 0)
        {
            body.setLinearVelocity(-Gdx.input.getAccelerometerX() * 4, body.getLinearVelocity().y);
        }
        else
        {
            body.setTransform(sprite.getWidth() / 2, body.getPosition().y, body.getAngle());
        }

        if(body.getPosition().x + sprite.getWidth() / 2 < Graphics.getCamera().viewportWidth)
        {
            body.setLinearVelocity(-Gdx.input.getAccelerometerX() * 4, body.getLinearVelocity().y);
        }
        else
        {
            body.setTransform(Graphics.getCamera().viewportWidth - sprite.getWidth() / 2, body.getPosition().y, body.getAngle());
        }

    }

    private void rotate()
    {
            sprite.setRotation(sprite.getRotation() + 90);
            sprite.setOriginCenter();
    }

    private void checkTheConditionOfTheSquare()
    {
        if(body.getPosition().y < 0)
        {
            Game.RESTART = true;
        }
    }

    public void restart()
    {
        body.setTransform(new Vector2(50,590),0);
        body.getWorld().destroyBody(body);
    }

    @Override
    public void action()
    {
        checkTheConditionOfTheSquare();
        move();
    }
}
