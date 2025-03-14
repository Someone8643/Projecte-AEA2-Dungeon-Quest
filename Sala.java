
public class Sala {
    // // Propietats

    private String tipus; // Tipus: "Normal", "Pont", "Teranyina"
    private Tresor tresor;
    private Monstre monstre;
    private boolean[] portes = new boolean[4]; // TODO revisar si així està bé
    // 0 = Nord
    // 1 = Est
    // 2 = Sud
    // 3 = Oest
    // (es comença del Nord i es va en sentit de les agulles del rellotge)
    private boolean explorada;

    // // Constructors
    public Sala(String tipus, Tresor tresor, Monstre monstre, boolean[] portes, boolean explorada) {
        this.tipus = tipus;
        this.tresor = tresor;
        this.monstre = monstre;
        this.portes = portes;
        this.explorada = explorada;
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
        if (Aleatori.percentatgeProbabilitat(Dificultat.percentatgeFinalObjecteBo(50))) {
            this.tresor = new Tresor();
        }

        // Probabilitat del 50% en normal de tenir monstre (s'ha de generar un objecte monstre amb 50% de fer-se).

        if (Aleatori.percentatgeProbabilitat(Dificultat.percentatgeFinalObjecteDolent(50))) {
            this.monstre = new Monstre();
        }
        // Assignar portes que té (50 50 per cada)
        // TODO mirar si ha sortit una sala sense portes i afegir mínim una porta?
        for (int i = 0; i < portes.length; i++) {

            portes[i] = Aleatori.tirarMoneda();
        }
    }

    // // Mètodes

    public boolean conteTresor(){
        return true;
    }
    public boolean conteMonstre(){
        return true;
    }
    public Boolean obtenirTresor(){
        return true;
    }


    // To string una mica complicat (realment no faria falta complicar-se tant)
    @Override
    public String toString() {

        String stringFinal;

        if (this.tresor != null) {

            if (this.monstre != null) { // La sala té tot

                stringFinal =   "Sala: \n" +
                        "\tTipus: " + tipus + "\n"+
                        "\t" + tresor +
                        "\t" + monstre +
                        "\tPortes: " + portes + "\n"+
                        "\tExplorada: " + explorada + ".\n";

            } else { // Té tresor però no monstre

                stringFinal =   "Sala: \n" +
                        "\tTipus: " + tipus + "\n"+
                        "\t" + tresor +
                        "\tMonstre: No hi ha monstre\n" +
                        "\tPortes: " + portes + "\n"+
                        "\tExplorada: " + explorada + ".\n";
            }

        } else if (this.monstre != null) { // No té tresor però sí monstre

            stringFinal =   "Sala: \n" +
                    "\tTipus: " + tipus + "\n"+
                    "\tTresor: No hi ha tresor\n" +
                    "\t" + monstre +
                    "\tPortes: " + portes + "\n"+
                    "\tExplorada: " + explorada + ".\n";

        } else { // No té ni tresor ni monstre

            stringFinal =   "Sala: \n" +
                    "\tTipus: " + tipus + "\n"+
                    "\tTresor: No hi ha tresor\n" +
                    "\tMonstre: No hi ha monstre\n" +
                    "\tPortes: " + portes + "\n"+
                    "\tExplorada: " + explorada + ".\n";
        }

        return stringFinal;
    }

    // // Getters i Setters
    // TODO Revisar més endavant per les portes

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
}






































