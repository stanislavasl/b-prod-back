package lt.seb.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lt.seb.api.entities.Product;
import lt.seb.api.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Operation(description = "Endpoint for getting all products")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @Operation(description = "Endpoint for getting the customer by its id")
    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable("productId") Long productId){
        return productService.getProductById(productId);
    }

    @Operation(description = "Endpoint for product creation")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @Operation(description = "Endpoint for uptating product information")
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @Operation(description = "Endpoint for product deletion")
    @DeleteMapping(value = "/delete/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }

}
