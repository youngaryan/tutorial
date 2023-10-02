package com.ltp.gradesubmission;

import java.util.UUID;

public class Grades {
    private String name;
    private String subject;
    private String score;
    private String id;

    public Grades(String name, String subject, String score, String id) {
        this.name = name;
        this.subject = subject;
        this.score = score;
        this.id = id;
    }

    
    public Grades() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", subject='" + getSubject() + "'" +
            ", score='" + getScore() + "'" +
            "}";
    }

}
