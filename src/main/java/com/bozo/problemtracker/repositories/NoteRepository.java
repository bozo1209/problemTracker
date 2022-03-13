package com.bozo.problemtracker.repositories;

import com.bozo.problemtracker.entities.Note;
import com.bozo.problemtracker.entities.Users;
import com.bozo.problemtracker.enums.NoteStatus;
import com.bozo.problemtracker.models.NotePresentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {


//    select n.*, (select count(nn.outside_number) from note nn where nn.outside_number = n.outside_number) from note n where n.users_id = 1;
    @Query("SELECT new com.bozo.problemtracker.models.NotePresentation(n.id, n.market.name, n.outsideNumber, n.description, n.status, n.data, n.users.name, " +
            "(SELECT COUNT(nn.outsideNumber) FROM com.bozo.problemtracker.entities.Note nn WHERE nn.outsideNumber = n.outsideNumber)) " +
            "FROM com.bozo.problemtracker.entities.Note n")
    List<NotePresentation> getNotesForPresentation();

    @Query("SELECT new com.bozo.problemtracker.models.NotePresentation(n.id, n.market.name, n.outsideNumber, n.description, n.status, n.data, n.users.name, " +
            "(SELECT COUNT(nn.outsideNumber) FROM com.bozo.problemtracker.entities.Note nn WHERE nn.outsideNumber = n.outsideNumber))  " +
            "FROM com.bozo.problemtracker.entities.Note n " +
            "WHERE n.users.id = :id")
    List<NotePresentation> getNotesForPresentationByUserId(@Param("id") long id);

    @Query("SELECT new com.bozo.problemtracker.models.NotePresentation(n.id, n.market.name, n.outsideNumber, n.description, n.status, n.data, n.users.name, " +
            "(SELECT COUNT(nn.outsideNumber) FROM com.bozo.problemtracker.entities.Note nn WHERE nn.outsideNumber = n.outsideNumber))  " +
            "FROM com.bozo.problemtracker.entities.Note n " +
            "WHERE n.status != com.bozo.problemtracker.enums.NoteStatus.CLOSED AND n.users.id = :id")
    List<NotePresentation> getNotesForPresentationByUserIdWithoutClosed(@Param("id") long id);

    @Query("SELECT new com.bozo.problemtracker.models.NotePresentation(n.id, n.market.name, n.outsideNumber, n.description, n.status, n.data, n.users.name, " +
            "(SELECT COUNT(nn.outsideNumber) FROM com.bozo.problemtracker.entities.Note nn WHERE nn.outsideNumber = n.outsideNumber))  " +
            "FROM com.bozo.problemtracker.entities.Note n " +
            "WHERE n.id = :id")
    NotePresentation getNoteForPresentationById(@Param("id") long id);

    @Query("SELECT u FROM Note n JOIN Users u ON n.users.id = u.id WHERE n.id = :id")
    Users getUsersByNoteId(@Param("id") long id);
}
