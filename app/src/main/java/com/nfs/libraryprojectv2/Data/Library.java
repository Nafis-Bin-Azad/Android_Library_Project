package com.nfs.libraryprojectv2.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nafis on 15/09/2017.
 */

public final class Library implements Admin_work_description, Librarian_work_description {

    /*
     * For time being there wont be database used for this program.
     */
    private ArrayList<Librarian> staff;
    private ArrayList<Book> books;
    private ArrayList<Student> students;
    private ArrayList<Book> issuedBooks;
    private ArrayList<Admin> admins;
    private Admin loggedInAdmin;

    /**
     * Constructor
     */
    public Library() {
        staff = new ArrayList<>();
        books = new ArrayList<>();
        students = new ArrayList<>();
        issuedBooks = new ArrayList<>();
        admins = new ArrayList<>();

        admins.add(new Admin("nafislord", "spain", this));


    }

    /**
     * adds a new admin to the databases.
     *
     * @param admin    Admin, currently logged in.
     * @param newAdmin Admin, new admin to be added.
     */
    public void addAdmin(Admin admin, Admin newAdmin) {
        if (check_loggedInAdmin(admin)) {
            admins.add(newAdmin);
        }
    }

    /**
     * @param loggedInAdmin
     * @return
     */
    public boolean check_loggedInAdmin(Admin loggedInAdmin) {
        if (loggedInAdmin == null)
            return false;

        return (admins.contains(loggedInAdmin) && loggedInAdmin.isLoggedIn());
    }

    /**
     * @param newLibrarian TODO
     */
    @Override
    public void addLibrarian(Librarian newLibrarian) {
        if (check_loggedInAdmin(loggedInAdmin))
            staff.add(newLibrarian);
    }

    /**
     * @return
     */
    @Override
    public List<Librarian> viewLibrarians() {
        if (check_loggedInAdmin(loggedInAdmin)) {
            return Collections.unmodifiableList(staff);
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteLibrarian(int id) {
        if (check_loggedInAdmin(loggedInAdmin)) {
            for (Librarian otherLibrarian : staff) {
                if (otherLibrarian.getID() == id) {
                    staff.remove(otherLibrarian);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param newBook
     */
    @Override
    public void addBook(Book newBook) {
        int index = books.indexOf(newBook);
        if (index != -1) {
            /*
			 * the question is, does indexOf(object) calls equals method on
			 * book. if not, this needs to be changed
			 */

            // checks if book is already in the library.
            books.get(index).setQuantity(newBook.getQuantity());
        } else {
            books.add(newBook);
        }
    }

    /**
     * @return
     */
    @Override
    public List<Book> viewBooks() {
        return Collections.unmodifiableList(books);
    }

    /**
     * @param call_no
     * @param student_id
     * @param student_name
     * @param student_contact
     * @return
     */
    @Override
    public boolean issueBook(String call_no, int student_id, String student_name, int student_contact) {
        if (verifyStudent(new Student(student_id, student_name, student_contact))) {

        }
        return false;
    }

    /**
     * @return
     */
    @Override
    public List<Book> viewIssuedBooks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void returnBook(String call_no, int student_id) {
        // TODO Auto-generated method stub

    }

    /**
     * checks if this student is in system
     *
     * @param student
     * @return true if student is verified.
     */
    private boolean verifyStudent(Student student) {
        return students.contains(student);
    }

    /**
     * @param username
     * @param password
     * @return
     */
    public boolean logIn(String username, String password) {
        for (Admin admin : admins) {
            if (admin.logIn(username, password) != null) {
                loggedInAdmin = admin;
                return true;
            }
        }
        return false;
    }

}
