package com.nenuphar.nenufar.Models;

import javax.persistence.*;


@Entity
@Table(name="SubSkill")
public class SubSkill
{
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int grade;

    public SubSkill()
    {

    }

    public SubSkill(String name, int grade)
    {
        this.name = name;
        this.grade = grade;
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

    public int getGrade()
    {
        return grade;
    }

    public void setGrade(int grade)
    {
        this.grade = grade;
    }

}
