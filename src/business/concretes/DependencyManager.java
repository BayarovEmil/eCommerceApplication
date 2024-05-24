package business.concretes;

import business.abstracts.SellerService;
import dataAccess.repository.abstracts.SellerRepository;
import dataAccess.repository.concretes.SellerRepo;
import entity.order.Product;
import entity.user.Seller;
import entity.user.User;

public class SellerManager implements SellerService {
    private final SellerRepository sellerRepository;

    public SellerManager() {
        this.sellerRepository = new SellerRepo();
    }

    @Override
    public void getAllOrders() {

    }

    @Override
    public void showSellingHistory() {

    }

    @Override
    public void getAllOffers() {

    }

    @Override
    public void getAllCommentsByProductId(Product product) {

    }

    @Override
    public void addNewProduct(Product product) {

    }

    @Override
    public void deleteProductById(Product product) {

    }

    @Override
    public void updateProductById(Product product) {

    }

    @Override
    public void forgotPassword(User user) {
        // todo forgot password
        System.out.println("Imagine we return your password");
    }

    @Override
    public void writeToDatabase(User user) {
        sellerRepository.createSeller((Seller) user);
    }

    @Override
    public boolean checkUserInfoFormat(User user) {
        if (user.getEmail().contains("@gmail.com")) {
            return false;
        }
        return user.getPassword().length() >= 6;
    }

    @Override
    public boolean checkIsUserEmailAndPasswordAreCorrect(String email, String userEmail) {
        return false;
    }

    @Override
    public boolean checkIsEmailAlreadyExists(String email) {

        return false;
    }

    @Override
    public void verificationMessage() {
        System.out.println("Operation completed successfully!");
    }
}
