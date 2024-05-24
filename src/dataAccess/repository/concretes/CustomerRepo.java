package dataAccess.repository.concretes;

import core.exception.FileCannotBeUptadableException;
import dataAccess.repo.abstracts.FileOperations;
import dataAccess.repo.concretes.FileOperationsService;
import dataAccess.repository.abstracts.CustomerRepository;
import entity.user.Customer;

import java.io.IOException;

public class CustomerRepo implements CustomerRepository {
    private final FileOperations fileOperations;

    private final String fileName = "customers.txt";

    public CustomerRepo(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    @Override
    public void createCustomer(Customer customer) {
        String data = customer.getId()+","+customer.getNickname()+","+customer.getEmail()
                +","+customer.getPassword()
                +customer.getFirstname()+","+customer.getLastname()+","
               +customer.getAddress();
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
        fileOperations.getById(customer.getId(), fileName);
    }

    @Override
    public boolean isEmailAlreadyExists(String email) {
        return false;
    }
}
