package com.nenuphar.nenufar.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="GradedSubSkill")
public class GradedSubSkill
{
    @Id
    @GeneratedValue
    private long id;
    private int level;
    private Date date;
    private long subskill, user;

    @ManyToOne
    @JoinColumn(name="subskill_ID")
    private SubSkill subSkillID;

    @ManyToOne
    @JoinColumn(name="user_ID")
    private User userID; // (FOREIGN KEY)



    public GradedSubSkill()
    {

    }

    public GradedSubSkill(int level, SubSkill subSkillID, User userID, Date date)
    {
        this.level = level; // SET AS NULL BY DEFAULT IN DB ??
        this.subSkillID = subSkillID;
        this.userID = userID;
        this.date = date;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public SubSkill getSubSkillID() {
        return subSkillID;
    }

    public void setSubSkillID(SubSkill subSkillID) {
        this.subSkillID = subSkillID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public long getSubskill() { return subskill; }

    public void setSubskill(long subskill) { this.subskill = subskill; }

    public long getUser() { return user; }

    public void setUser(long user) { this.user = user; }
}
