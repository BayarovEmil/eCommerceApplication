package business.abstracts;

import entity.order.Product;

public interface ProductService {
    void showAllProducts();
    void findProductsByName(Product product);
    void findProductsByCategory(Product product);
    void findProductByIsDiscounted();
    void findProductByGreaterThanPrice();
    void findProductByLessThanPrice();
    void findProductsBetweenPrices();
    void findProductById(Integer id);
}
