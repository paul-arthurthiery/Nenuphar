package com.nenuphar.nenufar.Models;

public class Matiere
{
    private int id;
    private String nom;
    private int nbr_competences;

    public Matiere()
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

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public int getNbr_competences()
    {
        return nbr_competences;
    }

    public void setNbr_competences(int nbr_competences)
    {
        this.nbr_competences = nbr_competences;
    }
}
