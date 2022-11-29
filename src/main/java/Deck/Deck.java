package Deck;

import Cards.Card;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;

public class Deck {
    ArrayDeque<Card> startDeck;
    ArrayDeque<Card> deck;

    public Deck(ArrayDeque<Card> startDeck) {
        this.startDeck = startDeck;
        this.deck = mixedDeck(startDeck);
    }

    public ArrayDeque<Card> getStartDeck() {
        return startDeck;
    }

    public void setStartDeck(ArrayDeque<Card> startDeck) {
        this.startDeck = startDeck;
    }

    public ArrayDeque<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayDeque<Card> deck) {
        this.deck = deck;
    }


    public Card getFirstCard(ArrayDeque<Card> deck){
            return deck.pollFirst();
    }

    public ArrayDeque<Card> mixedDeck(ArrayDeque<Card> deck){
        List<Card> resList = deck.stream().toList();
        Collections.shuffle(resList);
        ArrayDeque<Card> res = new ArrayDeque<Card>();
        for (Card card: resList) {
            res.addFirst(card);
        }
        return res;
    }

}
