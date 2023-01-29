package com.example.demo.services;

import com.example.demo.banque.Compte;
import com.example.demo.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompteService {

        @Autowired
    CompteRepository compteRepository;


    public List<Compte> findAllComptes(){
        List<Compte> comptes = compteRepository.findAllComptes();

        return new ArrayList<>(comptes);
    }

    public List<String> findAllVilles(){

        List<Compte> comptes = compteRepository.findAllComptes();
        return comptes
                .stream()
                .map(Compte::getCity)
                .collect(Collectors.toList());
    }


    public List<String> FiltrerParVille(){
        List<Compte> comptes = compteRepository.findAllComptes();
        return comptes
                .stream()
                .map(Compte::getCity)
                .filter("Sogho"::equals)
                .collect(Collectors.toList());
    }
    public List<Compte> PlusRicheAuPauvre(){
        List<Compte> comptes = compteRepository.findAllComptes();
        return comptes
                .stream()
                .sorted(Comparator.comparingInt(Compte::getCompte).reversed())
                .collect(Collectors.toList());
    }
    public List<Compte> LestroisplusRiche(){

        List<Compte> comptes = compteRepository.findAllComptes();

        return comptes
                .stream()
                .sorted(Comparator.comparingInt(Compte::getCompte).reversed()).limit(3)
                .collect(Collectors.toList());
    }

    public Optional<Compte> LePlusPauvre(){

        List<Compte> comptes = compteRepository.findAllComptes();

        return comptes
                .stream()
                .min(Comparator.comparingInt(Compte::getCompte));
    }


    public List<Compte> findCompteByID(int id){

        return compteRepository.findCompteById(id);
    }
    public Compte createCompte(Compte compte){
        return compteRepository.save(compte);
    }
    public void deleteCompte(Compte compte){
        compteRepository.deleteById(compte.getId());
    }


    public List<Compte> findCompteWithMoreThan(int qte) {
        return compteRepository.findCompteWithMoreThan(qte);
    }
}
