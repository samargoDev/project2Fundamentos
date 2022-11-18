import java.util.Random;

public class Frase{
    public static String frasesAbuela[] = {
        "Verte sonreír ilumina mi mundo y lo llena de felicidad.", "Si nada va bien, llama a tu abuela.", 
        "No hay en nuestras vidas cómplice más hermoso que el abuelo; en él tenemos a un padre, a un maestro y a un amigo.",
        "Sigue el consejo de tu abuela y siempre acertarás.", "Los nietos sois como las flores, nunca nos cansamos de veros crecer.",
        "No grites. Nunca funciona, te duele a ti mismo y a los demás. Cada vez que he gritado, he fallado."
    };

    public static String fraseAleatoria(){
        Random num = new Random();
        int numeroAleatorio = num.nextInt((6 - 0) + 0) + 1; 
        String frase = frasesAbuela[numeroAleatorio];
        return frase;
    }
}
