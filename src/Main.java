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
                1,"Elbay","qasimzade.seller@gmail.com","elman1234","4169738822221111"
        );
        SellerService sellerService = new SellerManager();
        sellerService.register(seller);
        sellerService.login(seller);
        sellerService.addNewProduct(product);
        sellerService.deleteProductById(product);

        Customer customer = new Customer(
                2,"Lazarus","beyerovemil@gmail.com","emil1234",
                "Emil","Bayarov","Baku","4169738811112222"
        );

        CustomerService customerService = new CustomerManager();
        customerService.register(customer);
        customerService.login(customer);

        // Searching
        productService.showAllProducts();
        productService.findProductById(3);
        productService.findProductByIsDiscounted();
        productService.findProductsByName(product);
        productService.findProductsByCategory(product);
        productService.findProductByLessThanPrice(700);
        productService.findProductByGreaterThanPrice(500);
        productService.findProductsBetweenPrices(400,1000);

        customerService.buyProductById(product,customer);
        sellerService.getAllOrders();

    }
}