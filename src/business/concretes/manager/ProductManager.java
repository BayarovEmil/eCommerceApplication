package business.concretes.manager;

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
