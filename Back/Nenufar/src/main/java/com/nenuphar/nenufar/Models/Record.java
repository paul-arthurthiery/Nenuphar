package com.nenuphar.nenufar.Models;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Record")
public class Record
{
    @Id
    @GeneratedValue
    private long id;

    private int nbrCourses;
    private Date deadlines;
    private long course;



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

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Record_User",
            joinColumns = { @JoinColumn(name = "record_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public long getCourse() { return course; }

    public void setCourse(long course) { this.course = course; }
}
