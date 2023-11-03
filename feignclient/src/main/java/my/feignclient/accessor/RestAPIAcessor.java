package my.feignclient.accessor;

import my.feignclient.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "restapiapplication")
public interface RestAPIAcessor {

    @RequestMapping(path = "/api/products/{id}", method = RequestMethod.GET)
    public Product getProductFromRestAPI(@PathVariable(value = "id") String id);


}
