
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



        this.tresor = Aleatori.percentatgeProbabilitat(Dificultat.percentatgeFinalObjecteBo(50));
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

