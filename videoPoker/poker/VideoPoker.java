package poker;

import java.util.Scanner;

/**
 * A command line Video Poker simulation class. Guaranteed fun or your fake
 * digital money back! The program should be run like this:
 * java poker.VideoPoker <numberOfCredits>. After the program is run, the user
 * is prompted for a wager (which should be > 0 but less than his/her number of
 * credits). Five cards are then dealt from a deck and put in a hand. The user
 * has the option of holding any number of cards while the rest are discarded and
 * the same number then drawn. After that, the user should receive a payout based
 * on whatever poker hand he/she can make out of the five cards. Lastly, the user
 * is prompted whether he/she wants to play again if he/she has any credits left.
 */
public class VideoPoker {

    /**
     * Number of times the deck should be shuffled before each round.
     */
    private static final int SHUFFLE_NUMBER = 10;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java "
                    + "edu.lmu.edu.cs.akhayat.poker.VideoPoker <credits>");
        } else if (!isValidNumber(args[0])) {
            System.out.println("Credits must be a positive integer > 0.");
        } else {
            boolean playAgain = false;
            int credits = Integer.parseInt(args[0]);
            // Constructs a Scanner object which takes in user input.
            Scanner input = new Scanner(System.in);
            // The game loop. It loops while playAgain is true;
            do {
                // Feel free to tweak any messages.

                        //put this v in a while loop to check if the wager is valid and 
                        //prompt the user for another wager if theirs is invalid
                System.out.println("Credits: " + credits);
                System.out.println("How much would you like to wager?");

                // input.nextLine() prompts the user for input and stores it in
                // a String object.
                String wagerInput = input.nextLine();
                //TODO: Handle the wager input and deal some cards.
                int wager = Integer.parseInt(wagerInput);
                credits = credits - wager;
                if (wager < 0) {
                    System.out.println("Please enter a valid wager.");
                } 

                        // figure out if this is all you need to do ****************************************
                        // need to have the code ask for a valid wager again if the wager is wrong

                Deck deck = new Deck(SHUFFLE_NUMBER, true);

                Card[] cardArray = new Card[5];
                int topOfDeck = 0;
                cardArray[0] = deck.cardAt(topOfDeck++);
                cardArray[1] = deck.cardAt(topOfDeck++);
                cardArray[2] = deck.cardAt(topOfDeck++);
                cardArray[3] = deck.cardAt(topOfDeck++);
                cardArray[4] = deck.cardAt(topOfDeck++);

                FiveCardHand hand = new FiveCardHand(cardArray);

                System.out.println(hand);

                System.out.println("Type the numbers of the slots (1-5) you "
                        + "want to hold separated by spaces or commas...");
                System.out.println("Or press ENTER to discard them all.");

                String inputString = input.nextLine();
                // This semi-complex line of code takes whatever string was given,
                // and splits it via comma and/or space. In other words, it takes
                // anything comma/space separated and puts it in an Array. For example,
                // if the user inputs "1, 2, 5" or "1 2 5", the array ["1", "2", "5"]
                // is created.
                String[] slots = inputString.isEmpty() ? new String[0]
                        : inputString.split(", | |,");

                        //int[] numSlots = Integer.parseInt[slots]; //******************************************************
                //TODO: Switch out the cards they didn't want to keep.
                //      Then classify their hand and give them money based on
                //      the payout method.

                        //need to parseInt the string to make it so we can refer to the indices

                        //use setCard in FiveCardHand and you will use the index the user gives you and then switch it
                        // with the card at the top of the deck, would have to switch the system.out.println to 
                        // to say something that would make sense for switching out the cards they don't want
                
                for (int i=0; i < slots.length; i++) {
                    int slot = Integer.parseInt(slots[i]) - 1;
                    hand.setCard(slot, deck.cardAt(topOfDeck++));
                }
                System.out.println(hand);
                System.out.println(hand.classify());
                

                if (credits <= 0) {
                    playAgain = false;
                    System.out.println("Sorry, you're out of dough.");
                } else {
                    System.out.println("Play again? (y/n)");
                    String yesOrNo = input.nextLine();

                    //TODO: Find out when to quit.
                }
            } while (playAgain);
            System.out.println("Thanks for playing!");
        }
    }

    /**
     * Returns true if the given string is a valid integer greater than 0.
     */
    private static boolean isValidNumber(String text) {
        try {
            return Integer.parseInt(text) > 0;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Returns the the payout for the given hand and wager.
     * You can fiddle with the numbers if you want.
     */
    private static int payout(FiveCardHand hand, int wager) {
        switch(hand.classify()) {
            case STRAIGHT_FLUSH:  return wager * 50;
            case FOUR_OF_A_KIND:  return wager * 25;
            case FULL_HOUSE:      return wager * 15;
            case FLUSH:           return wager * 10;
            case STRAIGHT:        return wager * 5;
            case THREE_OF_A_KIND: return wager * 2;
            case TWO_PAIR:        return wager;
            case PAIR:            return wager / 2;
            default:              return 0;
        }
    }
}
