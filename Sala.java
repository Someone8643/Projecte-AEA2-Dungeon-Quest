
public class Sala {
    // // Propietats

    private String tipus; // Tipus: "Normal", "Pont", "Teranyina"
    private Tresor tresor;
    private Monstre monstre;
    private boolean[] portes = new boolean[4];
    // 0 = Nord
    // 1 = Est
    // 2 = Sud
    // 3 = Oest
    // (es comença del Nord i es va en sentit de les agulles del rellotge)
    private boolean explorada;
    private boolean tePocio;

    // // Constructors
    public Sala(String tipus, Tresor tresor, Monstre monstre, boolean[] portes, boolean explorada, boolean tePocio) {
        this.tipus = tipus;
        this.tresor = tresor;
        this.monstre = monstre;
        this.portes = portes;
        this.explorada = explorada;
        this.tePocio = tePocio;
    }

    // Constructor de sala que ho genera de forma aleatòria
    public Sala() {

        int resultatAleatori = Aleatori.generarIntAleatoriRang(0, 100);

        if (resultatAleatori <= 70) {

            this.tipus = "Normal";

        } else if (resultatAleatori > 70 && resultatAleatori <= 85) {

            this.tipus = "Pont";

        } else {

            this.tipus = "Teranyina";
        }

        // Probabilitat del 50% en normal de tenir tresor (s'ha de generar un objecte tresor amb 50% de fer-se).
        if (Aleatori.percentatgeProbabilitat(Dificultat.valorFinalObjecteBo(50))) {
            this.tresor = new Tresor();
        }

        // Probabilitat del 50% en normal de tenir poció
        if (Aleatori.percentatgeProbabilitat(Dificultat.valorFinalObjecteBo(50))) {
            this.tePocio = true;
        }

        // Probabilitat del 50% en normal de tenir monstre (s'ha de generar un objecte monstre amb 50% de fer-se).
        if (Aleatori.percentatgeProbabilitat(Dificultat.valorFinalObjecteDolent(50))) {
            this.monstre = new Monstre();
        }


        // Assignem les portes:

        // Sempre es generarà porta cap a l'est i oest però no cap amunt o cap avall.
        this.portes[1] = true;
        this.portes[3] = true;

        /* codi antic
        // Primer, assegurem que mínim hi ha una porta (en qualsevol de les direccions)
        portes[Aleatori.generarIntAleatoriRang(0,3)] = true;

        // Ara, passem pel array i amb probabilitat del 50% (tirar moneda) posarem una altra porta.
        for (int i = 0; i < portes.length; i++) {

            // Si no hi ha porta, probabilitat de 50% de posar porta
            if (!portes[i]) {
                portes[i] = Aleatori.tirarMoneda();
            }
        }

         */
    }


    // // Mètodes

    /**
     * Mètode per omplir una matriu amb sales, per crear una masmorra.
     * @param matriu
     */
    public static void omplirMatriuSales(Sala[][] matriu) {

        // Recorrer la matriu i omplir i amb condicions modificar les portes per assegurar que hi ha sortida i que sol hi ha sortida a l'última filera.

        // Primer, omplirem la matriu amb sales aleatòries del constructor
        for (int fil = 0; fil < matriu.length; fil++) {
            for (int col = 0; col < matriu[fil].length; col++) {
                matriu[fil][col] = new Sala();
            }
        }


        // Ara, revisarem els costats (esquerra i dreta) per eliminar sortides a l'exterior.

        // Eliminar portes d'oest
        for (int fil = 0; fil < matriu.length; fil++) {

            matriu[fil][0].setPortaDireccio(3, false);
        }

        // Eliminar portes de l'est
        for (int fil = 0; fil < matriu.length; fil++) {

            matriu[fil][(matriu[fil].length - 1)].setPortaDireccio(1, false);
        }


        // Per últim, afegirem portes per anar cap avall i afegirem una única sortida en l'última filera.

        // En totes les fileres *menys l'última*, hi poden haver fins a un màxim de 2 portes cap avall amb un mínim d'una entre qualsevol de les sales de la filera.
        for (int fil = 0; fil < (matriu.length - 1); fil++) {

            // Seleccionar una sala aleatòria i afegir una porta cap a a baix i també afegir porta cap amunt en la següent filera.
            int index = Aleatori.generarIntAleatoriRang(0, (matriu[fil].length - 1));
            matriu[fil][index].setPortaDireccio(2, true);

            // afegir porta cap amunt en la següent filera.
            matriu[(fil + 1)][index].setPortaDireccio(0, true);

            // Seleccionar una sala aleatòria i afegir AMB PROBABILITAT una porta
            index = Aleatori.generarIntAleatoriRang(0, (matriu[fil].length - 1));

            if (Aleatori.tirarMoneda()) {

                matriu[fil][index].setPortaDireccio(2, true);

                // afegir porta cap amunt en la següent filera.
                matriu[(fil + 1)][index].setPortaDireccio(0, true);
            }
        }

        // En l'última, afegirem una única porta cap a fora, que serà la sortida de la masmorra.
        // Elegir una sala i afegir una porta cap a fora
        matriu[(matriu.length - 1)][Aleatori.generarIntAleatoriRang(0, (matriu[(matriu.length - 1)].length - 1))].setPortaDireccio(2, true);
    }


