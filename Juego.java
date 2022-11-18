import java.util.Scanner;

public class Juego{
    public static void main(String[] args) {
        Scanner mySc = new Scanner(System.in);
        String msj = "1.Disparar una bala \n" + "2.Activar bomba atomica \n" + "3.Activar tanque mutante \n" + "4.La frase de la abuela. \n" + "5.Conteo de disparos \n" + "6.Leer cantidad de sangre. \n" + "7.Mostrar menu \n" + "8.Mostrar tablero \n" + "9.Guardar datos en archivo .txt"; 
        Tanque.cargarTanques();
        System.out.println("Tablero del juegos");
        System.out.println(Tanque.showTablero());

        System.out.println("\n // Seleccione una opcion // \n ");
        System.out.println(msj);
        int numUser = mySc.nextInt();

        Boolean bl = true;
        while(bl == true){
            switch (numUser){
                case 1:
                System.out.println("Digite la fila");
                int fila = mySc.nextInt();
                System.out.println("Digite la columna");
                int columna = mySc.nextInt();
                Tanque.disparo(fila, columna);
                Tanque.cantidadDisparos++;
                System.out.println(Tanque.showTablero());
                    break;
                case 2:
                    Tanque.bombaAtomica();
                    System.out.println("La bomba ha sido lanzada");
                    System.out.println(Tanque.showTablero());
                    break;
                case 3:
                    Tanque.mutante();
                    System.out.println("Tanque mutante");
                    System.out.println(Tanque.showTablero());
                    break;
                case 4:
                    System.out.println(Frase.fraseAleatoria());
                    System.out.println(Tanque.showTablero());
                    break;
                case 5:
                    System.out.println("La cantidad de disparos efecutados en el campo de batalla " + Tanque.cantidadDisparos);
                    System.out.println(Tanque.showTablero());
                    break;
                case 6:
                System.out.println("La cantidad de sangre de los tanques es: " + Tanque.leerSangre());
                System.out.println(Tanque.showTablero());
                    break;
                case 7:
                System.out.println(msj);
                System.out.println(Tanque.showTablero());
                    break;
                case 8:
                System.out.println(Tanque.showTablero());
                System.out.println(Tanque.showTablero());
                    break;
                case 9:
                    Tanque.guardarSangreTXT();
                    System.out.println("Informacion guardada");
                    System.out.println(Tanque.showTablero());
                    break;
                default:
                    System.out.println("Digite una opcion correcta");
                    System.out.println(Tanque.showTablero());
                    break;
            }

            if(Tanque.tanquesMuertos() == Tanque.numTanques){
                System.out.println("Juego finalizado");
                break;
            }

            System.out.println("\n // Seleccione una opcion // \n ");
            System.out.println(msj);
            numUser = mySc.nextInt();
        }
        mySc.close();
    }
}