package jump.matiko101.Objects;

import jump.matiko101.Game.Game;

/**
 * Created by mateusz on 2016-03-07.
 */
public class Star extends Bonus
{
    public Star(float x, float y, String pathToFile)
    {
        super(x, y, pathToFile);
    }

    @Override
    public void action()
    {
        if(disappear)
        {
            body.setActive(false);
            sprite.setAlpha(0);
        }
    }
}
