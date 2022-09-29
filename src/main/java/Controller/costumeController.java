package Controller;

import com.ejemplo.despliegue.jba.jbaprueba.Costume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Service.costumeService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/costume")
public class costumeController {
    @Autowired
    private costumeService costumeService;
    @GetMapping("/all")
    public List<Costume> getCostume() {return costumeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Costume> getCostume(@PathVariable("id") int costumeid){
        return costumeService.getCostume(costumeid);
    }
    @PostMapping("/save")
    public Costume save(@RequestBody Costume costume) {return costumeService.save(costume);
    }
    @PutMapping("/update")
    public Costume update (@RequestBody Costume costume) {return costumeService.update(costume);
    }
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id")int carId){ return costumeService.deleteCostume(carId);
    }
}
