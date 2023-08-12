package com.company.takenote;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Notes.class},version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public static NoteDatabase noteDatabase;

    public abstract NotesDao notesDao();

    public static synchronized NoteDatabase getnoteDatabase(Context context){

        if(noteDatabase == null)
        {
            noteDatabase = Room.databaseBuilder(context.getApplicationContext(),NoteDatabase.class,"note_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
        }
        return noteDatabase;

    }
    private static RoomDatabase.Callback roomCallback =new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            //new PopulateDbAsyncTask(noteDatabase).execute();

            NotesDao notesDao = noteDatabase.notesDao();
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    };

//    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>
//    {
//
//        private NotesDao notesDao;
//        private PopulateDbAsyncTask(NoteDatabase noteDatabase){
//            notesDao = noteDatabase.notesDao();
//
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//
//            notesDao.insert(new Notes("Title 1","Description 1"));
//            notesDao.insert(new Notes("Title 2","Description 2"));
//            notesDao.insert(new Notes("Title 3","Description 3"));
//            notesDao.insert(new Notes("Title 4","Description 4"));
//            notesDao.insert(new Notes("Title 5","Description 5"));
//            return null;
//        }
//    }

}
