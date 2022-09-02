package proyecto.supermercado;
import java.util.ArrayList;

public class Producto {

    int codigo;
    String subcategoria;
    String descripcion;
    double precio;

    static ArrayList<Producto> products = new ArrayList<>();

    public Producto(int codigo, String subcategoria, String descripcion, double precio) {
        this.codigo = codigo;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public static void setProducts(ArrayList<Producto> products) {
        Producto zanahoria = new Producto(1849, "Verdura", "Zanahoria", 560);
        products.add(zanahoria);
        Producto pepino = new Producto(1748, "Verdura", "Pepino", 790);
        products.add(pepino);
        Producto papas = new Producto(2875, "Verdura", "Papas", 1600);
        products.add(papas);
        Producto arandanos = new Producto(1250, "Fruta", "Arándanos", 2400);
        products.add(arandanos);
        Producto pina = new Producto(9785, "Fruta", "Pina", 1250);
        products.add(pina);
    }

    public String getDescripcion() {
        return descripcion;
    }
    public static void displayProductos(ArrayList<Producto> products) {
        for (Producto p : products) {
            System.out.println("PRODUCTO: " + p.descripcion + "\nPRECIO: " + p.precio + "\n");
        }
    }

    public double getPrice() {
        return precio;
    }
}



