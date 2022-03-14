package com.example.mvpdesign.model;

public interface IUser {
    String getEmail();
    String getPassword();

    int checkUserValidity();
}
