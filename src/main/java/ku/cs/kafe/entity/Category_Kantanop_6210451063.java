package ku.cs.kafe.entity;


import jakarta.persistence.*;
import lombok.Data;


import java.util.List;
import java.util.UUID;


@Data
@Entity
public class Category_Kantanop_6210451063 {


    @Id
    @GeneratedValue
    private UUID id;


    private String name;


    @OneToMany(mappedBy = "category")
    List<Menu_Kantanop_6210451063> menuKantanop6210451063s;
}
