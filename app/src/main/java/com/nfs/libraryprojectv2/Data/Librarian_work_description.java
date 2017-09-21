package com.nfs.libraryprojectv2.Data;

import java.util.List;

public interface Librarian_work_description {
    /**
     * adds a new book to the library.
     *
     * @param newBook
     */
    public void addBook(Book newBook);

    /**
     * shows list of books in the library
     *
     * @return read only list of books in library
     */
    public List<Book> viewBooks();

    /**
     * checks if student exist and book is available.
     *
     * @param call_no
     * @param student_id
     * @param student_name
     * @param student_contact
     * @return true only if book is successfully issued.
     */
    public boolean issueBook(String call_no, int student_id, String student_name, int student_contact);

    /**
     * shows list all the books issued.
     *
     * @return read only list of books currently issued.
     */
    public List<Book> viewIssuedBooks();

    /**
     * stores the book issued to student with the matching id back to the library books database.
     *
     * @param call_no
     * @param student_id
     */
    public void returnBook(String call_no, int student_id);

}
