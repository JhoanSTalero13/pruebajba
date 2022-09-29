package Service;

import com.ejemplo.despliegue.jba.jbaprueba.Costume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Respository.costumeRespository;

import java.util.List;
import java.util.Optional;

@Service
public class costumeService {
    @Autowired
    public costumeRespository CostumeRepository;
    public List<Costume> getAll() {return CostumeRepository.getAll();
    }
    public Optional<Costume> getCostume(int id) { return CostumeRepository.getCostume(id);
    }

    public Costume save (Costume costume){
      if (costume.getId()==null){
          return CostumeRepository.save(costume);
      } else {
          Optional<Costume> e= CostumeRepository.getCostume(costume.getId());
              if(e.isEmpty()){
              return CostumeRepository.save(costume);
             } else {
                  return costume;
              }
      }

    }

    public Costume update (Costume costume){
      if(costume.getId()!=null) {
          Optional<Costume> e= CostumeRepository.getCostume(costume.getId());
          if (!e.isEmpty()){
              if (costume.getName()!=null){
                  e.get().setName(costume.getName());
              }
              if (costume.getBrand()!=null){
                  e.get().setBrand(costume.getBrand());
              }
              if (costume.getYear()!=null){
                  e.get().setYear(costume.getYear());
              }
              if (costume.getDescription()!=null){
                  e.get().setDescription(costume.getDescription());
              }
              if (costume.getCategory()!=null){
                  e.get().setCategory(costume.getCategory());
              }
              CostumeRepository.save(e.get());
              return e.get();

          } else {
              return costume;
          }
      } else {
          return costume;
      }
    }
    public boolean deleteCostume (int id){
     Boolean aBoolean = getCostume(id).map(costume -> {
         CostumeRepository.delete(costume);
         return true;
     }).orElse(false);
     return aBoolean;
    }


}


