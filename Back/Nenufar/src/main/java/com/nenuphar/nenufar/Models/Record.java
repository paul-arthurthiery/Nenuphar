package com.nenuphar.nenufar.Models;

import java.util.Date;

public class Record
{
    private int id;
    private int nbrCourses;
    private Date deadlines;

    public Record()
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

    public int getNbrCourses()
    {
        return nbrCourses;
    }

    public void setNbrCourses(int nbrCourses)
    {
        this.nbrCourses = nbrCourses;
    }

    public Date getDeadlines()
    {
        return deadlines;
    }

    public void setDeadlines(Date deadline)
    {
        this.deadlines = deadline;
    }
}
