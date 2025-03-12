public class Tresor {

    // ** Com està implementat **
    // Existeixen noms per a tresors i s'assignen de forma aleatòria amb repetició.
    // Els altres atributs es generen aleatòriament amb mínims i màxims.

    // // Propietats

    private String nom;
    private int valor;
    private double pes;

    // Llista de noms que tenim
    private String[] arrayNomsDeTresors = {"TEMPTRESOR1", "TEMPTRESOR2", "TEMPTRESOR3", "TEMPTRESOR4"};

    // // Constructors

    // Constructor amb assignació
    public Tresor(String nom, int valor, double pes) {
        this.nom = nom;
        this.valor = valor;
        this.pes = pes;
    }

    // Constructor aleatori
    public Tresor() {

        // Assignem un nom aleatori de la llista que tenim
        this.nom = arrayNomsDeTresors[Aleatori.generarIntAleatoriRang(0, (arrayNomsDeTresors.length - 1))];

        // Es genera un valor de forma aleatòria. Min 100, max 3000
        this.valor = Aleatori.generarIntAleatoriRang(100, 3000);

        // Es genera un pes aleatori. Min 1, max 100
        this.pes = Aleatori.generarDoubleAleatoriRang(1, 100);
    }


    // // Mètodes

    @Override
    public String toString() {
        return
                "Tresor: \n" +
                "\t\tNom: " + nom + ".\n"+
                "\t\tValor: " + valor +" monedes.\n"+
                "\t\tPes: " + pes +".\n";
    }


    // // Getters i Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    public String[] getArrayNomsDeTresors() {
        return arrayNomsDeTresors;
    }

    public void setArrayNomsDeTresors(String[] arrayNomsDeTresors) {
        this.arrayNomsDeTresors = arrayNomsDeTresors;
    }
}
