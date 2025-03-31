import java.util.Scanner;

public class Masmorra {

    // TODO eliminar enunciat en acabar i posar breu descripció del joc en general
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

        // Omplir la masmorra
        Sala.omplirMatriuSales(matriuMasmorra);

        /* Codi antic
        // Omplir la matriu amb sales (for de matriu i crear sala per cada pos)
        for (int fil = 0; fil < matriuMasmorra.length; fil++) {
            for (int col = 0; col < matriuMasmorra[fil].length; col++) {

                // Crear una sala per aquesta posició i posar dintre de la matriu.
                // Recorda que dintre de la sala ja es crea un tresor i monstre aleatòri.
                matriuMasmorra[fil][col] = new Sala();
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
        System.out.println();

        if (scanner.nextLine().equalsIgnoreCase("s")) {

            System.out.println("Creant personatge aleatori...");
            System.out.println();
            // Crear a un personatge aleatori
            jugador = new Personatge();

            // Mostrar
            System.out.println("El teu personatge és:");
            System.out.println(jugador);
            System.out.println();

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
                System.out.println("1 - Millorar vida en 10 punts.");
                System.out.println("2 - Millorar atac en 5 punts.");
                System.out.println("3 - Millorar agilitat en 2 punts.");
                System.out.println("4 - Millorar força en 1 punt.");
                System.out.println();

                System.out.println("Actualment tens:");
                System.out.println("Vida: " + jugador.getVida());
                System.out.println("Atac: " + jugador.getAtac());
                System.out.println("Agilitat: " + jugador.getAgilitat());
                System.out.println("Força: " + jugador.getForsa());
                System.out.println();

                System.out.print("Introdueix la teva elecció (introdueix el número): ");
                int respostaPunts = scanner.nextInt();
                System.out.println();

                // Segons l'opció, es dedica punts a una estadística o una altra
                // Utilitzar getters i setters
                switch(respostaPunts) {
                    case 1:

                        jugador.setVida(jugador.getVida() + 10);

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




        // tenim al jugador i a la masmorra amb sales, tresors i monstres.
        // TODO revisar generació de sales



        // Entrar en el bucle principal del programa
        // Sol sortirem si hi ha gameOver
        boolean gameOver = false;

        // Variable per mostrar al final la causa de mort.
        String causaMort = "una causa desconeguda";

        // Donar la benvinguda a la masmorra
        System.out.println("Benvingut a la masmorra!");
        System.out.println();

        while (!gameOver) {

            // Obtenim la sala actual per a futurs usos
            Sala salaActual = matriuMasmorra[jugador.getPosicioY()][jugador.getPosicioX()];


            int pos[] = jugador.getPosicio(); // TODO arreglar referències a aquesta variable (utilitzar getPosicio de X i Y)


            // Dir la sala en que es troba (inclòs si és l'inici)
            System.out.println("Et trobes a la sala " + (jugador.getPosicioX() + 1) + " del nivell " + (jugador.getPosicioY() + 1) + ". La sala té aquesta forma (on & ets tu i les fleches una porta):");

            mostrarSalaGraficament(salaActual);
            System.out.println();

            /*
            // TEST
            System.out.println("aaa");
            for (int fil = 0; fil < matriuMasmorra.length; fil++) {
                for (int col = 0; col < matriuMasmorra[fil].length; col++) {
                    mostrarSalaGraficament(matriuMasmorra[fil][col]);
                    System.out.print(" --- ");
                }
                System.out.println("+++++++++++++++++");
            }
            */


            // TODO
            // Mostrar menú d'opcions (moure, explorar...). Mirar abans si hi ha gameOver.
            // Dintre de cada opció, començar una cosa i acabar-la.

            System.out.println("Opcions:");
            System.out.println("1. Explorar la sala actual (si no l'has explorada).");
            System.out.println("2. Moure cap a una altra sala.");
            System.out.println("3. Entrar en combat amb un monstre de la sala (si n'hi ha).");
            System.out.println("4. Mostrar estadístiques.");
            System.out.println();

            System.out.print("Introdueix una opció: ");
            int respostaMenu = scanner.nextInt();
            scanner.nextLine(); // Pel nextInt
            System.out.println();

            // Mentres incorrecte, preguntar
            while (respostaMenu < 1 || respostaMenu > 4) {

                System.out.print("Opció incorrecta, introdueix 1, 2, 3 o 4: ");
                System.out.println("Introdueix una opció: ");
                respostaMenu = scanner.nextInt();
                scanner.nextLine(); // Pel nextInt
            }

