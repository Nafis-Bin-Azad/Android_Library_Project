package com.nfs.libraryprojectv2.Data;

import java.util.List;

public class Librarian {
    private String username, password, email, address, city;
    private int contact_number;
    private final int id; // id if the staff
    private static int uniqID = 100; // increasing number
    private Librarian_work_description library;

    public Librarian(String username, String password, String email, String address, String city, int contact_number, Librarian_work_description library) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contact_number = contact_number;
        this.library = library;
        id = generateID(); //generates unique id.
    }

    /**
     * Constructs a new book with the supplied info and adds it to the database;
     *
     * @param call_no
     * @param bookName
     * @param author
     * @param publisher
     * @param quantity
     */
    public void addBook(String call_no, String bookName, String author, String publisher, int quantity) {
        library.addBook(new Book(call_no, bookName, author, publisher, quantity));
    }

    /**
     * shows list of books in the library
     *
     * @return read only list of books in library
     */
    public List<Book> viewBooks() {
        return library.viewBooks();
    }

    /**
     * checks if student exist and book is available.
     *
     * @param call_no
     * @param student_id
     * @param student_name
     * @param student_contact
     * @return true only if book is successfully issued.
     */
    public boolean issueBook(String call_no, int student_id, String student_name, int student_contact) {
        return library.issueBook(call_no, student_id, student_name, student_contact);
    }

    /**
     * shows list all the books issued.
     *
     * @return read only list of books currently issued.
     */
    public List<Book> viewIssuedBooks() {
        return library.viewIssuedBooks();
    }

    /**
     * stores the book issued to student with the matching id back to the library books database.
     *
     * @param call_no
     * @param student_id
     */
    public void returnBook(String call_no, int student_id) {
        library.returnBook(call_no, student_id);
    }


    /**
     * id of the librarian.
     *
     * @return int; ID number.
     */
    public int getID() {
        return id;
    }

    /**
     * generate unique id
     *
     * @return id number
     */
    private int generateID() {
        return uniqID++;
    }
    /*
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Librarian){
			return ((Librarian)obj).id == this.id;
		}
		return false;
	}
	*/

    @Override
    public String toString() {
        return "\nId: " + id + " ,Username: " + username + " ,Password: " + password + " ,Email: " + email + " ,Address: " + address + " ,City: " + city + " ,Contact: " + contact_number + ".\n";
    }
}
