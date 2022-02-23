package com.bozo.problemtracker.services;

import com.bozo.problemtracker.entities.Note;
import com.bozo.problemtracker.entities.Users;
import com.bozo.problemtracker.forms.NoteForm;
import com.bozo.problemtracker.models.NotePresentation;
import com.bozo.problemtracker.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class NoteService {

    private NoteRepository noteRepository;
    private UsersService usersService;
    private MarketService marketService;

    @Autowired
    public NoteService(NoteRepository noteRepository, UsersService usersService, MarketService marketService) {
        this.noteRepository = noteRepository;
        this.usersService = usersService;
        this.marketService = marketService;
    }

    public List<NotePresentation> getNotesPresentation(){
        return Collections.unmodifiableList(noteRepository.getNotesForPresentation());
    }

    public List<NotePresentation> getNotesForPresentationByUserId(long id){
        return Collections.unmodifiableList(noteRepository.getNotesForPresentationByUserId(id));
    }

    public NotePresentation getNoteForPresentationById(long id){
        return noteRepository.getNoteForPresentationById(id);
    }

    public void addNote(NoteForm noteForm){
        Note note = new Note(
                marketService.getMarketByName(noteForm.getMarket()),
                noteForm.getOutsideNumber(),
                noteForm.getDescription(),
                noteForm.getStatus(),
                LocalDate.now(),
                usersService.getUsersById(1)
        );
        noteRepository.save(note);
    }

    public void updateNote(NoteForm noteForm){
        Note note = new Note(
                noteForm.getId(),
                marketService.getMarketByName(noteForm.getMarket()),
                noteForm.getOutsideNumber(),
                noteForm.getDescription(),
                noteForm.getStatus(),
                LocalDate.now(),
                usersService.getUsersById(1)
        );
//        note.setId(id);
        noteRepository.save(note);
    }

}
