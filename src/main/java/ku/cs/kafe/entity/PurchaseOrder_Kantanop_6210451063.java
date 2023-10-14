package ku.cs.kafe.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import ku.cs.kafe.common.Status_Kantanop_6210451063;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@Entity
public class PurchaseOrder_Kantanop_6210451063 {
    @Id
    @GeneratedValue
    private UUID id;


    private LocalDateTime timestamp;
    private Status_Kantanop_6210451063 statusKantanop6210451063;


    @OneToMany(mappedBy = "purchaseOrder")
    private List<OrderItem_Kantanop_6210451063> items = new ArrayList<>();

    public double getTotal() {
        double total = 0;
        for (OrderItem_Kantanop_6210451063 item : items)
            total += item.getSubtotal();
        return total;
    }
}
