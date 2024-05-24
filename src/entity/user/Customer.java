package entity.user;

public class Customer extends User {
    private String firstname;
    private String lastname;
    private String address;

    private String card;

    @Override
    public void update(String message) {
        System.out.println("Customer " + firstname + " received notification: " + message);
    }

    public Customer(){}

    public Customer(String firstname, String lastname, String address, String card) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.card = card;
    }

    public Customer(Integer id, String nickname, String email, String password, String firstname, String lastname, String address, String card) {
        super(id, nickname, email, password);
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.card = card;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
