package com.ifacture.outils;

import com.ifacture.beans.Client;
import com.ifacture.beans.Facture;
import com.ifacture.beans.ProduitFacture;

import java.util.Date;

public class Other {
    public static final String DATEBASE_NAME = "ifacture";

    private Other() {
        super();
    }

    public static Facture mockFrature() {
        Facture facture = new Facture();
        facture.setDevis(false);
        facture.setDateFacturation(new Date());
        facture.setNote("paiement par virsement bancaire");
        facture.setStatus("cree");
        facture.setEnTete("Facture N° ");
        facture.setRemise(0);
        facture.setAvecRemise(false);
        facture.setLangue("Francais");
        facture.setTypeFacture("facture");
        facture.setDelaiPaiement(20);
        facture.setClient(mockClient());
        return facture;
    }

    public static ProduitFacture mockProduitFrature() {
        ProduitFacture produitFacture = new ProduitFacture();
        produitFacture.setDate(new Date());
        produitFacture.setQuantite(20.2);
        produitFacture.setNom("DEV JAVA");
        produitFacture.setPrix(450.5);
        produitFacture.setTarif("ht");
        produitFacture.setTva(20.5);
        produitFacture.setUnite("j");
        produitFacture.setFacture(mockFrature());
        return produitFacture;

    }

    public static Client mockClient() {
        Client client = new Client();
        return client;
    }
}
