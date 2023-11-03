package my.restapi.service;

import my.restapi.controller.ProductController;
import my.restapi.model.Product;
import my.restapi.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(String id) {
        LOG.info("Getting the product with id : " + id);
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product productSaved) {
        Product productSave;
        try{
            LOG.info("Saving the product with id : " + productSaved.getId());
            productSave = productRepository.save(productSaved);
            return productSave;
        }catch (Exception e) {
            LOG.error("Error saving the product: " + e.getMessage());
        }
        return new Product();
    }

    public Product updateProduct(Product updateProduct, String id) {
        Product foundProduct = productRepository.findById(id).orElse(null);
        try{
            foundProduct.setName(updateProduct.getName());
            foundProduct.setDescription(updateProduct.getDescription());
            foundProduct.setType(updateProduct.getType());
            foundProduct.setCategory(updateProduct.getCategory());
            return productRepository.save(foundProduct);
        }catch (Exception e) {
            LOG.error("Error updating the product: " + e.getMessage());
        }
        return updateProduct;
    }

    public void deleteProduct(String id) {
        try{
            LOG.info("Deleting the product with id : " + id);
            productRepository.deleteById(id);
        }catch (Exception e) {
            LOG.error("Error deleting the product: " + e.getMessage());
        }
    }

}
