package ru.netology.domain;

import java.util.Collections;
import java.util.Set;

public class Issue<label, assignee> {
    private int id;
    private String name;
    private boolean close;
    private String author;
    private Set<String> label;
    private String project;
    private Set<String> milestone;
    private String assignee;
    private Set<String> tag;


    public Issue() {

    }


    public Issue(int id, String name, boolean close, String author, Set<String> label, String project, Set<String> milestone, String assignee, Set<String> tag) {
        this.id = id;
        this.name = name;
        this.close = close;
        this.author = author;
        this.label = label;
        this.project = project;
        this.milestone = milestone;
        this.assignee = assignee;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        this.close = close;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<String> getLabel() {
        return label;
    }

    public void setLabel(Set<String> label) {
        this.label = label;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Set<String> getMilestone() {
        return milestone;
    }

    public void setMilestone(Set<String> milestone) {
        this.milestone = milestone;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Set<String> getTag() {
        return tag;
    }

    public void setTag(Set<String> tag) {
        this.tag = tag;
    }


}
