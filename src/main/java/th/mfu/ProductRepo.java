package th.mfu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Integer> {
  List<Product> findAll();
List<Product> findByNameStartingWith(String prefix);
List<Product>findAllByOrderByPriceAsc();
 List<Product> findByDescriptionStartingWith(String prefix);
 
}
