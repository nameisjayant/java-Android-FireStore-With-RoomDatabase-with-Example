package com.jayant.firestoreroomdatabase.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.jayant.firestoreroomdatabase.Dao.DataDao;
import com.jayant.firestoreroomdatabase.Database.DataDatabase;
import com.jayant.firestoreroomdatabase.Modal.Data;

import java.util.List;

public class DataRepository {

    private DataDatabase dataDatabase;
    private LiveData<List<Data>> getAllData;

    public DataRepository(Application application)
    {
        dataDatabase=DataDatabase.getInstance(application);
        getAllData=dataDatabase.dataDao().getAllData();
    }

    public void insert(List<Data> dataList){
  new InsertAsynTask(dataDatabase).execute(dataList);
    }

    public void deleteAll()
    {
        new DeleteAsynTask(dataDatabase).execute();
    }

    public LiveData<List<Data>> getAllData()
    {
        return getAllData;
    }

    static class InsertAsynTask extends AsyncTask<List<Data>,Void,Void>
    {
        private DataDao dataDao;

        InsertAsynTask(DataDatabase dataDatabase)
        {
            dataDao=dataDatabase.dataDao();
        }

        @Override
        protected Void doInBackground(List<Data>... lists) {
            dataDao.insert(lists[0]);
            return null;
        }
    }

    static class DeleteAsynTask extends AsyncTask<Void,Void,Void>
    {
        private DataDao dataDao;

        DeleteAsynTask(DataDatabase dataDatabase)
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
