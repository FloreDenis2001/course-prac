package model;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;

    public Student(int id, String firstName, String lastName, String email, int age, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public Student(String text) {
        String[] path = text.split(",");
        this.id = Integer.parseInt(path[0]);
        this.firstName = path[1];
        this.lastName = path[2];
        this.email = path[3];
        this.age = Integer.parseInt(path[4]);
        this.password = path[5];
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String descriere() {
        String text = "Id : " + this.id + "\n";
        text += "First Name :" + this.firstName + "\n";
        text += "Last Name : " + this.lastName + "\n";
        text += "Email : " + this.email + "\n";
        text += "Age : " + this.age + "\n";
        text += "Password : " + this.password + "\n";
        return text;
    }

    //
    public String toSave() {
        String text = this.id + "," + this.firstName + "," + this.lastName + "," + this.email + "," + this.age + "," + this.password;
        return text;
    }

}
