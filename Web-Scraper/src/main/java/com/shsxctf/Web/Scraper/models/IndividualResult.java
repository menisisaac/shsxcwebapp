package com.shsxctf.Web.Scraper.models;

public class IndividualResult extends Result{
    private String firstName;
    private String lastName;
    private String grade;

    public IndividualResult(Race race, String time, String place, String heat, String team, String firstName, String lastName, String grade) {
        super(race, time, place, heat, team);
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "IndividualResult{" +
                "time='" + getTime() + '\'' +
                ", place='" + getPlace() + '\'' +
                ", heat='" + getHeat() + '\'' +
                ", team='" + getTeam() + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
