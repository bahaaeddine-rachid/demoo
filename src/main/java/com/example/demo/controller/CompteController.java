package com.example.demo.controller;

import com.example.demo.banque.Compte;
import com.example.demo.services.CompteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class CompteController {

    @Autowired
    CompteService  compteService;


    @RequestMapping(value="/findAllComptes", method = RequestMethod.GET)
    public ResponseEntity<List<?>> findAllComptes()  {
        List<?> result=compteService.findAllComptes();
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value="/findAllVilles", method = RequestMethod.GET)
    public ResponseEntity<List<?>> findAllVilles()  {
        List<?> result=compteService.findAllVilles();
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value="/FiltrerParVille", method = RequestMethod.GET)
    public ResponseEntity<List<?>> FiltrerParVille()  {
        List<?> result=compteService.FiltrerParVille();
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value="/PlusRicheAuPauvre", method = RequestMethod.GET)
    public ResponseEntity<List<?>> PlusRicheAuPauvre()  {
        List<?> result=compteService.PlusRicheAuPauvre();
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value="/LePlusPauvre", method = RequestMethod.GET)
    public ResponseEntity<Optional<?>> LePlusPauvre()  {
        Optional<?> result=compteService.LePlusPauvre();
        return ResponseEntity.ok(result);
    }


    @RequestMapping(value="/LestroisplusRiche", method = RequestMethod.GET)
    public ResponseEntity<List<?>> LestroisplusRiche()  {
        List<?> result=compteService.LestroisplusRiche();
        return ResponseEntity.ok(result);
    }






    @RequestMapping(value="/findCompteById", method = RequestMethod.GET)
    public ResponseEntity<List<Compte>> findCompteById(@RequestParam int id)  {
        log.info(""+id);
        List<Compte> result=compteService.findCompteByID(id);
        return ResponseEntity.ok(result);
    }
    @RequestMapping(value="/createCompte", method = RequestMethod.POST)
    public ResponseEntity<Compte> createCompte(@RequestBody Compte compte)  {
        log.info(compte.toString());
        Compte result=compteService.createCompte(compte);
        return ResponseEntity.ok(result);
    }
    @RequestMapping(value="/deleteCompte", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deleteCompte(@RequestBody Compte compte)  {
        compteService.deleteCompte(compte);
        return ResponseEntity.ok(true);
    }
}
