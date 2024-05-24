package business.concretes.observer;

import entity.order.Product;
import entity.user.Customer;

import java.util.ArrayList;
import java.util.List;

public class ProductObservable implements Observable{
    private List<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer: observers) {
            observer.update(message);
        }
    }

    public void buyProduct(Product product, Customer customer) {
        notifyObservers("Product /"+product.getId()+"/ "
                + product.getProductName() + " has been bought by "
                + customer.getNickname());
    }
}
