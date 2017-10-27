package com.ifacture.beans;

import com.ifacture.outils.Other;

import javax.persistence.*;

@Entity
@Table(name = "t_client", schema = Other.DATEBASE_NAME)
public class Client {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_entreprise")
    private String nomEntreprise;

    @Column(name = "siret")
    private String siret;

    @Column(name = "num_tva")
    private String numTva;

    @Column(name = "titre")
    private String titre;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom_f")
    private String nomF;

    @Column(name = "email")
    private String email;

    @Column(name = "tele_fixe")
    private String teleFixe;

    @Column(name = "tele_port")
    private String telePort;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "code_postale")
    private Integer codePostale;

    @Column(name = "complement_adresse")
    private String complementAdresse;

    @Column(name = "ville")
    private String ville;

    @Column(name = "pays")
    private String pays;

    @Column(name = "langue_facture")
    private String langueFacture;

    @Column(name = "delai_paiement")
    private Integer delaiPaiement;

    @Column(name = "tva")
    private Double tva;

    @Column(name = "is_particulier")
    private boolean isParticulier;

    public Client() {
    }

    public Client(String nomEntreprise, String siret, String numTva, String titre, String prenom,
                  String nomF, String email, String teleFixe, String telePort, String adresse, Integer codePostale,
                  String complementAdresse, String ville, String pays, String langueFacture, Integer delaiPaiement,
                  Double tva, boolean isParticulier) {
        this.nomEntreprise = nomEntreprise;
        this.siret = siret;
        this.numTva = numTva;
        this.titre = titre;
        this.prenom = prenom;
        this.nomF = nomF;
        this.email = email;
        this.teleFixe = teleFixe;
        this.telePort = telePort;
        this.adresse = adresse;
        this.codePostale = codePostale;
        this.complementAdresse = complementAdresse;
        this.ville = ville;
        this.pays = pays;
        this.langueFacture = langueFacture;
        this.delaiPaiement = delaiPaiement;
        this.tva = tva;
        this.isParticulier = isParticulier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getNumTva() {
        return numTva;
    }

    public void setNumTva(String numTva) {
        this.numTva = numTva;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomF() {
        return nomF;
    }

    public void setNomF(String nomF) {
        this.nomF = nomF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeleFixe() {
        return teleFixe;
    }

    public void setTeleFixe(String teleFixe) {
        this.teleFixe = teleFixe;
    }

    public String getTelePort() {
        return telePort;
    }

    public void setTelePort(String telePort) {
        this.telePort = telePort;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(Integer codePostale) {
        this.codePostale = codePostale;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getLangueFacture() {
        return langueFacture;
    }

    public void setLangueFacture(String langueFacture) {
        this.langueFacture = langueFacture;
    }

    public Integer getDelaiPaiement() {
        return delaiPaiement;
    }

    public void setDelaiPaiement(Integer delaiPaiement) {
        this.delaiPaiement = delaiPaiement;
    }

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public boolean isParticulier() {
        return isParticulier;
    }

    public void setParticulier(boolean particulier) {
        isParticulier = particulier;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nomEntreprise='" + nomEntreprise + '\'' +
                ", siret='" + siret + '\'' +
                ", numTva='" + numTva + '\'' +
                ", titre='" + titre + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nomF='" + nomF + '\'' +
                ", email='" + email + '\'' +
                ", teleFixe='" + teleFixe + '\'' +
                ", telePort='" + telePort + '\'' +
                ", adresse='" + adresse + '\'' +
                ", codePostale=" + codePostale +
                ", complementAdresse='" + complementAdresse + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                ", langueFacture='" + langueFacture + '\'' +
                ", delaiPaiement=" + delaiPaiement +
                ", tva=" + tva +
                ", isParticulier=" + isParticulier +
                '}';
    }
}
