package sotiroglou.athanasios.microservices.sql.catalogue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ImageUrl {
    @Id
    @GeneratedValue
    private Long id;

    private String url;

}
