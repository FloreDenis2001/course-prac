package view;

import Controller.ControllerStudents;
import model.Student;

import java.util.Scanner;

public class ViewLogin {
    private ControllerStudents controllerStudents;
    private Scanner scanner;

    public ViewLogin() {
        this.controllerStudents = new ControllerStudents();
        this.scanner = new Scanner(System.in);
    }

    public void meniu() {
        System.out.println("-----------------------LOGIN-------------------");
        System.out.println("Apasa 1 pentru a te loga");
        System.out.println("Apasa 2 pentru a te inregistra");
        System.out.println("Apasa 3 pentru a iesi");
        System.out.println("-----------------------------------------------");
    }

    public void play() {
        int c;
        boolean running = true;
        while (running) {
            meniu();
            c = Integer.parseInt(scanner.nextLine());
            switch (c) {
                case 3:logOut();
                       running = false;
                       break;
                case 1:
                    login();
                    break;
                case 2:
                    registration();
                    break;
                default:
                    meniu();
            }
        }
    }

    public void login() {
        System.out.println("Introduceti numele utilizatorului : ");
        String email = scanner.nextLine();
        System.out.println("Introduceti parola : ");
        String password = scanner.nextLine();


        Student student = controllerStudents.verificareLogare(email, password);

        if (student != null) {

            View view = new View(student);
            view.play();

        } else {

            System.out.println("Credentialele dvs sunt incorecte");
        }


    }


    public void registration() {
        System.out.println("Introduceti Nume : ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti Prenume :");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti Email : ");
        String email = scanner.nextLine();
        System.out.println("Introduceti parola : ");
        String password = scanner.nextLine();
        System.out.println("Introduceti varsta : ");
        int age = Integer.parseInt(scanner.nextLine());
        int noulId = controllerStudents.nextId();
        controllerStudents.registrationStudent(noulId, nume, prenume, email, password, age);
        play();
    }

    public void logOut(){

        System.out.println("Login OUT");
    }
}

