package com.nenuphar.nenufar.Models;

public class Enseignant
{
    private int id;
    private String name;
    private String last_name;
    private String email;
    private String login;
    private String password;
    private String matiere;
    private boolean istuteur;
    private boolean isrespoapp;
    private boolean isadmin;

    public Enseignant()
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

    public String getLast_name()
    {
        return last_name;
    }

    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getMatiere()
    {
        return matiere;
    }

    public void setMatiere(String matiere)
    {
        this.matiere = matiere;
    }

    public boolean isIstuteur()
    {
        return istuteur;
    }

    public void setIstuteur(boolean istuteur)
    {
        this.istuteur = istuteur;
    }

    public boolean isIsrespoapp()
    {
        return isrespoapp;
    }

    public void setIsrespoapp(boolean isrespoapp)
    {
        this.isrespoapp = isrespoapp;
    }

    public boolean isIsadmin()
    {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin)
    {
        this.isadmin = isadmin;
    }
}
