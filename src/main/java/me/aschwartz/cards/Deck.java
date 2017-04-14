package me.aschwartz.cards;

import me.aschwartz.cards.Card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by werdn on 4/7/17.
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();

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

    public Card draw() {
        Card c = this.cards.get(0);
        this.cards.remove(0);
        return c;
    }

    void shuffle() {
        Collections.shuffle(this.cards);
    }


    @Override
    public String toString() {
        return cards.toString();
    }
}
