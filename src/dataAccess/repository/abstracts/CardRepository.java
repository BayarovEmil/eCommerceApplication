package dataAccess.repository.abstracts;

import entity.order.Card;

public interface CardRepository {
    boolean findByCardNumber(String number);
    void addNewCardAccount(Card card);
    void increaseBalanceByCardNumber(Card card,Integer amount);
    void decreaseBalanceByCardNumber(Card card,Integer amount);
}
