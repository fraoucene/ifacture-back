package com.ifacture.beans;


import com.ifacture.outils.Other;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_facture", schema = Other.DATEBASE_NAME)
public class Facture  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "avec_remise")
    private boolean avecRemise = Boolean.FALSE;

    @Column(name = "date_facturation")
    private Date dateFacturation;

    @Column(name = "delai_paiement")
    private Integer delaiPaiement;

    @Column(name = "devis")
    private String devis;

    @Column(name = "en_tete")
    private String enTete;

    @Column(name = "is_devis")
    private boolean isDevis = Boolean.FALSE;

    @Column(name = "langue")
    private String langue;

    @Column(name = "note")
    private String note;

    @Column(name = "remise")
    private Integer remise;

    @Column(name = "status")
    private String status;

    @Column(name = "type_facture")
    private String typeFacture;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_t_client")
    private Client client;

    public Facture(boolean avecRemise, Date dateFacturation, Integer delaiPaiement, String devis, String enTete,
                   boolean isDevis, String langue, String note, Integer remise, String status, String typeFacture,
                   Client client) {
        this.avecRemise = avecRemise;
        this.dateFacturation = dateFacturation;
        this.delaiPaiement = delaiPaiement;
        this.devis = devis;
        this.enTete = enTete;
        this.isDevis = isDevis;
        this.langue = langue;
        this.note = note;
        this.remise = remise;
        this.status = status;
        this.typeFacture = typeFacture;
        this.client = client;
    }

    public Facture() {

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvecRemise() {
        return avecRemise;
    }

    public void setAvecRemise(boolean avecRemise) {
        this.avecRemise = avecRemise;
    }

    public Date getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    public Integer getDelaiPaiement() {
        return delaiPaiement;
    }

    public void setDelaiPaiement(Integer delaiPaiement) {
        this.delaiPaiement = delaiPaiement;
    }

    public String getDevis() {
        return devis;
    }

    public void setDevis(String devis) {
        this.devis = devis;
    }

    public String getEnTete() {
        return enTete;
    }

    public void setEnTete(String enTete) {
        this.enTete = enTete;
    }

    public boolean isDevis() {
        return isDevis;
    }

    public void setDevis(boolean devis) {
        isDevis = devis;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getRemise() {
        return remise;
    }

    public void setRemise(Integer remise) {
        this.remise = remise;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeFacture() {
        return typeFacture;
    }

    public void setTypeFacture(String typeFacture) {
        this.typeFacture = typeFacture;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", avecRemise=" + avecRemise +
                ", dateFacturation=" + dateFacturation +
                ", delaiPaiement=" + delaiPaiement +
                ", devis='" + devis + '\'' +
                ", enTete='" + enTete + '\'' +
                ", isDevis=" + isDevis +
                ", langue='" + langue + '\'' +
                ", note='" + note + '\'' +
                ", remise=" + remise +
                ", status='" + status + '\'' +
                ", typeFacture='" + typeFacture + '\'' +
                '}';
    }
}
