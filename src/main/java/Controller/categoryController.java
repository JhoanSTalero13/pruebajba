package Controller;

import Service.categoryService;
import com.ejemplo.despliegue.jba.jbaprueba.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class categoryController {
    @Autowired
    private categoryService categoryService;
    @GetMapping("/all")
    public List<Category> getCategory() {return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int categoryid){
        return categoryService.getCategory(categoryid);
    }
    @PostMapping("/save")
    public Category save(@RequestBody Category category) {return categoryService.save(category);
    }
    @PutMapping("/update")
    public Category update (@RequestBody Category category) {return categoryService.update(category);
    }
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id")int carId){ return categoryService.deleteCategory(carId);
    }
}
