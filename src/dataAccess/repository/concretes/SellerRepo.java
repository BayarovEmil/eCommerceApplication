package dataAccess.repository.concretes;

import core.exception.FileCannotBeUptadableException;
import dataAccess.repo.abstracts.FileOperations;
import dataAccess.repo.concretes.FileOperationsService;
import dataAccess.repository.abstracts.CardRepository;
import dataAccess.repository.abstracts.SellerRepository;
import entity.user.Seller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SellerRepo implements SellerRepository {
    private final FileOperations fileOperations = new FileOperationsService();
    private final CardRepository cardRepository = new CardRepo();
    private final String fileName = "C:\\Users\\LENOVO\\IdeaProjects\\eCommerceApplication\\src\\dataAccess\\repo\\file\\sellers.txt";
//    Path fileName = Paths.get("C:\\Users\\LENOVO\\IdeaProjects\\eCommerceApplication\\src\\dataAccess\\repo\\file\\sellers.txt");
    @Override
    public void createSeller(Seller seller) {
        String data = seller.getId()+","+seller.getNickname()+","+seller.getEmail()
                +","+seller.getPassword()+","
                +seller.getCard().getCardNumber();
        cardRepository.addNewCardAccount(seller.getCard());
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