            switch(respostaMenu) {
                case 1:

                    // OP 1
                    // EXPLORAR
                    // Cridar mètode d'explorar de Personatge. No mostrar l'opció si la sala ja està explorada.
                    int posiX=jugador.getPosicio()[0];
                    int posiY=jugador.getPosicio()[1];
                    if (!matriuMasmorra[posiX][posiY].isExplorada()){
                        System.out.println("explorant sala");
                        System.out.println(jugador.explorar(matriuMasmorra[posiX][posiY]));
                    }else {
                        System.out.println("sala ja esta explorada");
                    }

                    break;
                case 2:

                    // OP 2
                    // MOVIMENT
                    // Preguntar a quina direcció vol moure i utilitzar mètode de Personatge

                    // SOLUCIÓ TEMPORAL

                    System.out.println("Direcció (N, E, S, O):");
                    char respostaDireccio = scanner.nextLine().charAt(0);

                    int direccioNum = 0;

                    switch(respostaDireccio) {
                        case 'N', 'n':

                            direccioNum = 0;
                            break;
                        case 'E', 'e':

                            direccioNum = 1;
                            break;
                        case 'S', 's':

                            direccioNum = 2;
                            break;
                        case 'O', 'o':

                            direccioNum = 3;
                            break;
                        default:
                    }


                    // Mentres no hi hagi porta, seguir preguntant
                    while (!salaActual.isPortaDireccio(direccioNum)) {

                        System.out.println("Incorrecte");
                        System.out.println("Direcció (N, E, S, O):");
                        respostaDireccio = scanner.nextLine().charAt(0);

                        direccioNum = 0;

                        switch(respostaDireccio) {
                            case 'N', 'n':

                                direccioNum = 0;
                                break;
                            case 'E', 'e':

                                direccioNum = 1;
                                break;
                            case 'S', 's':

                                direccioNum = 2;
                                break;
                            case 'O', 'o':

                                direccioNum = 3;
                                break;
                            default:
                        }


                    }

                    jugador.moureDireccio(respostaDireccio);

                    // Revisar moviment (si hi ha porta i si es fora matriu, gameOver)
                    // TODO acabar



                    if (!dintreMatriu(matriuMasmorra, jugador.getPosicioY(), jugador.getPosicioX())) {

                        gameOver = true;
                    }


                    // Passar direcció al metode de moure

                    break;
                case 3:

                    // OP 3
                    // COMBAT

                    // Entrar en combat amb un monstre si a la sala n'hi ha
                    pos = jugador.getPosicio();

                    if (matriuMasmorra[pos[0]][pos[1]].getMonstre() != null) {

                        combatPersonatgeMonstre(jugador, matriuMasmorra[pos[0]][pos[1]].getMonstre());

                        // Combat acabat, hem de fer gameOver si jugador mort i si monstre mort, treure de la sala
                        if (jugador.getVida() <= 0) {
                            gameOver = true;
                            causaMort = "matat per monstre";
                        }

                        if (matriuMasmorra[pos[0]][pos[1]].getMonstre().getVida() <= 0) {

                            matriuMasmorra[pos[0]][pos[1]].setMonstre(null);
                        }

                    } else {

                        // Dir que no hi ha monstre
                        System.out.println("No hi ha monstre en aquesta sala...");
                        System.out.println();
                    }

                    break;
                case 4:

                    // OP 4
                    // MOSTRAR VIDA, SALUT, INVENTARI...

                    System.out.println("Les teves estadístiques:");
                    System.out.println();

                    System.out.println(jugador);
                    System.out.println();

                    break;
                default:
            }





