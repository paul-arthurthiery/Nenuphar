package com.nenuphar.nenufar.Models;

public class Skill
{
    private int id;
    private String name;
    private int nbrSubSkills;
    private int recommendedWeek; //Semaine recommmandée


    public Skill()
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
