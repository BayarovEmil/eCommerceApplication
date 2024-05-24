package business.concretes.manager;

import business.abstracts.CustomerService;
import business.abstracts.registration.Response;
import business.concretes.observer.ProductObservable;
import business.utils.ReturnPolicy;
import dataAccess.repository.abstracts.CardRepository;
import dataAccess.repository.concretes.CardRepo;
import dataAccess.repository.concretes.CustomerRepo;
import dataAccess.repository.concretes.ProductRepo;
import entity.order.Card;
import entity.order.Product;
import entity.user.Customer;
import entity.user.User;

public class CustomerManager implements CustomerService {
    private final ReturnPolicy returnPolicy = new ReturnPolicy();
    private final CustomerRepo customerRepo = new CustomerRepo();
//    private final CustomerRepo customerRepo = new CustomerRepo(getFileOperationInstance());
    private final ProductRepo productRepo = new ProductRepo();
    private final CardRepository cardRepository = new CardRepo();

    @Override
    public void returnProduct(Product product) {
        //TODO
        System.out.println(Response.UNCOMPLETED_OPERATION);
    }

    @Override
    public void balanceOperations(Card card, Integer unitPrice) {
        if (!cardRepository.findByCardNumber(card.getCardNumber())) {
            return;
        }
        cardRepository.decreaseBalanceByCardNumber(card,unitPrice);
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
