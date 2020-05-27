package com.jayant.firestoreroomdatabase.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.jayant.firestoreroomdatabase.Dao.DataDao;
import com.jayant.firestoreroomdatabase.Modal.Data;

@Database(entities = {Data.class},version = 1)
public abstract class DataDatabase  extends RoomDatabase {

    private static final String DATABASE_NAME="data";
    public abstract DataDao dataDao();

    private static volatile DataDatabase instance=null;

    public static DataDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            synchronized (DataDatabase.class)
            {
                if(instance == null)
                {
                    instance= (DataDatabase) Room.databaseBuilder(context,DataDatabase.class,
                            DATABASE_NAME)
                            .addCallback(callback)
                            .build();
                }
            }
        }

        return  instance;
    }

    static Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsynTask(instance);
        }
    };

    static class PopulateAsynTask extends AsyncTask<Void,Void,Void>
    {
        private DataDao dataDao;

        PopulateAsynTask(DataDatabase dataDatabase)
        {
            dataDao=dataDatabase.dataDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dataDao.deleteAll();
            return null;
        }
    }
}
