package com.jayant.firestoreroomdatabase.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jayant.firestoreroomdatabase.Modal.Data;
import com.jayant.firestoreroomdatabase.Repository.DataRepository;

import java.util.List;

public class DataViewModel extends AndroidViewModel {

    private DataRepository repository;
    private LiveData<List<Data>> getAllList;

    public DataViewModel(@NonNull Application application) {
        super(application);
        repository=new DataRepository(application);
        getAllList=repository.getAllData();
    }

    void insert(List<Data> dataList)
    {
        repository.insert(dataList);
    }

    public LiveData<List<Data>> getAllData()
    {
        return getAllList;
    }
}
