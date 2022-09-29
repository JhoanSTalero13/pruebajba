package Service;

import com.ejemplo.despliegue.jba.jbaprueba.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Respository.categoryRespositoty;

import java.util.List;
import java.util.Optional;

@Service
public class categoryService {
    @Autowired
    private categoryRespositoty CategoryRespository;
    public List<Category> getAll() {return CategoryRespository.getAll();
    }
    public Optional<Category> getCategory (int id){ return CategoryRespository.getCategory(id);
    }
    public Category save (Category category){
        if (category.getId()==null){
            return CategoryRespository.save(category);
        }else {
            Optional<Category> e= CategoryRespository.getCategory(category.getId());
            if(e.isEmpty()){
                return CategoryRespository.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update (Category category){
        if (category.getId()!=null){
          Optional<Category> e= CategoryRespository.getCategory(category.getId());
        if (!e.isEmpty()){
            if (category.getName()!=null){
                e.get().setName(category.getName());
            }
            if (category.getDescription()!=null){
                e.get().setDescription(category.getDescription());
            }
            if (category.getCostumes()!=null){
                e.get().setCostumes(category.getCostumes());
            }
            CategoryRespository.save(e.get());
            return e.get();
        }
        else {
                return category;
            }
        }
        else {
            return category;
        }
    }

    public boolean deleteCategory (int id) {
        Boolean aboolean = getCategory(id).map(category -> {
            CategoryRespository.delete(category);
            return true;
        }).orElse(false);
        return aboolean;
    }

}

