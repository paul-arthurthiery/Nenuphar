package com.nenuphar.nenufar.Models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="Skill")
public class Skill
{
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int nbrSubSkills;
    private Date recommendedWeek; //Semaine recommmandée

    @ManyToOne
    @JoinColumn(name = "course_ID")
    private Course courseID;



    public Skill()
    {

    }

    public Skill(String name, int nbrSkills, Date recommendedWeek)
    {
        this.name = name;
        this.nbrSubSkills = nbrSkills;
        this.recommendedWeek = recommendedWeek;
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

    public Date getRecommendedWeek()
    {
        return recommendedWeek;
    }

    public void setRecommendedWeek(Date recommendedWeek)
    {
        this.recommendedWeek = recommendedWeek;
    }

    public Course getCourseID() {
        return courseID;
    }

    public void setCourseID(Course courseID) {
        this.courseID = courseID;
    }
}
