public class Card {

    private char rank;
    private char suit;

    public Card(char rank, char suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public char getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }

    public boolean equals(Card card){
        return card.getRank() == rank || card.getSuit() == suit;
    }

}
