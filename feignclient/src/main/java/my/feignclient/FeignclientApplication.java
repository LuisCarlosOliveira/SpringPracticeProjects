package my.feignclient;

import my.feignclient.accessor.RestAPIAcessor;
import my.feignclient.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignclientApplication implements CommandLineRunner {


    private Logger LOG = LoggerFactory.getLogger(FeignclientApplication.class);
    private RestAPIAcessor restAPIAcessor;

    @Autowired
    public void setRestAPIAcessor(RestAPIAcessor restAPIAcessor) {
        this.restAPIAcessor = restAPIAcessor;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignclientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Product productFromFeignClient = restAPIAcessor.getProductFromRestAPI("4028b9818b8159cb018b8159df650000");
        LOG.info("Product from Feign Client: " + productFromFeignClient.toString());
    }
}
