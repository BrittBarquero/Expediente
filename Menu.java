import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
    }
    
    public static void menu(Scanner scanner){
        while(true){
           imprimirMenu();
           int opcion = Integer.parseInt(validar(scanner,"Digite una opción: ","^[1-3]$","Error solo debe digitar opciones del 1 al 3"));
           accionMenu(opcion,scanner);
           if(opcion ==3){
               break;
           } 
        }
    }
    
    public static void imprimirMenu(){ 
         System.out.println("Menu principal");
         System.out.println("1. Votaciones");
         System.out.println("2. Préstamo");
         System.out.println("3. Salir");
    }
    
    public static void accionMenu(int opcion,Scanner scanner){
      switch(opcion){
          case 1:
              subMenu(scanner);
              break;
          case 2: 
              System.out.println("2. Préstamo");
              break;
          case 3:
            System.out.println("¡Gracias para usar nuestro programa de votaciones y préstamos! Usted ha salido del sistema");
              break; 
      }  
    }

    public static String validar(Scanner scanner, String mensajeEntrada,String patron, String mensajeError){
        String entrada ="";
        while(true){
            System.out.println(mensajeEntrada);
            entrada = scanner.nextLine();
            if(entrada.matches(patron)){
                break;
            }else{
                System.out.println(mensajeError);
            }  
        }
        return entrada;
    }
    
    public static void subMenu(Scanner scanner){
        while(true){
           imprimirSubMenu();
           int opcion = Integer.parseInt(validar(scanner,"Digite una opción: ","^[1-5]$","Error solo debe digitar opciones del 1 al 5"));
           accionSubMenu(opcion);
           if(opcion ==5){
               break;
           } 
        }
    }
    public static void imprimirSubMenu(){
         System.out.println("Menú de votaciones");
         System.out.println("1. Votar");
         System.out.println("2. Reporte por candidato");
         System.out.println("3. Reporte por provincia");
         System.out.println("4. Reporte por edades");
         System.out.println("5. Volver al menú principal");
    }
    public static void accionSubMenu(int opcion){
      switch(opcion){
          case 1:
              System.out.println("Estamos realizando la accion uno");
              break;
          case 2: 
              System.out.println("Estamos realizando la accion dos");
              break;
          case 3: 
              System.out.println("Estamos realizando la accion tres");
              break;
          case 4: 
              System.out.println("Estamos realizando la accion cuatro");
              break;
          case 5:
              break;
      }  
    }
}

