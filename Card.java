// Luke Stanley
// The Card class for the Sabaac game mainly, but should not be hard to convert to other card games

import java.util.*;


public class Card
{
	int suit;
	int value;
	String gameName;
	String suitName;
	String name;
	String shortName;
	String longName;
	int user;
	boolean inPlay = false;
	boolean playersCard = false;
	boolean inStatic = false;
	Random rand = new Random();

	public Card()
	{

	}
	
	public Card(Card card)
	{
		suit = card.suit;
		value = card.value; 
		gameName = card.gameName;
		suitName = card.suitName;
		name = card.name;
		shortName = card.shortName;
		longName = card.longName;
		user = card.user;
		inPlay = card.inPlay;
		playersCard = card.playersCard;
		inStatic = card.inStatic;
		
		
	}
	
	public Card(int s, int n, String cardName,String game,boolean t)
	{
		suit =s;
		value = n;
		inPlay = t;
		name = cardName;
		gameName = game;
		if(gameName.equals("Sabacc"))
		{
			if(suit == 0)
				suitName = "Sabers";
			if(suit == 1)
				suitName = "Flasks";
			if(suit == 2)
				suitName = "Coins";
			if(suit == 3)
				suitName = "Staves";
			if(suit == 4)
				suitName = "Face Cards";

		}
	}

	public String getLongName()
	{
		return name+ " of " + suitName;
	}
	public boolean isPlayersCard()
	{
		return playersCard;
	}
	public void setIsPlayersCard(boolean t)
	{
		playersCard = t;
	}
	public boolean getStatic()
	{
		return inStatic;
	}
	public void setInPlay(boolean t)
	{
		inPlay = t;
	}
	public void setStatic(boolean t)
	{
		inStatic = t;
	}
	public void switchStatic()
	{
		inStatic = !inStatic;
	}

	public String getName()
	{
		return name;
	}
	public String getShortName()
	{
		return this.getName();
	}
	public String getSuit()
	{
		return suitName;
	}
	public int getValue()
	{
		return value;
	}


}