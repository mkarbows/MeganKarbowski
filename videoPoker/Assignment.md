# Video Poker
## Due 02/26/2015

For this assignment, you'll be working with objects by creating your very own
text-based command line video poker game. A lot of the code has been stubbed out
for you, luckily, but you'll want to complete any methods with a nice little
TODO commented in it. Here's an outline of the classes and methods.

### Card, Rank, Suit, and PokerHand

Card is a class that represents a standard playing card with a suit and rank.
Card has already been completed for you. Rank, Suit, and Pokerhands are all enum constants
that represent a rank (ACE, DEUCE, THREE, FOUR, KING etc.), a suit
(CLUBS, SPADES, HEARTS, DIAMONDS), and the various possible poker hands
(PAIR, TWO_PAIR, STRAIGHT, etc.). These have also been completed for you.

### Deck

Deck is a class that represents a 52-card standard playing card deck. It contains
an array of Cards called cardArray. Lucky for you, all the constructors and the overridden
version of toString have all been done already. You will, however, be completing the
following methods:

* **public Card cardAt(int index):** Given an index, it returns the Card at that index
in the Deck. If the index is invalid, it returns null.
* **public int indexOf(Card card):** Does the opposite of the above method. Returns the
index of the given card. Returns -1 if it doesn't find it.
* **public void shuffle():** Rearranges the cards randomly. I recommend the in-place
(Durstenfield) version of the Fisher-Yates shuffle. Check
[here](http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_.22inside-out.22_algorithm)
to see what that gibberish means: Also a random number of standard "riffle" shuffles works, too.
* **public void cut():** Puts the top half of the deck on the bottom.

### FiveCardHand

This class represents a standard five card hand in poker. It has two fields:
Card[] hand and Card[] ordered. hand is the array of cards this FiveCardHand represents
and ordered is the sorted version of hand. Once again, all the constructors have
been created for you, as well as the methods, setOrdered() which sets the ordered field
equal to a sorted version of hand, the overriden toString, and also the method getHand
which returns a copy of the hand field. These are the methods YOU will be completing.

* **public void setCard(int index, Card card):** Sets the card at the given index then
re-orders the ordered field, and throws an exception if the index is bad.
* **public Card getCard(int index):** Gets a COPY of the card at the given index and throws
an exception if the index is bad.
* **public PokerHand classify():** Returns the best possible poker hand you can make
out of the hand.
* **public boolean containsPair():** Returns true if the hand contains a pair
(at least two of the cards are the same).
* **public boolean containsTwoPair():** Returns true if the hand contains two pairs.
* **public boolean containsThreeOfAKind():** Returns true if the hand contains at
least three cards of a single rank.
* **public boolean containsStraight():** Returns true if all the cards in the hand
are in sequential order. Note that A-2-3-4-5 and 10-J-Q-K-A are both straights.
* **public boolean containsFlush():** returns true if all the cards have the same suit.
* **public boolean containsFullHouse():** Returns true if the hand contains a full house.
In other words, it returns true if the hand contains three cards of one rank and two of another.
For Example, A-A-A-K-K or 7-7-7-2-2.
* **public boolean containsFourOfAKind():** Returns true if the hand contains at
least four cards of the same rank.
* **public boolean containsStraightFlush():** Returns true if the hand contains both
a straight and a flush. The wording of the desciption is a hint on how to easily complete this one.
*Wink wink nudge nudge.*

### Video Poker

Video poker is the main java file here. It should be the only class with a main method.
Some of the method is filled out for you, as well as the method payout which returns
the payout based on given hand and wager, and a method to check if a String is a valid
positive integer greater than one. This program should be run like this:
*java poker.VideoPoker <numberOfStartingCredits>*

* **public static void main(String[] args):** Yup. We've seen this guy before. The flow
of the game will all be taken care of here. Whenever a message is printed out, or
the user prompted for input, that happens here. Valid input should be checked for here,
etc. etc. Here's how the game's flow should work:
    * User is asked for a wager, or in other words, how much he/she wants to bet.
    * If the wager is invalid, tell them and ask for it again.
    * Subtract the wager from the number of credits.
    * Create, shuffle, and cut a deck of a cards.
    * Deal five cards from the deck and display them to the user.
    * The user is prompted to type the slots of the cards they want to keep. For example,
    if they type 1, 2, 4 or 1 2 4 or 1,2,4 then the first, second, and fourth card in
    the hand are held, and the rest (third and fifth) are exchanged for new ones. If
    they give you gibberish or bad numbers, then ask again.
    * The new hand is displayed.
    * The classification of the new hand is displayed (i.e. Pair, Two Pair, Flush, etc.).
    * The player's winnings are displayed.
    * The player's new credit total is displayed.
    * If the user still has credits, they are asked if they wish to play again.
    * Repeat the above steps if they enter "y", "Y", or "yes".
    * Quit (and thank them politely for playing—we're not animals) if they enter
    "n", "N", or "no".
    * Ask again if they give you gibberish.

**DON'T FORGET TO COMMIT AT THE END OF CLASS (or at least, at the end of the day in which we had class).**

You're also encouraged to commit after every milestone (finish a method, class, stubs, etc.).
