package in.codebuffdev.jpaannotations.repository;

import in.codebuffdev.jpaannotations.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Here, I'm not writing real unit testcase methods, rather I'm just executing my piece of code
 * */

@SpringBootTest
class ProductCrudRepositoryTest {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Test
    void saveMethodTest() {
        Product product = new Product();
        product.setName("Samsung Mobile");
        product.setDescription("Electronics");
        product.setSku("100ZZ");
        product.setPrice(new BigDecimal(10000));
        product.setIsActive(true);
        product.setImageUrl("smt.png");
        Product saved = productCrudRepository.save(product);
        System.out.println(saved);
    }

    @Test
    void findByMethod(){
        Optional<Product> byId = productCrudRepository.findById(1L);
        Product product = byId.orElse(null);
        System.out.println(product);
    }

    @Test
    void updateEntityUsingSaveMethod(){
        Product product = productCrudRepository.findById(1L).orElse(null);
        assert product != null;
        product.setSku("KSU");
        Product savedProd = productCrudRepository.save(product);
        System.out.println(savedProd.getLastUpdated());
    }

    @Test
    void saveAllMethod(){
        Product product2 = new Product();
        product2.setSku("BST");
        product2.setName("Man Fan");
        product2.setDescription("Cosmetic & man items");
        product2.setPrice(new BigDecimal("130"));
        product2.setIsActive(true);
        product2.setImageUrl("https://manly.com");

        Product product3 = new Product();
        product3.setSku("BSC");
        product3.setName("paytm");
        product3.setDescription("Online payment ");
        product3.setPrice(new BigDecimal("430"));
        product3.setIsActive(true);
        product3.setImageUrl("https://paytm.com");

        productCrudRepository.saveAll(List.of(product2,product3));
    }


    @Test
    void findAllMethod(){
        productCrudRepository.findAll().forEach(System.out::println);
    }

    @Test
    void countMethod(){
        long count = productCrudRepository.count();
        System.out.println(count);
    }

    @Test
    void existByIdMethod(){
        boolean isExists = productCrudRepository.existsById(1l);
        System.out.println(isExists);
    }

    //@Test
    void deleteByIdMethod(){
        productCrudRepository.deleteById(3L);
    }

    //@Test
    void deleteMethod(){
        Product product = productCrudRepository.findById(2L).get();
        productCrudRepository.delete(product);
    }

    //@Test
    void deleteAllMethod(){
        productCrudRepository.deleteAll();
    }

    //@Test
    void deleteAllObjectMethod(){
        Iterable<Product> all = productCrudRepository.findAll();
        productCrudRepository.deleteAll(all);
    }

    //@Test
    void deleteAllByIdMethod(){
        productCrudRepository.deleteAllById(List.of(1L,2L,3L));
    }

}
