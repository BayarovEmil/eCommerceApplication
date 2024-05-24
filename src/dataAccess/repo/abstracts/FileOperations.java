package dataAccess.repo.abstracts;

import entity.order.Product;

import java.io.IOException;

public interface FileOperations {
    void getAll(String fileName);
    void writeToFile(String text,String fileName);
    void deleteById(Integer id,String fileName);
    void updateById(Integer id,String fileName,String data) throws IOException;
    void getById(Integer id,String fileName);

    void getAllProductsByProductName(Product product,String fileName);
    void getAllProductsByCategory(Product product,String fileName);
    void getAllProductsLessThanPrice(Product product,String fileName);
    void getAllProductsGreaterThanPrice(Product product,String fileName);

    void getSellerByStoreName(String nickname, String fileName);
}
