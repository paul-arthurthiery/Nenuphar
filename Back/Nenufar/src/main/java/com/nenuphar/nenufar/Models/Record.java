package com.nenuphar.nenufar.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Record")
public class Record
{
    @Id
    @GeneratedValue
    private long id;

    private int nbrCourses;
    private Date deadlines;

    public Record()
    {

    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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
