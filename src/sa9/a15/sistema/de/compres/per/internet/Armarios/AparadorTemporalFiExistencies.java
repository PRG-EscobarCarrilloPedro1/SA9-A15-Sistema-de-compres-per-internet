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
public class AparadorTemporalFiExistencies extends Aparador{
    
    private long fechaCreado;
    private int diasMaximos;
    
    public AparadorTemporalFiExistencies(String nom, Marcas marca, Producte... productes) {
        super(nom, marca, productes);
        this.fechaCreado = System.currentTimeMillis();
        this.diasMaximos = 3;
    }

    @Override
    public boolean estaObert() {
        long tempsActual = System.currentTimeMillis();
        long tempsPassat = tempsActual - fechaCreado;
        long milisegons = diasMaximos * 86400 * 1000;
        
        return tempsPassat < milisegons && !productesEnStock().isEmpty();
    }
    
    public int diesRestants() {
        long tempsActual = System.currentTimeMillis();
        long tempsPassat = tempsActual - fechaCreado;
        long milisegons = (diasMaximos * 86400L * 1000) - tempsPassat;
        
        return (int) Math.ceil(milisegons / (86400.0 * 1000));
    }
    
}
