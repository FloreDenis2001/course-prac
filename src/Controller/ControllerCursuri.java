package Controller;

import model.Curs;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerCursuri {
    private ArrayList<Curs> curs;

    public ControllerCursuri() {
        curs = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\mycode\\JavaBasics\\Incapsularea\\coruse-prac\\src\\res\\cursuri.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String t = scanner.nextLine();
                Curs x = new Curs(t);
                this.curs.add(x);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisare() {
        for (Curs x : curs) {
            System.out.println(x.descriere());
        }
    }

    public Curs findById(int id) {
        for (Curs x : curs) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public void addCurs(Curs cursNou) {
        Curs x = findById(cursNou.getId());
        if (x == null) {
            this.curs.add(cursNou);
        } else {
            System.out.println("Exista un curs cu ID respectiv");
        }
    }

    public void updatePret(int id, double pretNou) {
        Curs x = findById(id);
        if (x != null) {
            x.setPretCurs(pretNou);
        } else {
            System.out.println("Cursul respectiv nu exista");
        }

    }

    public void removeById(int id) {
        Curs c = findById(id);
        if (c != null) {
            this.curs.remove(c);
        } else {
            System.out.println("Nu exista cursul respectiv");
        }

    }

    //findCourseByName

    public int findCourseByName(String name) {
        for (Curs x : curs) {
            if (x.getNumeCurs().equals(name) ) {
                return x.getId();
            }
        }
        return -1;
    }


    public String toSaveCrusuri() {
        String text = "";
        for (Curs c : curs) {
            text += c.toSave() + "\n";
        }
        return text;
    }


    public void save() {
        try {
            File file = new File("C:\\Users\\flore\\Desktop\\mycode\\JavaBasics\\Incapsularea\\coruse-prac\\src\\res\\cursuri.txt");

            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter= new PrintWriter(fileWriter);

            printWriter.print(toSaveCrusuri());

            printWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int idCourse(String nameCourse){
        int idMasina=0;
        for (Curs s:curs){
            if(s.getNumeCurs().compareTo(nameCourse)==0){
                idMasina=s.getId();
            }
        }
        return  idMasina;
    }
}
