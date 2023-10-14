package ku.cs.kafe.controller;


import ku.cs.kafe.model.AddCartRequest_Kantanop_6210451063;
import ku.cs.kafe.service.OrderService_Kantanop_6210451063;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;


@Controller
@RequestMapping("/orders")
public class OrderController_Kantanop_6210451063 {


    @Autowired
    private OrderService_Kantanop_6210451063 orderServiceKantanop6210451063;

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cart", orderServiceKantanop6210451063.getCurrentOrder());
        return "cart_Kantanop_6210451063";
    }

    @PostMapping
    public String submitOrder(Model model) {
        orderServiceKantanop6210451063.submitOrder();
        model.addAttribute("confirmOrder", true);
        return "home";
    }



    @PostMapping("/{menuId}")
    public String order(@PathVariable UUID menuId,
                        @ModelAttribute AddCartRequest_Kantanop_6210451063 request, Model model){
        orderServiceKantanop6210451063.order(menuId, request);
        return "redirect:/menus";
    }
}
