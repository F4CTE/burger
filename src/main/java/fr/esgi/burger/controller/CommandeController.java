package fr.esgi.burger.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.esgi.burger.App;
import fr.esgi.burger.business.Commande;
import fr.esgi.burger.service.CommandeService;
import fr.esgi.burger.service.impl.CommandeServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.*;


public class CommandeController implements Initializable {

    private final CommandeService commandeService = new CommandeServiceImpl();


    ObservableList<String> burgers = FXCollections.observableArrayList("CLELIA Burger", "Polenta Burger",
            "Rice Burger");

    ObservableList<String> accompagnements = FXCollections.observableArrayList("Frites", "Salade",
            "Onion Rings");

    ObservableList<String> boissons = FXCollections.observableArrayList("Badoit", "Coca-Cola",
            "Pepsi Cola", "Tropico");


    @FXML
    private RadioButton surPlace;
    @FXML
    private RadioButton aEmporter;
    @FXML
    private ToggleGroup commandeType;
    @FXML
    private TextArea remarques;
    @FXML
    private CheckBox samourai;
    @FXML
    private CheckBox ketchup;
    @FXML
    private CheckBox mayonnaise;
    @FXML
    private ComboBox<String> listBurgers;
    @FXML
    private ComboBox<String> listAccompagnements;
    @FXML
    private ComboBox<String> listBoissons;



    // @Override est une annotation Java
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listBurgers.setValue("Choisissez votre burger");
        listBurgers.setItems(burgers);

        listAccompagnements.setValue("Choisissez votre accompagnement");
        listAccompagnements.setItems(accompagnements);

        listBoissons.setValue("Choisissez votre boisson");
        listBoissons.setItems(boissons);


    }




    public void submitCommande(ActionEvent actionEvent) throws IOException {
        Commande commande = new Commande();
        commande.setAccompagnement(listAccompagnements.getValue());
        commande.setEmporter(commandeType.getSelectedToggle().equals(aEmporter));
        commande.setBurger(listBurgers.getValue());
        commande.setBoisson(listBoissons.getValue());
        commande.setRemarque(remarques.getText());
        ArrayList<String> sauces = new ArrayList<>();
        if (samourai.isSelected()) {
            sauces.add("samourai");
        }
        if (ketchup.isSelected()) {
            sauces.add("ketchup");
        }
        if (mayonnaise.isSelected()) {
            sauces.add("mayonnaise");
        }
        commande.setSauce(sauces);
        this.commandeService.createCommande(commande);
        this.retrunToCommandeList();
    }

    public void retrunToCommandeList  ()  throws IOException {
        App.setRoot("listeDesCommandes");
    }

}
