package in.codebuffdev.jpaannotations.repository;

import in.codebuffdev.jpaannotations.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductFinderMethodRepository extends JpaRepository<Product,Long> {
    /**
     * Returns the found product entry by using its name as search criteria.
     * If no product entry is found, method returns null.
     * */
    Product findByName(String name);

    /**
     * Returns an Optional which contains the found product entry by using id as search criteria.
     * If no entry found it returns empty Optional.
     * */
    Optional<Product> findById(Long id);

    /**
     * Returns the found list of product entries whose title or description is given as method parameter.
     * If not match found, returns empty List */
    List<Product> findByNameOrDescription(String name, String description);

    /**
     * Returns the found list of product entries whose title and description is given as method parameter.
     * If not match found, returns empty List */
    List<Product> findByNameAndDescription(String name, String description);

    /**
     * Returns the distinct Product entry whose name is given as a Method parameter.
     * If no product entry is found, this method returns null
     * */
    Product findDistinctByName(String name);

    /**
     * Returns the products whose price is grater than the price parameter */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /**
     * Returns the products whose price is less than the price parameter */
    List<Product> findByPriceLessThan(BigDecimal price);

    /**
     * Returns the filtered product records that match the given text */
    List<Product> findByNameContaining(String name);

    /**
     * Return products based on SQL like conditions
     * */
    List<Product> findByNameLikeIgnoreCase(String name);

    /**
     * Returns products which price in between startRange & endRange*/
    List<Product> findByPriceBetween(BigDecimal startRange, BigDecimal endRange);

    /**
     * Returns products which dateCreated in between startRange & endRange
     * */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Returns products which dateCreated in between startRange & endRange
     * */
    List<Product> findByDateCreatedIsBetween(LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Returns the list of products which names matches with the list of names*/
    List<Product> findByNameIn(List<String> names);

    //Limiting query Results
    List<Product> findFirstByPriceIn(List<BigDecimal> list);
    List<Product> findFirst2ByPriceIn(List<BigDecimal> list);

    /**
     * Return the Product list whose name is not null*/
    List<Product> findByNameIsNotNull();

    /**
     * Return the Product list whose name is null*/
    List<Product> findByNameIsNull();

    /**
     * Returns the List of product in ascending Order */
    List<Product> findByOrderByNameAsc();

    /**
     * Returns the List of product in descending Order */
    List<Product> findByOrderByNameDesc();
}
