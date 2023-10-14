package ku.cs.kafe.service;


import ku.cs.kafe.common.Status_Kantanop_6210451063;
import ku.cs.kafe.entity.Menu_Kantanop_6210451063;
import ku.cs.kafe.entity.OrderItem_Kantanop_6210451063;
import ku.cs.kafe.entity.OrderItemKey_Kantanop_6210451063;
import ku.cs.kafe.entity.PurchaseOrder_Kantanop_6210451063;
import ku.cs.kafe.model.AddCartRequest_Kantanop_6210451063;
import ku.cs.kafe.repository.MenuRepository_Kantanop_6210451063;
import ku.cs.kafe.repository.OrderItemRepository_Kantanop_6210451063;
import ku.cs.kafe.repository.PurchaseOrderRepository_Kantanop_6210451063;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class OrderService_Kantanop_6210451063 {


    @Autowired
    private PurchaseOrderRepository_Kantanop_6210451063 orderRepository;


    @Autowired
    private OrderItemRepository_Kantanop_6210451063 itemRepository;


    @Autowired
    private MenuRepository_Kantanop_6210451063 menuRepositoryKantanop6210451063;


    private UUID currentOrderId;

    public PurchaseOrder_Kantanop_6210451063 getCurrentOrder() {
        if (currentOrderId == null)
            createNewOrder();
        return orderRepository.findById(currentOrderId).get();
    }


    public void submitOrder() {
        PurchaseOrder_Kantanop_6210451063 currentOrder =
                orderRepository.findById(currentOrderId).get();
        currentOrder.setTimestamp(LocalDateTime.now());
        currentOrder.setStatusKantanop6210451063(Status_Kantanop_6210451063.CONFIRM);
        orderRepository.save(currentOrder);
        currentOrderId = null;
    }

    public void createNewOrder() {
        PurchaseOrder_Kantanop_6210451063 newOrder = new PurchaseOrder_Kantanop_6210451063();
        newOrder.setStatusKantanop6210451063(Status_Kantanop_6210451063.ORDER);
        PurchaseOrder_Kantanop_6210451063 record = orderRepository.save(newOrder);
        currentOrderId = record.getId();
    }


    public void order(UUID menuId, AddCartRequest_Kantanop_6210451063 request) {
        if (currentOrderId == null)
            createNewOrder();


        PurchaseOrder_Kantanop_6210451063 currentOrder =
                orderRepository.findById(currentOrderId).get();
        Menu_Kantanop_6210451063 menuKantanop6210451063 = menuRepositoryKantanop6210451063.findById(menuId).get();


        OrderItem_Kantanop_6210451063 item = new OrderItem_Kantanop_6210451063();
        item.setId(new OrderItemKey_Kantanop_6210451063(currentOrderId, menuId));
        item.setPurchaseOrderKantanop6210451063(currentOrder);
        item.setMenuKantanop6210451063(menuKantanop6210451063);
        item.setQuantity(request.getQuantity());
        itemRepository.save(item);
    }

    public List<PurchaseOrder_Kantanop_6210451063> getAllOrders() {
        return orderRepository.findAll();
    }

    public PurchaseOrder_Kantanop_6210451063 getById(UUID orderId) {
        return orderRepository.findById(orderId).get();
    }


    public void finishOrder(UUID orderId) {
        PurchaseOrder_Kantanop_6210451063 record = orderRepository.findById(orderId).get();
        record.setStatusKantanop6210451063(Status_Kantanop_6210451063.FINISH);
        orderRepository.save(record);
    }
}
