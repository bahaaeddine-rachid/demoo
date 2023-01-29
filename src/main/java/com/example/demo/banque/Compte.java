
package com.example.demo.banque;

        import javax.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name="compte")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="compte_id")
    Integer id;
    int compte;
    String utilisateur;
    String city;
}

