package com.akoca.mvc.domain.test;

import java.io.Serializable;

public class Visitor implements Serializable {


    private static final long serialVersionUID = -7546540425001087882L;

    private String name;
    private String email;

    public Visitor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
