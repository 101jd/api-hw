package org.example.api_hw.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "note")
    private String note;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private final Date date = new Date();
}
