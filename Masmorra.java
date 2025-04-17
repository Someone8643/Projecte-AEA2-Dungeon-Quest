import java.util.Scanner;

public class Masmorra {

    // Breu descripció general:
    // El joc comença a la sala 1 1.
    // Has d'anar movent-te fins a trobar la sortida.
    // La sortida sempre estarà a l'última fila.
    // Les sales poden tenir monstres, tresors i pocions.
    // Els monstres són agressius i t'intentaran matar.
    // Per evitar-ho, et pots curar amb pocions en un temps tranquil.

    /*
    Modificacions en general:
    - Tots els tresors i monstres es generen de forma aleatòria.
    - Nivells de dificultat.
    - Sistema de millorar habilitats abans de començar.
    - Pocions per curar el personatge.
    - Combat canviat.
    - Generació de masmorra i sales completament diferent. Sempre hi haurà mínim un camí cap a la sortida.
    - Sortides sol en l'últim nivell.
    - Modificacions en molts valors.
    - Modificacions en altres detalls més petits.

    En general, el joc final és molt diferent del que s'havia proposat amb aquestes ampliacions.
     */

    public static void main(String[] args) {

        System.out.println();
        System.out.println("--------------------");
        System.out.println("----DungeonQuest----");
        System.out.println("--------------------");
        System.out.println("----Java Edition----");
        System.out.println("--------------------");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvingut a DungeonQuest!");
        System.out.print("Estàs preparat per jugar? (s/n): ");
        String respostaJugar = scanner.nextLine();
        System.out.println();

        while (!respostaJugar.equalsIgnoreCase("s")) {

            System.out.println("Quan estiguis preparat, introdueix s.");
            respostaJugar = scanner.nextLine();
        }

        // Seleccionar una dificultat
        System.out.println("Selecciona una dificultat:");
        System.out.println("D = Difícil");
        System.out.println("N = Normal");
        System.out.println("F = Fàcil");

        System.out.print("La teva elecció: ");
        String respostaDificultat = scanner.nextLine();

        // Mentres no sigui correcta la resposta, seguir preguntant
        while (!respostaDificultat.equalsIgnoreCase("D") && !respostaDificultat.equalsIgnoreCase("N") && !respostaDificultat.equalsIgnoreCase("F")) {

            System.out.print("Resposta incorrecta! (introdueix D, N o F): ");
            respostaDificultat = scanner.nextLine();
        }

        // Preparem per ser guardat com a char
        respostaDificultat = respostaDificultat.toUpperCase();

        Dificultat.setNivellDeDificultat(respostaDificultat.charAt(0));


        // Crear masmorra, amb totes les dades aleatories segons els constructors de cada classe

        // Crear la matriu de masmorra de mida aleatòria (min 3 x 3)
        Sala[][] matriuMasmorra = new Sala[Aleatori.generarIntAleatoriRang(3, Dificultat.valorFinalObjecteDolent(6))][Aleatori.generarIntAleatoriRang(3, Dificultat.valorFinalObjecteDolent(6))];

        // Omplir la masmorra
        Sala.omplirMatriuSales(matriuMasmorra);


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
            // En normal serà 6
            int puntsPersonatge = Dificultat.valorFinalObjecteBo(6);

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


        // Tenim al jugador i a la masmorra amb sales, tresors i monstres.


        // ---------Entrar en el bucle principal del programa
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

            System.out.println("----Sala----");

            // Dir la sala en que es troba (inclòs si és l'inici)
            System.out.println("Et trobes a la sala " + (jugador.getPosicioX() + 1) + " del nivell " + (jugador.getPosicioY() + 1) + ". La sala té aquesta forma (on & ets tu i les fleches una porta):");

            salaActual.mostrarSalaGraficament();
            System.out.println();

            if (salaActual.getMonstre() != null) {

                System.out.println("Perill! Hi ha un monstre a la sala! Si intentes explorar-la o fugir, entraràs en combat!");
                System.out.println();
            }

            if (salaActual.getTipus().equals("Pont")) {

                System.out.println("Aquesta sala és de tipus pont, per sortir hauràs de fer una tirada d'agilitat.");
                System.out.println();
            }

            if (salaActual.getTipus().equals("Teranyina")) {

                System.out.println("Aquesta sala és de tipus teranyina, per sortir hauràs de fer una tirada de força.");
                System.out.println();
            }

            // Mostrar menú d'opcions (moure, explorar...). Mirar abans si hi ha gameOver.
            // Dintre de cada opció, començar una cosa i acabar-la.

            System.out.println("----Opcions----");
            System.out.println("1. Explorar la sala actual (si no l'has explorada).");
            System.out.println("2. Moure cap a una altra sala.");
            System.out.println("3. Entrar en combat amb un monstre de la sala (si n'hi ha).");
            System.out.println("4. Mostrar estadístiques.");
            System.out.println("5. Mostrar mapa de la masmorra.");
            System.out.println("6. Utilitzar poció.");
            System.out.println();

            System.out.print("Introdueix una opció: ");
            int respostaMenu = scanner.nextInt();
            scanner.nextLine(); // Pel nextInt
            System.out.println();

            // Mentres incorrecte, preguntar
            while (respostaMenu < 1 || respostaMenu > 6) {

                System.out.print("Opció incorrecta, introdueix 1, 2, 3, 4, 5 o 6: ");
                System.out.println("Introdueix una opció: ");
                respostaMenu = scanner.nextInt();
                scanner.nextLine(); // Pel nextInt
            }

            switch(respostaMenu) {
                case 1:

                    // OP 1
                    // EXPLORAR
                    // Cridar mètode d'explorar de Personatge.

                    // Si hi ha un monstre, no deixar explorar i entrar en combat
                    if (salaActual.getMonstre() != null) {

                        System.out.println("Hi havia un monstre en aquesta sala!");
                        System.out.println();

                        // S'entra en combat
                        combatPersonatgeMonstre(jugador, salaActual.getMonstre());

                        // Combat acabat, hem de fer gameOver si jugador mort i si monstre mort, treure de la sala
                        // Si el jugador no ha mort, després pot tornar a decidir explorar la sala.
                        if (jugador.getVida() <= 0) {

                            System.out.println("Has mort en intentar explorar una sala amb un monstre!");
                            System.out.println();

                            gameOver = true;
                            causaMort = "matat per monstre";

                        } else {

                            System.out.println("Ara que no hi ha monstre, pots explorar la sala");
                            System.out.println();
                        }

                        if (salaActual.getMonstre().getVida() <= 0) {

                            salaActual.setMonstre(null);
                        }

                    } else {

                        if (!salaActual.isExplorada()) {

                            System.out.println("Explorant sala...");
                            System.out.println();

                            System.out.println(jugador.explorar(salaActual));
                            System.out.println();

                        } else { // Si està explorada, no deixar tornar a explorar

                            System.out.println("Aquesta sala ja està explorada!");
                            System.out.println();
                        }
                    }

                    // Esperar a que usuari vulgui continuar
                    System.out.print("Introdueix Enter per continuar...");
                    scanner.nextLine();
                    System.out.println();

                    break;
                case 2:

                    // OP 2
                    // MOVIMENT
                    // Preguntar a quina direcció vol moure i utilitzar mètode de Personatge

                    System.out.print("Introdueix una direcció (N, E, S, O) (Q per desistir): ");
                    String respostaDireccio = scanner.nextLine();
                    System.out.println();

                    // Mentres no escrigui Q per sortir i no hi hagi porta, continuar preguntant.
                    while ( !respostaDireccio.equalsIgnoreCase("Q") && !salaActual.isPortaDireccioChar(respostaDireccio.charAt(0))) {

                        System.out.println("Incorrecte, no hi ha porta cap aquesta direcció.");
                        System.out.print("Introdueix una direcció (N, E, S, O) (Q per desistir): ");
                        respostaDireccio = scanner.nextLine();
                        System.out.println();
                    }

                    // Si no ha dit que no vol moure (Q), podem continuar
                    if (!respostaDireccio.equalsIgnoreCase("Q")) {

                        // La resposta s'utilitza després de les comprovacions

                        // Comprovacions

                        // Si més endavant no vol continuar intentant travessar una teranyina o pont, acabar.
                        String respostaContinuar = "S";

                        // Si la sala no és del tipus normal, s'haurà de fer o una tirada de força o d'agilitat.
                        if (!salaActual.getTipus().equals("Normal")) {

                            if (salaActual.getTipus().equals("Teranyina")) {

                                System.out.println("La sala és de tipus teranyina, hauràs de fer una tirada de força per poder continuar!");

                                boolean escapar = false;

                                // Mentres vol continuar intentant-ho i no escapa, continuar intentant.
                                while (respostaContinuar.equalsIgnoreCase("S") && !escapar) {

                                    int resultat = Aleatori.generarIntAleatoriRang(1, 12);
                                    System.out.println("Has tret un " + resultat + "!");

                                    if (resultat <= jugador.getForsa()) {

                                        escapar = true;
                                        System.out.println("Has aconseguit escapar!");
                                        System.out.println();
                                    } else {

                                        System.out.println("Necessites treure un " + jugador.getForsa() + " o menys per escapar!");
                                        System.out.println();

                                        // Preguntar si vol continuar intentant-ho.
                                        System.out.println("Vols continuar intentant-ho?");
                                        System.out.println("Introdueix s per continuar.");
                                        respostaContinuar = scanner.nextLine();
                                    }
                                }

                            } else { // És de pont

                                System.out.println("La sala és de tipus pont, hauràs de fer una tirada de d'agilitat per poder continuar!");
                                System.out.println("Vigila! Cada intent fallit et farà mal!");
                                System.out.println();

                                boolean escapar = false;

                                // Si vol continuar i no escapa i segueixi tenint vida, seguir intentant.
                                while (respostaContinuar.equalsIgnoreCase("S") && !escapar && (jugador.getVida() > 0)) {

                                    int resultat = Aleatori.generarIntAleatoriRang(1, 12);
                                    System.out.println("Has tret un " + resultat + "!");

                                    if (resultat <= jugador.getAgilitat()) {

                                        escapar = true;
                                        System.out.println("Has aconseguit escapar!");
                                        System.out.println();

                                    } else {

                                        System.out.println("Necessites treure un " + jugador.getAgilitat() + " o menys per escapar!");
                                        System.out.println();

                                        // Generar aleatòriament el dany que pot fer el pont segons dificultat però amb mínim sempre de 1.
                                        int danyPont = Aleatori.generarIntAleatoriRang(1, Dificultat.valorFinalObjecteDolent(8));
                                        jugador.setVida(jugador.getVida() - 1);
                                        System.out.println("Has rebut " + danyPont + " punts de dany!");
                                        System.out.println();

                                        // Preguntar si vol continuar intentant (pot servir per si el jugador està a vida baixa i vol sortir per curar amb poció).
                                        System.out.println("Vols continuar intentant-ho? El teu nivell de vida és " + jugador.getVida() + " punts.");
                                        System.out.println("Introdueix s per continuar.");
                                        respostaContinuar = scanner.nextLine();
                                    }
                                } // o ha parat o ha escapat o ha mort.

                                // Si ha mort, gameOver (morir per culpa d'un pont és bastant trist)
                                if ((jugador.getVida() <= 0)) {

                                    System.out.println("Has mort per culpa de caure del pont!");
                                    causaMort = "caure repetidament d'un pont";
                                    gameOver = true;
                                }
                            }
                        }

                        // Si no ha mort pel pont i no ha deixat d'intentar el pont o teranyina i doncs ho ha superat, podem continuar.
                        if (!gameOver && respostaContinuar.equalsIgnoreCase("S")) {

                            // Si hi havia monstre, aplicar penalització abans de sortir i revisar per un gameOver.
                            if (salaActual.getMonstre() != null) {

                                System.out.println("El monstre de la sala t'ha atacat en fugir i t'ha fet " + salaActual.getMonstre().penalitzarPersonatge(jugador) + " punts de vida!");
                                System.out.println();
                            }

                            if (jugador.getVida() <= 0) {

                                System.out.println("El monstre t'ha matat en intentar fugir!");
                                System.out.println();

                                gameOver = true;
                                causaMort = "matat per monstre en intentar fugir d'una sala";

                            } else { // Es pot moure

                                // Finalment, passar direcció de la pregunta inicial al mètode de moure
                                jugador.moureDireccio(respostaDireccio.charAt(0));

                                // Si està fora de la matriu, és que ha sortit per una porta cap a fora i ha guanyat.
                                if (!dintreMatriu(matriuMasmorra, jugador.getPosicioY(), jugador.getPosicioX())) {

                                    gameOver = true;
                                }
                            }
                        }
                    }

                    // Esperar a que usuari vulgui continuar
                    System.out.print("Introdueix Enter per continuar...");
                    scanner.nextLine();
                    System.out.println();

                    break;
                case 3:

                    // OP 3
                    // COMBAT

                    // Entrar en combat amb un monstre si a la sala n'hi ha
                    if (matriuMasmorra[jugador.getPosicioY()][jugador.getPosicioX()].getMonstre() != null) {

                        combatPersonatgeMonstre(jugador, matriuMasmorra[jugador.getPosicioY()][jugador.getPosicioX()].getMonstre());

                        // Combat acabat, hem de fer gameOver si jugador mort i si monstre mort, treure de la sala
                        if (jugador.getVida() <= 0) {
                            gameOver = true;
                            causaMort = "matat per monstre";
                        }

                        if (matriuMasmorra[jugador.getPosicioY()][jugador.getPosicioX()].getMonstre().getVida() <= 0) {

                            matriuMasmorra[jugador.getPosicioY()][jugador.getPosicioX()].setMonstre(null);
                        }

                    } else {

                        // Dir que no hi ha monstre
                        System.out.println("No hi ha monstre en aquesta sala...");
                        System.out.println();
                    }

                    // Esperar a que usuari vulgui continuar
                    System.out.print("Introdueix Enter per continuar...");
                    scanner.nextLine();
                    System.out.println();

                    break;
                case 4:

                    // OP 4
                    // MOSTRAR VIDA, SALUT, INVENTARI...

                    System.out.println("Les teves estadístiques:");
                    System.out.println();

                    System.out.println(jugador);
                    System.out.println();

                    // Esperar a que usuari vulgui continuar
                    System.out.print("Introdueix Enter per continuar...");
                    scanner.nextLine();
                    System.out.println();

                    break;
                case 5:

                    // OP 5
                    // MOSTRAR MASMORRA

                    System.out.println("Mapa de la masmorra:");
                    System.out.println();

                    System.out.println("El '&' ets tu, '*' és una sala explorada i '-' és una sala no explorada.");
                    System.out.println();

                    mostrarMasmorra(matriuMasmorra, jugador.getPosicioX(), jugador.getPosicioY());
                    System.out.println();

                    // Esperar a que usuari vulgui continuar
                    System.out.print("Introdueix Enter per continuar...");
                    scanner.nextLine();
                    System.out.println();

                    break;
                case 6:

                    // OP 6
                    // UTILITZAR POCIÓ

                    if (jugador.utiltzarPocio()) {

                        System.out.println("Utilitzes una poció.");
                        System.out.println();

                    } else {

                        System.out.println("No tens pocions...");
                        System.out.println();
                    }

                    // Esperar a que usuari vulgui continuar
                    System.out.print("Introdueix Enter per continuar...");
                    scanner.nextLine();
                    System.out.println();

                    break;
                default:
            }
        }

