package com.ifacture.beans;

import com.ifacture.outils.Other;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_produit", schema = Other.DATEBASE_NAME)
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "prix")
    private Float prix;

    @Column(name = "tarif")
    private String tarif;

   @Column(name = "unite")
    private String unite;

   @Column(name = "tva")
    private Float tva;

    public Produit() {
    }

    public Produit(String nom, String description, Float prix, String tarif, String unite, Float tva) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.tarif = tarif;
        this.unite = unite;
        this.tva = tva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Float getTva() {
        return tva;
    }

    public void setTva(Float tva) {
        this.tva = tva;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", tarif='" + tarif + '\'' +
                ", unite='" + unite + '\'' +
                ", tva=" + tva +
                '}';
    }
}
