public class Monstre {

    // ** Com està implementat **
    // Existeixen noms per als monstres i s'assignen de forma aleatòria amb repetició.
    // Els altres atributs es generen aleatòriament amb mínims i màxims.

    // // Propietats

    private String nom;
    private int vida;
    private int penalitazcio;

    // // Llista de noms que tenim
    private String[] arrayNomsDeMonstres = {"TEMPMONSTRE1", "TEMPMONSTRE2", "TEMPMONSTRE3", "TEMPMONSTRE4"};

    // // Constructors

    // Constructor amb assignació
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
                "\t\tNom: " + nom + "\n" +
                "\t\tVida: " + vida +"\n"+
                "\t\tPenalització: " + penalitazcio + ".\n";
    }

    // // Getters i Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPenalitazcio() {
        return penalitazcio;
    }

    public void setPenalitazcio(int penalitazcio) {
        this.penalitazcio = penalitazcio;
    }

    public String[] getArrayNomsDeMonstres() {
        return arrayNomsDeMonstres;
    }

    public void setArrayNomsDeMonstres(String[] arrayNomsDeMonstres) {
        this.arrayNomsDeMonstres = arrayNomsDeMonstres;
    }
}


