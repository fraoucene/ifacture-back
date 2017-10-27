package com.ifacture.beans;

import com.ifacture.outils.Other;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_produit_facture", schema = Other.DATEBASE_NAME)
public class ProduitFacture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "quantite")
    private double quantite;

    @Column(name = "prix")
    private double prix;

    @Column(name = "tarif")
    private String tarif;

   @Column(name = "unite")
    private String unite;

   @Column(name = "tva")
    private double tva;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_facture_t_facture")
    private Facture facture;

    public ProduitFacture() {
    }

    public ProduitFacture(String nom, String description, Date date, double quantite, double prix, String tarif, String unite, double tva, Facture facture) {
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.quantite = quantite;
        this.prix = prix;
        this.tarif = tarif;
        this.unite = unite;
        this.tva = tva;
        this.facture = facture;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
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

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    @Override
    public String toString() {
        return "ProduitFacture{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", quantite=" + quantite +
                ", prix=" + prix +
                ", tarif='" + tarif + '\'' +
                ", unite='" + unite + '\'' +
                ", tva=" + tva +
                ", facture=" + facture +
                '}';
    }
}
