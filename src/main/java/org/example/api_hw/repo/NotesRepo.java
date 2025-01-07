package org.example.api_hw.repo;

import org.example.api_hw.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepo extends JpaRepository<Note, Integer> {
}
