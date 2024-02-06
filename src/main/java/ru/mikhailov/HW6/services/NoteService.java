package ru.mikhailov.HW6.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mikhailov.HW6.model.Note;
import ru.mikhailov.HW6.redositories.NoteRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    /*
    Создает заметку.
    id присваивается автоматически.
    временная метка присваивается автоматически - текущие время/дата
    Название и тело заметки берет из переданного в аргументе экземпляра Note
     */
    public Note createNote(Note note){
        note.setTimestamp(LocalDateTime.now());
        return noteRepository.save(note);
    }

    /*
    Возвращает все заметки
     */
    public List<Note> findAllNotes(){
        return noteRepository.findAll();
    }

    /*
    Возвращает заметку по id
     */
    public Note findNoteById(Long id){
        return noteRepository.findById(id).get();
    }

    /*
    Обновляет заметку по переданному id
    Новые данные берет из переданного экзампляра Note
    Временная метка обновляется
     */
    public Note editNote(Note note){
        Note noteToEdit = findNoteById(note.getId());
        noteToEdit.setId(note.getId());
        noteToEdit.setTitle(note.getTitle());
        noteToEdit.setBody(note.getBody());
        noteToEdit.setTimestamp(LocalDateTime.now());
        return noteRepository.save(noteToEdit);
    }

    /*
    Удаляет заметку по id
     */
    public void deleteNote(Long id){
        noteRepository.deleteById(id);
    }

}
