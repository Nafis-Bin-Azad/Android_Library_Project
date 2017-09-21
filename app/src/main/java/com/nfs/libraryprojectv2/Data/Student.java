package com.nfs.libraryprojectv2.Data;

public class Student {
    private String name;
    private int id, contact;

    public Student(int id, String name, int contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student otherStudent = (Student) obj;
            return (otherStudent.id == this.id && otherStudent.contact == this.contact
                    && otherStudent.name.equals(this.name));
        }
        return false;
    }
}
