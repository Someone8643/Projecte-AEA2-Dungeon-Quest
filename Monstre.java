public class Monstre {
    // // Propietats

    private String nom;
    private int vida;
    private int penalitazcio;

    // // Llista de noms que tenim
    private String[] arrayNomsDeMonstres = {"TEMPMONSTRE1", "TEMPMONSTRE2", "TEMPMONSTRE3", "TEMPMONSTRE4"};

    // // Constructors

    public Monstre(String nom, int vida, int penalitazcio) {
        this.nom = nom;
        this.vida = vida;
        this.penalitazcio = penalitazcio;
    }

    // Constructor aleatòri
    public Monstre() {

        // Assignem un nom aleatori de la llista que tenim
        this.nom = arrayNomsDeMonstres[Aleatori.generarIntAleatoriRang(0, (arrayNomsDeMonstres.length - 1))];

        // Es genera un nivell de vida de forma aleatòria. Min 10, max 100
        this.vida = Aleatori.generarIntAleatoriRang(10, 100);

        // Es genera una penalització per fugir de forma aleatòria. Min 10, max 20
        this.penalitazcio = Aleatori.generarIntAleatoriRang(1, 30);
    }

    // // Mètodes

    @Override
    public String toString() {
        return "Monstre: \n" +
                "\tNom: " + nom + "\n" +
                "\tVida: " + vida +"\n"+
                "\tPenalització: " + penalitazcio + "\n";
    }

    // // Getters i Setters
    // TODO



}


