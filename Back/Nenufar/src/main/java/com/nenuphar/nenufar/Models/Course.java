package com.nenuphar.nenufar.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Course")
public class Course
{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int nbrSkills;


    public Course()
    {

    }

    public Course(String name, int nbrSkills)
    {
        this.name = name;
        this.nbrSkills = nbrSkills;
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

    public int getNbrSkills()
    {
        return nbrSkills;
    }

    public void setNbrSkills(int nbrSkills)
    {
        this.nbrSkills = nbrSkills;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Course_user",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
