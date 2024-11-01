package sotiroglou.athanasios.microservices.sql.catalogue.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sotiroglou.athanasios.microservices.sql.catalogue.model.Sock;

import java.util.List;

@Repository
public interface SockRepository extends JpaRepository<Sock, Long> {

    List<Sock> findAllByTags(List<Long> tagIds);
}
