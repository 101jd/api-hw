package org.example.api_hw.service;

import org.example.api_hw.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.api_hw.repo.NotesRepo;

import java.util.List;

@Service
public class NotesService {
    @Autowired
    NotesRepo repo;

    public List<Note> getAllNotes(){
        return repo.findAll();
    }

    public Note getNoteById(int id){
        return repo.findById(id).orElse(null);
    }

    public void deleteNote(int id){
        Note n = getNoteById(id);
        repo.delete(n);
    }

    public Note createNote(Note note){
        Note n = new Note();
        n.setTitle(note.getTitle());
        n.setNote(note.getNote());
        return repo.save(n);
    }

    public Note updateNote(int id, Note note){
        Note n = getNoteById(id);
        n.setTitle(note.getTitle());
        n.setNote(note.getNote());
        return repo.save(n);
    }
}
