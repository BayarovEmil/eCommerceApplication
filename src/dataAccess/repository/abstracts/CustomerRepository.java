package dataAccess.repository.abstracts;

import entity.user.Customer;

public interface CustomerRepository {
    void createCustomer(Customer customer);
    void getAllCustomers();
    void deleteCustomerById(Customer customer);
    void updateCustomerById(Customer customer);
    void getCustomerById(Customer customer);
    boolean isEmailAlreadyExists(String email);
    boolean isEmailAndPasswordCorrect(String email,String password);
}
