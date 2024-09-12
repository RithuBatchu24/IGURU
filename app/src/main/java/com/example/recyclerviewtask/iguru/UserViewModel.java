package com.example.recyclerviewtask.iguru;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository repository;
    private LiveData<List<User>> allUsers;

    public UserViewModel(Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void fetchUsersFromApi() {
        repository.fetchUsersFromApi();
    }

    public void updateUser(User user) {
        repository.updateUser(user);
    }
}
