package model;

import java.time.LocalDateTime;

public class Enrolment {
    int id;
    private int studentId;
    private int courseId;
    private String createdAt;

    public Enrolment(int id,int studentId, int courseId, String createdAt) {
        this.id=id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.createdAt = createdAt;
    }

    public Enrolment(String text){
        String []path=text.split(",");
        this.id=Integer.parseInt(path[0]);
        this.studentId=Integer.parseInt(path[1]);
        this.courseId=Integer.parseInt(path[2]);
        this.createdAt=path[3];
    }

    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId){
        this.courseId=courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String descriere(){
        String text="ID: "+this.id+"\n";
        text+="CursID"+this.courseId+"\n";
        text+="StudentId"+this.studentId+"\n";
      return text;
    }

    public String toSave(){
        String text=this.id+","+this.courseId+","+this.studentId+","+this.createdAt;
        return  text;
    }
}
