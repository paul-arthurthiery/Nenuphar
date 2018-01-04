package com.nenuphar.nenufar.Models;

import javax.persistence.*;


@Entity
@Table(name="Skill")
public class Skill
{
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int nbrSubSkills;
    private int recommendedWeek; //Semaine recommmandée


    public Skill()
    {

    }

    public Skill(String name, int nbrSkills, int recommendedWeek)
    {
        this.name = name;
        this.nbrSubSkills = nbrSkills;
        this. recommendedWeek = recommendedWeek;
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

    public int getNbrSubSkills()
    {
        return nbrSubSkills;
    }

    public void setNbrSubSkills(int nbrSubSkills)
    {
        this.nbrSubSkills = nbrSubSkills;
    }

    public int getRecommendedWeek()
    {
        return recommendedWeek;
    }

    public void setRecommendedWeek(int recommendedWeek)
    {
        this.recommendedWeek = recommendedWeek;
    }
}
