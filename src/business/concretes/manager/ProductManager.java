package business.concretes.manager;

import business.abstracts.ProductService;
import dataAccess.repository.abstracts.ProductRepository;
import entity.order.Product;

import static business.concretes.singlton.DependencyManager.getProductRepositoryInstance;

public class ProductManager implements ProductService {
    private final ProductRepository productRepository = getProductRepositoryInstance();
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
    public void findProductByGreaterThanPrice(Integer unitPrice) {
        //todo
        productRepository.getAllProductsGreaterThanPrice(unitPrice);
    }

    @Override
    public void findProductByLessThanPrice(Integer unitPrice) {
        //todo
        productRepository.getAllProductsLessThanPrice(unitPrice);
    }

    @Override
    public void findProductsBetweenPrices(Integer price1, Integer price2) {
        //todo

    }

    @Override
    public void findProductById(Integer id) {
        productRepository.getProductById(id);
    }
}
