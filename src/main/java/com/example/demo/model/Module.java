package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name="module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="module_id")
    Integer id;
    String nomModule;



    public Module(Module module) {

        this.id=module.getId();
        this.nomModule=module.getNomModule();
    }
}
