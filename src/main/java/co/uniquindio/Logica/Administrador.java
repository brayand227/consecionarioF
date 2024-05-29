package co.uniquindio.Logica;

import java.time.LocalDate;

public class Administrador extends Persona implements PersonaComponent {
    private String id;

    public Administrador(String nombre, String apellido, LocalDate date, User user, String id) {
        super(nombre, apellido, date, user);

        this.id = id;

    }

    public static AdministradorBuilder builder() {
        return new AdministradorBuilder();

    }

    public String getId() {
        return id;
    }

    public void agregarEmpleado(Empleado empleado) {

        Consecionario.getEmpleados().add(empleado);

    }

    public void removerEmploye(PersonaComponent componente) {
        Consecionario.getEmpleados().remove(componente);

    }

    @Override
    public void mostrarDetalles() {

        System.out.println("Administrador: " + getNombre() + " " + getApellido());
        for (Empleado componente : Consecionario.getEmpleados()) {
            componente.mostrarDetalles();
        }

    }

}
