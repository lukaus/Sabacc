/**
 * @(#)AIPlayer.java
 *
 *
 * @author
 * @version 1.00 2011/4/22
 */
import java.util.*;

public class AIPlayer extends Player
{
	double risk;
	boolean isPlaying = false;
	Random rand = new Random();

	public AIPlayer()
	{
		name = "UnNamed";
		credits = 100;
		risk = 1;
		isPlaying = true;
	}

    public AIPlayer(String n, int c, int r, boolean t)
    {
		name = n;
		credits = c;
		risk = r;
		isPlaying = t;
    }

	public boolean isPlaying()
	{
		return isPlaying;
	}

    public void setPlaying(boolean t)
    {
    	isPlaying = t;
    }

	public boolean putCardInField()
	{
		int x = rand.nextInt(20);
		if(this.getPoints() == 23 || this.getPoints() == -23 || idiotArray() || x == 5)
			return true;
		else
			return false;
	}

	public boolean timeCallGame(Game game)
	{
		if((idiotArray() || this.getPoints() == 23 || this.getPoints() == -23 || (this.getPoints() > 20 && this.getPoints() < 23) || (this.getPoints() < -20 && this.getPoints() > -23)) && !(game.lastRound))
			return true;
		else
			return false;
	}

	public boolean drawCard()
	{
		int x = rand.nextInt(20);
		if((this.getPoints() < 15 && this.getPoints() > -15) && (this.hand.size() < 5) || x==5)
			return true;
		else
			return false;
	}

	public double getBet()
	{
		int r = rand.nextInt(9)+1;

		return risk*.25*this.getPoints()+r;
	}

	public void setRisk(int r)
	{
		risk = r;
	}
}