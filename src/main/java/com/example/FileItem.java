package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileItem {
    // leaf

    private File file;
    private String id;
    private ArrayList<String> namesList;
    private String assignmentFileName;
    // String extractedData;

    public FileItem(File file) {
        this.file = file;
        namesList = new ArrayList<String>();
        getImportantDetails();
    }

    public String getName() {
        return file.getName();
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getstudentNames() {
        return namesList;
    }

    public String getAssignmentFileName() {
        return assignmentFileName;
    }

    public void renameFile(String newFileName) {
        Boolean isRenamed;
        // String fileName = "lib/renamedFiles/test.docx";

        String seperator = File.separator;
        String ogFileDirectory = "lib" + seperator + "fileToRename";
        String newFileDirectory = ogFileDirectory + seperator + "renamedFiles";
        File oldFile = new File(ogFileDirectory + seperator + getName());
        File newFile = new File(newFileDirectory + seperator + newFileName + getAssignmentFileName()); // takes in file
                                                                                                       // path

        File f = new File(newFileDirectory);
        f.mkdirs();

        isRenamed = oldFile.renameTo(newFile); // take in file , returns bool

        if (isRenamed) {
            System.out.println("Rename Successful!" + newFileName);
        } else {
            System.out.println("Rename Failed!");
            System.out.println(ogFileDirectory + seperator + getName());
            System.out.println(newFileDirectory + seperator + newFileName + getAssignmentFileName() + "\n");
        }

    }

    private void getImportantDetails() {
        ArrayList<String> fullFileName = new ArrayList<String>(Arrays.asList(getName().split("_")));

        // ArrayList<String> importantDetails = new ArrayList<String>();

        int x;
        for (x = 1; !NumChecker.isNumeric(fullFileName.get(x)); x++)
            namesList.add(fullFileName.get(x));

        id = fullFileName.get(x++); // Participant id
        assignmentFileName = fullFileName.get(x++);
        while (x < fullFileName.size())
            assignmentFileName += "_" + fullFileName.get(x++);

    }

    public void printImportantDetails() {
        String names = "";
        for (String name : namesList)
            names += name + " ";
        System.out.println("Important Details: " + "\nID: " + id + "\nName: " + names + "\nOriginal File Name: "
                + assignmentFileName);

        // System.out.println(getImportantDetails() + "\n\n");
    }

    // get file extension?

}