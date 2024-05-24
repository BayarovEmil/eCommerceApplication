package dataAccess.repository.concretes;

import dataAccess.repo.abstracts.FileOperations;
import dataAccess.repo.concretes.FileOperationsService;
import dataAccess.repository.abstracts.OrderRepository;
import entity.order.Product;

public class OrderRepo implements OrderRepository {
    private final FileOperations fileOperations = new FileOperationsService();
    private final String fileName = "C:\\Users\\LENOVO\\IdeaProjects\\eCommerceApplication\\src\\dataAccess\\repo\\file\\orders.txt";
    @Override
    public void saveOrder(Product product) {
        String data = product.getId()+","+product.getProductName()+","+product.getCategory()+","
                +product.getUnitPrice()+","
                + product.getDiscount()+","+product.getDescription()+","
                +product.getSellingCount()+","+product.isReturnable();
        fileOperations.writeToFile(data,fileName);
    }

    @Override
    public void showAllOrders() {
        System.out.println("You see your orders:");
        fileOperations.getAll(fileName);
    }
}
