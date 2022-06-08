// Mandi Xu
// mx2244
// Deck.java
// This is the Deck class that creates the deck of cards 

import java.util.Random;
public class Deck {
	
	private Card[] cards;
	private int top; // the index of the top of the deck
	private Random rand = new Random();
    	
	/* Creates a 52 card deck */
	public Deck(){
        	cards = new Card[52];
        	int index = 0;
        	for(int i = 1; i<=4; i++) {
            		for(int j = 1; j<=13; j++) {
                		Card c = new Card(i,j);
                		cards[index] = c;
               			index += 1;
            		}
            
        	}
        	top = 0;
	}
	
	/* Shuffles the deck */ 
	public void shuffle(){
        	for(int i = 0; i<cards.length; i++) { 
            		int x = rand.nextInt(cards.length);
           		Card tempCard = cards[i];
            		Card switchCard = cards[x];
            		cards[i] = switchCard;
            		cards[x] = tempCard;
        	}
	}
	
	/* Deals the Top card of the deck */
	public Card deal(){
        	if(top < 52) {
            		top += 1;
        	} else { // reshuffles if end reached
            		shuffle();
            		deal();
        	}
        	return cards[top-1];
    	}
}
