package business.concretes.manager;

import business.abstracts.CustomerService;
import business.abstracts.registration.Response;
import business.concretes.observer.Observer;
import business.concretes.observer.ProductObservable;
import business.utils.ReturnPolicy;
import dataAccess.repository.concretes.CustomerRepo;
import dataAccess.repository.concretes.ProductRepo;
import entity.order.Product;
import entity.user.Customer;
import entity.user.User;

public class CustomerManager implements CustomerService {
    private final ReturnPolicy returnPolicy = new ReturnPolicy();
    private final CustomerRepo customerRepo = new CustomerRepo();
//    private final CustomerRepo customerRepo = new CustomerRepo(getFileOperationInstance());
    private final ProductRepo productRepo = new ProductRepo();

    @Override
    public void returnProduct(Product product) {
        //TODO
        System.out.println(Response.UNCOMPLETED_OPERATION);
    }

    @Override
    public void enterCardInformation() {
        //todo
        System.out.println(Response.UNCOMPLETED_OPERATION);
    }

    @Override
    public void balanceOperations() {
        //todo
        System.out.println("Your balance increased!");
    }

    @Override
    public void sendInformationToSeller(Product product,Customer customer) {
        ProductObservable productObservable = new ProductObservable();
        productObservable.addObserver(new SellerManager());
        productObservable.buyProduct(product,customer);
    }

    @Override
    public void getSuccessMessage() {
        System.out.println("Buying operation completed successfully!");
    }

    @Override
    public boolean checkItemIsAvailable(Product product) {
        if (productRepo.getProductById(product.getId())) {
            return true;
        }
        return false;
    }

    @Override
    public void forgotPassword(User user) {
        //todo
        System.out.println(Response.UNCOMPLETED_OPERATION);
    }

    @Override
    public void writeToDatabase(User user) {
        customerRepo.createCustomer((Customer) user);
    }

    @Override
    public boolean checkUserInfoFormat(User user) {
        if (!user.getEmail().contains("@gmail.com")) {
            System.out.println("Email format is wrong!");
            return false;
        }
        if (user.getPassword().length()<=4) {
            System.out.println("Password length must long 4character!");
            return false;
        }
        return true;
    }


    @Override
    public boolean checkIsUserEmailAndPasswordAreCorrect(String email, String userEmail) {
        if (customerRepo.isEmailAlreadyExists(email)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIsEmailAlreadyExists(String email) {
        if (customerRepo.isEmailAlreadyExists(email)) {
            return true;
        }
        return false;
    }

    @Override
    public void verificationMessage() {
        System.out.println("Operation is completed successfully!");
    }

    public void returnProductV2(Product product){
        returnPolicy.returnProduct(product);
    }


}