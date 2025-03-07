
public class Sala {
    // // Propietats

    private String tipus; // Tipus: "Normal", "Pont", "Teranyina"
    private Tresor tresor;
    private Monstre monstre;
    private String portes; // TODO mirar una millor forma de representar
    private boolean explorada;

    // // Constructors

    public Sala(String tipus, Tresor tresor, Monstre monstre, String portes, boolean explorada) {
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

        // Probabilitat del 50% en normal de tenir tresor (s'ha de generar un objecte tresor amb 50% de fer-se)
        if (Aleatori.percentatgeProbabilitat(Dificultat.percentatgeFinalObjecteBo(50))) {
            this.tresor = new Tresor();
        }

        // Probabilitat del 50% en normal de tenir monstre (s'ha de generar un objecte monstre amb 50% de fer-se)

        if (Aleatori.percentatgeProbabilitat(Dificultat.percentatgeFinalObjecteDolent(50))) {
            this.monstre = new Monstre();
        }

        // TODO Assignar portes que té, fer servir tirar moneda per decidir cada direcció

        // No fa falta dir que explorada és fals
    }

    // // Mètodes

    @Override
    public String toString() {
        return  "Sala: \n" +
                "\tTipus: " + tipus + "\n"+
                "\tTresor: " + tresor + "\n"+
                "\tMonstre: " + monstre + "\n"+
                "\tPortes: " + portes + "\n"+
                "\tExplorada: " + explorada + "\n";
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

    public String getPortes() {
        return portes;
    }

    public void setPortes(String portes) {
        this.portes = portes;
    }

    public boolean isExplorada() {
        return explorada;
    }

    public void setExplorada(boolean explorada) {
        this.explorada = explorada;
    }
}

