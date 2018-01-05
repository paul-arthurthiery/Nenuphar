package com.nenuphar.nenufar.Models;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "course_ID")
    private Course courseID;

    public Record()
    {

    }

    public Record(int nbrCourses, Date deadlines)
    {
        this.nbrCourses = nbrCourses;
        this.deadlines = deadlines;
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

    public Course getCourseID() {
        return courseID;
    }

    public void setCourseID(Course courseID) {
        this.courseID = courseID;
    }

}
