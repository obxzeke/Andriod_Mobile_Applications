//Assignment 4
//Response.java
//Zeke Marshall

package edu.uncc.assignment04;

import java.io.Serializable;

public class Response implements Serializable {
    String name, email, role, education, maritalStatus, livingStatus, income;

    public Response(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.education = null;
        this.maritalStatus = null;
        this.livingStatus = null;
        this.income = null;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus = maritalStatus;
    }

    public void setLivingStatus(String livingStatus) {
        this.livingStatus = livingStatus;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getEducation() {
        return education;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getLivingStatus() {
        return livingStatus;
    }

    public String getIncome() {
        return income;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Response{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", education='" + education + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", livingStatus='" + livingStatus + '\'' +
                ", income='" + income + '\'' +
                '}';
    }
}
