package dataAccess.repository.concretes;

import core.exception.FileCannotBeUptadableException;
import dataAccess.repo.abstracts.FileOperations;
import dataAccess.repo.concretes.FileOperationsService;
import dataAccess.repository.abstracts.ProductRepository;
import entity.order.Product;

import java.io.IOException;

public class ProductRepo implements ProductRepository {
    private final FileOperations fileOperations = new FileOperationsService();
    private final String fileName = "products.txt";


    @Override
    public void addNewProduct(Product product) {
        String data = product.getId()+","+product.getProductName()+","+product.getCategory()+","
                +product.getUnitPrice()+","
                + product.getDiscount()+","+product.getDescription()+","
                +product.getSellingCount()+","+product.isReturnable();
        fileOperations.writeToFile(data,fileName);
    }

    @Override
    public void deleteProductById(Product product) {
        fileOperations.deleteById(product.getId(),fileName);
    }

    @Override
    public void getAllProducts() {
        fileOperations.getAll(fileName);
    }

    @Override
    public void updateProductById(Product product,String data) {
        try {
            fileOperations.updateById(product.getId(), fileName,data);
        } catch (IOException e) {
            throw new FileCannotBeUptadableException("Product infos cannot be updatable.");
        }
    }

    @Override
    public void getAllProductsByProductName(Product product) {
        fileOperations.getAllProductsByProductName(product,fileName);
    }

    @Override
    public void getAllProductsByCategory(Product product) {
        fileOperations.getAllProductsByCategory(product,fileName);
    }

    @Override
    public void getAllProductsLessThanPrice(Product product) {
        fileOperations.getAllProductsLessThanPrice(product,fileName);
    }

    @Override
    public void getAllProductsGreaterThanPrice(Product product) {
        fileOperations.getAllProductsGreaterThanPrice(product,fileName);
    }

    @Override
    public Product getProductById(Integer id) {
        return null;
    }
}
