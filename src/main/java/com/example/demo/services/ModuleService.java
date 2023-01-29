package com.example.demo.services;

import com.example.demo.banque.Transaction;
import com.example.demo.model.Module;
import com.example.demo.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;


    public List<Module> findAllModules(){
        return moduleRepository.findAllModules();
    }
}
