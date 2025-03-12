import java.util.Scanner;

public class Masmorra {

    // Finalment, hi haurà una classe masmorra (estàtica) per controlar el joc:
    // Contenir els arrays de tots els tresors i monstres que hi haurà al joc.
    // Crear la masmorra (MxN) i omplir-la de sales aleatòriament.
    // Impressió de la masmorra amb les sales explorades (*), sales sense explorar (-) i posició actual del personatge (&).
    // Mostrar opcions (moure, explorar i/o atacar).
    // Comprovar si el joc ha finalitzat o no i mostrar resultats.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvingut a DungeonQuest!");
        System.out.print("Estàs preparat per jugar? (s/n): ");
        String respostaJugar = scanner.nextLine();

        while (!respostaJugar.equalsIgnoreCase("s")) {

            System.out.println("Quan estiguis preparat, introdueix s.");
            respostaJugar = scanner.nextLine();
        }

        System.out.println();
        System.out.println("-------------------");
        System.out.println("----DungeonQuest---");
        System.out.println("-------------------");
        System.out.println();

        // Seleccionar una dificultat

        System.out.println("Selecciona una dificultat:");
        System.out.println("D = Difícil");
        System.out.println("N = Normal");
        System.out.println("F = Fàcil");

        System.out.print("La teva elecció: ");
        char dificultat = scanner.nextLine().charAt(0);

        // Mentres no sigui correcta la resposta, seguir preguntant
        while (dificultat != 'D' && dificultat != 'N' && dificultat != 'F') {

            System.out.print("Resposta incorrecta! (introdueix D, N o F en majúscules): ");
            dificultat = scanner.nextLine().charAt(0);
        }

        Dificultat.setNivellDeDificultat(dificultat);


        // Crear masmorra, amb totes les dades aleatories segons els constructors de cada cosa

        // Crear la matriu de masmorra de mida aleatòria (min 5 x 5)
        Sala[][] matriuMasmorra = new Sala[Aleatori.generarIntAleatoriRang(5, 10)][Aleatori.generarIntAleatoriRang(5, 10)];

        // test
        // System.out.println(matriuMasmorra.length + " " + matriuMasmorra[0].length);

        // Omplir la matriu amb sales (for de matriu i crear sala per cada pos)
        for (int fil = 0; fil < matriuMasmorra.length; fil++) {
            for (int col = 0; col < matriuMasmorra[fil].length; col++) {

                // Crear una sala per aquesta posició.
                // Recordar que dintre de la sala ja es crea un tresor i monstre aleatòri.
                Sala salaNova = new Sala();

                // test
                // System.out.println("a" + fil + col);

                // Guardar a la masmorra
                matriuMasmorra[fil][col] = salaNova;
            }
        }

        /*
        testos, ignorar
        Aleatori.generarIntAleatoriRang();

        Dificultat.getNivellDeDificultat()
        */

        for (int fil = 0; fil < matriuMasmorra.length; fil++) {
            for (int col = 0; col < matriuMasmorra[fil].length; col++) {
                System.out.println(matriuMasmorra[fil][col]);
            }
        }


        // Crear el personatge, posició serà 0 0. Altres dades posicionar a 0 o demanar a l'usuari.



        // Entrar en en bucle principal del programa
        // Sol sortirem si hi ha gameOver




    }

    /**
     * Funció que comprova si una posició està dintre d'una matriu. POTSER NO VA AQUÍ PERÒ ÉS ÚTIL.
     * @param matriu Matriu a comprovar.
     * @param fil Filera.
     * @param col Columna.
     * @return Cert o fals segons si està dintre o no.
     */
    public static boolean dintreMatriu(Sala[][] matriu, int fil, int col) {

        return  (fil >= 0 && col >= 0) &&
                (fil < matriu.length && col < matriu.length);
    }
}