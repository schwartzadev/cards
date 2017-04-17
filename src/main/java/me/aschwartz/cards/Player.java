package me.aschwartz.cards;

import java.util.ArrayList;

/**
 * Created by Andrew Schwartz on 4/7/17.
 */
public class Player {
    private Hand hand = new Hand();
    private int total;

    /**
     * Empty constructor for a <code>Player</code> object.
     * </br>Contains a <code>Hand</code> object that should be used instead of an independent <code>Hand</code>.
     * @see Hand
     */
    public Player() {
    }

    /**
     * Adds a given card to a <code>Player</code>'s <code>Hand</code>.
     * @param c the card to be added to the <code>Player</code>'s <code>Hand</code>.
     */
    public void addCard(Card c) {
        this.getCards().add(c);
    }

    /**
     * Find's a card at a given index in a <code>Player</code>'s <code>Hand</code>.
     * @param i the index of the card
     * @return the card at index <code>i</code>.
     */
    public Card findCard(int i) {
        return this.getCards().get(i);
    }


    /**
     * Getter for a <code>Player</code>'s <code>Hand</code>.
     * @return <code>Hand</code>
     * @see Hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Gets an <code>ArrayList&lt;Card&gt;</code> of a <code>Player</code>'s cards.
     * @return A list of all of a <code>Player</code>'s cards.
     * @see Card
     */
    public ArrayList<Card> getCards() {
        return hand.getCards();
    }

}
