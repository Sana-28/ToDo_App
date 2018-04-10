package com.fundoonotes.noteservice;

import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fundoonotes.userservice.IUserDao;
import com.fundoonotes.userservice.User;

/**
 * Purpose: This class contains implementation of notesService interface and
 * contains business logic.
 * 
 * @author SANA SHAIKH
 * @since 21Mar 2018
 */

@Service
public class NotesServiceImpl implements INotesService
{

   @Autowired
   INotesDao notesDao;

   @Autowired
   IUserDao userDao;

   @Transactional
   @Override
   public void createNote(Notes notes, int userId)
   {
      Date date = new Date();
      notes.setDate(date);

      User user = new User();
      user.setUserId(userId);
      notes.setUser(user);
      notesDao.createNotes(notes);
   }

   @Transactional
   @Override
   public void deleteNotes(int noteId, int userId)
   {
      Notes notes = notesDao.getNotesById(noteId);
      notesDao.deleteNotes(noteId);
   }

   @Transactional
   @Override
   public void updateNotes(int noteId, Notes notes, int userId)
   {
      // System.out.println(noteId);
      notesDao.updateNotes(noteId, notes);
   }

   @Override
   public Notes getNotesById(int noteId)
   {

      return notesDao.getNotesById(noteId);
   }
}