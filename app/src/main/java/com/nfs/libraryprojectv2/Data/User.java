package com.nfs.libraryprojectv2.Data;

/**
 * Created by nafis on 20/09/2017.
 */

public class User {
    private String email;
    private String password;

    public User(){

    }
    public User(String Email, String Password){
        this.email = Email;
        this.password = Password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
