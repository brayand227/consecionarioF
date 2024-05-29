package co.uniquindio.co;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.Logica.Cliente;
import co.uniquindio.Logica.Consecionario;
import co.uniquindio.Logica.User;
import co.uniquindio.Logica.Vehiculo;
import co.uniquindio.Logica.VehiculoFactory;
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

public class CompraUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField Password;

    @FXML
    private Button btSesion;

    @FXML
    private Button btVolver;

    @FXML
    private TextField txUser;
    private String user;
    private User usuario;
    private String contraseña;
    String marca;
    String modelo;
    String precio;

    @FXML
    void Iniciar(ActionEvent event) throws IOException {

        Controller controller = Controller.getController();
        marca = controller.getMarca();
        modelo = controller.getModelo();
        precio = controller.getPrecio();
        Double pre = Double.parseDouble(precio);

        user = txUser.getText();
        contraseña = Password.getText();
        usuario = new User(user, contraseña);
        if (Consecionario.getClientes() == null) {
            RegistrarseController.Imprimir("ERROR", "EL USUARIO NO SE HA REGISTRADO");
        } else {
            if (Consecionario.validarUser(usuario)) {
                Cliente cliente = Consecionario.buscarCliente(usuario);
                VehiculoFactory vehiculoFactory = new VehiculoFactory();
                Vehiculo vehiculo = vehiculoFactory.crearVehiculoBuilder("camioneta")
                        .Marca(marca)
                        .Modelo(modelo)
                        .Valor(pre)
                        .build();
                cliente.AgregarvVehiculo(vehiculo);
                cliente.getVehiculoBuilders().size();
            } else {
                RegistrarseController.Imprimir("ERROR", "EL USUARIO NO SE HA REGISTRADO");
            }
        }

    }

    @FXML
    void Volver(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    void initialize() {

    }

}
