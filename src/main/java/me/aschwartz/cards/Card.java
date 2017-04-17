package me.aschwartz.cards;

/**
 * Created by Andrew Schwartz on 4/7/17.
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

    /**
     * Creates a Card instance
     * </br>
     * <b>This shouldn't be necessary to use on its own, and Cards should always be created through a Deck instance.</b>
     * @param value The value of the card. Aces are 1, Jacks are 11, Queens are 12, Kings are 13.
     * @param suit An enum of suits (spades, hearts, diamonds, clubs)
     * @see Deck
     */
    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Determines whether or not a card is an ace.
     * @return True, if the card is an ace. False otherwise.
     */
    public boolean isAce() { return this.value == 1; }

    /**
     * Determines whether or not a card is an face card: Jack, Queen, or King.
     * Note that this does return false if the card is an ace.
     * @return True, if the card is a face card. False otherwise.
     */
    public boolean isFace() { return this.value >= 11; }

    /**
     * Gets the <b>display</b> value for a given card, taking into account face cards and aces
     * @return Either the number or letter value of the card, as a String
     */
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
    /**
     * This is the classic toString method, and it will return the DisplayValue of the card (numbers for 2-10, letters for aces, queens, etc.), as well as the Unicode symbol for the suit
     * @return the suit and display value of the card, such as "Q&hearts;"
     */
    @Override
    public String toString() {
        return (getDisplayValue() + suit.getSymbol());
    }

    /**
     * Gets the value without any alterations for face cards or aces, for the given card
     * @return The value of the card, as an int
     */
    public int getValue() {
        return value;
    }

}
