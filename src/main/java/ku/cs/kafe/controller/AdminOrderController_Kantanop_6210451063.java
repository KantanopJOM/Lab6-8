package ku.cs.kafe.controller;


import ku.cs.kafe.service.OrderService_Kantanop_6210451063;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.UUID;


@Controller
@RequestMapping("/admin/orders")
public class AdminOrderController_Kantanop_6210451063 {


    @Autowired
    private OrderService_Kantanop_6210451063 orderServiceKantanop6210451063;


    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderServiceKantanop6210451063.getAllOrders());
        return "order-all_Kantanop_6210451063";
    }
    @GetMapping("/{orderId}")
    public String getAllOrders(@PathVariable UUID orderId, Model model) {
        model.addAttribute("order", orderServiceKantanop6210451063.getById(orderId));
        return "order-view_Kantanop_6210451063";
    }


    @PostMapping("/{orderId}/finish")
    public String finishOrder(@PathVariable UUID orderId, Model model) {
        orderServiceKantanop6210451063.finishOrder(orderId);
        return "redirect:/admin/orders";
    }
}

