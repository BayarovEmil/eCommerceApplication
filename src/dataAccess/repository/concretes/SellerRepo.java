package dataAccess.repository.concretes;

import core.exception.FileCannotBeUptadableException;
import dataAccess.repo.abstracts.FileOperations;
import dataAccess.repo.concretes.FileOperationsService;
import dataAccess.repository.abstracts.SellerRepository;
import entity.user.Seller;

import java.io.IOException;

public class SellerRepo implements SellerRepository {
    private final FileOperations fileOperations = new FileOperationsService();
    private final String fileName = "sellers.txt";

    @Override
    public void createSeller(Seller seller) {
        String data = seller.getId()+","+seller.getNickname()+","+seller.getEmail()
                +","+seller.getPassword()
                +seller.getCard();
        fileOperations.writeToFile(data,fileName);
    }

    @Override
    public void getAllSellers() {
        fileOperations.getAll(fileName);
    }

    @Override
    public void deleteSellerById(Seller seller) {
        fileOperations.deleteById(seller.getId(), fileName);
    }

    @Override
    public void updateSellerById(Seller seller,String data) {
        try {
            fileOperations.updateById(seller.getId(), fileName, data);
        } catch (IOException e) {
            throw new FileCannotBeUptadableException("This seller's information cannot be updatable.");
        }
    }

    @Override
    public void getSellerByStoreName(Seller seller) {
        fileOperations.getSellerByStoreName(seller.getNickname(),fileName);
    }

    @Override
    public boolean isEmailAlreadyExists(String email) {
        return false;
    }
}
