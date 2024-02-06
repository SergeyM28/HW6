package ru.mikhailov.HW6.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //Заголовок заметки
    @Column(nullable = false)
    private String title;
    
    //Тело(содержание) заметки
    @Column(nullable = false)
    private String body;

    //Дата и время последнего изменения заметки. Проставляется автоматически. НАчальное значение - время создания заметки
    @Column
    private LocalDateTime timestamp;

    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    }

}
