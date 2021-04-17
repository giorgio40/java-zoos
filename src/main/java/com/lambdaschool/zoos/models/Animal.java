package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="animals")
public class Animal extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    private String animaltype;

    @OneToMany(mappedBy = "animal",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "animal")
    private List<ZooAnimals> zooanimals = new ArrayList<>();


    public Animal() {
    }

    public Animal( String animaltype) {
        this.animaltype = animaltype;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public List<ZooAnimals> getZooanimals() {
        return zooanimals;
    }

    public void setZooanimals(List<ZooAnimals> zooanimals) {
        this.zooanimals = zooanimals;
    }

    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }
}
