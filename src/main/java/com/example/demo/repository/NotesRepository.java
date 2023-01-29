package com.example.demo.repository;

import com.example.demo.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes,Integer>, CustomNotesRepository{
}
