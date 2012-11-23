// Luke Stanley
// A tester file

import java.util.*;
import java.awt.*;
import java.applet.*;

public class Tester extends Applet
{
	static DeckList<Card> preDeck = new DeckList<Card>();
	static Random rand = new Random();
	static Game game;
	static int ugh = 0;											// There is a reason for 'ugh'... When I
	static DeckList<Card> shuffledDeck = new DeckList<Card>();	// looked at FinalProject.doc, I realized
	static DeckList<Card> discard = new DeckList<Card>();		// the program had to be an applet, so I
																// converted the whole thing to an applet.
public void paint(Graphics g)									// But then for some reason it ran through
	{															// the paint() method every time something
		if (ugh == 0)											// moved over the Applet Window
		{														// [looking back, this is likely because
			makeDeck(preDeck);									// applets refresh their display when some
			shuffledDeck = shuffle(preDeck);					// thing moves over them], and since I could
			game = new Game();									// not track down why or where it did this,
			game.play(shuffledDeck);							// I put a conditional statement inside the
			ugh++;												// paint() method to ensure it only did the
		}														// contained statements once. This is probly
	}															// bad program design, but it works :)

	public static void makeDeck(DeckList deck)
	{
		for(int suit = 0; suit <4; suit++)
		{
			for(int num = 2; num < 12; num++)
			{
				deck.add(new Card(suit,num, String.valueOf(num),"Sabacc",false));
			}
		}

		System.out.println("Regular cards made.");
		System.out.println(deck.size());

		for(int s = 0; s<4; s++)
		{
			deck.add(new Card(s,1,"One","Sabacc",false));
		}
		for(int s = 0; s<4; s++)
		{
			deck.add(new Card(s,12,"Commander","Sabacc",false));
		}
		for(int s = 0; s<4; s++)
		{
			deck.add(new Card(s,13,"Mistress","Sabacc",false));
		}
		for(int s = 0; s<4; s++)
		{
			deck.add(new Card(s,14,"Master","Sabacc",false));
		}
		for(int s = 0; s<4; s++)
		{
			deck.add(new Card(s,15,"Ace","Sabacc",false));
		}

		System.out.println("High cards made");
		System.out.println(deck.size());

		deck.add(new Card(4,-17,"The Star","Sabacc",false));						// makine Stars
		deck.add(new Card(4,-17,"The Star","Sabacc",false));

		deck.add(new Card(4,-15,"The Evil One","Sabacc",false));					// making Evil Ones
		deck.add(new Card(4,-15,"The Evil One","Sabacc",false));

		deck.add(new Card(4,-14,"Moderation","Sabacc",false));					// making Moderations
		deck.add(new Card(4,-14,"Moderation","Sabacc",false));

		deck.add(new Card(4,-13,"Demise","Sabacc",false));						// making Demises
		deck.add(new Card(4,-13,"Demise","Sabacc",false));

		deck.add(new Card(4,-11,"Balance","Sabacc",false));						// making Balance
		deck.add(new Card(4,-11,"Balance","Sabacc",false));

		deck.add(new Card(4,-8,"Endurance","Sabacc",false));						// making Endurance
		deck.add(new Card(4,-8,"Endurance","Sabacc",false));

		deck.add(new Card(4,-2,"Queen of A & D","Sabacc",false));		// making Queens
		deck.add(new Card(4,-2,"Queen of A & D","Sabacc",false));

		deck.add(new Card(4,0,"Idiot","Sabacc",false));							// making Idiots
		deck.add(new Card(4,0,"Idiot","Sabacc",false));

		System.out.println("Done with face cards");
		System.out.println(deck.size());
		System.out.println(deck.toString());
	}

	public static DeckList shuffle(DeckList deck)
	{
		int x = 0;
		while(x < 200)
		{
			int a = rand.nextInt(deck.size());
			int b = rand.nextInt(deck.size());
			while(a==b)
				b = rand.nextInt(deck.size());
			deck.swap(a,b);
			x++;
		}
		System.out.println("Shuffle done.");
		System.out.println(deck.size());
		System.out.println(deck.toString());
		return deck;

	}



}

