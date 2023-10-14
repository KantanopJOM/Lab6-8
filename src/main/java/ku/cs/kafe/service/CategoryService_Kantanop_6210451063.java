package ku.cs.kafe.service;


import ku.cs.kafe.entity.Category_Kantanop_6210451063;
import ku.cs.kafe.model.CategoryRequest_Kantanop_6210451063;
import ku.cs.kafe.repository.CategoryRepository_Kantanop_6210451063;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CategoryService_Kantanop_6210451063 {


    @Autowired
    private CategoryRepository_Kantanop_6210451063 categoryRepositoryKantanop6210451063;


    @Autowired
    private ModelMapper modelMapper;


    public List<Category_Kantanop_6210451063> getAllCategories() {
        return categoryRepositoryKantanop6210451063.findAll();
    }


    public void createCategory(CategoryRequest_Kantanop_6210451063 request) {
        Category_Kantanop_6210451063 record = modelMapper.map(request, Category_Kantanop_6210451063.class);
        categoryRepositoryKantanop6210451063.save(record);
    }
}
