package me.aschwartz.cards;

import java.util.ArrayList;

/**
 * Created by Andrew Schwartz on 4/9/17.
 */
public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int total;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public boolean hasBlackjack() {
        return (this.cards.get(0).isAce() && this.cards.get(1).isFace()) || (this.cards.get(1).isAce() && (this.cards.get(0).isFace()));
    }

    public boolean hasTwentyOne() {
        return this.getMaxTotal() == 21;
    }

    public boolean isBusted() {
        return this.getMaxTotal() > 21;
    }

    public ArrayList<Integer> getTotal() {
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

    public int getMaxTotal() {
        return this.getTotal().get(this.getTotal().size()-1);
    }

    public void print() {
        for (Card c : this.getCards()) {
            System.out.print(c + " ");
        }
        for (int i : this.getTotal()) {
            System.out.print("(" + i + ") ");
        }
        System.out.println("");
    }

}
