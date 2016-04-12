package jump.matiko101.Box2D;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by mateusz on 2015-11-11.
 */
public class MyWorld
{
    public static final float SCALE = 0.01f;
    public World world;

    public MyWorld()
    {
        world = new World(new Vector2(0, -10f), true);
    }

    public Body createObject(Sprite sprite,BodyDef.BodyType bodyType) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = bodyType;
        float halfOfHeight = sprite.getHeight() / 2;
        float halfOfWidth = sprite.getWidth() / 2;
        bodyDef.position.set(new Vector2(sprite.getX() + halfOfWidth, sprite.getY() + halfOfHeight));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox((sprite.getWidth()) / 2, (sprite.getHeight()) / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        Body body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
        shape.dispose();
        return body;
    }
    public void update()
    {
        world.step(1/60f, 8, 3);
    }
}
