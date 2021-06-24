package com.jordan.chango.Examen.resources;

import com.jordan.chango.Examen.controllers.ProductController;
import com.jordan.chango.Examen.entities.Product;
import com.jordan.chango.Examen.resources.exceptions.EditProductException;
import com.jordan.chango.Examen.resources.exceptions.ProductCreateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ProductResource.PRODUCT)
public class ProductResource {
    public static final String PRODUCT = "/producto";
    public static final String ID = "/{id}";


    private ProductController productController;

    @Autowired
    public ProductResource(ProductController productController) {
        this.productController = productController;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return this.productController.findAllProduct();

    }


    @GetMapping(value = ID)
    public ResponseEntity getProductById(@PathVariable int id) {
        Optional<Product> productOptional = this.productController.findProductById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity(productOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("\"El vehiculo no  existe\"", HttpStatus.NOT_FOUND);
        }

    }



    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) throws ProductCreateException {
        try {
            this.productController.createProduct(product);
            return new ResponseEntity("\"El vehiculo fue creado\"", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ProductCreateException("los vehiculo enviados no son los correctos");
        }

    }

    @PutMapping(value = ID)
    public ResponseEntity editProductById(@RequestBody Product product, @PathVariable int id) throws EditProductException {
        try {
            if (this.productController.editProductById(id, product))
                return new ResponseEntity("\"El vehiculo fue edito\"", HttpStatus.ACCEPTED);
            return new ResponseEntity("\"El vehiculo no  existe\"", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new EditProductException("los datos enviados no son los correctos");
        }
    }

    @DeleteMapping(value = ID)
    public  ResponseEntity deleteProduct(@PathVariable int id)
        {
                if (this.productController.deleteProductById(id))
                    return new ResponseEntity("\"El vehiculo fue eliminado\"", HttpStatus.ACCEPTED);
                return new ResponseEntity("\"El vehiculo no  existe\"", HttpStatus.NOT_FOUND);


    }

}
