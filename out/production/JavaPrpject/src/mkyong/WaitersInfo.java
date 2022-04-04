package mkyong;

public class WaitersInfo{
    private String name,number;
    private String surname,email,address;
    private int ID;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getID() {
        return ID;
    }

    public void setID(double price) {
        this.ID=ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public WaitersInfo(){
        this.ID=0;
        this.name=null;
        this.surname=null;
        this.address=null;
        this.number=null;
        this.email=null;
    }
    WaitersInfo(int ID,String name,String surname,String address,String email,String number){
        this.ID=ID;
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.address=address;
        this.number=number;

    }
}