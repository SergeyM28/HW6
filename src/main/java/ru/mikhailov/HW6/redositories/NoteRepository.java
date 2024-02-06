package ru.mikhailov.HW6.redositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mikhailov.HW6.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
