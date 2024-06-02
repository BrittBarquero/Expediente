import java.util.Scanner;

public class Elecciones {
    static int[] votos = new int[5];

    private int edad;
    private int provincia;
    private int voto_candidato; 

    public Elecciones(int edad) {
        this.edad = edad;
    }

    public void elegirProvincia(Scanner scanner) {
        System.out.println("Seleccione la provicia de residencia actual:");
        System.out.println("1. San José");
        System.out.println("2. Alajuela");
        System.out.println("3. Cartago");
        System.out.println("4. Heredia");
        System.out.println("5. Guanacaste");
        System.out.println("6. Puntarenas");
        System.out.println("7. Limón");
        this.provincia = validarOpcion(scanner, "Digite una opción: ", "^[1-7]$", "Error: seleccione una opción válida");
    }

    public void elegirCandidato(Scanner scanner) {
        System.out.println("Seleccione el candidato de su preferencia:");
        System.out.println("1. Isabella Torres Jiménez");
        System.out.println("2. Alejandro Reyes Castro");
        System.out.println("3. Leonardo Mendoza Cruz");
        System.out.println("4. Santiago Herrera Ramírez");
        System.out.println("5. Laura Gómez Arrieta");
        this.voto_candidato = validarOpcion(scanner, "Digite una opción: ", "^[1-5]$", "Error: seleccione una opción válida");
    }


    private int validarOpcion(Scanner scanner, String mensajeEntrada, String patron, String mensajeError) {
        int opcion = 0;
        while (true) {
            System.out.println(mensajeEntrada);
            String entrada = scanner.nextLine();
            if (entrada.matches(patron)) {
                opcion = Integer.parseInt(entrada);
                break;
            } else {
                System.out.println(mensajeError);
            }
        }
        return opcion;
    }

    public String toString() {
        return "Edad: " + this.edad + "\n" +
               "Provincia: " + this.provincia + "\n" +
               "Su voto es válido para: " + this.voto_candidato + "\n" +
               "Mayor de edad: " + aprobado() + "\n";
    }

    public boolean aprobado() {
        return this.edad >= 18;
    }

    public static class SistemaElecciones {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese su edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            Elecciones elecciones = new Elecciones(edad);
            elecciones.elegirProvincia(scanner);
            elecciones.elegirCandidato(scanner);

            // Registrar el voto
            int votoCandidato = elecciones.voto_candidato;
            if (votoCandidato >= 1 && votoCandidato <= 5) {
                votos[votoCandidato - 1]++;
                System.out.println("¡Gracias por tu voto!");
            } else {
                System.out.println("Opción inválida. Vuelve a intentarlo.");
            }

            // Imprimir resultados
            System.out.println("\nResultados de la votación:");
            for (int i = 0; i < votos.length; i++) {
                System.out.println((i + 1) + ". Votos para el candidato " + (i + 1) + ": " + votos[i]);
            }
        }
    }
}
