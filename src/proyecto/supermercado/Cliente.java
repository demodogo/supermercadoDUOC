package proyecto.supermercado;
import java.lang.StringBuilder;
import java.util.Scanner;
import static proyecto.supermercado.Producto.products;

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

        System.out.println("Nombre:");
        String nombre = scanner.next();
        System.out.println("Correo electrónico:");
        String mail = scanner.next();
        System.out.println("Dirección:");
        String direccion = scanner.next();
        System.out.println("Número de telefono (+56 9): ");
        int telefono = scanner.nextInt();
        System.out.println("Ingrese su rut (sin puntos ni guión): ");
        String rut = scanner.next();

        new Cliente(rut, nombre, mail, direccion, telefono);
        Cliente.validarRut(rut);
    }

    private static void validarRut(String rut) {
        Cliente.rut = Cliente.rut.toUpperCase();
        StringBuilder noDVrut = new StringBuilder(Cliente.rut.substring(0, rut.length() -1 ));
        noDVrut.reverse();
        String rutToString = noDVrut.toString();
        char[] stringArray = rutToString.toCharArray();
        int size = stringArray.length;
        int [] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            String toString = String.valueOf(Character.getNumericValue(stringArray[i]));
            int toInt = Integer.parseInt(toString);
            numbers[i] = toInt;
        }
        int multiplicador = 2;
        int sumaDigitos = 0;
        int result;

        for (int number : numbers) {

            if (multiplicador > 7) {
                multiplicador = 2;
            }
            result = number * multiplicador;
            sumaDigitos += result;


            multiplicador++;
        }
        int resultDivision = sumaDigitos / 11;
        int floorDivision = (int)Math.floor(resultDivision);
        int resultMultiplicacion = floorDivision * 11;
        int finalResult = sumaDigitos - resultMultiplicacion;
        finalResult = finalResult - 11;
        finalResult = Math.abs(finalResult);
        System.out.println(finalResult);
        if (finalResult == Integer.parseInt(rut.substring(rut.length() -1) ) || finalResult == 11 && Integer.parseInt(rut.substring(0, rut.length() -1)) == 0 || finalResult == 10 && (rut.substring(0, rut.length() -1)).equals("K")) {
            System.out.println("Rut ingresado correctamente.");
            Cliente.terminateQuestion();
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Rut incorrecto o no existente.");
            System.out.println("Ingrese su rut (sin puntos ni guión): ");
            rut = scanner.next();
            Cliente.rut = rut;
            validarRut(Cliente.rut);
        }
        }

    private static void terminateQuestion() {
        System.out.println("¿Desea volver al menú principal o cerrar el programa? \n OPCION (1) = CERRAR PROGRAMA \n OPCION (2) = VOLVER AL MENÚ. ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            System.out.println("Gracias por comprar en nuestra tienda.");
            System.exit(0);
        } else if (opcion == 2) {
            Menu.getMenu(products);
        } else {
            System.out.println("Opción inválida.");
            terminateQuestion();
        }
    }
}

