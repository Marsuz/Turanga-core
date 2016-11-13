package services.categories;

import model.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public Category getCategoryById(Long id) {
        return repository.findOne(id);
    }

    public List<Category> getAllCategories() {
        return (List<Category>) repository.findAll();
    }

    public void saveCategory(Category category) {
        repository.save(category);
    }

}
