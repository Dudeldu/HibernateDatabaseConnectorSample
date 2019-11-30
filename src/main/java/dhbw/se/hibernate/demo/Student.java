package dhbw.se.hibernate.demo;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "STUDENT")
public class Student {
    @Id @GeneratedValue
    @Column(name = "Id")
    private int Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Birthdate")
    private Date birthdate;

    @OneToMany()
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
