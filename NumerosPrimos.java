import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumerosPrimos {
    private static final Scanner scanner = new Scanner(System.in);
    
    private static boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero <= 3) return true;
        if (numero % 2 == 0 || numero % 3 == 0) return false;
        
        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) return false;
        }
        return true;
    }
    
    public static List<Integer> encontrarPrimosEnRango(int inicio, int fin) {
        List<Integer> primos = new ArrayList<>();
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) primos.add(i);
        }
        return primos;
    }
    
    private static void mostrarPrimos(List<Integer> numeros, boolean rango) {
        if (numeros.isEmpty()) {
            System.out.println("No se encontraron números primos.");
            return;
        }
        
        System.out.println("\n=== Números Primos Encontrados ===");
        System.out.println("----------------------------------");
        
        int contador = 0;
        for (int numero : numeros) {
            contador++;
            System.out.printf("%-6d", numero);
            if (contador % 10 == 0) System.out.println();
        }
        
        if (contador % 10 != 0) System.out.println();
        
        System.out.println("----------------------------------");
        System.out.println("Total de números primos: " + numeros.size());
        
        if (rango) {
            double porcentaje = (numeros.size() * 100.0) / (numeros.get(numeros.size()-1) - numeros.get(0) + 1);
            System.out.printf("Porcentaje de números primos en el rango: %.2f%%\n", porcentaje);
        }
    }
    
    private static int obtenerNumero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int numero = Integer.parseInt(scanner.nextLine());
                if (numero < 0) {
                    System.out.println("Por favor, ingrese un número positivo.");
                    continue;
                }
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Analizador de Números Primos ===\n");
        
        int[] numerosPredefinidos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 17, 19, 23};
        List<Integer> primosPredefinidos = new ArrayList<>();
        
        for (int numero : numerosPredefinidos) {
            if (esPrimo(numero)) primosPredefinidos.add(numero);
        }
        
        System.out.println("Análisis de lista predefinida:");
        mostrarPrimos(primosPredefinidos, false);
        
        System.out.println("\nAnálisis por rango:");
        int inicio = obtenerNumero("Ingrese el inicio del rango: ");
        int fin;
        do {
            fin = obtenerNumero("Ingrese el fin del rango: ");
            if (fin < inicio) System.out.println("El fin debe ser mayor que el inicio.");
        } while (fin < inicio);
        
        List<Integer> primosRango = encontrarPrimosEnRango(inicio, fin);
        mostrarPrimos(primosRango, true);
        
        scanner.close();
    }
}