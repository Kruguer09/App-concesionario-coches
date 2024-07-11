package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Coche implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;
    private String combustible;
    private int kilometros;
    private boolean vendido;
    private static ArrayList<Coche> listaCoches = new ArrayList<>();

    public Coche(String matricula, String marca, String modelo, String combustible, int kilometros, boolean vendido) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.combustible = combustible;
        this.kilometros = kilometros;
        this.vendido = vendido;
        listaCoches.add(this);
    }
    

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCombustible() {
        return combustible;
    }

    public int getKilometros() {
        return kilometros;
    }

    public boolean getVendido() {
        return vendido;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public String toString() {
        String sVendido = "";
        if (this.vendido == true) {
            sVendido = "Si";
        } else {
            sVendido = "No";
        }

        String salida = this.matricula + "@" + this.marca + "@" + this.modelo + "@" + this.combustible + "@" + String.valueOf(this.kilometros) + "@" + sVendido;
        return salida;
    }

}
