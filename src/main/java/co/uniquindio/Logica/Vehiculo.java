package co.uniquindio.Logica;

public abstract class Vehiculo {
    protected String tipo;
    protected double valor;
    protected String marca;
    protected String modelo;

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public abstract void start();

    public abstract void stop();
}
