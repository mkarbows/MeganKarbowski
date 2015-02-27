package poker;

/**
 * Represents a standard 52-card deck. Mostly just a wrapper around
 * an array of Cards.
 */
public class Deck {

    /**
     * Right now, this Deck only handles 52 cards, but in the future,
     * maybe functionality for jokers could be added.
     */
    private final int DECK_SIZE = 52;
    private Card[] cardArray = new Card[DECK_SIZE];

    /**
     * Constructs a deck with all the cards in order of rank.
     */
    public Deck() {
        this(0);
    }

    /**
     * Constructs a deck and shuffles it the given amount of times.
     */
    public Deck(int numberOfShuffles) {
        this(numberOfShuffles, false);
    }

    /**
     * Constructs a deck with the given number of shuffles and
     * cuts it afterwards if cut is true.
     */
    public Deck(int numberOfShuffles, boolean cut) {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                int index = rank.ordinal()
                        + (suit.ordinal() * Rank.values().length);
                cardArray[index] = new Card(rank, suit);
            }
        }

        for (int i = 0; i < numberOfShuffles; i++) {
            shuffle();
        }

        if (cut) {
            this.cut();
        }
    }

    /**
     * Returns a COPY of the card at the given index.
     */
    
    public Card cardAt(int index) {
        if (index < 0 || index > cardArray.length) {
            return null;
        } 
        else {
          Card oldCard = this.cardArray[index];
          Card newCard = new Card(oldCard.getRank(), oldCard.getSuit());
          return newCard;
        }
    }

    /**
     * Returns the index of the given card or -1 if it doesn't exist.
     * Theoretically it should never return -1 but in practice, shit happens...
     */
    public int indexOf(Card card) {
        for (int i = 0; i < cardArray.length; i++) { 
            if (this.cardAt(i).equals(card)) {
                return i;
            } 
        }
          return -1;  
    }


    /**
     * Rearranges the cards randomly.
     * I recommend the in-place (Durstenfield) version of the Fisher-Yates shuffle.
     * Check here to see what that gibberish means:
     * http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_.22inside-out.22_algorithm
     * Also a random number of "riffle" shuffles works, too.
     */

    public void swap(int i, int j) {
        Card cardToSwap = this.cardArray[i];
        this.cardArray[i] = this.cardArray[j];
        this.cardArray[j] = cardToSwap;
    }

    public void shuffle() {
        for (int i = 0; i < cardArray.length; i++) {
            int j = (int)(Math.random() * (cardArray.length - 1 - i));
            this.swap(i, j);
        }
    }

    /**
     * Takes the top half of the deck and puts it on the bottom.
     */
    public void cut() {
        for (int i = 0; i < cardArray.length / 2; i++) {
            this.swap(i, i + 26);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        for (Card card : cardArray) {
            result.append(", " + card.toString());
        }
        return result.append(" ]").toString().replaceFirst(",", "[");
    }
}
