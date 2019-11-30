package dhbw.se.hibernate.demo;

public class Exam {
    private int Id;
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
