package com.example.simpleform.SimpleLoginForm;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
    @Id
    private int ID;
    private String NAME;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return "Login{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}
