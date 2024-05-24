package entity.order;

public class Card {
    private String cardNumber;
    private String cvc;
    private String date;
    private Double balance;

    public Card() {}

    public Card(String cardNumber, String cvc, String date, Double balance) {
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.date = date;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
