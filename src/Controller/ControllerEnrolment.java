package Controller;

import model.Enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerEnrolment {
    private ArrayList<Enrolment> enrolments;

    public ControllerEnrolment() {
        enrolments = new ArrayList<>();
        this.load();
    }

    public void load() {

        try {
            File file = new File("C:\\Users\\flore\\Desktop\\mycode\\JavaBasics\\Incapsularea\\coruse-prac\\src\\res\\enrolment.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String x = scanner.nextLine();
                Enrolment p = new Enrolment(x);
                this.enrolments.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisare() {
        for (Enrolment x : enrolments) {
            System.out.println(x.descriere());
        }
    }

    public Enrolment findById(int id) {
        for (Enrolment x : enrolments) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }


    //functie ce primeste ca prametru id unui student si returneaza

    public ArrayList<Enrolment> cursListStudent(int studentId) {


        ArrayList<Enrolment> cursListStudent = new ArrayList<>();
        for (Enrolment x : enrolments) {
            if (x.getStudentId() == studentId) {
                cursListStudent.add(x);
            }
        }
        return cursListStudent;
    }

    public int nextId() {

        if (this.enrolments.size() > 0) {

            return this.enrolments.get(this.enrolments.size() - 1).getId() + 1;
        }
        return 1;

    }

    public void add(Enrolment x) {
        Enrolment t = findById(x.getId());
        if (t == null) {
            this.enrolments.add(x);
        } else {
            System.out.println("ERROR");
        }
    }

    public String toSaveEnrolments() {
        String text = "";
        for (Enrolment e : enrolments) {
            text += e.toSave() + "\n";
        }
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\mycode\\JavaBasics\\Incapsularea\\coruse-prac\\src\\res\\enrolment.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSaveEnrolments());

            printWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(int courseId,int studentId) {
        Enrolment y = findByCursandStudent(courseId,studentId);

        this.enrolments.remove(y);

    }

    public Enrolment findByCursandStudent(int cursId,int studentId) {
        for (Enrolment x:enrolments){
            if(x.getCourseId()==cursId && x.getStudentId()==studentId){
                return  x;
            }
        }
        return null;
    }


}
