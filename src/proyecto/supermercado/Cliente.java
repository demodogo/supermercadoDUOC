package proyecto.supermercado;
import java.util.Scanner;
public class Cliente {
    static String rut;
    String nombre;
    String mail;
    String direccion;
    int telefono;

    public Cliente(String rut, String nombre, String mail, String direccion, int telefono) {
        Cliente.rut = rut;
        this.nombre = nombre;
        this.mail = mail;
        this. direccion = direccion;
        this.telefono = telefono;
    }

    public static void setCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su rut (con puntos y guión): ");
        String rut = scanner.next();
        System.out.println("Nombre:");
        String nombre = scanner.next();
        System.out.println("Correo electrónico:");
        String mail = scanner.next();
        System.out.println("Dirección:");
        String direccion = scanner.next();
        System.out.println("Número de telefono (+56 9): ");
        int telefono = scanner.nextInt();

        new Cliente(rut, nombre, mail, direccion, telefono);
        // Cliente.validarRut(rut);
    }

    /*public static void validarRut(String rut) {
        boolean esValido = false;
        rut = rut.toUpperCase();
        rut = rut.replace("-","");
        rut = rut.replace("-","");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() -1));

        char dv = rut.charAt(rut.length() - 1);
        int m = 0, s = 1;
        for (; rutAux != 0; rutAux /= 10) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
        }
        if (dv == (char) (s != 0 ? s + 47 : 75)) {
            esValido = true;
        }

        if (!esValido) {
            System.out.println("Boleta emitida. \n Gracias por comprar con nosotros");
        }
        else if (esValido) {
            System.out.println("RUT INVALIDO, INGRESE SU RUT NUEVAMENTE.");
            Cliente.setCliente();
        }

    }*/
}
