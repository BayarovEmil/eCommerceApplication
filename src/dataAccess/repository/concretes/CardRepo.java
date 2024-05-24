package dataAccess.repository.concretes;

import dataAccess.repo.abstracts.FileOperations;
import dataAccess.repo.concretes.FileOperationsService;
import dataAccess.repository.abstracts.CardRepository;
import entity.order.Card;

public class CardRepo implements CardRepository {
    private final FileOperations fileOperationsService =new FileOperationsService();
    private final String fileName = "C:\\Users\\LENOVO\\IdeaProjects\\eCommerceApplication\\src\\dataAccess\\repo\\file\\cards.txt";
    @Override
    public boolean findByCardNumber(String number) {
        return fileOperationsService.findByCardNumber(number,fileName);
    }

    @Override
    public void addNewCardAccount(Card card) {
        String data = card.getCardNumber()+","+card.getCvc()+","+card.getDate()+","+card.getBalance();
        fileOperationsService.writeToFile(data,fileName);
    }

    @Override
    public void increaseBalanceByCardNumber(Card card,Integer amount) {
        fileOperationsService.increaseBalance(card,amount,fileName);
    }

    @Override
    public void decreaseBalanceByCardNumber(Card card,Integer amount) {
        fileOperationsService.decreaseBalance(card,amount,fileName);
    }
}
