package edu.ufp.inf.lp2.p01_intro;

import java.util.Objects;

public class Person {

    private String idNumber;

    private String name;

    private String address;

    private Date birth;

    public Person() {
    }

    public Person(String idNumber, String name, String address, Date birth) {
        this.idNumber = idNumber;
        this.name = name;
        this.address = address;
        this.birth = birth;
    }

    public int age() {
        return 0;
    }

    public boolean olderThan(Person p) {
        return false;
    }


    public String getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(idNumber, person.idNumber) && Objects.equals(name, person.name) && Objects.equals(address, person.address) && Objects.equals(birth, person.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, name, address, birth);
    }
}