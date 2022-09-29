package Respository;

import com.ejemplo.despliegue.jba.jbaprueba.Category;
import crudRepository.categoryCrudCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class categoryRespositoty {
    @Autowired
    private categoryCrudCategory categoryCrudCategory;
    public List<Category> getAll() { return(List<Category>) categoryCrudCategory.findAll();
    }
    public Optional<Category> getCategory (int id){return categoryCrudCategory.findById(id);

    }
    public Category save(Category category) {return categoryCrudCategory.save(category);
    }
    public void delete (Category category) {categoryCrudCategory.delete(category);
    }

}
