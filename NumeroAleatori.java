import java.util.Random;

public class NumeroAleatori {

    // Propietats


    // Constructors

    // Mètodes

    /**
     * Mètode per generar un enter dintre d'un rang.
     * @param valorMinim El mínim valor que es pot generar.
     * @param valorMaxim El màxim valor que es pot generar.
     * @return Un número entre el mínim i el màxim, inclosos.
     */
    public static int generarIntAleatoriRang(int valorMinim, int valorMaxim) {

        // Utilitzem la classe random (mirar la seva documentació)
        // Hem d'utilitzar un dels seus mètodes per obtenir un int aleatori del 1 al màxim (mínim 1 per la suma i el màxim perquè aquest mètode agafa el màxim de forma no inclosa).

        Random aleatori = new Random();
        return aleatori.nextInt(valorMaxim - valorMinim + 1) + valorMinim;
    }

    /**
     * Mètode per generar un enter dintre d'un rang.
     * @param valorMinim El mínim valor que es pot generar.
     * @param valorMaxim El màxim valor que es pot generar.
     * @return Un número entre el mínim i el màxim, inclosos.
     */
    public static double generarDoubleAleatoriRang(double valorMinim, double valorMaxim) {

        // Utilitzem la classe random (mirar la seva documentació)
        // Hem d'utilitzar un dels seus mètodes per obtenir un int aleatori del 1 al màxim (mínim 1 per la suma i el màxim perquè aquest mètode agafa el màxim de forma no inclosa).

        Random aleatori = new Random();
        return aleatori.nextDouble(valorMaxim - valorMinim + 0.1) + valorMinim;
    }


}
