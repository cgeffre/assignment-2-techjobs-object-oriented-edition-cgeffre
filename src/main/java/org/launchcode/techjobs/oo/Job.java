package org.launchcode.techjobs.oo;

import java.util.Objects;
import java.util.ArrayList;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job () {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public String toString() {
        String stringName = name;
        String stringEmployer = employer.getValue();
        String stringLocation = location.getValue();
        String stringPositionType = positionType.getValue();
        String stringCoreCompetency = coreCompetency.getValue();
        String noData = "Data not available";

        ArrayList<String> fieldsToString = new ArrayList<>() {
            {
                add(stringName);
                add(stringEmployer);
                add(stringLocation);
                add(stringPositionType);
                add(stringCoreCompetency);
            }
        };

        for (int i = 0; i < fieldsToString.size(); i++) {
            if (fieldsToString.get(i).equals("")) {
                fieldsToString.set(i, noData);
            }
        }

        if (fieldsToString.get(0).equals(noData) && fieldsToString.get(1).equals(noData)
            && fieldsToString.get(2).equals(noData) && fieldsToString.get(3).equals(noData)
            && fieldsToString.get(4).equals(noData)) {
            return "\nOOPS! This job does not seem to exist.\n";
        } else {
            return
                "\nID: " + id +
                "\nName: " + fieldsToString.get(0) +
                "\nEmployer: " + fieldsToString.get(1) +
                "\nLocation: " + fieldsToString.get(2) +
                "\nPosition Type: " + fieldsToString.get(3) +
                "\nCore Competency: " + fieldsToString.get(4) + "\n";
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

}
