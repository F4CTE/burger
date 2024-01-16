package fr.esgi.burger.service.impl;

import fr.esgi.burger.business.Commande;
import fr.esgi.burger.service.CommandeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class CommandeServiceImpl implements CommandeService {

    private ArrayList<Commande> commandeRepository = new ArrayList<Commande>();


    @Override
    public Commande createCommande(Commande commande) {
        commandeRepository.add(commande);
        return commande;

    }

    @Override
    public Commande readCommande(int id) {
        for (Commande commande : commandeRepository) {
            if (commande.getId() == id) {
                return commande;
            }
        }
        return null;
    }

    @Override
    public void updateCommande(Commande commande) {
        for (int i = 0; i < commandeRepository.size(); i++) {
            if (Objects.equals(commandeRepository.get(i).getId(), commande.getId())) {
                commandeRepository.set(i, commande);
                break;
            }
        }

    }

    @Override
    public void deleteCommande(int id) {
        commandeRepository.removeIf(c -> c.getId() == id);

    }

    @Override
    public ObservableList<Commande> getAllCommande() {
        return FXCollections.observableArrayList(this.commandeRepository);
    }
}
