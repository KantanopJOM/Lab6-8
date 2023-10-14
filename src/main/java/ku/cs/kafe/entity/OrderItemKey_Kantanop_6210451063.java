package ku.cs.kafe.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class OrderItemKey_Kantanop_6210451063 implements Serializable {


    @Column(name = "order_id")
    private UUID orderId;


    @Column(name = "menu_id")
    private UUID menuId;
}
