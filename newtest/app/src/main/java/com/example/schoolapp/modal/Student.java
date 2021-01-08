package com.example.schoolapp.modal;

public class Student {


    private String name;
    private String age;
    private Boolean scase;
    private String note;

    public Student(String name, String age, boolean checked, String note){}

    public Student( String name, String age, Boolean scase, String note) {
       // this.id = id;
        this.name = name;
        this.age = age;
        this.scase = scase;
        this.note = note;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getScase() {
        return scase;
    }

    public void setScase(Boolean scase) {
        this.scase = scase;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
