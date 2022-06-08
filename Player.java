// Mandi Xu
// mx2244
// Player.java
// This is the Player.java class that represents a player in the Poker Game

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
    	private double bet;
	
	/* Creates Player here */
	public Player(){		
        	hand = new ArrayList<>();
        	bankroll = 1000.0;
        	bet = 0.0;
	}
	
	/* Adds a Card to 
	 * the Player's hand */ 
	public void addCard(Card c){
        	hand.add(c);
	}
	
	/* Removes a Card from 
	 * the Player's Hand */
	public void removeCard(Card c){
        	hand.remove(c); 
        }
	
	/* Player places a bet in 
	 * an amount given 
	 */
    	public void bets(double amt){
        	bet = bet + amt;
        	bankroll = bankroll - bet;
    	}
	
	/* Adjusts the Bankroll if 
	 * the player wins to include earnings 
	 */ 
    	public void winnings(double odds){
        	bankroll = bankroll + (bet * odds);
    	}
	
	/* Returns the current balance
	 * of the bankroll 
	 */ 
    	public double getBankroll(){
        	return bankroll;
    	}
    
	/* Arranges the hand in order 
	 * for comparison later 
	 */
    	public ArrayList<Card> sortHand() { 
        	Collections.sort(hand);
        	return hand;
    	}
    	
	/* Displays the hand to the player */
    	public String toString() {
        	sortHand();
        	String currentHand = "Current hand: \n";
        	for(Card c : hand) { 
           		currentHand = currentHand + c.toString() + "\n";
       		}
       		return currentHand;
	}
    	
	/* Returns the Hand to the Player */
    	public ArrayList<Card> getHand() {
        	return hand;
    	}
    	
	/* Sets the Bet to 0 for new game */
    	public void clearBet() { 
        	bet = 0.0;
    	}
    
}


