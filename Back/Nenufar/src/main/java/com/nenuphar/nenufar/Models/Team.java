package com.nenuphar.nenufar.Models;

import javax.persistence.*;


@Entity
@Table(name="Team")
public class Team
{
    @Id
    @GeneratedValue
    private long id;

    private int size;
    private String name;

    @ManyToOne
    @JoinColumn(name = "workgroup_ID")
    private Workgroup workgroupID;

    public Team()
    {

    }

    public Team(int size, String name)
    {
        this.size = size;
        this.name = name;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Workgroup getWorkgroupID() {
        return workgroupID;
    }

    public void setWorkgroupID(Workgroup workgroupID) {
        this.workgroupID = workgroupID;
    }
}
