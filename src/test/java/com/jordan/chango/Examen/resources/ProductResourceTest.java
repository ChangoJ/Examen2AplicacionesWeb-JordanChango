package com.jordan.chango.Examen.resources;

import com.jordan.chango.Examen.entities.Product;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductResourceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;
    private Product product;

    @Before
    public void before() {
        product = new Product();
        this.product.setBrand("Fiat");
        this.product.setModel("Bravo");
        this.product.setPrice(182000.25);
    }

    @Test
    public void getAllProduct() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductResource.PRODUCT).get().build();
        System.out.println(json);
    }

    @Test
    public void getById() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductResource.PRODUCT).path(ProductResource.ID).expand(4).get().build();
        System.out.println(json);
    }



    @Test
    public void createProduct() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductResource.PRODUCT).body(this.product).post().build();
        System.out.println(json);

    }

    @Test
    public void editProduct() {
        this.product.setBrand("Ferrari");
        this.product.setModel("488GTB");
        this.product.setId(4);
        this.product.setPrice(45000.75);
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductResource.PRODUCT).path(ProductResource.ID)
                .expand(4).body(product).put().build();
        System.out.println(json);
    }

    @Test
    public void deleteProduct() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductResource.PRODUCT).path(ProductResource.ID).expand(4).delete().build();
        System.out.println(json);
    }
}