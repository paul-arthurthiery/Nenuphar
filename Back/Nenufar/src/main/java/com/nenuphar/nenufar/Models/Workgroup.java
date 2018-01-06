package com.nenuphar.nenufar.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Workgroup")
public class Workgroup
{
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int Size;

    @ManyToOne
    @JoinColumn(name = "teacher_ID")
    private User teacherID;

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


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Workgroup_user",
            joinColumns = { @JoinColumn(name = "workgroup_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
