import business.abstracts.CustomerService;
import business.abstracts.ProductService;
import business.abstracts.SellerService;
import business.concretes.CustomerManager;
import business.concretes.ProductManager;
import business.concretes.SellerManager;
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

        Seller seller = new Seller(
                1,"Elbay","qasimzade@gmail.com","elman1234","4169738822221111"
        );
        SellerService sellerService = new SellerManager();
        sellerService.register(seller);
        sellerService.login(seller);
        sellerService.addNewProduct(product);

        Customer customer = new Customer(
                2,"Lazarus","beyerovemil@gmail.com","emil1234",
                "Emil","Bayarov","Baku","4169738811112222"
        );
        CustomerService customerService = new CustomerManager();
        customerService.register(customer);
        customerService.login(customer);

        productService.showAllProducts();
        productService.findProductById(3);
        customerService.buyProductById(product);

        sellerService.getAllOrders();
        sellerService.sendYourItemByProductId(product);

    }
}