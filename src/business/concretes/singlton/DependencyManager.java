package business.concretes.singlton;

import dataAccess.repo.concretes.FileOperationsService;
import dataAccess.repository.abstracts.*;
import dataAccess.repository.concretes.*;

public class DependencyManager {
    private static FileOperationsService fileOperationsService;
    private static CardRepository cardRepo;
    private static CustomerRepository customerRepo;
    private static ProductRepository productRepository;
    private static SellerRepository sellerRepository;
    private static OrderRepository orderRepository;

    public static FileOperationsService getFileOperationInstance(){
        if (fileOperationsService == null){
            fileOperationsService = new FileOperationsService();
        }
        return fileOperationsService;
    }

    public static CardRepository getCardRepositoryInstance() {
        if (cardRepo == null) {
            cardRepo = new CardRepo();
        }
        return cardRepo;
    }

    public static CustomerRepository getCustomerRepositoryInstance() {
        if (customerRepo == null) {
            customerRepo = new CustomerRepo();
        }
        return customerRepo;
    }

    public static ProductRepository getProductRepositoryInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepo();
        }
        return productRepository;
    }

    public static SellerRepository getSellerRepositoryInstance() {
        if (sellerRepository == null) {
            sellerRepository = new SellerRepo();
        }
        return sellerRepository;
    }

    public static OrderRepository getOrderRepositoryInstance() {
        if (orderRepository == null) {
            orderRepository = new OrderRepo();
        }
        return orderRepository;
    }
}
