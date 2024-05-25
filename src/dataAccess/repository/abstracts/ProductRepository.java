package dataAccess.repository.abstracts;

import entity.order.Product;

public interface ProductRepository {
    void addNewProduct(Product product);
    void deleteProductById(Product product);
    void getAllProducts();
    void updateProductById(Product product,Product product2);

    void getAllProductsByProductName(Product product);
    void getAllProductsByCategory(Product product);
    void getAllProductsLessThanPrice(Integer unitPrice);
    void getAllProductsGreaterThanPrice(Integer unitPrice);
    void getAllProductBetweenPrices(Integer price1, Integer price2);

    boolean getProductById(Integer id);

}
