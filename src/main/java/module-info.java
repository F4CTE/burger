module fr.esgi {
    requires javafx.controls;
    requires javafx.fxml;

    exports fr.esgi.burger;
    opens fr.esgi.burger to javafx.fxml;
    exports fr.esgi.burger.controller;
    opens fr.esgi.burger.controller to javafx.fxml;
}
