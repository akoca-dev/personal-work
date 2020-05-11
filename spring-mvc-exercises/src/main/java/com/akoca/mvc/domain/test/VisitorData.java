package com.akoca.mvc.domain.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VisitorData implements Serializable {

    private static final long serialVersionUID = -2829391567444023235L;

    private String currentVisitorName;
    private String currentVisitorEmail;

    private List<Visitor> visitorList;

    public VisitorData() {
        setCurrentVisitorName("No-data");
        setCurrentVisitorEmail("No-data");
        visitorList = new ArrayList<>();
    }

    public VisitorData(String currentVisitorName, String currentVisitorEmail , List<Visitor> visitorList) {
        this.currentVisitorName = currentVisitorName;
        this.currentVisitorEmail = currentVisitorEmail;
        this.visitorList = visitorList;
    }

    public String getCurrentVisitorName() {
        return currentVisitorName;
    }

    public void setCurrentVisitorName(String currentVisitorName) {
        this.currentVisitorName = currentVisitorName;
    }

    public String getCurrentVisitorEmail() {
        return currentVisitorEmail;
    }

    public void setCurrentVisitorEmail(String currentVisitorEmail) {
        this.currentVisitorEmail = currentVisitorEmail;
    }

    public List<Visitor> getVisitorList() {
        return visitorList;
    }

    public void setVisitorList(List<Visitor> visitorList) {
        this.visitorList = visitorList;
    }

    @Override
    public String toString() {
        return "VisitorData{" +
                "currentVisitorName='" + currentVisitorName + '\'' +
                ", currentVisitorEmail='" + currentVisitorEmail + '\'' +
                ", visitorList=" + visitorList +
                '}';
    }
}
