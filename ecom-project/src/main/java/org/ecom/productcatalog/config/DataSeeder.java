//Use data seeder and command liner to insert data
package org.ecom.productcatalog.config;

import org.ecom.productcatalog.model.Category;
import org.ecom.productcatalog.Product;
import org.ecom.productcatalog.repository.CategoryRepository;
import org.ecom.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        //Clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //Create categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home= new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,clothing,home));


        //Create products
        Product smartPhone =  new Product();
        smartPhone.setName("Smart phone");
        smartPhone.setDescription("Latest model samsung smart phone.");
        smartPhone.setImageUrl("https://placehold.co/600x400");
        smartPhone.setPrice(599.99);
        smartPhone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High performance laptop.");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter jacket");
        jacket.setDescription("It gives warm feeling and light weight jacket.");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(99.99);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High speed blender for smoothies and more.");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(129.99);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(smartPhone,laptop,jacket,blender));
    }
}
