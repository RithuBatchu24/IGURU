package com.example.recyclerviewtask.iguru;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getAllUsers();

    @Insert
    void insertUsers(List<User> users);

    @Update
    void updateUser(User user);



}
