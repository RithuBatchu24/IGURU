package com.example.recyclerviewtask.iguru;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
@PrimaryKey
    public int id;

    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
    public String uploadedImage;

    public User( int id,String email, String first_name, String last_name, String avatar, String uploadedImage) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
        this.uploadedImage = uploadedImage;
    }
}
