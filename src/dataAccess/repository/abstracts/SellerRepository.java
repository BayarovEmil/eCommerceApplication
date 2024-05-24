package dataAccess.repository.abstracts;

import entity.user.Seller;

public interface SellerRepository {
    void createSeller(Seller seller);
    void getAllSellers();
    void deleteSellerById(Seller seller);
    void updateSellerById(Seller seller,String data);

    void getSellerByStoreName(Seller seller);

    boolean isEmailAlreadyExists(String email);
//    void getAllSavedSellers();
}
