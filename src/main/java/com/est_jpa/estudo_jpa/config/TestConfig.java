package com.est_jpa.estudo_jpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.est_jpa.estudo_jpa.Category.Category;
import com.est_jpa.estudo_jpa.Category.CategoryRepository;
import com.est_jpa.estudo_jpa.Order.Order;
import com.est_jpa.estudo_jpa.Order.OrderRepository;
import com.est_jpa.estudo_jpa.Order.OrderStatus;
import com.est_jpa.estudo_jpa.Product.Product;
import com.est_jpa.estudo_jpa.Product.ProductRepository;
import com.est_jpa.estudo_jpa.User.User;
import com.est_jpa.estudo_jpa.User.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@Profile("test")
public class TestConfig implements CommandLineRunner{

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category("Electronics");
        Category cat2 = new Category("Books");
        Category cat3 = new Category("Computers"); 
        User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456"); 


		Order o1 = new Order(u1, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID);
		Order o2 = new Order(u2, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(u1, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT);

        Product p1 = new Product("The Lord of the Rings","", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product("Smart TV", "", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product("Macbook Pro", "", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product("PC Gamer", "","Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product("Rails for Dummies", "","Cras fringilla convallis sem vel faucibus.", 100.99, ""); 


        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);


        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }

    public void runOrder(String... args) throws Exception{
       
    }

}