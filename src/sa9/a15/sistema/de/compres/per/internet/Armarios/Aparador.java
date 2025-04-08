package sa9.a15.sistema.de.compres.per.internet.Armarios;

import java.util.ArrayList;
import java.util.Collections;
import sa9.a15.sistema.de.compres.per.internet.Exceptions.CanNotMergeBrandsException;
import sa9.a15.sistema.de.compres.per.internet.Exceptions.NotExistEnoughItemException;
import sa9.a15.sistema.de.compres.per.internet.Exceptions.ShowRoomNotOpenException;
import sa9.a15.sistema.de.compres.per.internet.Marcas;
import sa9.a15.sistema.de.compres.per.internet.Producte;
import sa9.a15.sistema.de.compres.per.internet.StockProducte;

public abstract class Aparador {

    private String nombre;
    private Marcas marca;
    private ArrayList<StockProducte> inventario;

    public Aparador(String nombre, Marcas marca, Producte... productos) {
        this.nombre = nombre;
        this.marca = marca;
        this.inventario = new ArrayList<>();
        int productosDiferentes = 0;

        for (Producte producto : productos) {
            if (producto.getMarca() != this.marca) {
                throw new CanNotMergeBrandsException("El producto [" + producto.getId() + "] no pertenece a la marca del expositor");
            }

            StockProducte productoEnStock = new StockProducte(producto);

            if (inventario.contains(productoEnStock)) {
                productosDiferentes++;
            }

            if (productosDiferentes < 20) {
                inventario.add(productoEnStock);
            } else {
                System.out.println("Ya hay 20 productos de este tipo en el expositor");
                break;
            }
        }
    }

    public ArrayList<Producte> productesEnStock() {
        ArrayList<Producte> disponibles = new ArrayList<>();

        for (StockProducte productoEnStock : inventario) {
            if (productoEnStock.getQuantitatDisponible() > 0) {
                disponibles.add(productoEnStock.getProducte());
            }
        }

        return disponibles;
    }

    public boolean productesDisponible(Producte producto, int cantidad) {
        assert cantidad > 0 : "La cantidad debe ser mayor que cero";

        if (inventario.isEmpty()) {
            return false;
        }

        for (StockProducte productoEnStock : inventario) {
            if (productoEnStock.getProducte().equals(producto)) {
                return productoEnStock.getQuantitatDisponible() >= cantidad;
            }
        }

        return false;
    }

    public boolean quedaProducteEnStock(Producte producto) {
        if (inventario.isEmpty()) {
            return false;
        }

        for (StockProducte productoEnStock : inventario) {
            if (productoEnStock.getProducte().equals(producto)) {
                return true;
            }
        }

        return false;
    }

    public int unitatsDisponibles(Producte producto) {
        if (inventario.isEmpty()) {
            return 0;
        }

        int unidades = 0;

        for (StockProducte productoEnStock : inventario) {
            if (productoEnStock.getProducte().equals(producto)) {
                unidades += productoEnStock.getQuantitatDisponible();
            }
        }

        return unidades;
    }

    public abstract boolean estaObert();

    public void comprarProducte(Producte producto, int cantidad) throws ShowRoomNotOpenException {
        assert cantidad > 0 : "La cantidad debe ser mayor que cero";

        if (!estaObert()) {
            throw new ShowRoomNotOpenException("El expositor está cerrado, vuelve más tarde");
        }

        if (!productesDisponible(producto, cantidad)) {
            throw new NotExistEnoughItemException("No hay suficientes unidades del producto: [" + producto.getId() + "]");
        }

        for (StockProducte productoEnStock : inventario) {
            if (productoEnStock.getProducte().equals(producto)) {
                productoEnStock.setStock(productoEnStock.getQuantitatDisponible() - cantidad);
                System.out.printf("Compra realizada con éxito: %d unidades de [%s]\n", cantidad, producto.getId());
                break;
            }
        }
    }

    public ArrayList<Producte> productesEnStockOrdenats() {
        ArrayList<Producte> ordenados = new ArrayList<>();

        for (StockProducte productoEnStock : inventario) {
            if (productoEnStock.getQuantitatDisponible() > 0) {
                ordenados.add(productoEnStock.getProducte());
            }
        }

        Collections.sort(ordenados);

        return ordenados;
    }
}
