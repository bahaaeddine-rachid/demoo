package com.example.demo.controller;

import com.example.demo.model.Notes;
import com.example.demo.model.Student;
import com.example.demo.services.NotesService;
import com.example.demo.services.StudentService;
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
public class NotesController {

    @Autowired
    NotesService notesService;

    @RequestMapping(value="/findAllNotes", method = RequestMethod.GET)
    public ResponseEntity<List<Notes>> findAllNotes() {

        return ResponseEntity.ok(new ArrayList<>());
    }
}
