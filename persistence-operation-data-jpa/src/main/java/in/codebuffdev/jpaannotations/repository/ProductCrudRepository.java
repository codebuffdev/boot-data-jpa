package in.codebuffdev.jpaannotations.repository;

import in.codebuffdev.jpaannotations.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCrudRepository extends JpaRepository<Product,Long>{}
