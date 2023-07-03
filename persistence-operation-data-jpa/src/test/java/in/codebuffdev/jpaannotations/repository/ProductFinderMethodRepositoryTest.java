package in.codebuffdev.jpaannotations.repository;

import in.codebuffdev.jpaannotations.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class ProductFinderMethodRepositoryTest {

    @Autowired
    private ProductFinderMethodRepository productFinderMethodRepository;

    @Test
    void findByNameMethod() {
        Product retriveProduct = productFinderMethodRepository.findByName("Samsung Mobile");
        System.out.println(retriveProduct.getId());
        System.out.println(retriveProduct.getName());
        System.out.println(retriveProduct.getPrice());
    }

    @Test
    void findByIdMethod() {
        Optional<Product> byId = productFinderMethodRepository.findById(1L);
        byId.ifPresent(System.out::println);
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> byNameOrDescription = productFinderMethodRepository.findByNameOrDescription("paytm", "electronics");
        byNameOrDescription.forEach(System.out::println);
    }

    @Test
    void findByNameAndDescription() {
        List<Product> byNameOrDescription = productFinderMethodRepository.findByNameAndDescription("paytm", "electronics");
        if (byNameOrDescription.isEmpty())
            System.out.println("No entries found");
        else
            byNameOrDescription.forEach(System.out::println);

        List<Product> byNameOrDescription2 = productFinderMethodRepository.findByNameAndDescription("Samsung Mobile", "electronics");
        byNameOrDescription2.forEach(System.out::println);
    }

    @Test
    void findDistinctByNameMethod(){
        Product paytm = productFinderMethodRepository.findDistinctByName("paytm");
        System.out.println(paytm);
    }

    @Test
    void findByPriceGreaterThan(){
        productFinderMethodRepository.findByPriceGreaterThan(new BigDecimal(2000)).forEach(System.out::println);
    }

    @Test
    void findByPriceLessThan(){
        productFinderMethodRepository.findByPriceLessThan(new BigDecimal(10130)).forEach(System.out::println);
    }

    @Test
    void findByNameContaining(){
        productFinderMethodRepository.findByNameContaining("m").forEach(System.out::println);
        productFinderMethodRepository.findByNameContaining("mo").forEach(System.out::println);
    }

    @Test
    void findByNameLikeIgnoreCase(){
        productFinderMethodRepository.findByNameContaining("m").forEach(System.out::println);
        productFinderMethodRepository.findByNameContaining("mo").forEach(System.out::println);
        System.out.println("--");
        productFinderMethodRepository.findByNameLikeIgnoreCase("Sam").forEach(System.out::println);
        productFinderMethodRepository.findByNameLikeIgnoreCase("Samsung Mobile").forEach(System.out::println);
    }

    @Test
    void findByPriceBetween(){
        productFinderMethodRepository.findByPriceBetween(new BigDecimal(10000), new BigDecimal(11000)).forEach(System.out::println);
    }

    @Test
    void findByDateCreatedBetween(){
        LocalDateTime startDate = LocalDateTime.of(2023,7,2,19,30,14);
        LocalDateTime endDate = LocalDateTime.of(2023, 7,2, 21,11,37);
        productFinderMethodRepository.findByDateCreatedBetween(startDate,endDate).forEach(System.out::println);
    }

    @Test
    void findByDateCreatedIsBetween(){
        LocalDateTime startDate = LocalDateTime.of(2023,7,2,19,30,14);
        LocalDateTime endDate = LocalDateTime.of(2023, 7,2, 21,11,37);
        productFinderMethodRepository.findByDateCreatedIsBetween(startDate,endDate).forEach(System.out::println);
    }

    @Test
    void findByNameIn(){
        productFinderMethodRepository.findByNameIn(List.of("Man Fan","paytm")).forEach(System.out::println);
    }

    @Test
    void findFirstByPriceIn(){
        productFinderMethodRepository.findFirstByPriceIn(List.of(new BigDecimal(430),new BigDecimal(10000))).forEach(System.out::println);
    }

    @Test
    void findFirst2ByPriceIn(){
        productFinderMethodRepository.findFirst2ByPriceIn(List.of(new BigDecimal(430),new BigDecimal(10000))).forEach(System.out::println);
    }

    @Test
    void findByNameIsNotNull(){
        productFinderMethodRepository.findByNameIsNotNull().forEach(System.out::println);
    }

    @Test
    void findByNameIsNull(){
        productFinderMethodRepository.findByNameIsNull().forEach(System.out::println);
    }

    @Test
    void findByOrderByNameAsc(){
        productFinderMethodRepository.findByOrderByNameAsc().forEach(System.out::println);
    }

    @Test
    void findByOrderByNameDesc(){
        productFinderMethodRepository.findByOrderByNameDesc().forEach(System.out::println);
    }
}
