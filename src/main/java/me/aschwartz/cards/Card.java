package me.aschwartz.cards;

/**
 * Created by werdn on 4/7/17.
 */
public class Card {
    private String kind;

    enum Suit {
        spades("\u2660"),hearts("\u2665"),diamonds("\u2666"),clubs("\u2663");
        private String symbol;

        Suit(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    private final int value;
    private final Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return (getDisplayValue() + suit.getSymbol());
    }

    boolean isAce() { return this.value == 1; }
    boolean isFace() { return this.value >= 11; }

    public String getDisplayValue() {
        if(this.isAce()) {
            return "A";
        }

        if(!this.isFace()) {
            return String.valueOf(this.value);
        }

        switch(this.value) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
        }

        return "?";
    }

    public int getValue() {
        return value;
    }

    public String getKind() {
        return kind;
    }


}
