package th.mfu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SaleOerderRepo extends CrudRepository<SaleOrder , Long> {
    List<SaleOrder> findAll();
    List<SaleOrder> findByCustomer_id(Integer id);
}
