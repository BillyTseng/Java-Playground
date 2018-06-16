package come.OOD_IV_BlackJack.attempt01;

public class Card {
    private final FaceValue faceValue;
    private final Suit suit;

    public Card(FaceValue faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    public Suit getSuit() {
        return suit;
    }
}
