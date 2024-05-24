package dataAccess.repository.abstracts;

import entity.order.Product;

public interface ProductRepository {
    void addNewProduct(Product product);
    void deleteProductById(Product product);
    void getAllProducts();
    void updateProductById(Product product,String data);

    void getAllProductsByProductName(Product product);
    void getAllProductsByCategory(Product product);
    void getAllProductsLessThanPrice(Product product);
    void getAllProductsGreaterThanPrice(Product product);

    Product getProductById(Integer id);

}
