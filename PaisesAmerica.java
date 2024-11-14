import java.util.ArrayList;
import java.util.List;

public class PaisesAmerica {
    private static final String[][] PAISES_AMERICA = {
        {"Argentina", "Buenos Aires"},
        {"Bolivia", "La Paz"},
        {"Brasil", "Brasilia"},
        {"Chile", "Santiago"},
        {"Cuba", "La Habana"},
        {"Ecuador", "Quito"},
        {"Estados Unidos", "Washington DC"},
        {"Guatemala", "Ciudad de Guatemala"},
        {"Haiti", "Puerto Príncipe"},
        {"Honduras", "Tegucigalpa"},
        {"Jamaica", "Kingston"},
        {"Mexico", "Ciudad de México"},
        {"Nicaragua", "Managua"},
        {"Panama", "Ciudad de Panamá"},
        {"Paraguay", "Asunción"},
        {"Peru", "Lima"},
        {"República Dominicana", "Santo Domingo"},
        {"Uruguay", "Montevideo"},
        {"Venezuela", "Caracas"},
        {"Canada", "Ottawa"}
    };
    
    public static List<String[]> buscarPaisesPorLongitud(int longitud) {
        List<String[]> paisesFiltrados = new ArrayList<>();
        for (String[] paisInfo : PAISES_AMERICA) {
            String paisSinEspacios = paisInfo[0].replace(" ", "");
            if (paisSinEspacios.length() == longitud) {
                paisesFiltrados.add(paisInfo);
            }
        }
        return paisesFiltrados;
    }
    
    public static void mostrarInformacionPaises(List<String[]> paises) {
        if (paises.isEmpty()) {
            System.out.println("No se encontraron países con esa longitud.");
            return;
        }
        
        System.out.println("\n=== Información de Países Encontrados ===");
        System.out.println("----------------------------------------");
        System.out.printf("%-25s %-20s%n", "PAÍS", "CAPITAL");
        System.out.println("----------------------------------------");
        
        for (String[] paisInfo : paises) {
            System.out.printf("%-25s %-20s%n", paisInfo[0], paisInfo[1]);
        }
        System.out.println("----------------------------------------");
        System.out.println("Total de países encontrados: " + paises.size());
    }
    
    public static void main(String[] args) {
        System.out.println("=== Análisis de Países de América ===\n");
        System.out.println("Buscando países con nombres de 4 letras...");
        List<String[]> paisesCuatroLetras = buscarPaisesPorLongitud(4);
        mostrarInformacionPaises(paisesCuatroLetras);
    }
}