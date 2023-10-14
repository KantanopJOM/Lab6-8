package ku.cs.kafe.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import java.util.UUID;


@Data
@Entity
public class Menu_Kantanop_6210451063 {
    @Id
    @GeneratedValue
    private UUID id;


    private String name;
    private double price;


    @ManyToOne
    private Category_Kantanop_6210451063 categoryKantanop6210451063;
}
