
package uk.ac.westminster.products_api;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private JsonMapper jsonMapper;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody JsonNode json) {

        Product product;

        if (json.has("downloadUrl") || json.has("fileSizeMB")) {
            product = jsonMapper.convertValue(json, DigitalProduct.class);
        } else if (json.has("weightKg") || json.has("dimensions")) {
            product = jsonMapper.convertValue(json, PhysicalProduct.class);
        } else {
            product = jsonMapper.convertValue(json, Product.class);
        }

        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }
}
