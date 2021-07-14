package modes;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerPin() {
        return customerPin;
    }

    public void setCustomerPin(int customerPin) {
        this.customerPin = customerPin;
    }

    public int getCustomerTag() {
        return customerTag;
    }

    public void setCustomerTag(int customerTag) {
        this.customerTag = customerTag;
    }

    private String email;
    private int customerPin;
    private int customerTag;
    private List<Wallet> customerWallet;

    public List<Wallet> getCustomerWallet() {
        return customerWallet;
    }

    public void setCustomerWallet(List<Wallet> customerWallet) {
        this.customerWallet = customerWallet;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    private List<Card> cards;

    public Customer(String firstName, String lastName, String email, int customerPin, int customerTag) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.customerPin = customerPin;
        this.customerTag = customerTag;
        this.customerWallet = Arrays.asList(new Wallet(0, this));
    }

}
