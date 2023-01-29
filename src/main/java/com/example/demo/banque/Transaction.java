package com.example.demo.banque;

        import lombok.Data;
        import lombok.NoArgsConstructor;
        import javax.persistence.*;

@Data
@NoArgsConstructor
    @Entity
    @Table(name="transaction")
    public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="transaction_id")
        Integer id;
        int nouvellevaleur;
        int ancienvaleur;
        String date;
        @Column(name = "compte_id")
        Integer compteId;

    @MapsId("compteId")
    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte = new Compte();

    public Transaction(Transaction transaction) {
        this.id = transaction.getId();
        this.nouvellevaleur = transaction.getNouvellevaleur();
        this.ancienvaleur = transaction.getAncienvaleur();
        this.date = transaction.getDate();
        this.compteId = transaction.getCompteId();
        this.compte=transaction.getCompte();
    }
}