        // El joc ha acabat (sol pot ser per haver mort o per haver sortit)
        System.out.println();
        System.out.println("-------------------");
        System.out.println("-----GAME OVER-----");
        System.out.println("-------------------");
        System.out.println();

        // Si ha mort, dir la causa
        if (jugador.getVida() <= 0) {

            System.out.println("Causa de mort: " + causaMort + ".");
            System.out.println();

            // Estadístiques
            System.out.println("Havies aconseguit " + jugador.getExperiencia() + " experiència.");
            System.out.println("Havies explorat el " + percentatgeExplorat(matriuMasmorra) + "% de sales de la masmorra.");
            System.out.println();

            System.out.println("Gràcies per jugar!");

        } else {

            System.out.println("Has sobreviscut la masmorra!");
            System.out.println();

            System.out.println("Felicitats!");
            System.out.println();

            System.out.println("T'ha quedat una nivell de vida de " + jugador.getVida() + " punts.");
            System.out.println("Has sortit amb " + jugador.totalTresors() + " tresors!");
            System.out.println("Amb els tresors que has aconseguit, tens el total equivalent en monedes de " + jugador.totalMonedes() + ".");
            System.out.println("Has explorat el " + percentatgeExplorat(matriuMasmorra) + "% de la masmorra.");
            System.out.println();

            System.out.println("Gràcies per jugar!");
        }
    }


    // // Funcions

    /**
     * Funció per calcular el percentatge total de sales explorades.
     * @param matriuMasmorra La matriu masmorra amb sales.
     * @return El percentatge de sales explorades.
     */
    public static double percentatgeExplorat(Sala[][] matriuMasmorra) {
        int totalSales = 0;
        int totalExplorat = 0;

        for (int fil = 0; fil < matriuMasmorra.length; fil++) {
            for (int col = 0; col < matriuMasmorra[fil].length; col++) {

                totalSales++;

                if (matriuMasmorra[fil][col].isExplorada()) {

                    totalExplorat++;
                }
            }
        }

        return (totalExplorat / (double)totalSales) * 100;
    }


    /**
     * Funció per fer un combat entre un Personatge i un Monstre, es mostrarà per pantalla missatges i s'acabarà quan un dels dos perdi o el personatge fugi.
     * @param personatge El Personatge que ataca.
     * @param monstre El Monstre que és atacat.
     */
    public static void combatPersonatgeMonstre(Personatge personatge, Monstre monstre) {

        Scanner scanner = new Scanner(System.in);

        // Variable per mirar si el personatge es pot curar una mica o no
        boolean personatgeFerit = false;

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

                // Incrementem l'experiència sempre
                personatge.setExperiencia( personatge.getExperiencia() + (int)( (monstre.getVidaInicial() * 0.5) + (monstre.getAtac() * 1.5) ) );
                System.out.println("Has guanyat " + ((monstre.getVidaInicial() * 2)) + " punts d'experiència!");
                System.out.println();

                // Regenerar una mica la vida (+ segons la dificultat, una mica més o menys del 20% que queda) menys si la dificultat és difícil. Sol si ha rebut mal en aquest combat.
                if (Dificultat.getNivellDeDificultat() != 'D' && personatgeFerit) {

                    personatge.curar(Dificultat.valorFinalObjecteBo((int)(personatge.getVida() * 0.20)));
                    System.out.println("Et cures una mica abans de continuar.");
                    System.out.println();
                }

                // Esperar a que usuari vulgui continuar
                System.out.print("Introdueix Enter per continuar...");
                scanner.nextLine();
                System.out.println();

            } else {

                // Torn del monstre
                System.out.println("El monstre " + monstre.getNom() + " ataca a " + personatge.getNom() + " amb una ferida de " + monstre.atacarPersonatge(personatge) + " punts de vida!");
                System.out.println();

                personatgeFerit = true;

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
                    String respostaContinuar = scanner.nextLine();
                    System.out.println();

                    // Mentres no sigui correcta la resposta, seguir preguntant
                    while (!respostaContinuar.equalsIgnoreCase("S") && !respostaContinuar.equalsIgnoreCase("N")) {

                        System.out.print("Resposta incorrecta! (introdueix s/n): ");
                        respostaContinuar = scanner.nextLine();
                        System.out.println();
                    }

                    // Si és que no, s'aplica la penalització i s'acaba el combat.
                    if (respostaContinuar.equalsIgnoreCase("N")) {

                        // Fer que el Personatge rebi penalització

                        System.out.println("El monstre " + monstre.getNom() + " ataca al personatge " + personatge.getNom() + " amb " + monstre.penalitzarPersonatge(personatge) + " punts mentres aquest s'escapa!");
                        System.out.println();

                        // si just ha mort, dir-ho
                        if (personatge.getVida() <= 0) {

                            System.out.println("El personatge " + personatge.getNom() + " ha perdut en intentar fugir del combat!");
                        }

                        // S'acaba el combat perquè el personatge ha fugit
                        continuar = false;
                    }
                }
            }
        }
    }


    public static void mostrarMasmorra(Sala[][] matriuMasmorra, int posXJugador, int posYJugador) {

        for (int fil = 0; fil < matriuMasmorra.length; fil++) {
            for (int col = 0; col < matriuMasmorra[fil].length; col++) {

                // Dibuixar una sala
                System.out.print("|");

                if (fil == posYJugador && col == posXJugador) {
                    System.out.print("&");
                } else {

                    if (matriuMasmorra[fil][col].isExplorada()) {

                        System.out.print("*");

                    } else {

                        System.out.print("-");
                    }
                }

                System.out.print("|\t");
            }
            System.out.println();
        }
    }

    /**
     * Funció que comprova si una posició està dintre d'una matriu.
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