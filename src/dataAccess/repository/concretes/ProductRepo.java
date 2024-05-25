package dataAccess.repository.concretes;

import core.exception.FileCannotBeUptadableException;
import dataAccess.repo.abstracts.FileOperations;
import dataAccess.repository.abstracts.ProductRepository;
import entity.order.Product;

import java.io.IOException;

import static business.concretes.singlton.DependencyManager.getFileOperationInstance;

public class ProductRepo implements ProductRepository {
    private final FileOperations fileOperations = getFileOperationInstance();
    private final String fileName = "C:\\Users\\LENOVO\\IdeaProjects\\eCommerceApplication\\src\\dataAccess\\repo\\file\\products.txt";

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
    public void updateProductById(Product product, Product product2) {
        try {
            fileOperations.updateById(product.getId(), fileName, product2);
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
    public void getAllProductsLessThanPrice(Integer unitPrice) {
        fileOperations.getAllProductsLessThanPrice(unitPrice,fileName);
    }

    @Override
    public void getAllProductsGreaterThanPrice(Integer unitPrice) {
        fileOperations.getAllProductsGreaterThanPrice(unitPrice,fileName);
    }

    @Override
    public void getAllProductBetweenPrices(Integer price1, Integer price2) {

    }

    @Override
    public boolean getProductById(Integer id) {
        return fileOperations.getById(id,fileName);
    }
}
