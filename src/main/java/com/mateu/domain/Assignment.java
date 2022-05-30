package com.mateu.domain;

public class Assignment {

    private String Name;
    private String Description;
    private String Postcode;

    public Assignment() {}

    public Assignment(String name, String description, String postcode) {
        this.Name = name;
        this.Description = description;
        this.Postcode = postcode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }
}
