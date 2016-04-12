package jump.matiko101.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import jump.matiko101.Game.Events;

/**
 * Created by mateusz on 2016-02-25.
 */
public class Square extends Obstacle
{
    private float actualyTime;
    private float timeWhenDisappears;
    private float timeDisappearance;
    public Square(float x, float y, String pathToFile)
    {
        super(x, y, pathToFile);
        actualyTime = 0;
        timeWhenDisappears = Events.RAND.nextInt(3) + 1;
        timeDisappearance = Events.RAND.nextInt(3) + 1;
    }

    private void disappear()
    {
        body.setActive(false);
        sprite.setAlpha(0);
    }

    private void materialize()
    {
        body.setActive(true);
        sprite.setAlpha(1);
    }

    private void calculateTimeToDisappears()
    {
        actualyTime += Gdx.graphics.getDeltaTime();
        if(actualyTime >= timeWhenDisappears)
        {
            disappear();
            if(actualyTime >= timeWhenDisappears + timeDisappearance)
            {
                materialize();
                actualyTime = 0;
            }
        }

    }

    @Override
    public void action()
    {
        calculateTimeToDisappears();
    }

}
