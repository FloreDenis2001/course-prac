package Controller;

import model.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerStudents {
    private ArrayList<Student> students;

    public ControllerStudents() {
        students = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\mycode\\JavaBasics\\Incapsularea\\coruse-prac\\src\\res\\students.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                Student s = new Student(text);
                this.students.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisare() {
        for (Student s : students) {
            System.out.println(s.descriere());
        }
    }


    public Student varstnic() {
        Student x = students.get(0);
        for (Student t : students) {
            if (t.getAge() > x.getAge()) {
                x.setAge(t.getAge());
            }
        }
        return x;
    }

    public Student varstnicPar() {
        Student x = students.get(0);
        for (Student t : students) {
            if (t.getAge() % 2 == 0 && t.getAge() > x.getAge()) {
                x.setAge(t.getAge());
            }
        }
        return x;
    }


    //todo functoe ce primeste ca prametru id unei persoane si retunreaza Persona
    public Student findById(int id) {
        for (Student x : students) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }


    //todo update in functie de id schimb varsta
    public void updateVarsta(int id, int varstaNoua) {

        Student student = this.findById(id);

        if (student != null) {

            student.setAge(varstaNoua);
        }
    }

    //todo exista student dupa id
    public boolean existStud(int id) {
        boolean exist = false;
        for (Student x : students) {
            if (x.getId() == id) {
                exist = true;
            }
        }
        return exist;
    }


    //todo remove
    public void deleteStudent(int id) {

        Student student = this.findById(id);

        this.students.remove(student);
    }

    //todo add students

    public void add(Student student) {

        Student aux = findById(student.getId());

        if (aux == null) {
            this.students.add(student);
        } else {
            System.out.println("Studentul  cu id " + student.getId() + " a mai fost introdus");
        }

    }

    //to save students

    public String toSaveStudents() {

        String text = "";

        for (Student student : students) {
            text += student.toSave() + "\n";
        }

        return text;
    }

    public void save() {

        try {
            File file = new File("C:\\Users\\flore\\Desktop\\mycode\\JavaBasics\\Incapsularea\\coruse-prac\\src\\res\\students.txt");


            FileWriter fileWriter = new FileWriter(file);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSaveStudents());

            printWriter.close();


        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public Student verificareLogare(String Email, String password) {
        for (Student s : students) {
            if (s.getEmail().equals(Email) && s.getPassword().equals(password)) {
                return s;
            }
        }
        return null;
    }

    public int nextId() {

        if (this.students.size() > 0) {

            return this.students.get(this.students.size() - 1).getId() + 1;
        }
        return 1;

    }
    public void registrationStudent(int id,String name,String prenume,String email,String parola,int age){
        Student x= new Student(id,name,prenume,email,age,parola);
        this.students.add(x);
    }
}
