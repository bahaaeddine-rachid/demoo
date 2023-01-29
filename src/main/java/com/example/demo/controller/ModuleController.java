package com.example.demo.controller;

import com.example.demo.model.Module;
import com.example.demo.services.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j

public class ModuleController {

    @Autowired
    ModuleService moduleService;

    @RequestMapping(value="/findAllModules", method = RequestMethod.GET)
    public ResponseEntity<List<Module>> findAllModules(){

        return ResponseEntity.ok(new ArrayList<>());
    }
}