    /**
     * Funció que mostra gràficament la sala.
     */
    public void mostrarSalaGraficament() {

        // Mostrar direccions de la sala
        // Les portes (↑, →, ↓, ←) es mostren quan existeixen (true en el array de portes de Sala).
        System.out.println(" ┌───────────┐ ");
        System.out.println(" │    " + (isPortaDireccio(0) ? "↑" : " ") + "    \t │ "); // Nord
        System.out.println(" │ " + (isPortaDireccio(3) ? "←" : " ") + "  &  " + (isPortaDireccio(1) ? "→" : " ") + " \t │ "); // Oest i Est
        System.out.println(" │    " + (isPortaDireccio(2) ? "↓" : " ") + "    \t │ "); // Sud
        System.out.println(" └───────────┘ ");
    }


    // To string
    @Override
    public String toString() {

        return  "Sala: \n" +
                    "\tTipus: " + tipus + "\n"+
                    "\t" + (tresor != null ? tresor : "Tresor: No hi ha tresor") +
                    "\t" + (monstre != null ? monstre : "Monstre: No hi ha monstre") +
                    "\tPortes: " + portes + "\n"+
                    "\tExplorada: " + (explorada ? "S'ha explorat" : "No s'ha explorat") + ".\n";
    }


    // // Getters i Setters

    /**
     * Mètode que retorna cert o fals segons si en una direcció hi ha porta o no.
     * @param direccio La direcció a comprovar, en número.
     * @return Cert o fals segons si hi ha porta.
     */
    public boolean isPortaDireccio(int direccio) {

        return this.portes[direccio];
    }

    /**
     * Mètode que retorna cert o fals segons i hi ha una porta cap a una direcció en char.
     * @param direccio Char d'una direcció (mirar la declaració de la variable portes[])
     * @return Cert o fals segons si hi ha porta o no. Si no existeix la direcció, fals.
     */
    public boolean isPortaDireccioChar(char direccio) {

        int direccioNum;
        switch(direccio) {
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
                return false;
        }

        return isPortaDireccio(direccioNum);
    }

    /**
     * Mètode que assigna a una de les direccions si hi ha porta o no.
     * @param direccio La direcció en número.
     * @param hiHaPorta Assignar si hi ha porta o no.
     */
    public void setPortaDireccio(int direccio, boolean hiHaPorta) {

        this.portes[direccio] = hiHaPorta;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public Tresor getTresor() {
        return tresor;
    }

    public void setTresor(Tresor tresor) {
        this.tresor = tresor;
    }

    public Monstre getMonstre() {
        return monstre;
    }

    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    public boolean[] getPortes() {
        return portes;
    }

    public void setPortes(boolean[] portes) {
        this.portes = portes;
    }

    public boolean isExplorada() {
        return explorada;
    }

    public void setExplorada(boolean explorada) {
        this.explorada = explorada;
    }

    public boolean isTePocio() {
        return tePocio;
    }

    public void setTePocio(boolean tePocio) {
        this.tePocio = tePocio;
    }
}