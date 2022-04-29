package view;

import Controller.ControllerCursuri;
import Controller.ControllerEnrolment;
import model.Curs;
import model.Enrolment;
import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

    private ControllerCursuri controllerCursuri;
    private ControllerEnrolment controllerEnrolment;
    private Student logat;
    private Scanner scanner;

    public View(Student student) {
        this.controllerCursuri = new ControllerCursuri();
        this.controllerEnrolment = new ControllerEnrolment();
        this.logat =student;
        this.scanner = new Scanner(System.in);
    }

    public void meniu() {
        System.out.println("--------Bine ai venit " + this.logat.getFirstName() + " -----------------");
        System.out.println("Apasa 1 pentru a afisa lista cursurilor");
        System.out.println("Apasa 2 pentru a vedea cursurile la care sunteti inscris ");
        System.out.println("Apasa 3 pentru a te inscrie la un curs");
        System.out.println("Apasa 4 pentru a te dezabona de la un curs");
        System.out.println("------------------------------------");
    }

    public void play() {
        int choose;
        boolean running = true;
        while (running) {
            meniu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 0:
                    running=false;
                    break;
                case 1:
                    controllerCursuri.afisare();
                    break;
                case 2:
                    cursStudent();
                    break;
                case 3:
                    enrolToCourse();
                    break;
                case 4: unsubToCourse();
                    break;
            }
        }
        controllerCursuri.save();
        controllerEnrolment.save();
    }

    public void cursStudent() {
        System.out.println("Cursurile la care esti abonat " + this.logat.getFirstName());

        ArrayList<Enrolment> enrolments = controllerEnrolment.cursListStudent(logat.getId());


        for (Enrolment enrolment : enrolments) {

            Curs curs = controllerCursuri.findById(enrolment.getCourseId());

            System.out.println(curs.descriere());
        }

    }

    public void enrolToCourse() {
        System.out.println("Adauga curs pentru : " + this.logat.getFirstName());
        System.out.println("Introduceti cursul dorit : ");
        String cursName = scanner.nextLine();
        Enrolment x = new Enrolment(controllerEnrolment.nextId(), this.logat.getId(), controllerCursuri.findCourseByName(cursName), "azi");
        controllerEnrolment.add(x);
    }
    public void unsubToCourse(){
        System.out.println("Introduceti cursul de la care doriti sa va dezabonati: ");
        String cursName= scanner.nextLine();
        int idCurs=controllerCursuri.findCourseByName(cursName);


         controllerEnrolment.remove(idCurs,this.logat.getId());


    }
}
