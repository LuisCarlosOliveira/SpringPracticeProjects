package my.restapi;

import my.restapi.model.Product;
import my.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RestapiApplication implements CommandLineRunner {

    private ProductRepository productRepository;

    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Product p1 = new Product();
        p1.setName("Product 1");
        p1.setDescription("Description 1");
        p1.setType("Type 1");
        p1.setCategory("Category 1");

        productRepository.save(p1);

    }
}
