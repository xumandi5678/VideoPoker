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

	// you may choose to use more instance variables
		
	public Player(){		
	    // create a player here
        hand = new ArrayList<>();
        bankroll = 1000.0;
        bet = 0.0;
	}

	public void addCard(Card c){
	    // add the card c to the player's hand
        hand.add(c);
	}

	public void removeCard(Card c){
	    // remove the card c from the player's hand
        hand.remove(c); 
        }
		
    public void bets(double amt){
        // player makes a bet
        bet = bet + amt;
        bankroll = bankroll - bet;
    }

    public void winnings(double odds){
        //	adjust bankroll if player wins
        bankroll = bankroll + (bet * odds);
    }

    public double getBankroll(){
        // return current balance of bankroll
        return bankroll;
    }

    // you may wish to use more methods here
    
    public ArrayList<Card> sortHand() { 
        // arranges the hand in order for comparison later
        Collections.sort(hand);
        return hand;
    }
    
    public String toString() {
        sortHand();
       // displays the hand to the player 
       String currentHand = "Current hand: \n";
       for(Card c : hand) { 
           currentHand = currentHand + c.toString() + "\n";
       }
       return currentHand;
       }
    
    public ArrayList<Card> getHand() {
        // returns the hand for access
        return hand;
    }
    
    public void clearBet() { 
        bet = 0.0;
    }
    
}


