
package javaapplication13;


public class StudentModal {
    
    private int id;
    private String name;
    private String mail;
    private String course;
    private double fee;

    public StudentModal(int id, String name, String mail, String course, double fee) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.course = course;
        this.fee = fee;
    }

    public StudentModal(String name, String mail, String course, double fee) {
        this.name = name;
        this.mail = mail;
        this.course = course;
        this.fee = fee;
    }

    public StudentModal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
    
    
}
