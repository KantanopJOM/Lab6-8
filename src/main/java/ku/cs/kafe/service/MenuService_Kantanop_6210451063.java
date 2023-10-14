package ku.cs.kafe.service;


import ku.cs.kafe.entity.Category_Kantanop_6210451063;
import ku.cs.kafe.entity.Menu_Kantanop_6210451063;
import ku.cs.kafe.model.MenuRequest_Kantanop_6210451063;
import ku.cs.kafe.repository.CategoryRepository_Kantanop_6210451063;
import ku.cs.kafe.repository.MenuRepository_Kantanop_6210451063;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;


@Service
public class MenuService_Kantanop_6210451063 {


    @Autowired
    private MenuRepository_Kantanop_6210451063 menuRepositoryKantanop6210451063;


    @Autowired
    private CategoryRepository_Kantanop_6210451063 categoryRepositoryKantanop6210451063;


    @Autowired
    private ModelMapper modelMapper;


    public List<Menu_Kantanop_6210451063> getAllMenus() {
        return menuRepositoryKantanop6210451063.findAll();
    }

    public Menu_Kantanop_6210451063 getOneById(UUID id) {
        return menuRepositoryKantanop6210451063.findById(id).get();
    }

    public void createMenu(MenuRequest_Kantanop_6210451063 request) {
        Menu_Kantanop_6210451063 record = modelMapper.map(request, Menu_Kantanop_6210451063.class);
        Category_Kantanop_6210451063 categoryKantanop6210451063 =
                categoryRepositoryKantanop6210451063.findById(request.getCategoryId()).get();
        record.setCategoryKantanop6210451063(categoryKantanop6210451063);
        menuRepositoryKantanop6210451063.save(record);
    }
}
