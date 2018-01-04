package com.nenuphar.nenufar.Models;

import javax.persistence.*;


@Entity
@Table(name="Workgroup")
public class Workgroup
{
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int Size;

    public Workgroup()
    {

    }

    public Workgroup(String name, int size)
    {
        this.name = name;
        Size = size;
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
