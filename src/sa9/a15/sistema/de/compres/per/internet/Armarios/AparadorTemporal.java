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
public class AparadorTemporal extends Aparador{
    
    private long fechaCreado;
    private int diasAbierto;
    
    public AparadorTemporal(String nom, Marcas marca, int dies, Producte... productes) {
        super(nom, marca, productes);
        this.fechaCreado = System.currentTimeMillis();
        this.diasAbierto = dies;
    }

    @Override
    public boolean estaObert() {
        
        long tempsActual = System.currentTimeMillis();
        long tempsPassat = tempsActual - fechaCreado;
        long milisegons = diasAbierto * 86400 * 1000;
        
        return tempsPassat < milisegons;
    }

    public int diesRestants() {
        long tempsActual = System.currentTimeMillis();
        long tempsPassat = tempsActual - fechaCreado;
        long milisegons = (diasAbierto * 86400L * 1000) - tempsPassat;
        
        return (int) Math.ceil(milisegons / (86400.0 * 1000));
    }
    
    
}
