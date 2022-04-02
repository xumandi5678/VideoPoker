# VideoPoker
This is the code from an assignment that created a Video Poker Game

## Text File w/ Code Explanations: 

## 1) Card.java

* creates the Card object with suit and rank stored as its integer values
* **compareTo(Card c)**: creates a compareTo method using subtraction
to find the difference between two cards so they may be easily sorted
* **toString()**: formats the Card object in a readable fashion
* **getSuit()**: accessor method for the suit of the card
* **getRank()**: accessor method for the rank of the card
* **defineSuit(int suit)**: takes in the integer value of the suit
and returns the string representation of that suit; Ex. when suit = 1, it's clubs
* **defineRank(int rank)**: takes in the integer value of the rank
and returns the string representation of that rank; Ex. rank 11 = Jack

## 2) Deck.java

* creates an array of Card objects with a nested for loop to create the
suit and the rank in integers and storing them into the object cards 
* **shuffle()**: randomizes the deck by iterating through each time
and generating a random integer to switch positions in index with
for example, if i == 2 and you generate a random integer the 
card[random integer] would be swapped with the card[2]
* **deal()**: takes off the top card of the deck and if it reaches
the end of the deck, it reshuffles 

## 3) Player.java 

* creates a Player's hand as an Arraylist and keeps track
of the bankroll and the tokens betted as doubles (my choice 1000, 0 tokens)
* **addCard(Card c)**: adds a card to the array of hand
* **removeCard(Card c)**: removes a card from the array of hand 
* **bets(double amt)**: calculates what remains after a bet
* **winnings(double odds)**: calculates the earnings 
* **getBankroll()**: accessor method for bankroll
* **sortHand()**: sorts and returns the ArrayList
* **toString()**: formats the current hand using \n to make it look
neater and on each line 
* **getHand()**: accessor method for hand
* **clearBet()**: sets bet back to 0 after each round

## 4) Game.java

Using many booleans as controls, you have essentially two branches.

1) First in the constructor for the test, you take in a Scanner object input, format it by iterating through and matching the letter with a suit
integer and replacing that letter with 0 so when you turn that 
String into an integer, it is just that number with a 0 in front
and so the 0 goes away. Then you continue playing by asking user which
cards to keep and remove, shuffling the deck, refilling the deck,
and then displaying to the player the earnings. Afterwards,
they can decide to continue playing, generating random decks,
or end the game. 

2) Second in the constructor for the normal game (this paragraph explains
the algorithm), you just generate the various control variables.
* 1: if the player has said yes or y = true to playing the game 
and there is no given hand, generate the game display asking
for the bet
* 2: generate the initial hand and sort it before showing it to
the player.
* 3: give them the choice of whether to hold or remove
using user input 
* 4: refill the hand and sort again; Show the player what the hand is now 
* 5: check the hand using boolean to confirm 
* 6: tell the player what type of hand they have 
* 7: calculate the earnings and display them to the player
* 8: ask if they want to play again 
* 9: if yes, clear everything and run play inside play again.
* 10: else, change the boolean y to false and after printing 
"Game Over" the loop ends and the main method is done.  
