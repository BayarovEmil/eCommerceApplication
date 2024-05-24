package business.concretes;

import business.abstracts.ProductService;
import dataAccess.repository.abstracts.ProductRepository;
import dataAccess.repository.concretes.ProductRepo;
import entity.order.Product;

public class ProductManager implements ProductService {
    private final ProductRepository productRepository = new ProductRepo();
    @Override
    public void showAllProducts() {
        productRepository.getAllProducts();
    }

    @Override
    public void findProductsByName(Product product) {
        productRepository.getAllProductsByProductName(product);
    }

    @Override
    public void findProductsByCategory(Product product) {
        productRepository.getAllProductsByCategory(product);
    }

    @Override
    public void findProductByIsDiscounted() {
        //todo
    }

    @Override
    public void findProductByGreaterThanPrice() {
        //todo
    }

    @Override
    public void findProductByLessThanPrice() {
        //todo
    }

    @Override
    public void findProductsBetweenPrices() {
        //todo
    }

    @Override
    public void findProductById(Integer id) {
        productRepository.getProductById(id);
    }
}
