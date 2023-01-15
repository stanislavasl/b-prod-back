package lt.seb.api.repositories;

import lt.seb.api.entities.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BundleRepository extends JpaRepository<Bundle, Long> {

    @Query(value = "select * from bundles b where b.bundle_value = ?1", nativeQuery = true)
    Bundle findBundleByValue(Integer bandleValue);
}
