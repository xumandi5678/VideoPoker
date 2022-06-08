// Mandi Xu
// mx224 
// Game.java 
// This is the Game class that has the two constructors, one for the command
// and the other for the class game play 

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	
	private Player p;
	private Deck cards;
	// you'll probably need some more here
	private Scanner input;
    	private int earnings;
    	private int removed;
	private String type;
    	private boolean y;
    	private boolean playAgain;
    	private boolean given;
	
	public Game(String[] testHand){
		// This constructor is to help test your code.
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
        
        p = new Player();
        cards = new Deck();
        given = true;
        input = new Scanner(System.in);
        testCases(testHand);
        earnings = 0;
        removed = 0;
		type = "";
        y = true;
        
        
        
		
	}
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
        p = new Player();
        cards = new Deck();
        given = false;
        y = true;
        input = new Scanner(System.in);
        earnings = 0;
        removed = 0;
        type = "";
        
       
        
	}
	
	public void play(){
		// this method should play the game
        if((y == true) && (given == false)) { 
            gameDisplay();
            initialHand();
            p.sortHand();
            System.out.println(p.toString());
            heldVsRemove();
            refillHand();
            System.out.println(p.toString());
            checkHand(p.getHand());
            System.out.println("You have: " + type);
            calculateEarnings();
            System.out.println("Play again? (Y) or (N)");
            String x = input.next();
            if(x.equals("Y")) {
                p.getHand().clear();
                p.clearBet();
                removed = 0;
                play();
            } else { 
                y = false;
                System.out.println("Game Over.");
            }
            
        }
        if((y == true) && (given == true)) {
            gameDisplay();
            heldVsRemove();
            cards.shuffle();
            refillHand();
            System.out.println(p.toString());
            checkHand(p.getHand());
            System.out.println("You have: " + type);
            calculateEarnings();
            System.out.println("Play again? (Y) or (N)");
            String x = input.next();
            if(x.equals("Y")) { 
                p.getHand().clear();
                p.clearBet();
                removed = 0;
                given = false;
                play();
            } else { 
                y = false;
                System.out.println("Game Over.");
            }
        }
        
    }
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		
        if(checkRoyalFlush(hand)) { 
            type = "Royal Flush";
        } else if (checkStraightFlush(hand)) { 
            type = "Straight Flush";
        } else if (checkFourKind(hand)) { 
            type = "Four of a Kind";
        } else if (checkFullHouse(hand)) { 
            type = "Full House";
        } else if (checkFlush(hand)) { 
            type = "Flush";
        } else if (checkStraight(hand)) { 
            type = "Straight";
        } else if (checkThreeKind(hand)) { 
            type = "Three of a Kind";
        } else if (checkTwoPairs(hand)) { 
            type = "Two Pairs";
        } else if (checkOnePair(hand)) { 
            type = "One Pair";
        } else { 
            type = "No pair";
        }
        return type;
	}
	
	
	// you will likely want many more methods here
	// per discussion in class
    
    public void gameDisplay() {
        // displays the beginning of the game for the bet 
        System.out.println("Welcome to Video Poker. Place your bet (1-5?): ");
        int tokens = input.nextInt();
        p.bets(tokens);
        System.out.println("Balance: " + p.getBankroll());
    }
    
    public void initialHand() {
        // creates the initial hand shown to the player
        cards.shuffle();
        for(int i = 0; i < 5; i++) { 
            Card c = cards.deal();
            p.addCard(c);
        }
    }
    public void heldVsRemove() { 
        // asks user which cards in the hand held versus removed
        ArrayList<Card> discarded = new ArrayList<>();
        for(int i = 0; i < 5; i++) { 
            System.out.println("Hold or Remove Card " + (i+1) + ": " + "Enter (H) or (R)?");
            String instruction = input.next();
            if(instruction.equals("R")) {
                discarded.add(p.getHand().get(i));
                removed += 1;
            }
        }
        for(int i = 0; i < discarded.size(); i++) { 
            p.removeCard(discarded.get(i));
        }
            
    }
    
    public void refillHand() {
        // refills the hand with cards 
        for(int i = 0; i < removed; i++) { 
            Card c = cards.deal();
            p.addCard(c);
        }
        p.sortHand();
        
    }
    
    /* These are the various checks for the type of hand
     * from One Pair -- > Royal Flush
     */
    
    private boolean checkOnePair(ArrayList<Card> hand) {
        // checks if there is one pair
        for(int i = 0; i < (hand.size()-1); i++) { 
            if (hand.get(i).getRank() == hand.get(i+1).getRank() &&
                checkTwoPairs(hand) == false && 
                checkThreeKind(hand) == false) { 
                earnings = 1;
                return true;
            }
        }
        return false;
    }
    
    private boolean checkTwoPairs(ArrayList<Card> hand) { 
        // checks if there are two pairs 
        if(hand.get(0).getRank() == hand.get(1).getRank() && 
           hand.get(2).getRank() == hand.get(3).getRank() || 
           hand.get(1).getRank() == hand.get(2).getRank() && 
           hand.get(3).getRank() == hand.get(4).getRank() ||
           hand.get(0).getRank() == hand.get(1).getRank() && 
           hand.get(3).getRank() == hand.get(4).getRank()) { 
            earnings = 2;
            return true;
        } else { 
            return false;
        }
    }
    
    private boolean checkThreeKind(ArrayList<Card> hand) { 
        // checks if three cards are the same 
        if(hand.get(0).getRank() == hand.get(1).getRank() && 
           hand.get(0).getRank() == hand.get(2).getRank() &&
           hand.get(3).getRank() != hand.get(4).getRank() || // so that there is no pair 
           hand.get(1).getRank() == hand.get(2).getRank() && 
           hand.get(1).getRank() == hand.get(3).getRank() ||
           hand.get(2).getRank() == hand.get(3).getRank() && 
           hand.get(2).getRank() == hand.get(4).getRank() &&
           hand.get(0).getRank() != hand.get(1).getRank()) { 
            earnings = 3;
            return true;
        } else { 
            return false;
        }
    }
    
    private boolean checkStraight(ArrayList<Card> hand) { 
        // checks if the five cards are consecutive
        int check = 0;
        boolean checkSF = checkFlush(hand);
        for(int i = 0; i < 4; i++) {
            if(hand.get(i).getRank() + 1 == hand.get(i+1).getRank()) { 
                check += 1;
            }
        }
        if(check == 4 && checkSF == false || checkAce(hand)) { 
            earnings = 4;
            return true;
        } else { 
            return false;
        }
    }
    
    private boolean checkFlush(ArrayList<Card> hand) { 
        // checks if all have same suit
        if(hand.get(0).getSuit() == hand.get(1).getSuit() &&
           hand.get(1).getSuit() == hand.get(2).getSuit() && 
           hand.get(2).getSuit() == hand.get(3).getSuit() && 
           hand.get(3).getSuit() == hand.get(4).getSuit()) { 
            earnings = 5;
            return true;
        } else { 
            return false;
        }
    }
    
    private boolean checkFullHouse(ArrayList<Card> hand) { 
        // checks if it contains 3 of a kind and a pair 
        if(hand.get(0).getRank() == hand.get(1).getRank() &&
           hand.get(1).getRank() == hand.get(2).getRank() &&
           hand.get(3).getRank() == hand.get(4).getRank() ||
           hand.get(0).getRank() == hand.get(1).getRank() &&
           hand.get(2).getRank() == hand.get(3).getRank() &&
           hand.get(3).getRank() == hand.get(4).getRank()) { 
            earnings = 6;
            return true;
        } else {
            return false;
        }
    }
    
    private boolean checkFourKind(ArrayList<Card> hand) { 
        // checks if there are 4 of the same rank
        if(hand.get(0).getRank() == hand.get(1).getRank() &&
           hand.get(0).getRank() == hand.get(2).getRank() &&
           hand.get(2).getRank() == hand.get(3).getRank() ||
           hand.get(1).getRank() == hand.get(2).getRank() &&
           hand.get(1).getRank() == hand.get(3).getRank() &&
           hand.get(3).getRank() == hand.get(4).getRank()) { 
            earnings = 25;
            return true;
        } else { 
            return false;
        }
    }
    
    private boolean checkStraightFlush(ArrayList<Card> hand) { 
        // checks if both consecutive + all same suit 
        if(checkStraight(hand) && checkFlush(hand)) { 
            earnings = 50;
            return true;
        } else { 
            return false;
        }
    }
    
    private boolean checkRoyalFlush(ArrayList<Card> hand) { 
        // checks if there is a royal flush 
        if(hand.get(0).getRank() == 1 && 
           hand.get(1).getRank() == 10 &&
           hand.get(2).getRank() == 11 &&
           hand.get(3).getRank() == 12 &&
           hand.get(4).getRank() == 13 && 
           checkFlush(hand)) {
            earnings = 250;
            return true;
        } else {
            return false;
        }
    }
    
    public void calculateEarnings() {
        // calculates the payout 
        p.winnings(earnings);
        System.out.println("Current Balance: " + p.getBankroll());
    }
    
    public boolean checkAce(ArrayList<Card> hand) {
        // checks if there is an Ace for the checkStraight method
        if(hand.get(0).getRank() == 1) { 
            if(hand.get(1).getRank() == 10 &&
               hand.get(2).getRank() == 11 &&
               hand.get(3).getRank() == 12 &&
               hand.get(4).getRank() == 13) { 
                return true;
            } 
        } 
        return false;
    }
    
    public void testCases(String[] testHand) { 
        // takes in user input to make a card
        int suit = 0;
        Card c;
        for(int i = 0; i<testHand.length; i++) { 
            if (testHand[i].startsWith("c")) {
                testHand[i] = testHand[i].replace("c", "0");
                suit = 1;
            } else if (testHand[i].startsWith("d")) {
                testHand[i] = testHand[i].replace("d", "0");
                suit = 2;
            } else if (testHand[i].startsWith("h")) {
                testHand[i] = testHand[i].replace("h", "0");
                suit = 3;
            } else if (testHand[i].startsWith("s")) {
                testHand[i] = testHand[i].replace("s", "0");
                suit = 4;
            } 
            c = new Card(suit, Integer.parseInt(testHand[i].substring(1)));
            p.addCard(c);
            
        }
        System.out.println(p.toString());
            
        
    }
}
