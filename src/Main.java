import business.abstracts.CustomerService;
import business.abstracts.ProductService;
import business.abstracts.SellerService;
import business.concretes.manager.CustomerManager;
import business.concretes.manager.ProductManager;
import business.concretes.manager.SellerManager;
import entity.order.Card;
import entity.order.Product;
import entity.user.Customer;
import entity.user.Seller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to main page\n");
        Product product  = new Product(
                3,"Technology","Samsung-A23",600,10,"The best Samsung telephone",
                0,false
        );
        ProductService productService = new ProductManager();
        Card card1 = new Card(
                "4169738822221111","171","01:02",100.0
        );
        Card card2 = new Card(
                "4169738811112222","173","01:03",100.0
        );

        Seller seller = new Seller(
                1,"Elbay","qasimzade.seller@gmail.com","elman1234",card1
        );
        SellerService sellerService = new SellerManager();
        sellerService.register(seller);
        sellerService.login(seller);
        sellerService.addNewProduct(product);
        sellerService.deleteProductById(product);
        sellerService.showAllProducts();
        // Observer design pattern
        product.setUnitPrice(550);

        Customer customer = new Customer(
                2,"Lazarus","beyerovemil@gmail.com","emil1234",
                "Emil","Bayarov","Baku", card2
        );

        CustomerService customerService = new CustomerManager();
        customerService.register(customer);
        customerService.login(customer);

        // Searching
        Scanner scanner = new Scanner(System.in);
        // Enter choice must be later than showing menu
        System.out.println("1)Show All Products\n" +
                "2)Find Product By Id\n" +
                "3)Find Product By Is Discounted\n" +
                "4)Find Products By Name\n" +
                "5)Find Products By Category\n" +
                "6)Find Product By Less Than Price\n" +
                "7)Find Product By Greater ThanPrice\n" +
                "8)Find Products Between Prices");
        int op = scanner.nextInt();
        switch (op){
            case 1: productService.showAllProducts(); break;
            case 2: productService.findProductById(3); break;
            case 3: productService.findProductByIsDiscounted(); break;
            case 4: productService.findProductsByName(product); break;
            case 5:  productService.findProductsByCategory(product); break;
            case 6: productService.findProductByLessThanPrice(700); break;
            case 7: productService.findProductByGreaterThanPrice(500); break;
            case 8: productService.findProductsBetweenPrices(400,1000); break;
            default:
                System.out.println("Choices is wrong");
         }

        customerService.buyProductById(product,customer);
        sellerService.getAllOrders();

    }
}