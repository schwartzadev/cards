package me.aschwartz.cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Andrew Schwartz on 4/7/17.
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * Constructs a shuffled deck of 52 cards, numbered 1-13, one for each suit. (From A&spades; to K&clubs;.)
     * @see Card
     */
    public Deck() {
        for (int i = 1; i <= 13; i++) {
            Card card = new Card(i, Card.Suit.spades);
            cards.add(card);
            Card card1 = new Card(i, Card.Suit.hearts);
            cards.add(card1);
            Card card2 = new Card(i, Card.Suit.diamonds);
            cards.add(card2);
            Card card3  = new Card(i, Card.Suit.clubs);
            cards.add(card3);
        }
        this.shuffle();
    }

    /**
     * "Draws" the top card from the deck.
     * This gets the top card from the deck, removes it, and then returns it.
     * @return The card from the very top of the deck
     */
    public Card draw() {
        Card c = this.cards.get(0);
        this.cards.remove(0);
        return c;
    }

    /**
     * Shuffles the cards using Collections.shuffle
     * @see Collections
     */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    /**
     * Thit method simply returns the cards ArrayList
     * @return <code>ArrayList<Card> cards</code>
     */
    @Override
    public String toString() {
        return cards.toString();
    }

    /**
     * Gets the list of all cards in the deck.
     * @return <code>ArrayList&lt;Card&gt;</code> list of all cards in the deck
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

}
