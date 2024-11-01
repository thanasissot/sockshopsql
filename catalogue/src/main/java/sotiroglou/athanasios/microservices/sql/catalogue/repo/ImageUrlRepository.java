package sotiroglou.athanasios.microservices.sql.catalogue.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sotiroglou.athanasios.microservices.sql.catalogue.model.ImageUrl;

@Repository
public interface ImageUrlRepository extends JpaRepository<ImageUrl, Long> {
}
