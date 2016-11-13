package controllers.categories;

import model.categories.Category;
import services.categories.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
@CrossOrigin(origins="http://localhost:3000")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category getSingleCategory(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

}
