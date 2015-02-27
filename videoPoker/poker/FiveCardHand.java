package poker;

import java.util.Arrays;

/**
 * Represents a five card hand in poker.
 */
public class FiveCardHand {

    /**
     * This class ain't called SixCardHand...
     */
    public static final byte HAND_SIZE = 5;

    /**
     * Represents the hand in whatever order it was created.
     */
    private Card[] hand;
    /**
     * Represents the hand, but ordered from lowest rank to highest.
     */
    public Card[] ordered;

    /**
     * Constructs a five card hand.
     * Surprise, suprise, it freaks out if hand isn't of length 5.
     */
    public FiveCardHand(Card[] hand) {
        if (hand.length != HAND_SIZE) {
            throw new IllegalArgumentException(
                    "Card array must contain " + HAND_SIZE + " cards.");
        }
        this.hand = hand;
        setOrdered();
    }

    /**
     * Creates a copy of the hand array, sticks it in ordered, and sorts it.
     */
    private void setOrdered() {
        ordered = Arrays.copyOf(hand, hand.length);
        Arrays.sort(ordered);
    }

    /**
    * Returns a COPY of the card array representing the hand.
    */
    public Card[] getHand() {
        return Arrays.copyOf(hand, hand.length);
    }

    /**
     * Sets the card at the given index and reorders the ordered array,
     * or throws a hissy fit if the index is bad.
     */
    public void setCard(int index, Card card) {
        if (index < HAND_SIZE && index >= 0) {
            this.hand[index] = card;
            this.setOrdered();
        } else {
            throw new IllegalArgumentException(
                "No card at the given index: " + index);
        }
    }

    /**
     * Returns a COPY of the card at the given index. Or freaks out out if
     * it's a bad index.
     */
    public Card getCard(int index) {
        if (index >= 0 && index < HAND_SIZE) {
            Card c = this.hand[index];
            return c;
        } else {
            throw new IllegalArgumentException(
                "No card at the given index: " + index);
        }
    }

    /**
    * Returns the best poker hand you can make given this hand's cards.
    */
    public PokerHand classify() {
        if (containsStraightFlush() == true) {
            return PokerHand.STRAIGHT_FLUSH;
        } 
        if (containsFourOfAKind() == true) {
            return PokerHand.FOUR_OF_A_KIND;
        }
        if (containsFullHouse() == true) {
            return PokerHand.FULL_HOUSE;
        }
        if (containsFlush() == true) {
            return PokerHand.FLUSH;
        }
        if (containsStraight() == true) {
            return PokerHand.STRAIGHT;
        }
        if (containsThreeOfAKind() == true) {
            return PokerHand.THREE_OF_A_KIND;
        }
        if (containsTwoPair() == true) {
            return PokerHand.TWO_PAIR;
        }
        if (containsPair() == true) {
            return PokerHand.PAIR;
        } else {
            return PokerHand.HIGH_CARD;
        } 
    }

    /**
     * Returns true if the hand has at least one pair (two of the same card).
     */
    public boolean containsPair() {
        return this.ordered[0].getValue() == this.ordered[1].getValue() ||
            this.ordered[1].getValue() == this.ordered[2].getValue() ||
            this.ordered[2].getValue() == this.ordered[3].getValue() ||
            this.ordered[3].getValue() == this.ordered[4].getValue(); 
    }

    /**
     * Returns true if the hand has two pairs.
     */
    public boolean containsTwoPair() {
        return this.ordered[0].getValue() == this.ordered[1].getValue() && this.ordered[1].getValue() == this.ordered[2].getValue() ||
            this.ordered[1].getValue() == this.ordered[2].getValue() && this.ordered[3].getValue() == this.ordered[4].getValue() ||
            this.ordered[0].getValue() == this.ordered[1].getValue() && this.ordered[3].getValue() == this.ordered[3].getValue();
    }

    /**
     * Returns true if the hand contains at least three of the same card.
     */
    public boolean containsThreeOfAKind() {
        return this.ordered[0].getValue() == this.ordered[1].getValue() && this.ordered[1].getValue() == this.ordered[2].getValue() ||
            this.ordered[1].getValue() == this.ordered[2].getValue() && this.ordered[2].getValue() == this.ordered[3].getValue() ||
            this.ordered[2].getValue() == this.ordered[3].getValue() && this.ordered[3].getValue() == this.ordered[4].getValue();
    }

    /**
     * Returns true if the five cards are in sequential order.
     * Remember, A-2-3-4-5 and 10-J-Q-K-A also count.
     */
    public boolean containsStraight() {
        for (int i = 0; i < hand.length - 1; i++) {
            if (this.ordered[i].getValue() != this.ordered[i+1].getValue() - 1 && 
                (i != 3 || this.ordered[i].getRank() != Rank.FIVE || this.ordered[i+1].getRank() != Rank.ACE)) {
                return false;
            } 
        } 
        return true;
    }

    /**
     * Returns true if all five cards have the same suit.
     */
    public boolean containsFlush() {
        for (int i = 0; i < hand.length - 1; i++) {
            if (this.ordered[i].getSuit() != this.ordered[i+1].getSuit()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the hand contains three cards of one rank and two cards
     * of another rank. For example three aces and two kings or three twos and
     * two fives.
     */
    public boolean containsFullHouse() {
        return this.ordered[0].getRank() == this.ordered[1].getRank() && this.ordered[1].getRank() == this.ordered[2].getRank() &&
            this.ordered[3].getRank() == this.ordered[4].getRank() ||
            this.ordered[0].getRank() == this.ordered[1].getRank() && this.ordered[2].getRank() == this.ordered[3].getRank() && 
            this.ordered[3].getRank() == this.ordered[4].getRank();
    }

    /**
     * Returns true if the the hand contains at least four cards of the same
     * rank.
     */
    public boolean containsFourOfAKind() {
        return this.ordered[0].getRank() == this.ordered[1].getRank() && this.ordered[1].getRank() == this.ordered[2].getRank() &&
            this.ordered[2].getRank() == this.ordered[3].getRank() ||
            this.ordered[1].getRank() == this.ordered[2].getRank() && this.ordered[2].getRank() == this.ordered[3].getRank() &&
            this.ordered[3].getRank() == this.ordered[4].getRank();
    }

    /**
     * Returns true if the hand contains both a straight and a flush.
     */
    public boolean containsStraightFlush() {
        return containsStraight() && containsFlush();
    }

    @Override
    public String toString() {
        return "[ " + hand[0].toString() + "  " + hand[1].toString()
                + "  " + hand[2].toString() + "  " + hand[3].toString()
                + "  " + hand[4].toString() + " ]";
    }
    public String orderedString() {
        Card [] oh = this.ordered;
        return "[ " + oh[0].toString() + "  " + oh[1].toString()
                + "  " + oh[2].toString() + "  " + oh[3].toString()
                + "  " + oh[4].toString() + " ]";
    }
}
