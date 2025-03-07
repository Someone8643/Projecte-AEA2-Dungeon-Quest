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
        System.out.println("Estàs preparat per jugar? (s/n):");
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

        // Omplir la matriu amb sales (for de matriu i crear sala per cada pos)
        for (int fil = 0; fil < matriuMasmorra.length; fil++) {
            for (int col = 0; col < matriuMasmorra.length; col++) {

                // Crear una sala per aquesta pos
                // Crearem un tresor i un monstre per la sala sol si ha sortit per probabilitat

                Sala salaNova = new Sala();

                // Crear tresor per la sala si en té





                matriuMasmorra[fil][col] =



            }
        }

        /*
        Aleatori.generarIntAleatoriRang();

        Dificultat.getNivellDeDificultat()
        */


        // Posicionar el personatge a la sala superior esquerra de la masmorra









    }

}
