package fr.esgi.burger.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.esgi.burger.App;
import fr.esgi.burger.business.Commande;
import fr.esgi.burger.service.CommandeService;
import fr.esgi.burger.service.impl.CommandeServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class CommandesController implements Initializable {

    private final CommandeService commandeservice = new CommandeServiceImpl();

    @FXML
    private TableView<Commande> tableView = new TableView<Commande>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.setItems(commandeservice.getAllCommande());
    }


    public void redirectToCreation() throws IOException{
        App.setRoot("commande");
    }


}