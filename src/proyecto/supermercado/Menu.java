package proyecto.supermercado;
import java.util.ArrayList;
import java.util.Scanner;
import static proyecto.supermercado.Compra.cart;
import static proyecto.supermercado.Compra.total;
public class Menu {
    public static void getMenu(ArrayList<Producto> products) {
        boolean salir = false;
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡BIENVENIDO AL SÚPER! \n 1. Lista de productos. \n 2. Agregar productos. \n 3. Ver carrito \n 4. Nueva compra\n 5. Salir");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Producto.displayProductos(products);
                Menu.getMenu(products);
            case 2:
                Compra.addProduct(products);
            case 3:
                Compra.getBoleta(cart, total, products);
            case 4:
                Compra.nuevaSolicitud(cart, products,Compra.nSolicitud);
            case 5:
                System.exit(0);
                Compra.setSolicitud(Compra.nSolicitud);


        }
    }
}
