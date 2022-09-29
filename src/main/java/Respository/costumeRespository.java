package Respository;

import com.ejemplo.despliegue.jba.jbaprueba.Costume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import crudRepository.costumeCrudResposiroty;

import java.util.List;
import java.util.Optional;

@Repository
public class costumeRespository {

    @Autowired
    private costumeCrudResposiroty costumeCrudResposiroty;
    public List<Costume> getAll(){return (List<Costume>) costumeCrudResposiroty.findAll();
    }
    public Optional<Costume> getCostume (int id) { return costumeCrudResposiroty.findById(id);
    }
    public Costume save (Costume costume) {return costumeCrudResposiroty.save(costume);
    }
    public void delete (Costume costume) {costumeCrudResposiroty.delete(costume);}
}
