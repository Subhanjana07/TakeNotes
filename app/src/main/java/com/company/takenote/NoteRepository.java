package com.company.takenote;

import android.app.Application;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {

    private NotesDao notesDao;
    private LiveData<List<Notes>> notes;

    ExecutorService executor = Executors.newSingleThreadExecutor();

    public NoteRepository(Application application){

        NoteDatabase noteDatabase = NoteDatabase.getnoteDatabase(application);
        notesDao = noteDatabase.notesDao();
        notes = notesDao.getAllNotes();
    }

    public void insert(Notes note)
    {
        //new InsertNoteAsyncTask(notesDao).execute(note);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                notesDao.insert(note);
            }
        });
    }
    public void update(Notes note)
    {
        //new UpdateNoteAsyncTask(notesDao).execute(note);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                notesDao.update(note);
            }
        });
    }
    public void delete(Notes note)
    {
        //new DeleteNoteAsyncTask(notesDao).execute(note);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                notesDao.delete(note);
            }
        });
    }
    public LiveData<List<Notes>> getAllNotes(){
        return notes;
    }

//    private static class InsertNoteAsyncTask extends AsyncTask<Notes,Void,Void>{
//
//        private NotesDao notesDao;
//
//        private InsertNoteAsyncTask(NotesDao notesDao)
//        {
//            this.notesDao = notesDao;
//        }
//        @Override
//        protected Void doInBackground(Notes... notes) {
//            notesDao.insert(notes[0]);
//            return null;
//        }
//    }
//
//    private static class UpdateNoteAsyncTask extends AsyncTask<Notes,Void,Void>{
//
//        private NotesDao notesDao;
//
//        private UpdateNoteAsyncTask(NotesDao notesDao)
//        {
//            this.notesDao = notesDao;
//        }
//        @Override
//        protected Void doInBackground(Notes... notes) {
//            notesDao.update(notes[0]);
//            return null;
//        }
//    }
//
//    private static class DeleteNoteAsyncTask extends AsyncTask<Notes,Void,Void>{
//
//        private NotesDao notesDao;
//
//        private DeleteNoteAsyncTask(NotesDao notesDao)
//        {
//            this.notesDao = notesDao;
//        }
//        @Override
//        protected Void doInBackground(Notes... notes) {
//            notesDao.delete(notes[0]);
//            return null;
//        }
//    }
}
