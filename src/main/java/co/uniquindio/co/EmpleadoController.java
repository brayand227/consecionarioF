package co.uniquindio.co;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.Logica.Consecionario;
import co.uniquindio.Logica.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmpleadoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtRegistrarse;
    @FXML
    private TextField TxId;
    @FXML
    private PasswordField Password;

    @FXML
    private Button btRegistrarse;

    @FXML
    private Button btVolver;

    @FXML
    void registrarse(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("empleadoRegistro.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("REGISTRO DE EMPLEADO");

        stage.show();
    }

    @FXML
    void siguiente(ActionEvent event) throws IOException {
        String user = TxId.getText();
        String passwor = Password.getText();
        User usuario = new User(user, passwor);
        if (Consecionario.getEmpleados() == null) {
            RegistrarseController.Imprimir("ERROR", "USUARIO NULO");

        } else if (Consecionario.validarUserEmpleado(usuario)) {
            Parent root = FXMLLoader.load(getClass().getResource("empleadoVenta.fxml"));
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.setTitle("Menu");

            stage.show();
        } else {
            RegistrarseController.Imprimir("ERROR", "USUARIO NO VALIDO" + "usuario"
                    + Consecionario.getEmpleados().get(0).getUser().getUsuario() + " contraseña :"
                    + Consecionario.getEmpleados().get(0).getUser().getContraseña());

        }

    }

    @FXML
    void volver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("principalVentana.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("Menu");

        stage.show();

    }

    @FXML
    void initialize() {

    }

}
