package me.aschwartz.cards;

import java.util.ArrayList;

/**
 * Created by Andrew Schwartz on 4/9/17.
 */
public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int total;

    /**
     * Gets the <code>ArrayList<Card> cards</code> of the <code>Hand</code> object.
     * @return <code>ArrayList&lt;Card&gt;</code> list of cards in the <code>Hand</code>.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Determines whether or not the hand has Blackjack (an Ace and a 10 or face card)
     * @return Boolean: true means the Hand does have blackjack, false means it does not.
     */
    public boolean hasBlackjack() {
        return (this.cards.get(0).isAce() && (this.cards.get(1).isFace()) || this.cards.get(1).getValue() == 10) || (this.cards.get(1).isAce() && ((this.cards.get(0).isFace() || this.cards.get(0).getValue() == 10)));
    }

    /**
     * Determines if the sum of the value of the cards is 21
     * @return Boolean: true if the value is 21.
     */
    public boolean hasTwentyOne() {
        return this.getMaxTotal() == 21;
    }

    /**
     * Creates a new Hand. Not the preferred method for using/creating a <code>Hand</code>.
     * </br><b>This should not be used to create a new <code>Hand</code>.</b>
     * </br>Instead, create a new <code>Player</code> object, then use <code>Player.hand</code>
     * @see Player
     */
    public Hand() {

    }

    /**
     * Determines whether or not a Hand is busted, in the context of Blackjack (21).
     * @return Boolean: true, if the hand is busted.
     */
    public boolean isBusted() {
        return this.getMaxTotal() > 21;
    }

    /**
     * Gets the total for the <code>Hand</code>, in blackjack style.
     * </br>This returns a list of ints that include all of the possible options that a player can have, if they have an Ace.
     * </br>The lowest possibility is first, then highest is last.
     * @return A list of possible values that a <code>Hand</code> could be worth in Blackjack, considering aces.
     */
    public ArrayList<Integer> getBlackjackTotal() {
        ArrayList<Integer> totals = new ArrayList<Integer>();
        int aces = 0;
        this.total = 0;
        for (Card c : this.getCards()) {
            // total += c.isFace() ? 10 : c.getValue();
            if (!c.isFace()) {
                this.total += c.getValue();
            }
            if (c.isFace()) {
                this.total += 10;
            }
            if (c.isAce()) {
                aces++;
            }
        }
        totals.add(total);
        while (total+(aces*10) <= 21 && aces > 0) {
            total += 10;
            aces--;
            totals.add(total);
        }
        return totals;
    }

    /**
     * Gets the largest possible value of a <code>Hand</code>, in Blackjack.
     * </br>While this does work for other games, <code>getTotal()</code> is more efficient.
     * @return Highest possible value of a hand, in Blackjack.
     */
    public int getMaxTotal() {
        return this.getBlackjackTotal().get(this.getBlackjackTotal().size()-1);
    }

    /**
     * Prints the <code>Hand</code> by printing each card adjacently inside of parenthesis.
     * @return A String containing the list of each card in the <code>Hand</code>.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : this.getCards()) {
            // System.out.print(c + " ");
            sb.append(c + " ");
        }
        for (int i : this.getBlackjackTotal()) {
            sb.append("(" + i + ") ");
            // System.out.print("(" + i + ") ");
        }
        //System.out.println("");
        return sb.toString();
    }

}
