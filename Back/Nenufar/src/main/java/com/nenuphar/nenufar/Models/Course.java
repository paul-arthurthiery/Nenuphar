package com.nenuphar.nenufar.Models;

import javax.persistence.*;

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
}