            //System.out.println("TEST");
            //gameOver = true;
        }

        // El joc ha acabat
        System.out.println();
        System.out.println("-------------------");
        System.out.println("-----GAME OVER-----");
        System.out.println("-------------------");
        System.out.println();

        // TODO Estadístiques
        // Si ha mort, dir la causa
        if (jugador.getVida() <= 0) {

            System.out.println("Has mort per culpa de: " + causaMort + ".");
            System.out.println();

        } else {

            System.out.println("Has sobreviscut la masmorra!");
            System.out.println();
            System.out.println("Felicitats!");
            System.out.println();
        }
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

        // Donar informació (del monstre i personatge) (sol dir vida i atac de cadascú)
        System.out.println("Has entrat en combat!");
        System.out.println("Et trobes amb el monstre " + monstre.getNom() + " amb " + monstre.getVida() + " punts de vida i " + monstre.getAtac() + " punts d'atac.");
        System.out.println("Recorda que tu tens " + personatge.getVida() + " punts de vida i " + personatge.getAtac() + " punts d'atac.");
        System.out.println("Sort!");
        System.out.println();

        // Esperar a que usuari vulgui continuar
        System.out.print("Introdueix Enter per continuar...");
        scanner.nextLine();
        System.out.println();

        while (continuar) {

            // Començar un atac
            // Atacarà primer sempre el Personatge
            System.out.println("El personatge " + personatge.getNom() + " ataca a " + monstre.getNom() + " amb una ferida de " + personatge.atacarMonstre(monstre) + " punts de vida!");
            System.out.println();

            // Sol continuar si segueix viu el monstre (vida > 0)
            continuar = monstre.getVida() > 0;

            if (!continuar) {

                // Ha perdut el monstre
                System.out.println("El monstre " + monstre.getNom() + " ha perdut!");
                System.out.println();

                // Esperar a que usuari vulgui continuar
                System.out.print("Introdueix Enter per continuar...");
                scanner.nextLine();
                System.out.println();

            } else {

                // Torn del monstre
                System.out.println("El monstre " + monstre.getNom() + " ataca a " + personatge.getNom() + " amb una ferida de " + monstre.atacarPersonatge(personatge) + " punts de vida!");
                System.out.println();

                // Esperar a que usuari vulgui continuar
                System.out.print("Introdueix Enter per continuar...");
                scanner.nextLine();
                System.out.println();

                continuar = personatge.getVida() > 0;

                if (!continuar) {

                    // Ha perdut el personatge
                    System.out.println("El personatge " + personatge.getNom() + " ha perdut!");

                    // Esperar a que usuari vulgui continuar
                    System.out.print("Introdueix Enter per continuar...");
                    scanner.nextLine();
                    System.out.println();

                } else { // Es continua si el monstre o el personatge no ha perdut

                    // Donar informació de la vida actual dels dos
                    System.out.println("Punts restants de vida dels combatents:");
                    System.out.println("El personatge " + personatge.getNom() + " té: " + personatge.getVida());
                    System.out.println("El monstre " + monstre.getNom() + " té: " + monstre.getVida());
                    System.out.println();

                    // Preguntar si vol continuar el combat (l'altra opció és fugir)
                    System.out.print("Vols continuar el combat? (introdueix s/n on n és fugir): ");
                    char respostaContinuar = scanner.nextLine().charAt(0);
                    System.out.println();

                    // Mentres no sigui correcta la resposta, seguir preguntant
                    while (respostaContinuar != 'S' && respostaContinuar != 's' && respostaContinuar != 'N' && respostaContinuar != 'n') {

                        System.out.print("Resposta incorrecta! (introdueix s o n): ");
                        respostaContinuar = scanner.nextLine().charAt(0);
                        System.out.println();
                    }

                    // Si és que no, s'aplica la penalització i s'acaba el combat.
                    if (respostaContinuar == 'N' || respostaContinuar == 'n') {

                        // Fer que el Personatge rebi penalització

                        System.out.println("El monstre " + monstre.getNom() + " ataca al personatge " + personatge.getNom() + " amb " + monstre.penalitzarPersonatge(personatge) + " punts mentres aquest s'escapa!");
                        System.out.println();

                        // si just ha mort, dir-ho
                        if (personatge.getVida() <= 0) {

                            System.out.println("El personatge " + personatge.getNom() + " ha perdut en intentar fugir!");
                        }

                        // S'acaba el combat perquè el personatge ha fugit
                        continuar = false;
                    }
                }
            }
        }
    }


    /**
     * Funció que mostra gràficament una sala. TODO Considerar moure aquesta funció a la classe Sala
     * @param salaAMostrar La sala a mostrar.
     */
    public static void mostrarSalaGraficament(Sala salaAMostrar) {

        // Mostrar direccions de la sala
        // Les portes (↑, →, ↓, ←) se mostren quan existeixen (true en el array de portes de Sala).
        System.out.println(" ┌───────────┐ ");
        System.out.println(" │    " + (salaAMostrar.isPortaDireccio(0) ? "↑" : " ") + "    \t │ "); // Norte
        System.out.println(" │ " + (salaAMostrar.isPortaDireccio(3) ? "←" : " ") + "  &  " + (salaAMostrar.isPortaDireccio(1) ? "→" : " ") + " \t │ "); // Oeste & Este
        System.out.println(" │    " + (salaAMostrar.isPortaDireccio(2) ? "↓" : " ") + "    \t │ "); // Sur
        System.out.println(" └───────────┘ ");
    }


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