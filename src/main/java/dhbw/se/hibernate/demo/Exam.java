package dhbw.se.hibernate.demo;

import javax.persistence.*;

@Entity
@Table(name = "EXAM")
public class Exam {
    @Id @GeneratedValue
    @Column(name = "Id")
    private int Id;

    @Column(name = "mark")
    private int mark;

    public Exam(int mark) {
        this.mark = mark;
    }
    public Exam(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
