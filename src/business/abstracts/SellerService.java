package business.abstracts;

import business.abstracts.registration.UserService;
import entity.order.Product;

public interface SellerService extends UserService {

    void addNewProduct(Product product);
    void deleteProductById(Product product);
//    void updateProductById(Product product);

    void getAllOrders();
    void sendYourItemByProductId(Product product);
    void showAllProducts();
}
