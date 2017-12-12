package com.nenuphar.nenufar.Models;

public class Course
{
    private int id;
    private String name;
    private int nbrSkills;

    public Course()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
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
