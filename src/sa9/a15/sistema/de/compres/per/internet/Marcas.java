/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sa9.a15.sistema.de.compres.per.internet;

/**
 *
 * @author pedro
 */
public enum Marcas {
    
    PEPEWEAR, LACOSTERA, FLORDELTARONGER;

    @Override
    public String toString() {
        return switch(this){
            case PEPEWEAR -> "PepeWear";
            case LACOSTERA -> "LaCostera";
            case FLORDELTARONGER -> "Flor del taronger";
            default -> null;
        };
    }
    
    
    
}
