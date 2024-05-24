package business.concretes;

import business.abstracts.SellerService;
import dataAccess.repo.concretes.FileOperationsService;
import dataAccess.repository.abstracts.SellerRepository;
import dataAccess.repository.concretes.SellerRepo;
import entity.order.Product;
import entity.user.Seller;
import entity.user.User;

public class DependencyManager {
    private static FileOperationsService fileOperationsService;

    public static FileOperationsService getFileOperationInstance(){
        if (fileOperationsService == null){
            //create new and return
        }

        return fileOperationsService;
    }
}
