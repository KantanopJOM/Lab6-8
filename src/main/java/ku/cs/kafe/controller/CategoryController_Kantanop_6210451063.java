package ku.cs.kafe.controller;


import ku.cs.kafe.model.CategoryRequest_Kantanop_6210451063;
import ku.cs.kafe.service.CategoryService_Kantanop_6210451063;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/categories")
public class CategoryController_Kantanop_6210451063 {


    @Autowired
    private CategoryService_Kantanop_6210451063 categoryServiceKantanop6210451063;

    @GetMapping("/add")
    public String getCategoryForm(Model model) {
        return "category-add_Kantanop_6210451063";
    }


    @PostMapping("/add")
    public String createCategory(@ModelAttribute CategoryRequest_Kantanop_6210451063 request,
                                 Model model) {
        categoryServiceKantanop6210451063.createCategory(request);
        return "redirect:/menus";
    }
}
