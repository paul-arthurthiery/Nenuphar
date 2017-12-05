package com.nenuphar.nenufar.Models;

public class Groupe
{
    private int id;
    private String name;
    private int taille;

    public Groupe()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
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

    public int getTaille()
    {
        return taille;
    }

    public void setTaille(int taille)
    {
        this.taille = taille;
    }
}
