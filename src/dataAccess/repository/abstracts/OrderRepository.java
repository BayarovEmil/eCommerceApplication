package dataAccess.repository.abstracts;

import entity.order.Product;

public interface OrderRepository {
    void saveOrder(Product product);
    void showAllOrders();

}
