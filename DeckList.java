// Luke Stanley
// A DeckList program for Sabacc, this class extends ArrayList in order to
// add a swap method and override the toString method


import java.util.*;

public class DeckList<E> extends ArrayList<E>
{

	public DeckList()
	{

	}


	public String toString()
    {
    	String ret = "";
    	Object temp = new Object();
    	for(int x =0; x < this.size(); x++)
    	{
    		temp = this.get(x);
    		Card card = (Card) temp;

    		ret += card.getName() + ",  ";
    	}

    	return "[ " +ret+" ]";
    }

    public void swap(int a, int b)
    {
		Card carda = (Card) this.get(a);
		Card cardb = (Card) this.get(b);
		Card cardtemp = new Card();

    	cardtemp = carda;
    	carda = cardb;
    	cardb = cardtemp;

		this.set(a,(E)carda);
		this.set(b,(E)cardb);
    }


}