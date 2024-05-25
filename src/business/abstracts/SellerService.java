package business.abstracts;

import business.abstracts.registration.UserService;
import entity.order.Product;

public interface SellerService extends UserService {

    void addNewProduct(Product product);
    void deleteProductById(Product product);
    void updateProductById(Product product,Product product2);

    void getAllOrders();
    void sendYourItemByProductId(String data);
    void showAllProducts();
}
