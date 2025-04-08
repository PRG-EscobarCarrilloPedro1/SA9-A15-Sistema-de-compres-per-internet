/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa9.a15.sistema.de.compres.per.internet;

import java.util.Objects;
import java.util.Random;

public class StockProducte {
    private Producte producte;
    private int quantitatDisponible;

    public StockProducte(Producte producte) {
        this.producte = producte;
        this.quantitatDisponible = new Random().nextInt(10) + 1;
    }

    public Producte getProducte() {
        return producte;
    }

    public int getQuantitatDisponible() {
        return quantitatDisponible;
    }

    public void decrementarQuantitat() {
        if (quantitatDisponible > 0) {
            quantitatDisponible--;
        }
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.producte);
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
        final StockProducte other = (StockProducte) obj;
        return Objects.equals(this.producte, other.producte);
    }


    public void setStock(int stock) {
        this.quantitatDisponible = stock;
    }
}

