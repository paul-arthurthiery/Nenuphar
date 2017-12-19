package com.nenuphar.nenufar.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Group")
public class Group
{
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int Size;

    public Group()
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getSize()
    {
        return Size;
    }

    public void setSize(int size)
    {
        this.Size = size;
    }
}
