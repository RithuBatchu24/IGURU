package com.example.recyclerviewtask.iguru;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>> allUsers;
    private ApiService apiService;

    public UserRepository(Application application) {
        UserDatabase db = UserDatabase.getDatabase(application);
        userDao = db.userDao();
        allUsers = userDao.getAllUsers();
        apiService = ApiService.create();

    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void fetchUsersFromApi() {
        apiService.getUsers(2).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.body() != null) {
                    new Thread(() -> userDao.insertUsers(response.body().data)).start();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void updateUser(User user) {
        new Thread(() -> userDao.updateUser(user)).start();
    }
}