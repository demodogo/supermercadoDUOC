package proyecto.supermercado;
import static proyecto.supermercado.Producto.products;

public class Main {
    public static void main(String[] args) {
        Producto.setProducts(products);
        Menu.getMenu(products);

    }
}
