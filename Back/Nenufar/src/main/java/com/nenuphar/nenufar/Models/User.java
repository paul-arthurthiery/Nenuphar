package com.nenuphar.nenufar.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="User")
public class User
{
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private boolean isRespoAPP;
    private boolean isAdmin;
    private boolean isTutor;
    private boolean isStudent;

    public User()
    {

    }

    public User(String name, String lastName, String email, String login, String password, boolean isRespoAPP, boolean isAdmin, boolean isTutor, boolean isStudent) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.isRespoAPP = isRespoAPP;
        this.isAdmin = isAdmin;
        this.isTutor = isTutor;
        this.isStudent = isStudent;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isRespoAPP() {
        return isRespoAPP;
    }

    public void setRespoAPP(boolean respoAPP) {
        isRespoAPP = respoAPP;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isTutor() {
        return isTutor;
    }

    public void setTutor(boolean tutor) {
        isTutor = tutor;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    @ManyToMany(mappedBy = "users")
    private Set<Record> records = new HashSet<>();

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }


    @ManyToMany(mappedBy = "users")
    private Set<Workgroup> workgroups = new HashSet<>();

    public Set<Workgroup> getWorkgroups() {
        return workgroups;
    }

    public void setWorkgroups(Set<Workgroup> workgroups) {
        this.workgroups = workgroups;
    }

    @ManyToMany(mappedBy = "users")
    private Set<Team> teams = new HashSet<>();

    public Set<Team> getTeams()
    {
        return teams;
    }

    public void setTeams(Set<Team> teams)
    {
        this.teams = teams;
    }
// standard constructors/getters/setters
}
