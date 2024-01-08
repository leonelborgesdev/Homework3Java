import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Producto> listaProductos= new ArrayList<>();
        listaProductos.add(new Producto("Producto1",10.50,"ABC123"));
        listaProductos.add(new Producto("Producto2", 0, "XYZ789"));
        listaProductos.add(new Producto("Producto3", 15.75, "10"));

        Collections.sort(listaProductos);
        System.out.println("Productos ordenados por precio:");
        for (Producto producto : listaProductos){
            System.out.println(producto.getNombre() + " - Precio: "+producto.getPrecio());
        }

        Filtrable vendible=Filtros.vendible();
        Filtrable descartable= Filtros.descartable();
        try {
            Filtrable imperecedero = Filtros.imperecedero();

            System.out.println("\nProductos Imperecederos");
            for (Producto producto: listaProductos){
                if (imperecedero.cumpleFiltro(producto)){
                    System.out.println(producto.getNombre());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nProductos vendibles:");
        for (Producto producto: listaProductos){
            if (vendible.cumpleFiltro(producto)){
                System.out.println(producto.getNombre());
            }
        }

        System.out.println("\nProductos descartables:");
        for (Producto producto: listaProductos){
            if (descartable.cumpleFiltro(producto)){
                System.out.println(producto.getNombre());
            }
        }

    }
}