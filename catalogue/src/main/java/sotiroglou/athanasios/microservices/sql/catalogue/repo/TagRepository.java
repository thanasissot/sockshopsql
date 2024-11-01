package sotiroglou.athanasios.microservices.sql.catalogue.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sotiroglou.athanasios.microservices.sql.catalogue.model.Tag;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findAllByNameIn(List<String> names);
}
