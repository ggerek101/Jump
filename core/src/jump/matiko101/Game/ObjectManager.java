package jump.matiko101.Game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

import java.util.Vector;

import jump.matiko101.Box2D.MyWorld;
import jump.matiko101.Graphics.Graphics;
import jump.matiko101.Objects.Background;
import jump.matiko101.Objects.Bonus;
import jump.matiko101.Objects.Hero;
import jump.matiko101.Objects.Obstacle;
import jump.matiko101.Objects.Star;

/**
 * Created by mateusz on 2016-01-22.
 */
public class ObjectManager
{
    Hero hero;
    Obstacle ground;
    Background background;
    Vector<Obstacle>obstacles;
    Vector<Bonus>bonuses;
    MyWorld myWorld;

    public ObjectManager(MyWorld myWorld)
    {
        this.myWorld = myWorld;
        obstacles = new Vector<Obstacle>();
        bonuses = new Vector<Bonus>();
        background = new Background(0,0,"tlo.png");
    }

    public void initHero(Hero h, BodyDef.BodyType bodyType, float density, float friction, float restitution)
    {
        hero = h;
        hero.setBody(myWorld.createObject(hero.getSprite(), bodyType));
        hero.setObjectProperties(density, friction, restitution);
    }

    public void initGround(Obstacle b, BodyDef.BodyType bodyType, float density, float friction, float restitution)
    {
        ground = b;
        ground.setBody(myWorld.createObject(ground.getSprite(), bodyType));
        ground.setObjectProperties(density, friction, restitution);
        ground.getBody().setUserData("noCollision");
    }

    public void addObstacle( Obstacle o, BodyDef.BodyType bodyType, float density, float friction, float restitution)
    {
        obstacles.add(o);
        obstacles.lastElement().setBody(myWorld.createObject(obstacles.lastElement().getSprite(), bodyType));
        obstacles.lastElement().setObjectProperties(density, friction, restitution);
        obstacles.lastElement().getBody().setUserData("collision");
    }

    public void addBonus(Bonus b)
    {
        bonuses.add(b);
        bonuses.lastElement().setBody(myWorld.createObject(bonuses.lastElement().getSprite(), BodyDef.BodyType.DynamicBody));
        bonuses.lastElement().setObjectProperties(0, 0, 0);
        bonuses.lastElement().getBody().setGravityScale(0);
    }

    public void deleteBonus(int numberOfBlock)
    {
        bonuses.get(numberOfBlock).getBody().getWorld().destroyBody(bonuses.get(numberOfBlock).getBody());
        bonuses.remove(numberOfBlock);
    }

    public void deleteObstacle(int numberOfBlock)
    {
        obstacles.get(numberOfBlock).getBody().getWorld().destroyBody(obstacles.get(numberOfBlock).getBody());
        obstacles.remove(numberOfBlock);
    }

    public void restart()
    {
        hero.restart();

        for(int i = 0; i != obstacles.size(); i++)
        {
            obstacles.get(i).getBody().getWorld().destroyBody(obstacles.get(i).getBody());
        }
        obstacles.clear();
        for(int i = 0; i != bonuses.size(); i++)
        {
            bonuses.get(i).getBody().getWorld().destroyBody(bonuses.get(i).getBody());
        }
        bonuses.clear();
    }

    public Hero getHero()
    {
        return hero;
    }

    public Vector<Obstacle> getBlocks()
    {
        return obstacles;
    }
}
