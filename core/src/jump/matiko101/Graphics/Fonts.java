package jump.matiko101.Graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by mateusz on 2015-12-22.
 */
public class Fonts
{
    BitmapFont font;
    String text;
    float x,y;

    public Fonts(float x, float y)
    {
        font = new BitmapFont();
        font.setColor(Color.YELLOW);
        this.x = x;
        this.y = y;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public BitmapFont getFont()
    {
        return font;
    }

    public void setPosition(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }
}
