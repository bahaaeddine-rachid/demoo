package com.example.demo.repository;

import com.example.demo.model.Module;

import java.util.List;

public interface CustomModuleRepository {

    List<Module> findAllModules();
}
