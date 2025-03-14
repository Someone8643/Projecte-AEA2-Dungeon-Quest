public class Dificultat {

    // Una classe per poder posar una dificultat i modificar els percentatges segons aquesta
    // La idea és més dificultat menys coses bones i més dolentes, menys dificultat més coses bones i menys dolentes (es modifica amb sumant o restant un 20% del percentatge que hi ha en normal).
    // El percentatge normal és l'extern, de la classe a qui volem modificar segons la dificultat.

    // // Propietats
    private static char nivellDeDificultat;


    // // Constructors

    public Dificultat() {
        // default
    }

    // Mètodes

    //


    // // Mètodes Estàtics

    /**
     * Mètode per calcular el percentatge final per a una cosa bona segons la dificultat (+ o - 20%)
     * @param percentatgeEnNormal El percentatge que hi ha en dificultat normal.
     * @return El percentatge introduït més o menys 20% d'aquest segons la dificultat
     */
    public static int percentatgeFinalObjecteBo(int percentatgeEnNormal) {
        int percentatgeFinal;

        if (Dificultat.nivellDeDificultat == 'D') {

            return percentatgeFinal = percentatgeEnNormal - (int)(percentatgeEnNormal * 0.2);

        } else if (Dificultat.nivellDeDificultat == 'F') {

            return percentatgeFinal = percentatgeEnNormal + (int)(percentatgeEnNormal * 0.2);

        } else {

            return percentatgeEnNormal;
        }
    }


    /**
     * Mètode per calcular el percentatge final per a una cosa dolenta segons la dificultat (+ o - 20%)
     * @param percentatgeEnNormal El percentatge que hi ha en dificultat normal.
     * @return El percentatge introduït més o menys 20% d'aquest segons la dificultat
     */
    public static int percentatgeFinalObjecteDolent(int percentatgeEnNormal) {
        int percentatgeFinal;

        if (Dificultat.nivellDeDificultat == 'D') {

            return percentatgeFinal = percentatgeEnNormal + (int)(percentatgeEnNormal * 0.2);

        } else if (Dificultat.nivellDeDificultat == 'F') {

            return percentatgeFinal = percentatgeEnNormal - (int)(percentatgeEnNormal * 0.2);

        }  else {

            return percentatgeEnNormal;
        }
    }

    // Per valors generals

    /**
     * Mètode per calcular el valor final per a una cosa bona segons la dificultat (+ o - 20%)
     * @param valorEnNormal El valor que hi ha en dificultat normal.
     * @return El valor introduït més o menys 20% d'aquest segons la dificultat
     */
    public static int valorFinalObjecteBo(int valorEnNormal) {
        int valorFinal;

        if (Dificultat.nivellDeDificultat == 'D') {

            return valorFinal = valorEnNormal - (int)(valorEnNormal * 0.2);

        } else if (Dificultat.nivellDeDificultat == 'F') {

            return valorFinal = valorEnNormal + (int)(valorEnNormal * 0.2);

        } else {

            return valorEnNormal;
        }
    }

    /**
     * Mètode per calcular el valor final per a una cosa dolenta segons la dificultat (+ o - 20%)
     * @param valorEnNormal El valor que hi ha en dificultat normal.
     * @return El valor introduït més o menys 20% d'aquest segons la dificultat
     */
    public static int valorFinalObjecteDolent(int valorEnNormal) {
        int valorFinal;

        if (Dificultat.nivellDeDificultat == 'D') {

            return valorFinal = valorEnNormal + (int)(valorEnNormal * 0.2);

        } else if (Dificultat.nivellDeDificultat == 'F') {

            return valorFinal = valorEnNormal - (int)(valorEnNormal * 0.2);

        }  else {

            return valorEnNormal;
        }
    }


    // // Getters i Setters
    public static char getNivellDeDificultat() {
        return nivellDeDificultat;
    }

    public static void setNivellDeDificultat(char nivellDeDificultat) {
        Dificultat.nivellDeDificultat = nivellDeDificultat;
    }
}
