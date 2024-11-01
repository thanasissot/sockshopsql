package sotiroglou.athanasios.microservices.sql.catalogue.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonbTransient
    private List<Sock> socks = new ArrayList<>();

}
