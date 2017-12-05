package com.nenuphar.nenufar.Models;

public class Competence
{
    private int id;
    private String nom;
    private int nbr_sous_competences;
    private int semaine_reco; //Semaine recommmandée


    public Competence()
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

    public int getNbr_sous_competences()
    {
        return nbr_sous_competences;
    }

    public void setNbr_sous_competences(int nbr_sous_competences)
    {
        this.nbr_sous_competences = nbr_sous_competences;
    }

    public int getSemaine_reco()
    {
        return semaine_reco;
    }

    public void setSemaine_reco(int semaine_reco)
    {
        this.semaine_reco = semaine_reco;
    }
}
