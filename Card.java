// Mandi Xu
// mx2244
// Card.java 
// This is the setup of a Card class to represent a singular card


public class Card implements Comparable<Card>{
	
	private int suit; // In integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	/* Makes a Card object with Suit s and Value v */
	public Card(int s, int r){
        	suit = s;
        	rank = r;
	} 
	
	/* Use this Method to compare cards
	 * so they may be 
	 * easily sorted
	 */
	public int compareTo(Card c){
        	if(this.rank != c.rank) { 
            		return this.rank - c.rank;
        	} else { 
            		return this.suit - c.suit;
		}
    	}
	
	/* Use this to easily print a Card object */ 
	public String toString() { 
        	return defineRank(rank) + " of " + defineSuit(suit);
	}

    	/* Returns suit of Card */
    	public int getSuit() { 
        	return suit;
    	}
    
	/* Returns rank of Card */
    	public int getRank() { 
        	return rank;
    	}
    	
	/* defines the suit based on ints */
    	public String defineSuit(int suit) { 
        	if(suit == 1) { 
            		return "Clubs";
        	} else if(suit == 2) { 
            		return "Diamonds";
        	} else if(suit == 3) { 
            		return "Hearts";
        	} else { 
            		return "Spades";
        	}
    	}
    	/* defines the rank based on ints */
	public String defineRank(int rank) { 
		if(rank == 11) { 
		    return "Jack";
		} else if(rank == 12) { 
		    return "Queen";
		} else if(rank == 13) {
		    return "King";
		} else if(rank == 1) { 
		    return "Ace";
		} else { 
		    return Integer.toString(rank);
		}
    	}
}
