package model;

public class Curs {
    private int id;
    private String numeCurs;
    private String departament;
    private double pretCurs;

    public Curs(int id, String numeCurs, String departament, double pretCurs) {
        this.id = id;
        this.numeCurs = numeCurs;
        this.departament = departament;
        this.pretCurs = pretCurs;
    }

    public Curs(String text) {
        String[] path = text.split(",");
        this.id = Integer.parseInt(path[0]);
        this.numeCurs = path[1];
        this.departament = path[2];
        this.pretCurs = Double.parseDouble(path[3]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeCurs() {
        return numeCurs;
    }

    public void setNumeCurs(String numeCurs) {
        this.numeCurs = numeCurs;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public double getPretCurs() {
        return pretCurs;
    }

    public void setPretCurs(double pretCurs) {
        this.pretCurs = pretCurs;
    }


    public String descriere() {
        String text = "Id: " + this.id + "\n";
        text += "Nume curs: " + this.numeCurs + "\n";
        text += "Departament: " + this.departament + "\n";
        text += "Pret Curs: " + this.pretCurs + "\n";
        return text;
    }

    public String toSave(){
        String text=this.id+","+this.numeCurs+","+this.departament+","+this.pretCurs;
        return text;
    }
}
