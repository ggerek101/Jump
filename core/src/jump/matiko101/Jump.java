package jump.matiko101;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import jump.matiko101.Game.Game;
import jump.matiko101.Graphics.Graphics;

public class Jump extends ApplicationAdapter {

	Graphics graphics;
	Game game;
	enum GameCondition {Game,Menu}
	GameCondition gameCondition;

	@Override
	public void create ()
	{
		graphics = new Graphics();
		game = new Game();
		gameCondition = GameCondition.Game;
	}

	@Override
	public void render ()
	{
		graphics.update();
		if(gameCondition == GameCondition.Game)
		{
			game.update();
			game.checkRestart();
		}
	}
}
