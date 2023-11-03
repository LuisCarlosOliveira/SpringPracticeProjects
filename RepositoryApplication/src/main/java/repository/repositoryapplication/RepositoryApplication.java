package repository.repositoryapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import repository.repositoryapplication.model.Product;
import repository.repositoryapplication.repository.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner {

    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger LOG = LoggerFactory.getLogger(RepositoryApplication.class);

    @Autowired
    public void productRepository (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RepositoryApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Product product1 = new Product();
        product1.setName("Tester Product");
        product1.setDescription("This is a tester product");
        product1.setCategory("TEST");
        product1.setType("GENERAL");
        product1.setPrice(0.0);

        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Another Product");
        product2.setDescription("This is a tester product");
        product2.setCategory("TEST");
        product2.setType("CUSTOM");
        product2.setPrice(15.0);

        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Tester Product");
        product3.setDescription("description");
        product3.setCategory("TEST");
        product3.setType("SPECIFIC");
        product3.setPrice(2.0);

        productRepository.save(product3);

        Product productFromRestTemplate = restTemplate.getForObject("http://localhost:8080/api/products/4028b9818b7d4059018b7d4061d80000", Product.class);

        LOG.info("Product received from rest template: "+ productFromRestTemplate.toString());
    }
}
