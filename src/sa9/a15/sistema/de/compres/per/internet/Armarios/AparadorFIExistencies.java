package sa9.a15.sistema.de.compres.per.internet.Armarios;

import sa9.a15.sistema.de.compres.per.internet.Marcas;
import sa9.a15.sistema.de.compres.per.internet.Producte;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author batoi
 */
public class AparadorFIExistencies extends Aparador{
    
    private boolean estaCerrado;
    
    public AparadorFIExistencies(String nom, Marcas marca, Producte... productes) {
        super(nom, marca, productes);
        this.estaCerrado = false;
    }

    @Override
    public boolean estaObert() {
        return !estaCerrado && !productesEnStock().isEmpty();
    }
    
    public void tancarAparador(){
        this.estaCerrado = true;
    }

    public boolean isEstaTancat() {
        return estaCerrado;
    }
    
    
    
}
