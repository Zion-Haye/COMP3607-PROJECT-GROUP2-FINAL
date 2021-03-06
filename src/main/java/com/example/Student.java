package com.example;

import java.util.ArrayList;
import java.util.Arrays;


public class Student {

    private String participantIdentifierNum;
    private ArrayList<String> fullName;
    private String idNumber;
    private boolean found;

    public Student(String participantIdentifierNum, String fullName, String idNumber) {
        this.participantIdentifierNum = participantIdentifierNum;
        found = false;
        setNames(fullName);
        this.idNumber = idNumber;
        System.out.println(this);

    }

    // Modifiers
    public void setNames(String fullName) {
        this.fullName = new ArrayList<String>(Arrays.asList(fullName.split("\\s+")));
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    // Accessors
    public String getParticipantIdentifierNum() {
        return participantIdentifierNum;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getFullNameString() {
        String newName = "";
        for (int x = 0; x < fullName.size(); x++)
            newName += fullName.get(x) + " ";
        newName = newName.substring(0, newName.length() - 1);
        return newName;
    }

    public ArrayList<String> getFullName() {
        return fullName;
    }

    public boolean isFound() {
        return found;
    }

    public String toString() {
        String studentDetails;
        studentDetails = getParticipantIdentifierNum() + ",";
        studentDetails += "Full Name: " + getFullNameString() + ",";
        studentDetails += getIdNumber() + "\n";
        return studentDetails;

    }

}
