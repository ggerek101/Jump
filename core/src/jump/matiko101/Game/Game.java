package jump.matiko101.Game;

import com.badlogic.gdx.Gdx;

import jump.matiko101.Box2D.MyContactListener;

/**
 * Created by mateusz on 2016-01-22.
 */
public class Game
{
    public static Score SCORE;
    public static boolean ADDPOINT;
    GameStage gameStage;
    MyContactListener myContactListener;

    public static boolean RESTART;

    public Game()
    {
        SCORE = new Score();
        gameStage = new GameStage();
        RESTART = false;
        ADDPOINT = false;
        myContactListener = new MyContactListener();
        gameStage.setContactListener(myContactListener);
    }

    public void checkRestart()
    {
        if(RESTART)
        {
            restart();
        }
    }

    private void restart()
    {
        gameStage.restart();
    }

    public void update()
    {
        gameStage.update();
    }
}
