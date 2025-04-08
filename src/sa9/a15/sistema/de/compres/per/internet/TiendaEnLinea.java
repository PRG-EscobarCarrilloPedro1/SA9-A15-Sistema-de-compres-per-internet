package sa9.a15.sistema.de.compres.per.internet;

import java.util.ArrayList;

import sa9.a15.sistema.de.compres.per.internet.Armarios.AparadorFIExistencies;
import sa9.a15.sistema.de.compres.per.internet.Armarios.AparadorTemporal;
import sa9.a15.sistema.de.compres.per.internet.Armarios.AparadorTemporalFiExistencies;
import sa9.a15.sistema.de.compres.per.internet.Exceptions.CanNotMergeBrandsException;
import sa9.a15.sistema.de.compres.per.internet.Exceptions.NotExistEnoughItemException;
import sa9.a15.sistema.de.compres.per.internet.Exceptions.ShowRoomNotOpenException;

public class TiendaEnLinea {

    public static void main(String[] args) throws ShowRoomNotOpenException {

        Producte productoPolo = new Producte("Polo a rayas", 50, Marcas.LACOSTERA);
        Producte productoBanador = new Producte("Bañador azul", 40, Marcas.LACOSTERA);
        Producte productoCamiseta = new Producte("Camiseta", 25, Marcas.FLORDELTARONGER);
        Producte productoZapatillas = new Producte("Zapatillas", 10, Marcas.FLORDELTARONGER);
        Producte productoReloj = new Producte("Reloj", 45, Marcas.PEPEWEAR);
        Producte productoAnillo = new Producte("Anillo", 35, Marcas.PEPEWEAR);

        AparadorTemporalFiExistencies expositorTemporal =
                new AparadorTemporalFiExistencies("Verano Lacostera 2020", Marcas.LACOSTERA, productoPolo, productoBanador);

        imprimirTitulo("Expositor Temporal Hasta Fin de Existencias");

        imprimirTitulo("Productos Disponibles en el Expositor");
        ArrayList<Producte> productosDisponibles = new ArrayList<>(expositorTemporal.productesEnStockOrdenats());
        for (Producte producto : productosDisponibles) {
            System.out.println(producto);
        }

        imprimirTitulo("Consultar Stock");
        System.out.println("Polo: " + expositorTemporal.unitatsDisponibles(productoPolo));
        System.out.println("Bañador: " + expositorTemporal.unitatsDisponibles(productoBanador));

        imprimirTitulo("Consultar Tiempo Restante");
        System.out.println("Quedan: " + expositorTemporal.diesRestants() + " días");

        imprimirTitulo("Realizar Compra");
        try {
            expositorTemporal.comprarProducte(productoPolo, expositorTemporal.unitatsDisponibles(productoPolo));
            expositorTemporal.comprarProducte(productoBanador, expositorTemporal.unitatsDisponibles(productoBanador));
        } catch (ShowRoomNotOpenException e) {
            System.out.println(e.getMessage());
        }

        imprimirTitulo("Estado del Expositor");
        if (expositorTemporal.estaObert()) {
            System.out.println("El expositor está abierto");
        } else {
            System.out.println("El expositor está cerrado");
        }

        System.out.println("---------- PRUEBAS ADICIONALES ----------");

        imprimirTitulo("Expositor Hasta Fin de Existencias");
        AparadorFIExistencies expositorStock =
                new AparadorFIExistencies("Fin de stock Flor del Taronger", Marcas.FLORDELTARONGER, productoCamiseta, productoZapatillas);
        System.out.println("Antes de cerrar: " + expositorStock.estaObert());
        expositorStock.tancarAparador();
        System.out.println("Después de cerrar: " + expositorStock.estaObert());

        imprimirTitulo("Expositor Temporal");
        AparadorTemporal expositorPepeWear =
                new AparadorTemporal("Temporal PepeWear", Marcas.PEPEWEAR, 50, productoReloj, productoAnillo);
        System.out.println("Días restantes: " + expositorPepeWear.diesRestants());
        System.out.println("¿Está abierto? " + expositorPepeWear.estaObert());

        imprimirTitulo("Intento de compra en expositor cerrado");
        try {
            expositorStock.comprarProducte(productoCamiseta, 1);
        } catch (ShowRoomNotOpenException e) {
            System.err.println(e.getMessage());
        }

        imprimirTitulo("Compra superior al stock disponible");
        try {
            expositorPepeWear.comprarProducte(productoReloj, 12);
        } catch (NotExistEnoughItemException e) {
            System.err.println(e.getMessage());
        }

        imprimirTitulo("Añadir producto con marca diferente");
        try {
            AparadorFIExistencies expositorInvalido =
                    new AparadorFIExistencies("Expositor con marcas distintas", Marcas.PEPEWEAR, productoReloj, productoCamiseta);
        } catch (CanNotMergeBrandsException e) {
            System.err.println(e.getMessage());
        }

        imprimirTitulo("Crear producto sin precio");
        try {
            Producte productoErroneo = new Producte("Producto sin precio", 0, Marcas.PEPEWEAR);
        } catch (IllegalArgumentException e) {
            System.err.println("Error al crear producto: " + e.getMessage());
        }
    }

    private static void imprimirTitulo(String texto) {
        System.out.println("\n----- " + texto + " -----\n");
    }
}
