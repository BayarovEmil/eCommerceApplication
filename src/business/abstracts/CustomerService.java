package business.abstracts;

import business.abstracts.registration.UserService;
import entity.order.Card;
import entity.order.Product;
import entity.user.Customer;

public interface CustomerService extends UserService {

    default void buyProductById(Product product,Customer customer) {
        if (!checkItemIsAvailable(product)) {
            return;
        }
        balanceOperations(customer.getCard(),product.getUnitPrice());
        sendInformationToSeller(product, customer);
        getSuccessMessage();
    }



    default void returnProduct(Product product) {
//        returnProductV2();TODO: implement method
        // write reason of returning
        // write seller of item
        // check is item returnable
        // seller send message
        // information
        // balance changing
    }



    void balanceOperations(Card card, Integer unitPrice);
    void sendInformationToSeller(Product product, Customer customer);
    void getSuccessMessage();
    boolean checkItemIsAvailable(Product product);
}
