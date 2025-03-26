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
        char respostaDificultat = scanner.nextLine().charAt(0);

        // Mentres no sigui correcta la resposta, seguir preguntant
        while (respostaDificultat != 'D' && respostaDificultat != 'N' && respostaDificultat != 'F') {

            System.out.print("Resposta incorrecta! (introdueix D, N o F en majúscules): ");
            respostaDificultat = scanner.nextLine().charAt(0);
        }

        Dificultat.setNivellDeDificultat(respostaDificultat);


        // Crear masmorra, amb totes les dades aleatories segons els constructors de cada classe

        // Crear la matriu de masmorra de mida aleatòria (min 5 x 5)
        Sala[][] matriuMasmorra = new Sala[Aleatori.generarIntAleatoriRang(5, 10)][Aleatori.generarIntAleatoriRang(5, 10)];

        // Omplir la matriu amb sales (for de matriu i crear sala per cada pos)
        for (int fil = 0; fil < matriuMasmorra.length; fil++) {
            for (int col = 0; col < matriuMasmorra[fil].length; col++) {

                // Crear una sala per aquesta posició i posar dintre de la matriu.
                // Recorda que dintre de la sala ja es crea un tresor i monstre aleatòri.
                matriuMasmorra[fil][col] = new Sala();
            }
        }

        /*
        testos, ignorar
        Aleatori.generarIntAleatoriRang();

        Dificultat.getNivellDeDificultat()
        */
