package com.example.demo.repository;


import com.example.demo.model.Notes;

import java.util.List;

public interface CustomNotesRepository {

    List<Notes> findAllNotes();
}
