package co.uniquindio.co;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EmpleadoVentaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtVenta;

    @FXML
    private Button BtVolver;

    @FXML
    private Button btSiguiente;

    @FXML
    void siguiente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menuUser.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("EMPLEADO");

        stage.show();

    }

    @FXML
    void venta(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("venta.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("EMPLEADO");

        stage.show();

    }

    @FXML
    void volver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("principalVentana.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("EMPLEADO");

        stage.show();
    }

    @FXML
    void initialize() {

    }

}
