package fr.esgi.burger.service;

import fr.esgi.burger.business.Commande;
import javafx.collections.ObservableList;

public interface CommandeService {

    Commande createCommande(Commande commande);

    Commande readCommande(int id);

    void updateCommande(Commande commande);

    void deleteCommande(int id);

    ObservableList<Commande> getAllCommande ();

}