package com.nfs.libraryprojectv2.Data;

import java.util.Collections;
import java.util.List;

public class Admin {
    private String email, password;
    private Admin_work_description library;
    private boolean isLoggedIn;

    /**
     * Empty constructor in order to create the Admin for Database
     */
    public Admin(){

    }

    /**
     * Constructs a new admin for the library
     *
     * @param email;                  to reset password if forgotten
     * @param password,               login detail
     * @param admin_work_description; job description of the admin
     */
    public Admin(String email, String password, Admin_work_description admin_work_description) {
        this.email = email;
        this.password = password;
        library = admin_work_description;
        isLoggedIn = false;
    }

    /**
     * Constructs a new librarian and adds it to the library staff database.
     *
     * @param name
     * @param password
     * @param email
     * @param address
     * @param city
     * @param contact
     */
    public void addLibrarian(String name, String password, String email, String address, String city, int contact,
                             Librarian_work_description libraria_work_description) {
        library.addLibrarian(new Librarian(name, password, email, address, city, contact, libraria_work_description));
    }

    /**
     * views list of librarians in the library database
     *
     * @return read only list of librarians.
     */
    public List<Librarian> viewLibrarians() {
        return Collections.unmodifiableList(library.viewLibrarians());
    }

    /**
     * @param id; ID of the librarian to be deleted
     * @return true only if the librarian was deleted successfully.
     */
    public boolean deleteLibrarian(int id) {
        return library.deleteLibrarian(id);
    }

    /**
     * To login admin in the system
     *
     * @param email
     * @param password
     * @return true if admin has logged in successfully, otherwise false.
     */
    public Admin logIn(String email, String password) {
        if ((this.email.equals(email)) && (this.password.equals(password))) {
            isLoggedIn = true;
            return this;
        }
        return null
                ;
    }

    /**
     * logs out the admin from the system.
     */
    public void logOut() {
        isLoggedIn = false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
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
