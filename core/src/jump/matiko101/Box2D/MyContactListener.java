package jump.matiko101.Box2D;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

import jump.matiko101.Game.Game;
import jump.matiko101.Objects.*;
import jump.matiko101.Objects.Object;

/**
 * Created by mateusz on 2015-11-13.
 */
public class MyContactListener implements ContactListener
{
    @Override
    public void beginContact(Contact contact)
    {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();
        if(b.getUserData() == "collision" && a.getUserData() instanceof Hero)
        {
            Game.RESTART = true;
        }
        else if(a.getUserData() == "collision" && b.getUserData() instanceof Hero)
        {
            Game.RESTART = true;
        }
        else if(b.getUserData() instanceof Star && a.getUserData() instanceof Hero)
        {
            Game.SCORE.addPoint();
            Object o = (Object) b.getUserData();
            o.disappear = true;
        }
        else if(a.getUserData() instanceof Star && b.getUserData() instanceof Hero)
        {
            Game.SCORE.addPoint();
            Object o = (Object) a.getUserData();
            o.disappear = true;
        }
    }

    @Override
    public void endContact(Contact contact) {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();
        if(b.getUserData() == "collision" && a.getUserData() instanceof Hero)
        {
            Game.RESTART = false;
        }
        else if(a.getUserData() == "collision" && b.getUserData() instanceof Hero)
        {
            Game.RESTART = false;
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold)
    {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
