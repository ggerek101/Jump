package jump.matiko101.Game;

/**
 * Created by mateusz on 2016-03-06.
 */
public class Score
{
    int points;

    public Score()
    {
        points = 0;
    }

    public void addPoint()
    {
        points++;
    }

    public void removePoints()
    {
        points = 0;
    }

    public int getPoints()
    {
        return points;
    }
}
