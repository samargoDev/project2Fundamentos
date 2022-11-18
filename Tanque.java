import java.util.Random;
import java.io.*;

public class Tanque {
    public static int numTanques = 0;
    public static int cantidadDisparos = 0;
    String nombre;
    int salud;

    public Tanque(String nombre, int salud) {
        this.nombre = nombre;
        this.salud = salud;
        numTanques++;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return this.salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    //Arreglo
    public static Tanque myArrayTanques[][] = new Tanque[2][2];
    //Agregar tanque
    public static void setTanque(Tanque tanque){
        boolean bandera = false;
        for(int i = 0; i < 2; i++){
            if(bandera){
                break;
            } else{
                for(int j = 0; j < 2; j++){
                    if(myArrayTanques[i][j] == null){
                        myArrayTanques[i][j] = tanque;
                        bandera = true;
                        break;
                    }
                }
            }
        }
    }

    //Generar tanques
    public static void cargarTanques(){
        Random num = new Random();
        int numeroAleatorio = num.nextInt((4 - 1) + 1) + 1; 

        for(int  i = 0; i <= numeroAleatorio; i++){
            int aleatorio = num.nextInt((2 - 1) + 1) + 1;
            
            if(aleatorio == 1){
                TanqueNormal tanqueNormal = new TanqueNormal();
                setTanque(tanqueNormal);
            } else {
                TanqueAlien tanqueAlien= new TanqueAlien();
                setTanque(tanqueAlien);
            }
        }

    }

    public String toString() {
        String res = this.nombre + "-" + this.salud;
        return res;
    }

    public static void disparo(int x, int y){
        if(x >= 2 || y >= 2){
            System.out.println("Posicion incorrecta");
        } else if(myArrayTanques[x][y] == null){
            System.out.println("No existe un tanque en esta posicion");
        } else if(myArrayTanques[x][y].getSalud() > 0){
            myArrayTanques[x][y].setSalud(myArrayTanques[x][y].getSalud() - 5);
        } else if(myArrayTanques[x][y].getSalud() <= 0){
            System.out.println("El tanque ya esta muerto");
        }
    }

    public static void bombaAtomica(){
        Random num = new Random();
        while(true){
            int x = (int) (Math.random()*2);
            int y = (int) (Math.random()*2);
            if(myArrayTanques[x][y] == null){
                continue;
            } else if(myArrayTanques[x][y].getSalud() > 0){
                myArrayTanques[x][y].setSalud(0);
                break;
            }
        }   
    }

    public static void mutante(){
        int arrayMenor[] = new int[numTanques];
        int num = 0;

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                if(myArrayTanques[i][j] != null && myArrayTanques[i][j].getSalud() > 0){
                    arrayMenor[num] = myArrayTanques[i][j].getSalud();
                    num++;
                }
            }
        }

        int menor = arrayMenor[0];
        for(int i = 0; i < num; i++){
            if(arrayMenor[i] < menor){
                menor = arrayMenor[i];
            }
        }

        boolean bandera = false;
        for(int i = 0; i < 2; i++){
            if(bandera == true){
                break;
            } 
            for(int j = 0; j < 2; j++){
                if(myArrayTanques[i][j] != null && myArrayTanques[i][j].getSalud() == menor){
                    myArrayTanques[i][j].setSalud(myArrayTanques[i][j].getSalud() * 2);
                    bandera = true;
                    break;
                }
            }
        }
    }

    public static void guardarSangreTXT(){
        try {
            PrintWriter txt = new PrintWriter(new FileWriter("Sangre.txt"));
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    if(myArrayTanques[i][j] != null){
                        txt.println(myArrayTanques[i][j].getNombre() + " " + myArrayTanques[i][j].getSalud());
                    }
                }
            }
            txt.close();
        } catch (Exception error) {
            System.out.println("Error al intentar crear el archivo" + error);
        }
    }

    public static String leerSangre(){
        String res = " ";
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                if(myArrayTanques[i][j] != null){
                    res = res + myArrayTanques[i][j].getNombre() + " " + myArrayTanques[i][j].getSalud() + " | ";
                }
            }
        }
        return res;
    }

    public static int tanquesMuertos(){
        int muertos = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                if(myArrayTanques[i][j] != null && Tanque.myArrayTanques[i][j].getSalud() <= 0){
                    muertos++;
                }
            }
        }
        return muertos;
    }

    public static String showTablero(){
        String tablero = "";
        if(numTanques == 1){
            tablero = "-------------\n"+
                    "|" + myArrayTanques[0][0].toString() +"|" +"     "+ "|\n"+
                    "-------------\n"+
                    "|" +"     "+"|" +"     "+ "|";
        }else if(numTanques==2){
            tablero = "-------------\n"+
                    "|" + myArrayTanques[0][0].toString() +"|" + myArrayTanques[0][1].toString() + "|\n"+
                    "-------------\n"+
                    "|" +"     "+"|" +"     "+ "|";
        }else if(numTanques ==3){
            tablero = "-------------\n"+
                    "|" + myArrayTanques[0][0].toString() +"|" + myArrayTanques[0][1].toString()+ "|\n"+
                    "-------------\n"+
                    "|" +myArrayTanques[1][0].toString() +"|" +"     "+ "|";
        }else{
            tablero = "-------------\n"+
                    "|" + myArrayTanques[0][0].toString() +"|" + myArrayTanques[0][1].toString()+ "|\n"+
                    "-------------\n"+
                    "|" +myArrayTanques[1][0].toString() +"|" +myArrayTanques[1][1].toString()+ "|";
        }
        return tablero;
    }
}
