/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa9.a15.sistema.de.compres.per.internet;

import java.util.Objects;

/**
 *
 * @author pedro
 */
public class Producte implements Comparable<Producte>{
    private String identificador;
    private double preu;
    private Marcas marca;


    public Producte(String identificador, double preu, Marcas marca) {
        assert preu > 0 : "No se puede crear un producto con precio negativo"; 
        this.identificador = identificador;
        this.preu = preu;
        this.marca = marca;
    }

    public String getId() {
        return identificador;
    }

    public double getPreu() {
        return preu;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.identificador);
        hash = 53 * hash + Objects.hashCode(this.marca);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producte other = (Producte) obj;
        if (!Objects.equals(this.identificador, other.identificador)) {
            return false;
        }
        return this.marca == other.marca;
    }

    @Override
    public int compareTo(Producte altre) {
        return this.identificador.compareToIgnoreCase(altre.identificador);
    }

    @Override
    public String toString() {
        return "Producte: \n" 
                + identificador + ", " + preu
                + "€, " + marca;
    }
    }
    
    
