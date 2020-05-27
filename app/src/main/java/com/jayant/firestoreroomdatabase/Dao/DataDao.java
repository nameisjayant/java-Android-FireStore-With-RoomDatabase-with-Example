package com.jayant.firestoreroomdatabase.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.jayant.firestoreroomdatabase.Modal.Data;

import java.util.List;

@Dao
public interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insert(List<Data> list);

    @Query("DELETE FROM data")
    void deleteAll();

    @Query("SELECT * FROM data")
    LiveData<List<Data>>  getAllData();
}
