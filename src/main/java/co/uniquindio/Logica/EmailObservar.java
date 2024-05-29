package co.uniquindio.Logica;

public class EmailObservar implements Observador {
    private String emailDestino;

    public EmailObservar(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    @Override
    public void actualizar(String tipo, String mensaje) {
        enviarEmail(tipo, mensaje);
    }

    private void enviarEmail(String tipo, String mensaje) {

    }

}
