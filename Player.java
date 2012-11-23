// Luke Stanley
// the Player class for the Sabacc game

import java.awt.*;

public class Player
{
	String name;
	DeckList hand = new DeckList();
	int credits;
	int points;
	int numCards;

 public Player()
    {
		name = "UnNamed";
		credits = 100;
    }
    public Player(String n, int c)
    {
		name = n;
		credits = c;
    }

	public String getName()
	{
		return name;
	}

	public Card getCard(int index)
	{
		Card card = new Card();
		card = (Card) hand.get(index);
		return card;
	}

	public int getPoints()
	{
		points = 0;
		Card temp = new Card();
		for(int x = 0; x < hand.size();x++)
		{
			temp = (Card) hand.get(x);
			points += temp.getValue();
		}
		return points;
	}

	public int getCredits()
	{
		return credits;
	}

	public void setName(String s)
	{
		name = s;
	}

	public void setCredits(int a)
	{
		credits = a;
	}

	public void setCard(Card card, int index)
	{
		hand.set(index, new Card(card));
	}
	public void addCard(Card card)
	{
		hand.add(new Card(card));
	}

	public void payIntoMain(int a, Game game)
	{
		if(credits < a)
		{
			game.mainPot += credits;
			credits = 0;
		}
		else
		{
			 game.mainPot += a;
			 credits -= a;
		}
	}

	public void payIntoSabacc(int a, Game game)
	{
		if(credits < a)
		{
			game.sabaccPot += credits;
			credits = 0;
		}
		else
		{
			 game.sabaccPot += a;
			 credits -= a;
		}

	}

	public boolean idiotArray()
	{
		boolean ret = false;
		if(this.numCards == 3)
		{
			Card temp1 = (Card) hand.get(0);
			Card temp2 = (Card) hand.get(1);
			Card temp3 = (Card) hand.get(2);
			String nam1 = temp1.getName();
			String nam2 = temp2.getName();
			String nam3 = temp3.getName();
			if((temp1.suit == temp2.suit || temp1.suit == temp3.suit || temp2.suit == temp3.suit) && (nam1.equals("Idiot") || nam2.equals("Idiot") || nam3.equals("Idiot")))
				ret = true;
		}
		return ret;
	}

	public Color cardMainColor(int index)
	{
		index = index-1;
		if(index >= hand.size())
		{
			return Color.blue;
		}
		else
		{
			Card temp = this.getCard(index);
			if(temp.getStatic() || temp.isPlayersCard())
			{
				if(temp.getStatic() && temp.isPlayersCard())
					return Color.green;
				else
					return Color.red;
			}
			else
				return Color.blue;
		}

	}
	public Color cardTextColor(int index)
	{
		index = index - 1;
		if(index >= this.hand.size())
		{
			return Color.blue;
		}
		else
		{

			Card temp = this.getCard(index);
			if(temp.getStatic() || temp.isPlayersCard())
				return Color.black;
			else
				return Color.blue;
		}
	}

	public String getCardText(int index)
	{
		index = index-1;
		if(index >= hand.size())
		{
			return "";
		}
		{

			Card temp = this.getCard(index);
			if(temp.value <0 && temp.value > -10)
				return temp.value + "              \n\n"+temp.getName() + "\n\n"+temp.getSuit();
			if(temp.value <-9)
				return temp.value + "             \n\n"+temp.getName() + "\n\n"+temp.getSuit();
			if(temp.value > 9)
				return temp.value + "              \n\n"+temp.getName() + "\n\n"+temp.getSuit();
			if(temp.value < 10)
				return temp.value + "               \n\n"+temp.getName() + "\n\n"+temp.getSuit();
			else
				return "error";
		}

	}

	public int getNumCards()
	{
		return numCards;
	}


}