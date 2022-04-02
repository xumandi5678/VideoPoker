// Mandi Xu
// mx2244
// Card.java 
// This is the setup of a Card class to represent a singular card


public class Card implements Comparable<Card>{
	
	private int suit; // In integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v
        suit = s;
        rank = r;
	} 
	
	public int compareTo(Card c){
		// use this method to compare cards so they 
		// may be easily sorted
        if(this.rank != c.rank) { 
            return this.rank - c.rank;
        } else { 
            return this.suit - c.suit;
        }
        
    }
	
	public String toString() { 
		// use this method to easily print a Card object
        return defineRank(rank) + " of " + defineSuit(suit);
	}
    
	// add some more methods here if needed

    // Accessor Methods: 
    public int getSuit() { 
        return suit;
    }
    
    public int getRank() { 
        return rank;
    }

    // Extra toString formatting 
    
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
