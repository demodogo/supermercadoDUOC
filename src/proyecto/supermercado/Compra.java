package proyecto.supermercado;
import java.text.SimpleDateFormat;
import java.util.*;

public class Compra {

    static String nSolicitud = "1";
    String cliente;
    static ArrayList<String> cart = new ArrayList<>(8);

    static double total;
    static int cantidad = 0;

    String fecha;

    public Compra(String fecha, String nSolicitud, String cliente, double total, ArrayList<String> cart) {
        this.fecha = fecha;
        Compra.nSolicitud = nSolicitud;
        this.cliente = cliente;
        Compra.total = total;
        Compra.cart = cart;

    }

    public static void setCart(String producto, String precio, String cantidad) {
        String[] concatProductPrice = {producto, precio, cantidad};
        cart.add(Arrays.toString(concatProductPrice));
    }

    public static void addProduct(ArrayList<Producto> products) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int tries = 0;
        while (continuar) {
            tries = 0;
            System.out.println("Seleccione un producto:");
            String producto = scanner.next();
            for (Producto p : products) {
                if (producto.equals(p.getDescripcion())) {
                    System.out.println("Precio del producto: " + p.getPrice());
                    System.out.println("Seleccione la cantidad a comprar:");
                    cantidad = scanner.nextInt();
                    Compra.setCart("Producto: " + producto, "Valor: " + p.getPrice(), "Cantidad: " + cantidad);
                    total += cantidad * p.getPrice();
                    continuar = Compra.addProductQuestion();
                    break;

                } else if (!producto.equals(p.getDescripcion()) && tries >= products.size() -1 ) {
                        System.out.println("Producto no disponible.");
                }
                tries++;
            }
            if (!continuar) {
                Menu.getMenu(products);
            }
        }
    }

    private static boolean addProductQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Desea agregar otro producto?");
        String result = scanner.next().toUpperCase();
        if (result.equals("SI")) {
            return true;
        } else {
            return false;
        }
    }

    public static void getBoleta(ArrayList<String> cart, double total, ArrayList<Producto> products) {
        Date date = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = formato.format(date);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Su número de solicitud es: " + setSolicitud(Compra.nSolicitud));
        System.out.println("Fecha: " + fecha);
        System.out.println(cart);
        System.out.println("El total es: " + total);
        System.out.println("¿Desea finalizar su compra?: ");
        String finalize = scanner.next().toUpperCase();
        if (finalize.equals("SI")) {
            Cliente.setCliente();
            System.exit(0);
        } else {
            Menu.getMenu(products);
        }
    }

    public static String setSolicitud(String nSolicitud) {
        if (nSolicitud.length() == 1) {
            nSolicitud = "000" + nSolicitud;
        } else if (nSolicitud.length() == 2) {
            nSolicitud = "00" + nSolicitud;
        } else if (nSolicitud.length() == 3) {
            nSolicitud = "0" + nSolicitud;
        }
        return nSolicitud;
    }

    public static  String nuevaSolicitud(ArrayList<String> cart, ArrayList<Producto> products, String nSolicitud) {
        cart.clear();
        int intSolicitud = Integer.parseInt(Compra.nSolicitud);
        intSolicitud++;
        System.out.println(intSolicitud);
        Compra.nSolicitud = Integer.toString(intSolicitud);
        Menu.getMenu(products);
        return nSolicitud;
    }
}
