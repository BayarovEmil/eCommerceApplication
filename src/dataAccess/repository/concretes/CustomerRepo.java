package dataAccess.repository.concretes;

import core.exception.FileCannotBeUptadableException;
import dataAccess.repo.abstracts.FileOperations;
import dataAccess.repo.concretes.FileOperationsService;
import dataAccess.repository.abstracts.CardRepository;
import dataAccess.repository.abstracts.CustomerRepository;
import entity.user.Customer;

import java.io.IOException;

public class CustomerRepo implements CustomerRepository {
    private final FileOperations fileOperations = new FileOperationsService();
    private final CardRepository cardRepository = new CardRepo();
    private final String fileName = "C:\\Users\\LENOVO\\IdeaProjects\\eCommerceApplication\\src\\dataAccess\\repo\\file\\customers.txt";


    @Override
    public void createCustomer(Customer customer) {
        String data = customer.getId()+","+customer.getNickname()+","+customer.getEmail()
                +","+customer.getPassword()
                +customer.getFirstname()+","+customer.getLastname()+","
               +customer.getAddress()+"," +customer.getCard().getCardNumber();
        cardRepository.addNewCardAccount(customer.getCard());
        fileOperations.writeToFile(data,fileName);
    }

    @Override
    public void getAllCustomers() {
        fileOperations.getAll(fileName);
    }

    @Override
    public void deleteCustomerById(Customer customer) {
        fileOperations.deleteById(customer.getId(), fileName);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        String data = customer.getId()+","+customer.getNickname()+","+customer.getEmail()
                +","+customer.getPassword()
                +customer.getFirstname()+","+customer.getLastname()+","
                +customer.getAddress();
        try {
            fileOperations.updateById(customer.getId(), fileName,data);
        } catch (IOException e) {
                throw new FileCannotBeUptadableException("This file cannot be updatable.");
        }
    }

    @Override
    public void getCustomerById(Customer customer) {

    }

    @Override
    public boolean isEmailAlreadyExists(String email) {
        if (fileOperations.getByEmail(email,fileName)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmailAndPasswordCorrect(String email, String password) {
        if (fileOperations.isEmailAndPasswordCorrect(email,password,fileName)) {
            return true;
        }
        return false;
    }
}
