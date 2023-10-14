package ku.cs.kafe.entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class OrderItem_Kantanop_6210451063 {


    @EmbeddedId
    private OrderItemKey_Kantanop_6210451063 id;


    private int quantity;


    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private PurchaseOrder_Kantanop_6210451063 purchaseOrderKantanop6210451063;


    @ManyToOne
    @MapsId("menuId")
    @JoinColumn(name = "menu_id")
    private Menu_Kantanop_6210451063 menuKantanop6210451063;

    public double getSubtotal() {
        return menuKantanop6210451063.getPrice() * quantity;
    }
}
