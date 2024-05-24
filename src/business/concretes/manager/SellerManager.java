package business.concretes.manager;

import business.abstracts.SellerService;
import business.abstracts.registration.Response;
import business.concretes.observer.Observer;
import business.concretes.observer.ProductObservable;
import dataAccess.repository.abstracts.OrderRepository;
import dataAccess.repository.abstracts.ProductRepository;
import dataAccess.repository.abstracts.SellerRepository;
import dataAccess.repository.concretes.OrderRepo;
import dataAccess.repository.concretes.ProductRepo;
import dataAccess.repository.concretes.SellerRepo;
import entity.order.Product;
import entity.user.Seller;
import entity.user.User;

public class SellerManager implements SellerService, Observer {
    private final SellerRepository sellerRepo = new SellerRepo();
    private final ProductRepository productRepository = new ProductRepo();
    private final OrderRepository orderRepository = new OrderRepo();
    @Override
    public void getAllOrders() {
        orderRepository.showAllOrders();
    }

    @Override
    public void update(String message) {
        System.out.println(message);
        sendYourItemByProductId(message);
    }

    @Override
    public void sendYourItemByProductId(String data) {
        System.out.println("Seller send "+ data.split("/")[1]+" product");
    }

    @Override
    public void showAllProducts() {
        productRepository.getAllProducts();
    }

    @Override
    public void addNewProduct(Product product) {
        if (productRepository.getProductById(product.getId())) {
            return;
        }
        productRepository.addNewProduct(product);
    }

    @Override
    public void deleteProductById(Product product) {
        productRepository.deleteProductById(product);
    }

//    @Override
//    public void updateProductById(Product product,Product product2) {
//        productRepository.updateProductById(product,product2);
//    }

    @Override
    public void forgotPassword(User user) {
        // todo forgot password
        System.out.println("Imagine we return your password");
    }

    @Override
    public void writeToDatabase(User user) {
        sellerRepo.createSeller((Seller) user);
    }

    @Override
    public boolean checkUserInfoFormat(User user) {
        if (!user.getEmail().contains(".seller@gmail.com")) {
            System.out.println("Email format is wrong!");
            return false;
        }
        if (user.getPassword().length()<=6) {
            System.out.println("Password length must long 4character!");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkIsUserEmailAndPasswordAreCorrect(String email, String userEmail) {
        if (sellerRepo.isEmailAlreadyExists(email)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIsEmailAlreadyExists(String email) {
        if (sellerRepo.isEmailAlreadyExists(email)) {
            return true;
        }
        return false;
    }

    @Override
    public void verificationMessage() {
        System.out.println("Operation completed successfully!");
    }

}
