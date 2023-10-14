package ku.cs.kafe.controller;


import ku.cs.kafe.entity.Menu_Kantanop_6210451063;
import ku.cs.kafe.model.MenuRequest_Kantanop_6210451063;
import ku.cs.kafe.service.CategoryService_Kantanop_6210451063;
import ku.cs.kafe.service.MenuService_Kantanop_6210451063;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RequestMapping("/menus")
public class MenuController_Kantanop_6210451063 {


    @Autowired
    private MenuService_Kantanop_6210451063 menuServiceKantanop6210451063;


    @Autowired
    private CategoryService_Kantanop_6210451063 categoryServiceKantanop6210451063;


    @GetMapping
    public String getAllMenus(Model model) {
        model.addAttribute("categories", categoryServiceKantanop6210451063.getAllCategories());
//        model.addAttribute("menus", menuService.getAllMenus());
        return "menu-all_Kantanop_6210451063";
    }

    @GetMapping("/{id}")
    public String getOneMenu(@PathVariable UUID id, Model model) {
        Menu_Kantanop_6210451063 menuKantanop6210451063 = menuServiceKantanop6210451063.getOneById(id);
        model.addAttribute("menu", menuKantanop6210451063);
        return "menu-view_Kantanop_6210451063";
    }

    @GetMapping("/add")
    public String getMenuForm(Model model) {
        model.addAttribute("categories", categoryServiceKantanop6210451063.getAllCategories());
        return "menu-add_Kantanop_6210451063";
    }


    @PostMapping("/add")
    public String createMenu(@ModelAttribute MenuRequest_Kantanop_6210451063 menu, Model model) {
        menuServiceKantanop6210451063.createMenu(menu);
        return "redirect:/menus";
    }
}
