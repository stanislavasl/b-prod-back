package lt.seb.api.repositories;

import lt.seb.api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select * from customers c where c.customer_personal_code = ?1", nativeQuery = true)
    Optional<Customer> findCustomerByPersonalCode(Long customerPersonalCode);

    @Query(value = "select * from customers c where c.customer_id = ?1", nativeQuery = true)
    Optional<Customer> findCustomerById(Long customerId);
}
