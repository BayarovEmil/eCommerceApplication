package entity.user;

import entity.order.Card;

public class Seller extends User {

    private Card card;

    @Override
    public void update(String message) {
        System.out.println("Seller " + super.getNickname() + " received notification: " + message);
    }

    public Seller() {}

    // todo singleton design pattern
    public Seller(Card card) {
        this.card = card;
    }

    public Seller(Integer id, String nickname, String email, String password, Card card) {
        super(id, nickname, email, password);
        this.card = card;
    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
