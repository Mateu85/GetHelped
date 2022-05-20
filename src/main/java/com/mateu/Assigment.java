package com.mateu;

public class Assigment {

    private String Name;
    private String Description;
    private String Postcode;


    public Assigment(String name, String description, String postcode) {
        Name = name;
        Description = description;
        Postcode = postcode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }
}
