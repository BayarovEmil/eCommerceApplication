package dataAccess.repo.abstracts;

import entity.order.Card;
import entity.order.Product;

import java.io.IOException;

public interface FileOperations {
    void getAll(String fileName);
    void writeToFile(String text,String fileName);
    void deleteById(Integer id,String fileName);
    void updateById(Integer id,String fileName,String data) throws IOException;
    boolean getById(Integer id,String fileName);

    void getAllProductsByProductName(Product product,String fileName);
    void getAllProductsByCategory(Product product,String fileName);
    void getAllProductsLessThanPrice(Integer unitPrice, String fileName);
    void getAllProductsGreaterThanPrice(Integer unitPrice,String fileName);
    void getAllProductsBetweenPrices(Integer price1, Integer price2,String fileName);

    void getSellerByStoreName(String nickname, String fileName);
    boolean getByEmail(String email,String fileName);
    boolean isEmailAndPasswordCorrect(String email,String password,String fileName);

    boolean findByCardNumber(String number, String fileName);
    void increaseBalance(Card card, Integer amount, String fileName);
    void decreaseBalance(Card card, Integer amount,String fileName);
}