/*

        for (int fil = 0; fil < matriuMasmorra.length; fil++) {
            for (int col = 0; col < matriuMasmorra[fil].length; col++) {
                System.out.println(matriuMasmorra[fil][col]);
            }
        }
*/

        // // // Creació del personatge

        // Crear el personatge, posició serà 0 0. Altres dades posicionar a 0 o demanar a l'usuari.
        System.out.println();
        System.out.println("----Creació de personatge----");
        System.out.println();

        Personatge jugador;

        System.out.print("Vols crear el teu personatge de forma aleatòria? (s/n): ");

        if (scanner.nextLine().equalsIgnoreCase("s")) {

            System.out.println("Creant personatge aleatori...");
            // Crear a un personatge aleatori
            jugador = new Personatge();

        } else {

            // VIGILAR AMB ELS NEXTLINE

            System.out.println();
            System.out.println("--Defineix el teu personatge--");
            System.out.println();

            // Preguntar el nom i guardar per a quan es crea l'objecte
            System.out.print("Escriu un nom per al teu personatge: ");
            String respostaNom = scanner.nextLine();

            // Crear el personatge, certes estadístiques són aleatòries
            jugador = new Personatge(respostaNom);

            System.out.println();
            System.out.println("--Elegir quines habilitats millorar--");
            System.out.println();

            // Decidir quants punts té l'usuari segons la dificultat:
            // En normal serà 4
            int puntsPersonatge = Dificultat.valorFinalObjecteBo(4);

            // Mentres no tingui 0 punts, seguirem preguntant a quina estadística hi vol dedicar punts
            while (puntsPersonatge != 0) {
                System.out.println("Tens " + puntsPersonatge + " punts per destinar-los a una estadística del teu personatge:");
                System.out.println();

                // Mostrar menú.
                System.out.println("Decideix a què dedicar-ho (cada millora sol costa un punt):");
                System.out.println("1 - Millorar vida en 5 punts.");
                System.out.println("2 - Millorar atac en 5 punts.");
                System.out.println("3 - Millorar agilitat en 2 punts.");
                System.out.println("4 - Millorar força en 1 punt.");
                System.out.println();
                System.out.println("Actualment tens:");
                System.out.println("Vida: " + jugador.getVida());
                System.out.println("Atac: " + jugador.getAtac());
                System.out.println("Agilitat: " + jugador.getAgilitat());
                System.out.println("Força: " + jugador.getForsa());

                System.out.println("Introdueix la teva elecció (introdueix el número): ");
                int respostaPunts = scanner.nextInt();

                // Segons l'opció, es dedica punts a una estadística o una altra
                // Utilitzar getters i setters
                switch(respostaPunts) {
                    case 1:

                        jugador.setVida(jugador.getVida() + 5);

                        puntsPersonatge--;
                        break;
                    case 2:

                        jugador.setAtac(jugador.getAtac() + 5);

                        puntsPersonatge--;
                        break;
                    case 3:

                        jugador.setAgilitat(jugador.getAgilitat() + 2);

                        puntsPersonatge--;
                        break;
                    case 4:

                        jugador.setForsa(jugador.getForsa() + 1);

                        puntsPersonatge--;
                        break;
                    default:
                        System.out.println("Aquesta opció no existeix!");
                }

                // Pel nextInt
                scanner.nextLine();
            }

            // Ara que la força ja té el valor final, ja es pot crear el array de Tresors
            jugador.setEquipament(new Tresor[jugador.getForsa()]);
        }


        System.out.println(jugador);

        // tenim al jugador i a la masmorra amb sales, tresors i monstres.







        // Entrar en el bucle principal del programa
        // Sol sortirem si hi ha gameOver
        boolean gameOver = false;

        // Variable per mostrar al final la causa de mort.
        String causaMort = "causa desconeguda";

        // Donar la benvinguda a la masmorra

        while (!gameOver) {

            // Dir la sala en que es troba (inclòs si és l'inici)



            // TODO
            // Mostrar menú d'opcions (moure, explorar...). Mirar abans si hi ha gameOver.
            // Dintre de cada opció, començar una cosa i acabar-la.

            System.out.println("aaa tests digues 1, 2, 3, 4");

            // Fer una opció o altra segons la resposta
            int respostaMenu = scanner.nextInt();
            scanner.nextLine();

            switch(respostaMenu) {
                case 1:

                    // OP 1
                    // EXPLORAR
                    // Cridar mètode d'explorar de Personatge. No mostrar l'opció si la sala ja està explorada.

                    break;
                case 2:

                    // OP 2
                    // MOVIMENT
                    // Preguntar a quina direcció vol moure i utilitzar mètode de Personatge
                    System.out.println("Direcció (N, E, S, O):");
                    jugador.moureDireccio(scanner.nextLine().charAt(0));

                    // testos
                    //int pos[] = jugador.getPosicio();
                    //System.out.println(pos[0]);
                    //System.out.println(pos[1]);

                    // Revisar moviment (si hi ha porta i si es fora matriu, gameOver)

                    // Passar direcció al metode de moure

                    break;
                case 3:

                    // OP 3
                    // COMBAT

                    // Entrar en combat amb un monstre si a la sala n'hi ha
                    int pos[] = jugador.getPosicio();

                    if (matriuMasmorra[pos[0]][pos[1]].getMonstre() != null) {

                        combatPersonatgeMonstre(jugador, matriuMasmorra[pos[0]][pos[1]].getMonstre());

                        // Combat acabat, hem de fer gameOver si jugador mort i si monstre mort, treure de la sala
                        if (jugador.getVida() <= 0) {
                            gameOver = true;
                        }

                        if (matriuMasmorra[pos[0]][pos[1]].getMonstre().getVida() <= 0) {

                            matriuMasmorra[pos[0]][pos[1]].setMonstre(null);
                        }
                    }

                    break;
                case 4:

                    // OP 4
                    // MOSTRAR INVENTARI

                    break;
                default:
            }















            //System.out.println("TEST");
            //gameOver = true;
        }

        // El joc ha acabat
        System.out.println("----GAME OVER----");

        // TODO Estadístiques
    }


    // // Funcions

    /**
     * Funció per fer un combat entre un Personatge i un Monstre, es mostrarà per pantalla missatges i s'acabarà quan un dels dos perdi o el personatge fugi.
     * @param personatge El Personatge que ataca.
     * @param monstre El Monstre que és atacat.
     */
    public static void combatPersonatgeMonstre(Personatge personatge, Monstre monstre) {

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {

            // Donar informació (del monstre i personatge) (sol dir vida i atac de cadascú)
            // TODO
            System.out.println("aaa dir vida");
            System.out.println();

            // Començar un atac
            // Atacarà primer sempre el Personatge
            System.out.println("El personatge " + personatge.getNom() + " ataca a " + monstre.getNom() + " amb una ferida de " + personatge.atacarMonstre(monstre) + " punts de vida!");
            System.out.println();

            // Sol continuar si segueix viu (vida > 0)

            continuar = personatge.getVida() > 0;

            if (!continuar) {

                // Ha perdut el personatge
                System.out.println("El personatge " + personatge.getNom() + " ha perdut!");
                System.out.println();

            } else {

                // Torn del monstre
                System.out.println("El monstre " + monstre.getNom() + " ataca a " + personatge.getNom() + " amb una ferida de " + monstre.atacarPersonatge(personatge) + " punts de vida!");
                System.out.println();

                // Esperar a que usuari vulgui continuar
                System.out.println("Introdueix Enter per continuar...");
                scanner.nextLine();
                System.out.println();

                continuar = monstre.getVida() > 0;

                if (!continuar) {

                    // Ha perdut el monstre
                    System.out.println("El monstre " + monstre.getNom() + " ha perdut!");


                } else { // Es continua si el monstre o el personatge no ha perdut

                    // Donar informació de la vida actual dels dos


                    // Preguntar si vol continuar el combat (l'altra opció és fugir)
                    System.out.println("Vols continuar el combat? (introdueix s/n on n és fugir)");
                    char respostaContinuar = scanner.nextLine().charAt(0);

                    // Mentres no sigui correcta la resposta, seguir preguntant
                    while (respostaContinuar != 'S' && respostaContinuar != 's' && respostaContinuar != 'N' && respostaContinuar != 'n') {

                        System.out.print("Resposta incorrecta! (introdueix s o n): ");
                        respostaContinuar = scanner.nextLine().charAt(0);
                    }

                    // Si és que no, s'aplica la penalització i s'acaba el combat.
                    if (respostaContinuar == 'N' || respostaContinuar == 'n') {

                        // Fer que el Personatge rebi penalització
                        monstre.penalitzarPersonatge(personatge);

                        // si just ha mort, dir-ho
                        if (personatge.getVida() <= 0) {

                            System.out.println("El personatge " + personatge.getNom() + " ha perdut en intentar fugir!");
                        }

                        // S'acaba el combat
                        continuar = false;
                    }
                }
            }
        }
    }



    // Funció per...


















    /**
     * Funció que comprova si una posició està dintre d'una matriu. TODO POTSER NO VA AQUÍ PERÒ ÉS ÚTIL.
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