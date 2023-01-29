    package com.example.demo.repository;

    import com.example.demo.banque.Compte;

    import java.util.List;

    public interface CustomCompteRepository {
        List<Compte> findAllComptes();


        List<Compte> findCompteById(int id);

        List<Compte> findCompteWithMoreThan(int qte);

    }
