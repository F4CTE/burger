package fr.esgi.burger.business;

import java.util.ArrayList;
import java.util.Objects;
public class Commande {
    private Long id;
    static Long compteur = 0L;
    private boolean emporter;
    private String burger;
    private String accompagnement;
    private String boisson;
    private String remarque;
    private ArrayList<String> sauces = new ArrayList<>();

    public Commande() {
        this.id = ++compteur;
    }
    public Commande( boolean emporter, String burger, String accompagnement, String boisson, String remarque,ArrayList<String> sauce) {
        this();
        this.emporter = emporter;
        this.burger = burger;
        this.accompagnement = accompagnement;
        this.boisson = boisson;
        this.remarque = remarque;
        this.sauces = sauce;
    }
    // Getters en setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEmporter() {
        return emporter;
    }
    public void setEmporter(boolean emporter) {
        this.emporter = emporter;
    }

    public String getBurger() {
        return burger;
    }

    public void setBurger(String burger) {
        this.burger = burger;
    }

    public String getAccompagnement() {
        return accompagnement;
    }

    public void setAccompagnement(String accompagnement) {
        this.accompagnement = accompagnement;
    }

    public String getBoisson() {
        return boisson;
    }

    public void setBoisson(String boisson) {
        this.boisson = boisson;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public ArrayList<String> getSauce() {
        return sauces;
    }

    public void setSauce(ArrayList<String> sauce) {
        this.sauces = sauce;
    }

    @Override
    public String toString() {
        return "Commande [id=" + id + ", emporter=" + emporter + ", burger=" + burger + ", accompagnement="
                + accompagnement + ", boisson=" + boisson + ", remarque=" + remarque + ", sauce=" + sauces + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(accompagnement, boisson, burger, emporter, id, remarque, sauces);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Commande other = (Commande) obj;
        return Objects.equals(accompagnement, other.accompagnement) && Objects.equals(boisson, other.boisson)
                && Objects.equals(burger, other.burger) && emporter == other.emporter && Objects.equals(id, other.id)
                && Objects.equals(remarque, other.remarque) && Objects.equals(sauces, other.sauces);
    }

}