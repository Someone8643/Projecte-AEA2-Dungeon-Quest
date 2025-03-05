
public class Sala {
    // Propiedades

    private String tipus; // Tipus: "Normal", "Pont", "Teranyina"
    private boolean tresor;
    private boolean monstre;
    private String portes;
    private boolean explorada;

    // Constructores

    public Sala(String tipus, boolean tresor, boolean monstre, String portes, boolean explorada) {
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

        // Probabilitat del 50% en normal de tenir tresor
        this.tresor = Aleatori.percentatgeProbabilitat(Dificultat.percentatgeFinalObjecteBo(50));

        // TODO Probabilitat del 50% en normal de tenir monstre

        // TODO Assignar portes que té, fer servir tirar moneda per decidir cada direcció

        // No fa falta dir que explorada és fals
    }

    // Métodos

    @Override
    public String toString() {
        return  "Sala: \n" +
                "\tTipus: " + tipus + "\n"+
                "\tTresor: " + tresor + "\n"+
                "\tMonstre: " + monstre + "\n"+
                "\tPortes: " + portes + "\n"+
                "\tExplorada: " + explorada + "\n";
    }
}

