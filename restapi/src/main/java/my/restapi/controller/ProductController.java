package my.restapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import my.restapi.model.Product;
import my.restapi.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/products/")
@Api(value = "ProductControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    //private ProductRepository productRepository;

    private ProductService productService;

    private Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public void ProductService(ProductService productService) {
        this.productService = productService;
    }
    /*@Autowired
    public void ProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiOperation("Gets the product with specific id")
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Product.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Product.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Product.class)
    })
    public Product getProduct(@PathVariable(name = "id") String id) {
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product postProduct(@RequestBody Product productSaved) {
        return productService.saveProduct(productSaved);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct( @RequestBody Product updateProduct, @PathVariable(name = "id") String id){
        return productService.updateProduct(updateProduct, id);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(name = "id") String id){
         productService.deleteProduct(id);
    }

}
