package com.nfs.libraryprojectv2.Data;

import java.util.List;

public interface Admin_work_description {
    /**
     * Adds a new librarian to the library staff database.
     *
     * @param newLibrarian TODO
     * @param admin        TODO
     */
    public void addLibrarian(Librarian newLibrarian);

    /**
     * @param admin TODO
     * @return read only list of librarians in the library.
     */
    public List<Librarian> viewLibrarians();

    /**
     * Delete a librarian with the current id.
     *
     * @param id
     * @param admin TODO
     * @return boolean; true only if a librarian was deleted.
     */
    public boolean deleteLibrarian(int id);

    public boolean check_loggedInAdmin(Admin loggedInAdmin);

    public boolean logIn(String username, String password);

}
