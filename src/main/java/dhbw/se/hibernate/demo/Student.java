package dhbw.se.hibernate.demo;

import java.util.Date;
import java.util.Set;

public class Student {
    private int Id;
    private String Name;
    private Date birthdate;
    private Set<Exam> exams;

    public Student(String name, Date birthdate) {
        Name = name;
        this.birthdate = birthdate;
    }
    public Student() {}

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }
}
