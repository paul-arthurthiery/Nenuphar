package com.nenuphar.nenufar.Models;

import java.util.Date;

public class Fiche
{
    private int id;
    private int nbr_matieres;
    private Date date_butoire;

    public Fiche()
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

    public int getNbr_matieres()
    {
        return nbr_matieres;
    }

    public void setNbr_matieres(int nbr_matieres)
    {
        this.nbr_matieres = nbr_matieres;
    }

    public Date getDate_butoire()
    {
        return date_butoire;
    }

    public void setDate_butoire(Date date_butoire)
    {
        this.date_butoire = date_butoire;
    }
}
