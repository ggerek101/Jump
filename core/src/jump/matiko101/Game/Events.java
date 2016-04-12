package jump.matiko101.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;

import java.util.Random;

import jump.matiko101.Graphics.Graphics;
import jump.matiko101.Objects.Line;
import jump.matiko101.Objects.Obstacle;
import jump.matiko101.Objects.Square;
import jump.matiko101.Objects.Star;

/**
 * Created by mateusz on 2016-02-01.
 */
public class Events
{
    public static Random RAND;
    ObjectManager clonedObjectManager;
    enum ObstacleTypeToPut{OBSTACLE, LINE, SQUARE}
    ObstacleTypeToPut obstacleTypeToPut;
    public Events()
    {
        RAND = new Random(123456789L);
        obstacleTypeToPut = ObstacleTypeToPut.OBSTACLE;
    }

    public ObjectManager checkEvents(ObjectManager oM)
    {
        clonedObjectManager = oM;
        checkPutBlock();
        checkDeleteBonuses();
        return clonedObjectManager;
    }

    private ObstacleTypeToPut getRandomObstacleType()
    {
        switch (RAND.nextInt(7))
        {
            case 0:
                return ObstacleTypeToPut.SQUARE;
            case 1:
                return ObstacleTypeToPut.LINE;
            default:
                return ObstacleTypeToPut.LINE;
        }
    }

    private void setObstacleTypeToPut()
    {
        for (int i = 1; i != 10; i++)
        {
            switch (getRandomObstacleType())
            {
                case OBSTACLE:
                    clonedObjectManager.addObstacle(new Obstacle(0,
                            clonedObjectManager.hero.getBody().getPosition().y * 100 + Graphics.getCamera().viewportHeight *100 / 3 * i,
                            "square.png"), BodyDef.BodyType.KinematicBody, 0, 0, 0);
                    break;
                case LINE:
                    clonedObjectManager.addObstacle(new Line(0,
                            clonedObjectManager.hero.getBody().getPosition().y * 100 + Graphics.getCamera().viewportHeight * 100 / 3 * i,
                            "line.png"), BodyDef.BodyType.KinematicBody, 0, 0, 0);
                    break;
                case SQUARE:
                    clonedObjectManager.addObstacle(new Square(0,
                            clonedObjectManager.hero.getBody().getPosition().y * 100 + Graphics.getCamera().viewportHeight * 100 / 3 * i,
                            "bigLine.png"), BodyDef.BodyType.KinematicBody, 0, 0, 0);
                    break;
            }
            randomBonus();
        }
    }

    private void checkPutBlock()
    {
        if(clonedObjectManager.obstacles.isEmpty() || clonedObjectManager.hero.getBody().getPosition().y > clonedObjectManager.obstacles.lastElement().getBody().getPosition().y)
        {
            setObstacleTypeToPut();
        }
    }

    private void randomBonus()
    {
        switch(RAND.nextInt(3))
        {
            case 0:
                break;
            default:
                int numberOfStars = RAND.nextInt(8) + 1;
                for(int i = 0; i != numberOfStars; i++)
                {
                    clonedObjectManager.addBonus(new Star((float) (RAND.nextInt(1100)), clonedObjectManager.obstacles.lastElement().getBody().getPosition().y * 100 + (float) (RAND.nextInt(300)), "star.png"));
                    clonedObjectManager.bonuses.lastElement().getBody().setUserData(clonedObjectManager.bonuses.lastElement());
                }
                break;

        }
    }

    private void checkDeleteBonuses()
    {
        for(int i = 0 ; i != clonedObjectManager.bonuses.size(); i++)
        {

            if (clonedObjectManager.getHero().getBody().getPosition().y - clonedObjectManager.bonuses.get(i).getBody().getPosition().y > 8)
            {
                clonedObjectManager.deleteBonus(i);
                i--;
            }
        }
        for(int i = 0 ; i != clonedObjectManager.obstacles.size(); i++)
        {

            if (clonedObjectManager.getHero().getBody().getPosition().y - clonedObjectManager.obstacles.get(i).getBody().getPosition().y > 8)
            {
                clonedObjectManager.deleteObstacle(i);
                i--;
            }
        }
    }

}
