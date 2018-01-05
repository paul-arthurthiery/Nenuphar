package com.nenuphar.nenufar.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GradedSubSkill")
public class GradedSubSkill
{
    @Id
    @GeneratedValue
    private long id;

    private int level;
    private int subskill_id; // (FOREIGN KEY)
    private int user_id; // (FOREIGN KEY)

    public GradedSubSkill()
    {

    }

    public GradedSubSkill(int level, int subskill_id, int user_id)
    {
        this.level = level; // SET AS NULL BY DEFAULT IN DB ??
        this.subskill_id = subskill_id;
        this.user_id = user_id;
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

    public int getSubskill_id()
    {
        return subskill_id;
    }

    public void setSubskill_id(int subskill_id)
    {
        this.subskill_id = subskill_id;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }
}
