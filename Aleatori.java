import java.util.Random;

public class Aleatori {

    //// Propietats
    private static Random generadorAleatori = new Random();

    //// Constructors
    public Aleatori() {
        // default
    }

    //// Mètodes
    /**
     * Mètode per generar un enter dintre d'un rang.
     * @param valorMinim El mínim valor que es pot generar.
     * @param valorMaxim El màxim valor que es pot generar.
     * @return Un número entre el mínim i el màxim, inclosos.
     */
    public static int generarIntAleatoriRang(int valorMinim, int valorMaxim) {

        // Utilitzem la classe random (mirar la seva documentació)
        // Hem d'utilitzar un dels seus mètodes per obtenir un int aleatori del 1 al màxim (mínim 1 per la suma i el màxim perquè aquest mètode agafa el màxim de forma no inclosa).

        return generadorAleatori.nextInt(valorMaxim - valorMinim + 1) + valorMinim;
    }


    /**
     * Mètode per generar un enter dintre d'un rang.
     * @param valorMinim El mínim valor que es pot generar.
     * @param valorMaxim El màxim valor que es pot generar.
     * @return Un número entre el mínim i el màxim, inclosos.
     */
    public static double generarDoubleAleatoriRang(double valorMinim, double valorMaxim) {

        // Utilitzem la classe random (mirar la seva documentació)
        // Hem d'utilitzar un dels seus mètodes per obtenir un double aleatori del 0,1 al màxim (mínim 0,1 per la suma i el màxim perquè aquest mètode agafa el màxim de forma no inclosa).

        return generadorAleatori.nextDouble(valorMaxim - valorMinim + 0.1) + valorMinim;
    }


    /**
     * Mètode que retorna cert o fals de forma aleatòria.
     * @return Cert o fals de forma aleatòria.
     */
    public static boolean tirarMoneda() {

        // Cridem a generar int amb mínim 0 i màxim 1, si és 0, false, si és 1, true.

        if (Aleatori.generarIntAleatoriRang(0, 1) == 0) {

            return false;
        } else {

            return true;
        }
    }

    /**
     * Mètode per obtenir cert o fals segons una probabilitat en percentatge. Un percentatge alt retornarà cert més vegades mentre que un de més baix menys vegades.
     * @param percentatge Un enter que representa el percentatge de vegades que es retornaria cert.
     * @return Cert o fals de forma aleatòria.
     */
    public static boolean percentatgeProbabilitat(int percentatge) {

        // Utilitzem el random int per fer una probabilitat de retornar cert segons el percentatge (enter) que ens passen.

        if (Aleatori.generarIntAleatoriRang(0, 100) <= percentatge) {

            return true;
        }

        return false;
    }

}
