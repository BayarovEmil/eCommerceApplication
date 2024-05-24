package business.concretes.manager;

import dataAccess.repo.concretes.FileOperationsService;

public class DependencyManager {
    private static FileOperationsService fileOperationsService;

    public static FileOperationsService getFileOperationInstance(){
        if (fileOperationsService == null){
            //create new and return
        }

        return fileOperationsService;
    }
}
