package co.uniquindio.Logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Consecionario {

    private static Consecionario consecionario;
    private static ArrayList<Cliente> clientes;
    private static Map<String, Administrador> administradores;
    private static ArrayList<Empleado> empleados;

    private Consecionario() {
        clientes = new ArrayList<>();
        administradores = new HashMap<>();
        empleados = new ArrayList<>();
    }

    public static synchronized Consecionario getConsecionario() {
        if (consecionario == null) {
            consecionario = new Consecionario();

        }

        return consecionario;
    }

    public static ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static Map<String, Administrador> getAdministradores() {
        return administradores;
    }

    // METODOS CRUD DE CLIENTE
    public static void agregarCliente(String nombre, String apellido, LocalDate date, String id, User user) {
        Cliente cliente = Cliente.builder().Apellido(apellido).Date(date).Id(id).nombre(nombre).user(user).build();
        if (validarCliente(cliente) == false) {
            clientes.add(cliente);
        }

    }

    // metodo para validar un usuario
    public static boolean validarUser(User user) {
        boolean centinela = false;
        for (int i = 0; i < clientes.size() || centinela == false; i++) {

            Cliente cliente = clientes.get(i);
            if (cliente.getUser().getUsuario().equals(user.getUsuario())
                    && cliente.getUser().getContraseña().equals(user.getContraseña())) {
                centinela = true;
            }
        }
        return centinela;
    }

    public static void eliminarCliente(int id) {
        clientes.remove(clientes.get(id));
    }

    public void actualizarCliente(int id, String nombre, String apellido, LocalDate date) {
        Cliente cliente = clientes.get(id);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDate(date);
    }

    public void leerCliente(int id) {
        Cliente cliente = clientes.get(id);
        System.out.println(cliente.toString());
    }

    // METODOS CRUD DE EMPLEADO
    public static void agregarEmpleado(String nombre, String apellido, LocalDate date, String id, User user) {
        Empleado empleado = Empleado.builder().apellido(apellido).date(date).id(id).nombre(nombre).user(user).build();
        if (!validarUserEmpleado(user)) {
            empleados.add(empleado);
        }

    }

    public static Cliente buscarCliente(User user) {
        Cliente cliente = null;
        for (Cliente cliente2 : clientes) {
            if (cliente2.getUser().getUsuario().equals(user.getUsuario())
                    && cliente2.getUser().getContraseña().equals(user.getContraseña())) {
                cliente = cliente2;

            }

        }
        return cliente;
    }

    public void eliminarEmpleado(int id) {
        empleados.remove(empleados.get(id));
    }

    // METODOS CRUD DE ADMINISTRADOR
    public void agergarAdmin(String nombre, String apellido, LocalDate date, String id) {
        Administrador administrador = Administrador.builder().apellido(apellido).date(date).id(id).nombre(nombre)
                .build();
        if (administradores.size() == 0) {
            administradores.put(id, administrador);
        }

    }

    public void eliminarAdmin(String id) {
        administradores.remove(administradores.get(id));
    }

    public void actualizarAdmin(String id, String nombre, String apellido, LocalDate date) {
        Administrador administrador = administradores.get(id);
        administrador.setNombre(nombre);
        administrador.setApellido(apellido);
        administrador.setDate(date);
    }

    public void leerAdmin(String id) {
        Administrador administrador = administradores.get(id);
        System.out.println(administrador.toString());
    }

    // metodo para validar si un cliente ya esta registrado
    public static boolean validarCliente(Cliente cliente) {
        boolean centinela = false;
        if (clientes.contains(cliente)) {
            centinela = true;
        }
        return centinela;
    }

    public static boolean ValidarEmpleado(Empleado empleado) {
        boolean centinela = false;
        if (empleados.contains(empleado)) {
            centinela = true;
        }

        return centinela;

    }

    public static boolean validarUserEmpleado(User user) {
        boolean centinela = false;
        for (int i = 0; i < empleados.size() && centinela == false; i++) {

            Empleado empleado = empleados.get(i);
            if (empleado.getUser().getUsuario().equals(user.getUsuario())
                    && empleado.getUser().getContraseña().equals(user.getContraseña())) {
                centinela = true;
            }
        }
        return centinela;
    }
}
