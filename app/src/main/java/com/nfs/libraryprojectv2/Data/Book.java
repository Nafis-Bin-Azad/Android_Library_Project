package com.nfs.libraryprojectv2.Data;

public class Book {
    private String call_no, book_name, author, publisher;
    private int quantity;

    public Book(String call_no, String book_name, String author, String publisher, int quantity) {
        this.call_no = call_no;
        this.book_name = book_name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    /**
     * increases the quantity of this book
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    /**
     * @return quantity of the book.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return call_no of the book;
     */
    public String getCallno() {
        return call_no;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            return ((Book) obj).call_no.equals(this.call_no);
        }
        return false;
    }

}
