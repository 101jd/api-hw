package org.example.api_hw.controller;

import org.example.api_hw.model.Note;
import org.example.api_hw.model.dto.NotesDto;
import org.example.api_hw.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    NotesService service;

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        List<Note> notes;
        try {
            notes = service.getAllNotes();
            return new ResponseEntity<>(notes, HttpStatus.OK);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id")int id){
        Note note;
        try {
            note = service.getNoteById(id);
            return new ResponseEntity<>(note, HttpStatus.OK);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new NotesDto());
        }
    }

    @PostMapping ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(service.createNote(note), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") int id, @RequestBody Note note){
        try {
            return new ResponseEntity<>(service.updateNote(id, note), HttpStatus.OK);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new NotesDto());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") int id){
        service.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
