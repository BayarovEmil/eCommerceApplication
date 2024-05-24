package business.abstracts;

import entity.order.Product;

public interface ProductService {
    void showAllProducts();
    void findProductsByName(Product product);
    void findProductsByCategory(Product product);
    void findProductByIsDiscounted();
    void findProductByGreaterThanPrice(Integer unitPrice);
    void findProductByLessThanPrice(Integer unitPrice);
    void findProductsBetweenPrices(Integer price1, Integer price2);
    void findProductById(Integer id);
}
