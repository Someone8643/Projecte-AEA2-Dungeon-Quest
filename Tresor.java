public class Tresor {

    // ** Com està implementat **
    // Existeixen noms per a tresors i s'assignen de forma aleatòria amb repetició.
    // Els altres atributs es generen aleatòriament amb mínims i màxims.

    // Propiedades

    private String nom;
    private double valor;
    private double pes;

    // Llista de noms que tenim
    private String[] arrayNomsDeTresors = {"nom1", "nom2", "nom3", "nom4"};

    // Constructores

    public Tresor(String nom, double valor, double pes) {
        this.nom = nom;
        this.valor = valor;
        this.pes = pes;
    }

    // Constructor aleatori
    public Tresor() {


        // Assignem un nom aleatori de la llista que tenim
        this.nom = arrayNomsDeTresors[Aleatori.generarIntAleatoriRang(0, (arrayNomsDeTresors.length - 1))];


    }


    // Métodos

    @Override
    public String toString() {
        return
                "Tresor: \n" +
                "\tNom " + nom + "\n"+
                "\tValor " + valor +"\n"+
                "\tPes " + pes +"\n";
    }
}
