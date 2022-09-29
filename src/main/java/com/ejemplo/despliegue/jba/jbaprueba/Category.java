package com.ejemplo.despliegue.jba.jbaprueba;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@Entity
@Table(name="category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @OneToMany (cascade ={CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Costume> costumes;

    public List<Costume> getCostumes() {
        return costumes;
    }
    public void setCostumes(List<Costume> costumes) {
        this.costumes = costumes;
    }
    private  Integer id;
    private  String  name;
    private  String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

