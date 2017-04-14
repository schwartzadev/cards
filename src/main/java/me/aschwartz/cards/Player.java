package me.aschwartz.cards;

import java.util.ArrayList;

/**
 * Created by werdn on 4/7/17.
 */
public class Player {
    private Hand hand = new Hand();
    private int total;

    public Player() {
    }

    public Hand getHand() {
        return hand;
    }


    public ArrayList<Card> getCards() {
        return hand.getCards();
    }

    public void addCard(Card c) {
        this.getCards().add(c);
    }

    public Card findCard(int i) {
        return this.getCards().get(i);
    }

}
