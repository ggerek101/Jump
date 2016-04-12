package jump.matiko101.Objects;

import java.util.Random;

import jump.matiko101.Game.Events;
import jump.matiko101.Graphics.Graphics;

/**
 * Created by mateusz on 2015-11-17.
 */
public class Line extends Obstacle
{
    enum Direction {Left,Right}
    enum Type {Static, Kinematic}
    Direction direction;
    Type type;
    public Line(float x, float y, String pathToFile) {
        super(x, y, pathToFile);
        direction = Direction.Right;
        if(Events.RAND.nextInt(2) == 0)
        {
            type = Type.Kinematic;
            V = Events.RAND.nextInt(6) + 1;
        }
        else
        {
            type = Type.Static;
            sprite.setPosition(Events.RAND.nextInt(6), sprite.getY());
        }
    }

    public void checkDirection()
    {
        if(body.getPosition().x < - 2)
        {
            direction = Direction.Right;
        }
        if (body.getPosition().x > 13)
        {
            direction = Direction.Left;
        }

    }

    @Override
    public void action()
    {
        if(type == Type.Kinematic)
        {
            checkDirection();
            switch (direction)
            {
                case Left:
                    body.setLinearVelocity(-V, body.getLinearVelocity().y);
                    break;
                case Right:
                    body.setLinearVelocity(V, body.getLinearVelocity().y);
                    break;
         }
     }
    }
}
