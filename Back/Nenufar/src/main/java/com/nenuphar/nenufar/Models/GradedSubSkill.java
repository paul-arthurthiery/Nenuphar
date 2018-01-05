package com.nenuphar.nenufar.Models;

import javax.persistence.*;

@Entity
@Table(name="GradedSubSkill")
public class GradedSubSkill
{
    @Id
    @GeneratedValue
    private long id;

    private int level;

    @ManyToOne
    @JoinColumn(name="subskill_ID")
    private SubSkill subSkillID;

    @ManyToOne
    @JoinColumn(name="user_ID")
    private User userID; // (FOREIGN KEY)



    public GradedSubSkill()
    {

    }

    public GradedSubSkill(int level, SubSkill subSkillID, User userID)
    {
        this.level = level; // SET AS NULL BY DEFAULT IN DB ??
        this.subSkillID = subSkillID;
        this.userID = userID;
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

}
