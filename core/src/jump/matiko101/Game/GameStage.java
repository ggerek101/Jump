package jump.matiko101.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ContactListener;

import jump.matiko101.Box2D.MyWorld;
import jump.matiko101.Graphics.Fonts;
import jump.matiko101.Graphics.Graphics;
import jump.matiko101.Objects.Hero;
import jump.matiko101.Objects.Obstacle;

/**
 * Created by mateusz on 2016-01-22.
 */
public class GameStage
{
    Fonts fonts;
    ObjectManager objectManager;
    Events events;
    MyWorld myWorld;

    public GameStage()
    {
        fonts= new Fonts(192,210);
        myWorld = new MyWorld();
        objectManager = new ObjectManager(myWorld);
        events = new Events();
        startGame();
    }

    public void setContactListener(ContactListener contactListener)
    {
        myWorld.world.setContactListener(contactListener);
    }

    public void updateEvents()
    {
        events.checkEvents(objectManager);
    }

    public void performActions()
    {
        objectManager.hero.action();
        objectManager.ground.action();
        for(int i = 0; i != objectManager.obstacles.size(); i++)
        {
            objectManager.obstacles.get(i).action();
        }
        for(int i = 0; i != objectManager.bonuses.size(); i++)
        {
            objectManager.bonuses.get(i).action();
        }
    }

    public void drawObjects()
    {
        Graphics.draw(objectManager.background, objectManager.hero.getBody().getPosition().y - 4);
        Graphics.draw(objectManager.hero);
        Graphics.draw(objectManager.ground);
        for(int i = 0; i != objectManager.obstacles.size(); i++)
        {
            Graphics.draw(objectManager.obstacles.get(i));
        }
        for(int i = 0; i != objectManager.bonuses.size(); i++)
        {
            Graphics.draw(objectManager.bonuses.get(i));
        }
    }

    public void update()
    {
        updateEvents();
        myWorld.update();
        performActions();
        drawObjects();
        drawScore();
        Graphics.setCameraToHero(objectManager.hero.getBody().getPosition().y);
    }

    public void restart()
    {
        Game.RESTART = false;

        objectManager.restart();
        Game.SCORE.removePoints();

        startGame();
    }

    public void startGame()
    {
        objectManager.initHero(new Hero(520, 400, "hero.png"), BodyDef.BodyType.DynamicBody, 0,0,0);
        objectManager.initGround(new Obstacle(0, objectManager.hero.getBody().getPosition().y * 100 - 300, "ground.png"), BodyDef.BodyType.StaticBody, 0, 0, 0);
    }

    private void drawScore()
    {
        // jedyny sposob, ktory dziala
        Graphics.getSpriteBatch().begin();
        OrthographicCamera camera = new OrthographicCamera(1920,1200f);
        camera.setToOrtho(false, 364f, 240f);
        Graphics.getSpriteBatch().setProjectionMatrix(camera.combined);
        fonts.getFont().draw(Graphics.getSpriteBatch(), "" + Game.SCORE.getPoints(), fonts.getX(), fonts.getY(), 0, 0, true);
        Graphics.getSpriteBatch().end();
        Graphics.getSpriteBatch().setProjectionMatrix(Graphics.getCamera().combined);
    }

}
